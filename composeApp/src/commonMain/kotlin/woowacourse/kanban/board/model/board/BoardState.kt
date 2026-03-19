package woowacourse.kanban.board.model.board

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlin.math.roundToInt
import woowacourse.kanban.board.model.TaskState
import woowacourse.kanban.board.model.taskcard.TaskCardData

class BoardState {
    val todoTasks = mutableStateListOf<TaskCardData>()
    val progressTasks = mutableStateListOf<TaskCardData>()
    val doneTasks = mutableStateListOf<TaskCardData>()
    var isShowModal by mutableStateOf(false)

    val totalTaskCount: Int
        get() = todoTasks.size + progressTasks.size + doneTasks.size

    fun addCard(data: TaskCardData) {
        when (data.task) {
            TaskState.TODO -> todoTasks.add(data)
            TaskState.PROGRESS -> progressTasks.add(data)
            TaskState.DONE -> doneTasks.add(data)
        }
    }

    fun calculateDoneRate(): Float {
        val totalTasks = todoTasks.size + progressTasks.size + doneTasks.size
        if (totalTasks == 0) return 0f
        val doneRate = doneTasks.size.toFloat() / totalTasks.toFloat()
        return (doneRate * 100).roundToInt() / 100f * 100
    }

    fun toggleShowModal() {
        isShowModal = isShowModal.not()
    }
}

@Composable
fun rememberBoardState(): BoardState = remember { BoardState() }
