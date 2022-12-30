plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

android {
    namespace = ProjectConfig.namespace("common.auth.data")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:auth:api"))
                implementation(project(":common:core"))
                implementation(Dependencies.Kodein.core)
            }
        }
    }
}