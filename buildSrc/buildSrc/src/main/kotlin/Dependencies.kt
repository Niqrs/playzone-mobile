object Dependencies {

    object Kodein {
        const val core = "org.kodein.di:kodein-di:7.16.0"
    }

    object Kotlin {
        private const val version = "1.7.20"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Serialization {
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:1.7.20"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.4.1"
        }
        object Coroutines {
            private const val version = "1.6.4"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Compose {
        private const val version = "1.2.2"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
        const val runtime = "org.jetbrains.compose.runtime:runtime:$version"
    }

    object Ktor {
        private const val version = "2.2.1"
        const val negotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val core = "io.ktor:ktor-client-core:$version"
        const val json = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val ios = "io.ktor:ktor-client-ios:$version"
        const val serialization = "io.ktor:ktor-client-serialization:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val okhttp = "io.ktor:ktor-client-okhttp:$version"
    }

    object SqlDelight {
        private const val version = "1.5.4"

        const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:$version"
        const val core = "com.squareup.sqldelight:runtime:$version"
        const val android = "com.squareup.sqldelight:android-driver:$version"
        const val desktop = "com.squareup.sqldelight:sqlite-driver:$version"
        const val ios = "com.squareup.sqldelight:native-driver:$version"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:8.0.0-alpha10"
    }
}