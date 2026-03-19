package woowacourse.kanban.board.model.state

import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import woowacourse.kanban.board.model.TaskState
import woowacourse.kanban.board.model.modal.Description
import woowacourse.kanban.board.model.modal.ProfileState
import woowacourse.kanban.board.model.modal.Tags
import woowacourse.kanban.board.model.modal.Title
import woowacourse.kanban.board.model.taskcard.TaskCardData

class BoardStateTest {
    private lateinit var boardState: BoardState

    @Before
    fun setUp() {
        boardState = BoardState()
    }

    @Test
    fun `Todo TaskCardData를 추가하면 todoList에 저장된다`() {
        val data = TaskCardData(
            title = Title(value = "업무1"),
            description = Description(""),
            tags = Tags(value = "컴포넌트"),
            task = TaskState.TODO,
            profile = ProfileState.DINO
        )
        boardState.addCard(data)
        assertThat(boardState.todoTasks).contains(data)
    }

    @Test
    fun `Progress TaskCardData를 추가하면 progressList에 저장된다`() {
        val data = TaskCardData(
            title = Title(value = "업무1"),
            description = Description(""),
            tags = Tags(value = "컴포넌트"),
            task = TaskState.PROGRESS,
            profile = ProfileState.DINO
        )
        boardState.addCard(data)
        assertThat(boardState.progressTasks).contains(data)
    }

    @Test
    fun `Done TaskCardData를 추가하면 doneList에 저장된다`() {
        val data = TaskCardData(
            title = Title(value = "업무1"),
            description = Description(""),
            tags = Tags(value = "컴포넌트"),
            task = TaskState.DONE,
            profile = ProfileState.DINO
        )
        boardState.addCard(data)
        assertThat(boardState.doneTasks).contains(data)
    }
}
