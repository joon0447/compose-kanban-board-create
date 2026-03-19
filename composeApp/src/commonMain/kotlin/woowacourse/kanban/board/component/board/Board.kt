package woowacourse.kanban.board.component.board

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import woowacourse.kanban.board.component.modal.Modal
import woowacourse.kanban.board.model.board.rememberBoardState

@Composable
fun Board(
    modifier: Modifier = Modifier,
) {
    val boardState = rememberBoardState()

    Scaffold { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues),
        ) {
            if (boardState.isShowModal) {
                Dialog(
                    onDismissRequest = { boardState.isShowModal = false }
                ) {
                    Modal()
                }
            }
            BoardHeader(
                doneRate = boardState.calculateDoneRate().toInt(),
                doneTasks = boardState.doneTasks.size,
                totalTasks = boardState.totalTaskCount,
                onClickCreateTask = { boardState.toggleShowModal() }
            )
        }
    }
}
