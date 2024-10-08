package com.example.presentation.main.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.Comment
import com.example.presentation.component.FCImagePager
import com.example.presentation.main.board.comment.CommentDialog
import com.mohamedrejeb.richeditor.model.RichTextState
import com.mohamedrejeb.richeditor.ui.BasicRichText
import theme.ConnectedTheme

@Composable
fun BoardCard(
    isMyBoard: Boolean,
    userId: Long,
    boardId: Long,
    profileImageUrl: String? = null,
    username: String,
    images: List<String>,
    richTextSate: RichTextState,
    comments: List<Comment>,
    onOptionClick: ()->Unit,
    onDeleteComment: (Long, Comment)->Unit,
    onCommentSend: (Long, String)->Unit
) {
    var commentDialogVisible by remember { mutableStateOf(false) }
    Surface {
        Column (
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()

        ) {
            //헤더
            BoardHeader(
                isMyBoard = isMyBoard,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                profileImageUrl = profileImageUrl,
                username = username,
                onOptionClick = onOptionClick
            )
            // 이미지 페이저
            if(images.isNotEmpty()) {
                FCImagePager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    images = images
                )
            }
            var maxLines by remember(richTextSate) { mutableStateOf(1) }
            var showMore by remember { mutableStateOf(false) }
            var showLess by remember { mutableStateOf(false) }

            //내용(텍스트)
            BasicRichText(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                state = richTextSate,
                maxLines = maxLines,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle.Default.copy(color = MaterialTheme.colorScheme.onPrimary, fontSize = MaterialTheme.typography.bodyLarge.fontSize),
                onTextLayout = { textLayoutResult ->
                    showMore = textLayoutResult.didOverflowHeight
                }
            )

            if(showMore) {
                showLess = true
                TextButton(
                    modifier = Modifier.
                        padding(start = 4.dp),
                    onClick = {
                        maxLines = Integer.MAX_VALUE
                    }
                ) {
                    Text(
                        text = "더보기",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            } else if(showLess) {
                TextButton(
                    modifier = Modifier.
                        padding(start = 4.dp),
                    onClick = {
                        maxLines = 1
                    }
                ) {
                    Text(
                        text = "간략히",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

            // 댓글 버튼
            TextButton(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.End),
                onClick = {
                    commentDialogVisible = true
                }
            ) {
                Text(text = "${comments.size} 댓글")
            }
        }
    }

    CommentDialog(
        isMyBoard = isMyBoard,
        userId = userId,
        visible = commentDialogVisible,
        comments = comments,
        onDismissRequest = { commentDialogVisible = false },
        onCloseClick = { commentDialogVisible = false },
        onDeleteComment = { comment -> onDeleteComment(boardId, comment) },
        onCommentSend = { text -> onCommentSend(boardId, text) }
    )
}

@Preview
@Composable
private fun BoardCardPreview() {
    ConnectedTheme {
        BoardCard(
            isMyBoard = true,
            userId = -1L,
            boardId = -1L,
            profileImageUrl = null,
            username = "Fast Campus",
            images = emptyList(),
            richTextSate = RichTextState(),
            comments = emptyList(),
            onOptionClick = {},
            onDeleteComment = { _, _ ->

            },
            onCommentSend = { _, _ ->

            },
        )
    }
}