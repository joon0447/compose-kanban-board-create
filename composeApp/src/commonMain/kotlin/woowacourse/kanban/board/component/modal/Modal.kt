package woowacourse.kanban.board.component.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
private fun ModalPreview() {
    Modal()
}

@Composable
fun Modal() {
    Card(
        modifier = Modifier
            .padding(50.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Header()
            HorizontalDivider()
            TextInputSection("제목", "태스크 제목을 입력하세요")
            TextInputSection("제목", "태스크 제목을 입력하세요", Modifier.height(200.dp))
            TextInputSection("제목", "태스크 제목을 입력하세요")
            ButtonSection("상태", listOf("1", "2", "3"))
            ButtonSection("상태", listOf("1", "2"))
            Footer()
        }
    }
}