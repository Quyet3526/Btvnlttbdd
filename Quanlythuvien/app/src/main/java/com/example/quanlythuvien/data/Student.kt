package com.example.quanlythuvien.data

/**
 * Lớp dữ liệu cho đối tượng Sinh viên
 */
data class Student(
    val id: Int,
    val name: String,
    val borrowedBooks: List<Book>
)