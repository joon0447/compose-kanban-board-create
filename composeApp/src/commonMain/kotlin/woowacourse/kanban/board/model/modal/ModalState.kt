package woowacourse.kanban.board.model.modal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import woowacourse.kanban.board.model.TaskState

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
