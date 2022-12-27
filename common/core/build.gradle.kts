plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

android {
    namespace = ProjectConfig.namespace("common.core")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies { //TODO: why api?
                api(Dependencies.Kotlin.Serialization.serialization)
                api(Dependencies.Kotlin.Coroutines.core)

                api(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.negotiation)
                implementation(Dependencies.Ktor.json)
                implementation(Dependencies.Ktor.serialization)
                implementation(Dependencies.Ktor.logging)


                api(Dependencies.Kodein.core)

                api(Dependencies.SqlDelight.core)
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Ktor.android)
                implementation(Dependencies.SqlDelight.android)
                implementation(Dependencies.Compose.runtime)
            }
        }

        iosMain {
            dependencies {
                implementation(Dependencies.Ktor.ios)
                implementation(Dependencies.SqlDelight.ios)
            }
        }

        desktopMain {
            dependencies {
                implementation(Dependencies.Ktor.okhttp)
                implementation(Dependencies.SqlDelight.desktop)
            }
        }
    }
}