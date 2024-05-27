package com.example.presentation.main.board

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.presentation.model.main.board.BoardCardModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun BoardScreen(
    viewModel: BoardViewModel
) {
    val context = LocalContext.current
    val state = viewModel.collectAsState().value
    var modelForDialog: BoardCardModel? by remember{ mutableStateOf( null ) }

    viewModel.collectSideEffect { sideEffect ->
        when(sideEffect) {
            is BoardSideEffect.Toast -> Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
        }
    }
    BoardScreen(
        boardCardModels = state.boardCardModelFlow.collectAsLazyPagingItems(),
        deleteBoardIds = state.deleteBoardIds,
        onOptionClick = { modelForDialog = it },
        onReplyClick = {},
    )
    BoardOptionDialog(
        model = modelForDialog,
        onBoardDelete = viewModel::onBoardDelete,
        onDismissRequest = { modelForDialog = null }
    )
}

@Composable
private fun BoardScreen(
    boardCardModels: LazyPagingItems<BoardCardModel>,
    deleteBoardIds: Set<Long> = emptySet(),
    onOptionClick: (BoardCardModel)->Unit,
    onReplyClick: (BoardCardModel)->Unit,

    ) {
    Surface {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items (
                count = boardCardModels.itemCount,
                key = { index -> boardCardModels[index]?.boardId ?: index }
            ) {index ->
                boardCardModels[index]?.run {
                    if (!deleteBoardIds.contains(this.boardId)) {
                        BoardCard(
                            username = this.username,
                            images = this.images,
                            text = this.text,
                            onOptionClick = { onOptionClick(this) },
                            onReplyClick = { onReplyClick(this) },
                        )
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//private fun BoardScreenPreview() {
//    ConnectedTheme {
//        BoardScreen(
//            boardCardModels = empty,
//            onOptionClick = {},
//            onReplyClick = {}
//        )
//    }
//}