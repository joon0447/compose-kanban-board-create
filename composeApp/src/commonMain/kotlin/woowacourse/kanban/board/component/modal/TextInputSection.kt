package woowacourse.kanban.board.component.modal

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutBoundsHolder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.ComponentText


@Composable
fun TextInputSection(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    tags: String,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onTagsChange: (String) -> Unit,
    isTitleEmpty: Boolean,
    isDescriptionLong: Boolean,
    isNotValidTag: Boolean
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        TextInput(
            label = ComponentText.TITLE_LABEL,
            value = title,
            placeholder = ComponentText.TITLE_PLACEHOLDER,
            onTextChange = onTitleChange,
            isError = isTitleEmpty,
            errorText = ComponentText.TITLE_ERROR
        )
        TextInput(
            label = ComponentText.DESCRIPTION_LABEL,
            value = description,
            singleLine = false,
            modifier = Modifier.height(200.dp),
            placeholder = ComponentText.DESCRIPTION_PLACEHOLDER,
            onTextChange = onDescriptionChange,
            isError = isDescriptionLong,
            errorText = ComponentText.DESCRIPTION_ERROR
        )
        TextInput(
            label = ComponentText.TAG_LABEL,
            value = tags,
            placeholder = ComponentText.TAG_PLACEHOLDER,
            onTextChange = onTagsChange,
            supportingText = ComponentText.TAG_SUPPORTING,
            isError = isNotValidTag,
            errorText = ComponentText.TAG_ERROR
        )
    }
}