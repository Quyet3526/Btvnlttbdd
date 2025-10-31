package com.example.uiux.ui.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextScreen(onGoBack: () -> Unit) {
    val goldBrown = Color(0xFFC49A6C)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Text Detail", fontWeight = FontWeight.Bold, fontSize = 22.sp) },
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
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .padding(top = 200.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item{
                Text(
                    text = buildAnnotatedString {
                        append("The ")
                        pushStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)); append("quick"); pop()
                        append(" ")
                        pushStyle(SpanStyle(color = goldBrown)); append("Brown"); pop()
                        append("\n")
                        append("fox ")
                        pushStyle(SpanStyle(letterSpacing = 0.25.em)); append("jumps"); pop()
                        append(" ")
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold)); append("over"); pop()
                        append("\n")
                        pushStyle(SpanStyle(textDecoration = TextDecoration.Underline)); append("the"); pop()
                        append(" ")
                        pushStyle(SpanStyle(fontStyle = FontStyle.Italic)); append("lazy"); pop()
                        append(" dog.")
                    },
                    modifier = Modifier.padding(20.dp),
                    fontSize = 30.sp,
                    lineHeight = 30.sp
                )
            }
        }
    }
}
