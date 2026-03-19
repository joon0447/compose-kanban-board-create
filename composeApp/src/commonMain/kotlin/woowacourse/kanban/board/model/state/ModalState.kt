package woowacourse.kanban.board.model.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import woowacourse.kanban.board.model.modal.ProfileState
import woowacourse.kanban.board.model.TaskState
import woowacourse.kanban.board.model.modal.Tags
import woowacourse.kanban.board.model.modal.Title

class ModalState {
    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var tags by mutableStateOf("")
    var taskState by mutableStateOf(TaskState.TODO)
    var profileState by mutableStateOf(ProfileState.DINO)

    val isTitleValid by derivedStateOf { Title.isTitleValid(title) }
    val isTagsValid by derivedStateOf { Tags.isTagsValid(tags) }
}

@Composable
fun rememberModalState(): ModalState = remember { ModalState() }