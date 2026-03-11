package woowacourse.kanban.board.component.modal

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextInput(
    label: String,
    value: String,
    placeholder: String,
    singleLine: Boolean = true,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    supportingText: String?= null
) {
    Text(
        text = label,
        fontSize = 14.sp,
        color = Color(0xFF364153),
        fontWeight = FontWeight.Bold
    )
    OutlinedTextField(
        value = value,
        modifier = modifier
            .fillMaxWidth(),
        singleLine = singleLine,
        placeholder = {
            Text(
                text = placeholder,
                color = Color(0xFFAAAAAA),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            )
        },
        supportingText = {
            if(supportingText != null) {
                Text(text = supportingText)
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color(0xFFE5E7EB),
            focusedBorderColor = Color(0xFFE5E7EB),
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
        ),
        onValueChange = onTextChange,
    )
}