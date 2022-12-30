plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

android {
    namespace = ProjectConfig.namespace("common.core_compose")
}