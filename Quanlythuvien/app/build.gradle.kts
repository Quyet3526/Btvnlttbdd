plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // KHÔNG cần khai báo org.jetbrains.kotlin.plugin.compose ở đây
}

android {
    namespace = "com.example.quanlythuvien" // sửa theo package project bạn
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.quanlythuvien"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            // proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        // Chỉnh version phù hợp với Kotlin 1.9 (ví dụ: 1.5.3 hoặc version tương ứng)
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2024.05.00") // hoặc version BOM bạn thích
    implementation(composeBom)
    // Compose UI
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    // Activity compose
    implementation("androidx.activity:activity-compose:1.8.0")
    // lifecycle (nếu cần)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
}
