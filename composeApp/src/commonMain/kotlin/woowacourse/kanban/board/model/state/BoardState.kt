package woowacourse.kanban.board.model.state

import androidx.compose.runtime.mutableStateListOf
import woowacourse.kanban.board.model.TaskState
import woowacourse.kanban.board.model.taskcard.TaskCardData

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
}
