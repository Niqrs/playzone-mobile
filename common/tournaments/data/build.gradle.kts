plugins {
    id("multiplatform-setup")
    id("android-setup")
}

android {
    namespace = ProjectConfig.namespace("common.tournaments.data")
}