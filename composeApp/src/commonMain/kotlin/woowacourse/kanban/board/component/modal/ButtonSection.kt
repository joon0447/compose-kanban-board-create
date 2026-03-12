package woowacourse.kanban.board.component.modal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.ComponentText
import javax.swing.ProgressMonitor

@Composable
@Preview(showBackground = true)
private fun ButtonSectionPreview() {
    val list = listOf("To Do", "In Progress", "Done")
//    ButtonSection()
}

@Composable
fun ButtonSection(
    state: Int,
    profile: Int,
    onStateClick: (Int) -> Unit,
    onProfileClick: (Int) -> Unit
    ) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = ComponentText.STATE_BUTTON_LABEL,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF364153),
        )
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            StateButton(text = ComponentText.STATE_BUTTON_TODO, state, onClick = { onStateClick(0) }, id = 0)
            StateButton(text = ComponentText.STATE_BUTTON_PROGRESS, state, onClick = { onStateClick(1) }, id = 1)
            StateButton(text = ComponentText.STATE_BUTTON_DONE, state, onClick = { onStateClick(2) }, id = 2)
        }
        Text(
            text = ComponentText.PROFILE_BUTTON_LABEL,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF364153),
        )
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            ProfileButton("다이노", profile, onClick = { onProfileClick(0) }, id = 0)
            ProfileButton("페임스", profile, onClick = { onProfileClick(1) }, id = 1)
        }

    }
}

