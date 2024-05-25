package com.example.presentation.main.board

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.model.main.board.BoardCardModel
import theme.ConnectedTheme

@Composable
fun BoardScreen(
    boardCardModels: List<BoardCardModel>,
    onOptionClick: (BoardCardModel)->Unit,
    onReplyClick: (BoardCardModel)->Unit,

) {
    Surface {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items (
                count = boardCardModels.size,
                key = { index -> boardCardModels[index].boardId }
            ) {index ->
                val boardCardModel = boardCardModels[index]
                BoardCard(
                    username = boardCardModel.username,
                    images = boardCardModel.images,
                    text = boardCardModel.text,
                    onOptionClick = { onOptionClick(boardCardModel) },
                    onReplyClick = { onReplyClick(boardCardModel) },
                )
            }
        }
    }
}

@Preview
@Composable
private fun BoardScreenPreview() {
    ConnectedTheme {
        BoardScreen(
            boardCardModels = listOf(
                BoardCardModel(
                    boardId = 0,
                    username = "Leslie Middleton",
                    images = listOf(),
                    text = "aperiri"

                ),
                BoardCardModel(
                    boardId = 1,
                    username = "Christa Cannon",
                    images = listOf(),
                    text = "urbanitas"
                ),
                BoardCardModel(
                    boardId = 2,
                    username = "Abraham Wilkerson",
                    images = listOf(),
                    text = "delectus"
                )
            ),
            onOptionClick = {},
            onReplyClick = {}
        )
    }
}