package com.example.presentation.main.board

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.domain.model.Comment
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
        myUserId = state.myUserId,
        boardCardModels = state.boardCardModelFlow.collectAsLazyPagingItems(),
        deleteBoardIds = state.deleteBoardIds,
        addedComments = state.addedComments,
        deletedComments = state.deletedComments,
        onOptionClick = { modelForDialog = it },
        onDeleteComment = viewModel::onDeleteComment,
        onCommentSend = viewModel::onCommentSend
    )
    BoardOptionDialog(
        model = modelForDialog,
        onBoardDelete = viewModel::onBoardDelete,
        onDismissRequest = { modelForDialog = null }
    )
}

@Composable
private fun BoardScreen(
    myUserId: Long,
    boardCardModels: LazyPagingItems<BoardCardModel>,
    deleteBoardIds: Set<Long> = emptySet(),
    addedComments: Map<Long, List<Comment>>,
    deletedComments: Map<Long, List<Comment>>,
    onOptionClick: (BoardCardModel)->Unit,
    onDeleteComment: (Long, Comment)->Unit,
    onCommentSend: (Long, String)->Unit
    ) {
    Surface {
        if(boardCardModels.itemCount == 0) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "작성된 글이 없습니다.")
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items (
                    count = boardCardModels.itemCount,
                    key = { index -> boardCardModels[index]?.boardId ?: index }
                ) {index ->
                    boardCardModels[index]?.run {
                        val model: BoardCardModel = this
                        if (!deleteBoardIds.contains(this.boardId)) {
                            BoardCard(
                                isMyBoard = model.userId == myUserId,
                                userId = myUserId,
                                boardId = model.boardId,
                                username = model.username,
                                images = model.images,
                                profileImageUrl = model.profileImageUrl,
                                richTextSate = model.richTextState,
                                comments = model.comments + addedComments[boardId].orEmpty() - deletedComments[boardId].orEmpty(),
                                onOptionClick = { onOptionClick(model) },
                                onDeleteComment = onDeleteComment,
                                onCommentSend = onCommentSend
                            )
                        }
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