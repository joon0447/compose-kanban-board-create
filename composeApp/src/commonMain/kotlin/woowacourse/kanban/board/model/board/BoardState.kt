package woowacourse.kanban.board.model.board

import androidx.compose.runtime.mutableStateListOf
import woowacourse.kanban.board.model.TaskState
import woowacourse.kanban.board.model.taskcard.TaskCardData
import kotlin.math.roundToInt

class BoardState {
    val todoTasks = mutableStateListOf<TaskCardData>()
    val progressTasks = mutableStateListOf<TaskCardData>()
    val doneTasks = mutableStateListOf<TaskCardData>()

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
        return (doneRate * 100).roundToInt() / 100f
    }
}