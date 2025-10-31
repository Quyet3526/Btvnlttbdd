// Root build.gradle.kts
plugins {
    // khai báo plugin android/kotlin ở root để có thể apply false (không áp dụng trực tiếp ở root)
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false

    // LƯU Ý:
    // Nếu bạn muốn dùng plugin "org.jetbrains.kotlin.plugin.compose" tại root, uncomment dòng sau:
    // id("org.jetbrains.kotlin.plugin.compose") version "1.9.0" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
