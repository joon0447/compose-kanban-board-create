package woowacourse.kanban.board.component.modal

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StateButton(
   text: String,
) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .border(1.dp, color = Color(0xFFE5E7EB), shape = RoundedCornerShape(10.dp))
            .padding(horizontal = 50.dp, vertical = 14.dp),
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            color = Color(0xFF364153),
            fontWeight = FontWeight.Normal,
        )
    }
}