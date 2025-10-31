package com.example.uiux.ui.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.uiux.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageScreen(onGoBack: () -> Unit,
) {
    val ctx = LocalContext.current
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Images", fontWeight = FontWeight.Bold, fontSize = 22.sp) },
                navigationIcon = {
                    IconButton(onClick = onGoBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    titleContentColor = Color(0xFF2196F3)
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {

                AsyncImage(
                    model = "https://cdn2.fptshop.com.vn/unsafe/1920x0/filters:format(webp):quality(75)/de_an_tuyen_sinh_dai_hoc_giao_thong_van_tai_tphcm_2025_1_8ba7e46c72.jpg",
                    contentDescription = null,
                )

                    // Ảnh local từ drawable
                Image(
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                )
            }
        }
    }
}
