plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    mavenLocal()
    google()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev") //TODO: What if i remove this?
}

dependencies {
    implementation(Dependencies.Kotlin.gradlePlugin)
    implementation(Dependencies.Compose.gradlePlugin)
    implementation(Dependencies.Android.gradlePlugin)
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}