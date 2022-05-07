package com.wordphrases

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}