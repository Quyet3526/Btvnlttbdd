package com.example.uiux.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    onGoImage: () -> Unit,
    onGoInput: () -> Unit,
    onGoLayout: () -> Unit,
    onGoText: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = Color(0xFF2196F3)
                ),
                title = {
                    Text(
                        text = "UI Components List",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // ===== Display =====
            item { SectionTitle("Display") }
            item {
                BlueListItem(
                    title = "Text",
                    subtitle = "Displays text",
                    onClick = { onGoText() }
                )
            }
            item {
                BlueListItem(
                    title = "Image",
                    subtitle = "Displays an image",
                    onClick = { onGoImage() }
                )
            }

            // ===== Input =====
            item { SectionTitle("Input") }
            item {
                BlueListItem(
                    title = "TextField",
                    subtitle = "Input field for text",
                    onClick = { onGoInput() }
                )
            }
            item {
                BlueListItem(
                    title = "PasswordField",
                    subtitle = "Input field for passwords",
                    onClick = { onGoInput() }
                )
            }

            // ===== Layout =====
            item { SectionTitle("Layout") }
            item {
                BlueListItem(
                    title = "Column",
                    subtitle = "Arranges elements vertically",
                    onClick = { onGoLayout() }
                )
            }
            item {
                BlueListItem(
                    title = "Row",
                    subtitle = "Arranges elements horizontally",
                    onClick = { onGoLayout() }
                )
            }
        }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
}

@Composable
private fun BlueListItem(
    title: String,
    subtitle: String,
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        color = Color(0xFFE3F2FD),
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 0.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = subtitle, fontSize = 13.sp, color = Color.Black.copy(alpha = 0.65f))
        }
    }
}
