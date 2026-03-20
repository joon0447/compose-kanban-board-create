package woowacourse.kanban.board.component.board

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import woowacourse.kanban.board.component.ComponentText
import woowacourse.kanban.board.component.modal.Modal
import woowacourse.kanban.board.model.TaskState
import woowacourse.kanban.board.model.board.rememberBoardState

@Composable
fun Board(
    modifier: Modifier = Modifier,
) {
    val boardState = rememberBoardState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(boardState.shouldShowSnackbar) {
        if (boardState.shouldShowSnackbar) {
            snackbarHostState.showSnackbar(ComponentText.BOARD_TASK_CREATE_SNACKBAR)
            boardState.shouldShowSnackbar = false
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues),
        ) {
            if (boardState.isShowModal) {
                Dialog(
                    onDismissRequest = { boardState.isShowModal = false },
                ) {
                    Modal(
                        onClickClose = { boardState.isShowModal = false },
                        onClickTaskCreate = { task ->
                            boardState.addCard(task)
                            boardState.shouldShowSnackbar = true
                            boardState.isShowModal = false
                        },
                    )
                }
            }
            BoardHeader(
                doneRate = boardState.calculateDoneRate().toInt(),
                doneTasks = boardState.doneTasks.size,
                totalTasks = boardState.totalTaskCount,
                onClickCreateTask = { boardState.toggleShowModal() },
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                TaskColumn(
                    taskState = TaskState.TODO,
                    tasks = boardState.todoTasks,
                    modifier = Modifier.weight(1f),
                )
                TaskColumn(
                    taskState = TaskState.PROGRESS,
                    tasks = boardState.progressTasks,
                    modifier = Modifier.weight(1f),
                )
                TaskColumn(
                    taskState = TaskState.DONE,
                    tasks = boardState.doneTasks,
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}
