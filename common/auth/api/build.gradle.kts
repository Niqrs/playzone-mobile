plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

android {
    namespace = ProjectConfig.namespace("common.auth.api")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Kotlin.Serialization.serialization)
            }
        }
    }
}