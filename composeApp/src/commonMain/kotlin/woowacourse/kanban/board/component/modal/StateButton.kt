package woowacourse.kanban.board.component.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StateButton(
   text: String,
   state: Int,
   onClick: () -> Unit,
   id: Int
) {
    var backgroundColor = if (state == id) Color(0xFFEFF6FF) else Color.Transparent
    var borderColor = if (state == id) Color(0xFF1447E6) else Color(0xFFE5E7EB)
    var textColor = if (state == id) Color(0xFF1447E6) else Color(0xFF364153)

    Box(
        modifier = Modifier
            .width(200.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp,
                color = borderColor,
                shape = RoundedCornerShape(10.dp))
            .background(color = backgroundColor)
            .clickable{ onClick() }
            .padding(horizontal = 50.dp, vertical = 14.dp)

    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            color = textColor,
            fontWeight = FontWeight.Normal,
        )
    }
}