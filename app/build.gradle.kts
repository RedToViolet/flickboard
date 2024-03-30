import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

val keystorePropertiesFile = rootProject.file("../flickboard.keystore.properties")
val keystoreProperties = keystorePropertiesFile
    .takeIf { it.exists() }
    ?.let { propFile ->
        Properties().also { props ->
            FileInputStream(propFile).use(props::load)
        }
    }

android {
    signingConfigs {
        if (keystoreProperties != null) {
            create("release") {
                storeFile = rootProject.file(keystoreProperties["storeFile"] as String)
                storePassword = keystoreProperties["storePassword"] as String
                keyAlias = keystoreProperties["keyAlias"] as String
                keyPassword = keystoreProperties["keyPassword"] as String
            }
        } else {
            logger.warn("$keystorePropertiesFile not found, no release signing config loaded")
        }
    }
    namespace = "se.nullable.flickboard"
    compileSdk = 34

    defaultConfig {
        applicationId = "se.nullable.flickboard"
        minSdk = 28
        targetSdk = 34
        versionCode = 14
        versionName = "0.0.11"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
            if (keystoreProperties != null) {
                signingConfig = signingConfigs.getByName("release")
            }
        }
        create("unsignedRelease") {
            initWith(getByName("release"))
            applicationIdSuffix = ".unsigned"
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    flavorDimensions += "purpose"
    productFlavors {
        create("plain") {
            dimension = "purpose"
        }
        create("screengrab") {
            dimension = "purpose"
            applicationIdSuffix = ".screengrab"
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.emoji2:emoji2-emojipicker:1.4.0")
    implementation("androidx.emoji2:emoji2-bundled:1.4.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.uiautomator:uiautomator:2.2.0")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation("tools.fastlane:screengrab:2.1.1")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}