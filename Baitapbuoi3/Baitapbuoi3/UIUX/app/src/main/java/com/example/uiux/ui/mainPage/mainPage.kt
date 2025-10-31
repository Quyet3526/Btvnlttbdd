package com.example.uiux.ui.mainPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uiux.R

@Composable
fun MainScreen(
    onGoList: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize() // Cho Column chiếm toàn màn hình
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "Than van ky\n08920501011695")
        }

        Image(
            modifier = Modifier
                .padding(top = 100.dp)
                .width(200.dp)
                .height(200.dp),
            painter = painterResource(id = R.drawable.jc),
            contentDescription = null
        )

        Spacer(Modifier.height(50.dp))

        Text(text = "Jetpack Compose",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(10.dp))

        // Không cần bọc thêm Row, chỉ cần Text trực tiếp
        Text(
            text = "Jetpack Compose is a modern UI toolkit for\n" +
                    "building native Android applications using\n" +
                    "a declarative programming approach",
            modifier = Modifier
                .widthIn(max = 320.dp) // giới hạn bề rộng đoạn văn
                .fillMaxWidth(),       // để textAlign.Center có tác dụng
            textAlign = TextAlign.Center,
            fontSize = 15.sp
        )

        // Đẩy nút xuống đáy
        Spacer(Modifier.weight(1f))

        Button(
            onClick = { onGoList() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "click me")
        }
    }
}
