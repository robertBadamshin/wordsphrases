pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "kmm_wordphrases"
include(":kmm-wordsphrases")

include(":android:app")
include(":android:navigation")
include(":android:core")
include(":android:core-ui")
include(":android:add-word-impl")
include(":android:add-word-api")
include(":android:home-impl")
include(":android:home-api")
include(":android:remote-api")
include(":android:remote-impl")
include(":android:translation-api")
include(":android:translation-impl")
include(":android:stories-api")
include(":android:stories-impl")
include(":android:popup-translator-impl")
include(":android:email-sender-impl")
include(":android:email-sender-api")
include(":android:login-impl")
include(":android:login-api")
include(":android:select-language-impl")
include(":android:select-language-api")
include(":android:entity")
include(":android:kmm-wordphrases")
