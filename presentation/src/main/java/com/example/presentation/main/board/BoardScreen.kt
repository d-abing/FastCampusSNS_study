package com.example.presentation.main.board

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.presentation.model.main.board.BoardCardModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun BoardScreen(
    viewModel: BoardViewModel = hiltViewModel()
) {
    val state = viewModel.collectAsState().value
    BoardScreen(
        boardCardModels = state.boardCardModelFlow.collectAsLazyPagingItems(),
        onOptionClick = {},
        onReplyClick = {},
    )
}

@Composable
private fun BoardScreen(
    boardCardModels: LazyPagingItems<BoardCardModel>,
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