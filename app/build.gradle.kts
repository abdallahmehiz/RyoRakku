plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.apollographql.apollo3") version "3.8.2"
}
apollo {
    service("service") {
        packageName.set("xyz.mehiz.ryorakku")
    }
}

android {
    namespace = "xyz.mehiz.ryorakku"
    compileSdk = 33

    defaultConfig {
        applicationId = "xyz.mehiz.ryorakku"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "0.0.0-1rc"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("com.apollographql.apollo3:apollo-runtime:3.8.2")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.navigation:navigation-compose:2.6.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2022.10.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

  // Voyager
  val voyagerVersion = "1.0.0-rc05"

  // Multiplatform

  // Navigator
  implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")

  // BottomSheetNavigator
  implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:$voyagerVersion")

  // TabNavigator
  implementation("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")

  // Transitions
  implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")

  // Android

  // Android ViewModel integration
  implementation("cafe.adriel.voyager:voyager-androidx:$voyagerVersion")

  // Koin integration
  implementation("cafe.adriel.voyager:voyager-koin:$voyagerVersion")

  // Hilt integration
  implementation("cafe.adriel.voyager:voyager-hilt:$voyagerVersion")

  // LiveData integration
  implementation("cafe.adriel.voyager:voyager-livedata:$voyagerVersion")

  // Desktop + Android

  // Kodein integration
  implementation("cafe.adriel.voyager:voyager-kodein:$voyagerVersion")

  // RxJava integration
  implementation("cafe.adriel.voyager:voyager-rxjava:$voyagerVersion")
}