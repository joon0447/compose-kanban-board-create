package woowacourse.kanban.board.component.extension

import woowacourse.kanban.board.ComponentText
import woowacourse.kanban.board.model.TaskState

fun TaskState.toText(): String = when (this) {
    TaskState.TODO -> ComponentText.STATE_BUTTON_TODO
    TaskState.PROGRESS -> ComponentText.STATE_BUTTON_PROGRESS
    TaskState.DONE -> ComponentText.STATE_BUTTON_DONE
}
