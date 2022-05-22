plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.squareup.sqldelight")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization") version "1.6.10"
}

sqldelight {
    database("WordsphrasesDatabase") {
        packageName = "com.wordphrases.db"
        sourceFolders = listOf("sqldelight")
    }
}

version = "1.0"

kotlin {
    android()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../ios-wordphrases/Podfile")
        framework {
            baseName = "kmm_wordsphrases"
        }
    }

    sourceSets {

        val sqlDelightVersion = rootProject.ext["sqlDelightVersion"]

        val commonMain by getting {
            dependencies {
                //api("org.jetbrains.kotlin:kotlin-stdlib-common")

                implementation("dev.gitlive:firebase-firestore:1.6.1")
                implementation("dev.gitlive:firebase-auth:1.6.1")

                val coroutinesVersion = rootProject.ext["coroutinesVersion"]
                //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
                implementation("com.squareup.sqldelight:coroutines-extensions:$sqlDelightVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
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
            implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
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
    compileSdk = rootProject.ext["compileSdkAndroidVersion"] as Int
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = rootProject.ext["minSdkAndroidVersion"] as Int
        targetSdk = rootProject.ext["compileSdkAndroidVersion"] as Int
    }
}