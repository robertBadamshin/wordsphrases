buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    extra.apply {
        set("coroutinesVersion", "1.5.2")
        set("sqlDelightVersion", "1.5.3")

        set("appCompatVersion", "1.4.1")
        set("compileSdkAndroidVersion", 32)
        set("minSdkAndroidVersion", 26)
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("com.android.tools.build:gradle:7.1.3")

        classpath("com.google.firebase:firebase-crashlytics-gradle:2.7.1")
        classpath("com.google.gms:google-services:4.3.10")

        classpath("com.squareup.sqldelight:gradle-plugin:1.5.3")

        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.19.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}