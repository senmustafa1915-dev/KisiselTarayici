plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.kisisel.tarayici"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kisisel.tarayici"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
        kotlinCompilerExtensionVersion = "1.5.8"
    }
}

// İŞTE SİHİRLİ KOD BURADA: Tüm sürüm çakışmalarını zorla eziyoruz!
configurations.all {
    resolutionStrategy {
        force("androidx.compose.material:material-ripple:1.5.8")
        force("androidx.compose.ui:ui:1.5.8")
        force("androidx.compose.material3:material3:1.1.2")
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose.ui:ui:1.5.8")
    implementation("androidx.compose.ui:ui-graphics:1.5.8")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.8")
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("androidx.compose.material:material-icons-extended:1.5.8")
    implementation("androidx.compose.material:material-ripple:1.5.8")
}
