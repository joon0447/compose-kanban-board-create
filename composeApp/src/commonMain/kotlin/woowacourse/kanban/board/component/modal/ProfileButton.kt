package woowacourse.kanban.board.component.modal

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.profile
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileButton(
    text: String,
    state: Int,
    id: Int,
    onClick: () -> Unit
) {
    var backgroundColor = if (state == id) Color(0xFFEFF6FF) else Color.Transparent
    var borderColor = if (state == id) Color(0xFF1447E6) else Color(0xFFE5E7EB)

    Box(
        modifier = Modifier
            .width(200.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, color = borderColor, shape = RoundedCornerShape(10.dp))
            .background(color = backgroundColor)
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 20.dp),
    ) {
        Row (
            horizontalArrangement = Arrangement.Start
        ){
            Image(
                painter = painterResource(Res.drawable.profile),
                contentDescription = "프로필 이미지",
                modifier = Modifier.size(24.dp),
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = text,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp,
                color = Color(0xFF364153),
                fontWeight = FontWeight.Normal,
            )
        }

    }
}