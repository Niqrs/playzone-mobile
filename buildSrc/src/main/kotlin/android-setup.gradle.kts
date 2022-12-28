import Dependencies

//import org.gradle.api.JavaVersion

plugins {
    id("com.android.library")
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 26
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml") //TODO: ???
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }

    dependencies {
        implementation(Dependencies.Compose.runtime)
    }
}
    