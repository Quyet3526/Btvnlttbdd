package com.example.quanlythuvien

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quanlythuvien.data.Book
import com.example.quanlythuvien.data.Student
import com.example.quanlythuvien.ui.theme.QuanlythuvienTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuanlythuvienTheme {
                LibraryManagementScreen()
            }
        }
    }
}

// ==========================================================
// DỮ LIỆU GIẢ ĐỊNH (MOCK DATA)
// ==========================================================
val mockStudentA = Student(
    id = 1,
    name = "Nguyen Van A",
    borrowedBooks = listOf(
        Book(id = 1, title = "Sách 01", isBorrowed = true),
        Book(id = 2, title = "Sách 02", isBorrowed = true)
    )
)

val mockStudentB = Student(
    id = 2,
    name = "Nguyen Thi B",
    borrowedBooks = listOf(
        Book(id = 1, title = "Sách 01", isBorrowed = true)
    )
)

val mockStudentC = Student(
    id = 3,
    name = "Nguyen Van C",
    borrowedBooks = emptyList()
)

// ==========================================================
// CÁC THÀNH PHẦN GIAO DIỆN (COMPOSABLES)
// ==========================================================

@Composable
fun LibraryManagementScreen() {
    // State để chuyển đổi giữa 3 sinh viên, mô phỏng 3 màn hình yêu cầu
    var currentStudent by remember { mutableStateOf(mockStudentA) }

    fun switchStudent() {
        currentStudent = when (currentStudent.id) {
            1 -> mockStudentB
            2 -> mockStudentC
            else -> mockStudentA
        }
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Hệ thống Quản lý Thư viện") }) },
        bottomBar = { LibraryBottomNavigation() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StudentInfoSection(
                student = currentStudent,
                onStudentChangeClick = ::switchStudent
            )
            Spacer(modifier = Modifier.height(20.dp))

            BorrowedBooksSection(
                books = currentStudent.borrowedBooks
            )

            Button(
                onClick = { /* Xử lý sự kiện Thêm sách mượn mới */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1E88E5))
            ) {
                Text("Thêm", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}

@Composable
fun StudentInfoSection(student: Student, onStudentChangeClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Sinh viên",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.LightGray.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
                    .padding(vertical = 12.dp, horizontal = 16.dp)
            ) {
                Text(text = student.name, style = MaterialTheme.typography.body1)
            }
            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = onStudentChangeClick,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1E88E5))
            ) {
                Text(text = "Thay đổi", color = Color.White)
            }
        }
    }
}

@Composable
fun BorrowedBooksSection(books: List<Book>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Danh sách sách",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(vertical = 8.dp),
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
        )

        if (books.isEmpty()) {
            // Hiển thị thông báo khi không có sách
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color.LightGray.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Bạn chưa mượn quyển sách nào\nNhấn \"Thêm\" để bắt đầu hành trình đọc sách!",
                    color = Color.DarkGray,
                    style = MaterialTheme.typography.body2,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
        } else {
            // Hiển thị danh sách sách đã mượn
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp)
            ) {
                items(books) { book ->
                    BookListItem(book = book)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun BookListItem(book: Book) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = book.isBorrowed,
            onCheckedChange = { /* Checkbox chỉ để hiển thị, không thay đổi trạng thái */ },
            colors = CheckboxDefaults.colors(checkedColor = Color(0xFF1E88E5))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = book.title, style = MaterialTheme.typography.body1)
    }
}

@Composable
fun LibraryBottomNavigation() {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 8.dp
    ) {
        val items = listOf("Quản lý", "DS Sách", "Sinh viên")
        val icons = listOf(Icons.Filled.Home, Icons.Filled.Book, Icons.Filled.Person)
        var selectedItem by remember { mutableStateOf(0) }

        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                selectedContentColor = Color(0xFF1E88E5),
                unselectedContentColor = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLibraryManagementScreen() {
    QuanlythuvienTheme {
        LibraryManagementScreen()
    }
}