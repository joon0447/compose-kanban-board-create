package woowacourse.kanban.board.component.modal

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.ComponentText
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class TextInputTest {

    @Test
    fun `제목 필드에 빈 값이 입력되면 텍스트 필드 border가 빨간색이 된다`() = runComposeUiTest {
        val value = ""
        setContent {
            TextInput(
                label = ComponentText.TITLE_LABEL,
                value = value,
                placeholder = ComponentText.TITLE_PLACEHOLDER,
                onTextChange = {  },
                isError = true,
                errorText = ComponentText.TITLE_ERROR,
            )
        }

    }
}