plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    //Hilt
    alias(libs.plugins.kotlinKapt)
    alias(libs.plugins.hiltAndroid)
}

hilt {
    enableAggregatingTask = false
}

android {
    namespace = "com.example.dailyqwiz"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.dailyqwiz"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.play.services.fitness)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.material.icons.extended)

    implementation(libs.androidx.storage)


    //Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    //Hilt
    implementation(libs.hilt)
    implementation(libs.hiltNavigationCompose)
    kapt(libs.hiltCompiler)

    // Retrofit
    implementation(libs.retrofit2)
    implementation(libs.retrofit2GsonConverter)

    //OkHttp
    implementation(libs.okhttp3)
    implementation(libs.okhttp3Logging)

    //Coroutines
    implementation(libs.coroutinesCore)
    implementation(libs.coroutinesAndroid)

    //Coroutine Lifecycle Scopes
    implementation(libs.lifecycleViewModel)

    //Navigation
    implementation(libs.navigationCompose)

    //coil
    implementation(libs.coil.compose)
}
kapt {
    correctErrorTypes = true
}