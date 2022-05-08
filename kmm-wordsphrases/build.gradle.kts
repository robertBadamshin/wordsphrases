import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.squareup.sqldelight")
    kotlin("plugin.serialization") version "1.6.10"
}

sqldelight {
    database("WordsphrasesDatabase") {
        packageName = "com.wordphrases.db"
        sourceFolders = listOf("sqldelight")
    }
}

tasks {
    val carthageTasks = if (projectDir.resolve("src/nativeInterop/cinterop/Cartfile").exists()) { // skipping firebase-common module
        listOf("bootstrap", "update").map {
            task<Exec>("carthage${it.capitalize()}") {
                group = "carthage"
                executable = "carthage"
                args(
                    it,
                    "--project-directory", projectDir.resolve("src/nativeInterop/cinterop"),
                    "--platform", "iOS"
                )
            }
        }
    } else emptyList()

    if (Os.isFamily(Os.FAMILY_MAC)) {
        withType(org.jetbrains.kotlin.gradle.tasks.CInteropProcess::class) {
            if (carthageTasks.isNotEmpty()) {
                dependsOn("carthageBootstrap")
            }
        }
    }

//    create("carthageClean", Delete::class.java) {
//        group = "carthage"
//        delete(
//            projectDir.resolve("src/nativeInterop/cinterop/Carthage"),
//            projectDir.resolve("src/nativeInterop/cinterop/Cartfile.resolved")
//        )
//    }
}

kotlin {
    android()

    val iosArm64 = iosArm64()
    val iosX64 = iosX64() // iosX64("ios") // iosX64()

    listOf(
        iosX64,
        iosArm64,
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "kmm-wordsphrases"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api("org.jetbrains.kotlin:kotlin-stdlib-common")

                implementation("com.squareup.sqldelight:runtime:1.5.3")
                implementation("dev.gitlive:firebase-firestore:1.6.1")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:android-driver:1.5.3")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        iosMain.dependencies {
            implementation("com.squareup.sqldelight:native-driver:1.5.3")
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 26
        targetSdk = 32
    }
}