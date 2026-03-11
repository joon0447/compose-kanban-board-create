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

@Composable
@Preview(showBackground = true)
private fun TextInputSectionPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        TextInputSection()
    }

}

@Composable
fun TextInputSection(
    modifier: Modifier = Modifier,
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var tags by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        TextInput(
            label = "제목 *",
            value = title,
            placeholder = "태스크 제목을 입력하세요",
            onTextChange = { title = it },
        )
        TextInput(
            label = "설명",
            value = description,
            singleLine = false,
            modifier = Modifier.height(200.dp),
            placeholder = "태스크에 대한 자세한 설명을 입력하세요",
            onTextChange = { description = it },
        )
        TextInput(
            label = "태그 *",
            value = tags,
            placeholder = "태그를 쉼표로 구분하여 입력하세요 (예: 버그, 긴급)",
            onTextChange = { tags = it },
            supportingText = "5자 이내에 태그를 최대 5개까지 등록할 수 있습니다."
        )
    }
}