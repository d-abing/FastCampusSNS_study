package com.example.presentation.main.writing

import androidx.lifecycle.ViewModel
import com.example.domain.model.Image
import com.example.domain.usecase.main.writing.GetImageListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@HiltViewModel
class WritingViewModel @Inject constructor(
    private val getImageListUseCase: GetImageListUseCase
)
    : ViewModel(), ContainerHost<WritingState, WritingSideEffect> {
    override val container: Container<WritingState, WritingSideEffect> = container(
        initialState = WritingState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent {
                    postSideEffect(WritingSideEffect.Toast(throwable.message.orEmpty()))
                }
            }
        }
    )

    init {
        load()
    }

    fun load() = intent {
        val images = getImageListUseCase()
        reduce {
            state.copy(
                selectedImages = images.firstOrNull()?.let { listOf(it) } ?: emptyList(),
                images = images
            )
        }
    }

    fun onItemClick(image: Image) = intent {
        reduce {
            if (state.selectedImages.contains(image)) {
                state.copy(
                    selectedImages = state.selectedImages - image
                )
            } else {
                state.copy(
                    selectedImages = state.selectedImages + image
                )
            }
        }

    }

    fun onTextChange(text: String) = blockingIntent {
        reduce {
            state.copy(text = text)
        }
    }

    fun onPostClick() = intent {
        val writingState = state
    }
}

@Immutable
data class WritingState(
    val selectedImages: List<Image> = emptyList(),
    val images: List<Image> = emptyList(),
    val text: String = "",
)

sealed interface WritingSideEffect {
    class Toast (val message: String) : WritingSideEffect
}