plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

android {
    namespace = ProjectConfig.namespace("common.umbrella_compose")
}