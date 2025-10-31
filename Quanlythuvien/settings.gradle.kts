rootProject.name = "Quanlythuvien"
include(":app")

pluginManagement {
    repositories {
        // cần có repo JetBrains Compose để resolver plugin compose nếu cần
        google()
        gradlePluginPortal()
        mavenCentral()
        // <-- thêm dòng này để Gradle có thể tìm plugin org.jetbrains.kotlin.plugin.compose
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // repository sau đây thường không cần cho Jetpack Compose Android, 
        // nhưng giữ thêm cho trường hợp bạn dùng multiplatform compose artifacts
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
