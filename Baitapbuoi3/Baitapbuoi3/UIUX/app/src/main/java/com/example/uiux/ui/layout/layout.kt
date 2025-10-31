package com.example.uiux.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uiux.R
import com.example.uiux.ui.navigation.Routes.Image

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutScreen(
    onGoBack: () -> Unit,
){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Layouts",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {  onGoBack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    titleContentColor = Color(0xFF2196F3)
                )
            )
        }
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start
        )
        {
            Text(text = "Column Layout", fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(id = R.drawable.download),
                contentDescription = null,
            )
            Image(
                painter = painterResource(id = R.drawable.download),
                contentDescription = null,
            )
            Image(
                painter = painterResource(id = R.drawable.download),
                contentDescription = null,
            )
            Image(
                painter = painterResource(id = R.drawable.download),
                contentDescription = null,
            )
            Text(text = "Row Layout", fontWeight = FontWeight.Bold)
            Row {
                Image(
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                )
                Image(
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                )
                Image(
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                )
                Image(
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = null,
                )
            }
            

        }
    }
}