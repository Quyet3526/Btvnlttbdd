package com.example.quanlythuvien.data

/**
 * Lớp dữ liệu cho đối tượng Sách
 */
data class Book(
    val id: Int,
    val title: String,
    val isBorrowed: Boolean = false
)