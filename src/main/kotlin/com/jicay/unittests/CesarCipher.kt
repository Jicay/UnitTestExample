package com.jicay.unittests

private const val FIRST_CHARACTER = 'A'
private const val LAST_CHARACTER = 'Z'

private const val NUMBER_OF_CHARACTER = 26

fun cipher(char: Char, key: Int): Char {
    if (key < 0) {
        throw IllegalArgumentException("Key must be positive")
    }

    val encrypted = char + key % NUMBER_OF_CHARACTER

    return when {
        encrypted > LAST_CHARACTER -> encrypted - NUMBER_OF_CHARACTER
        else -> encrypted
    }
}

fun decipher(char: Char, key: Int): Char {
    if (key < 0) {
        throw IllegalArgumentException("Key must be positive")
    }

    val decrypted = char - key % NUMBER_OF_CHARACTER

    return when {
        decrypted < FIRST_CHARACTER -> decrypted + NUMBER_OF_CHARACTER
        else -> decrypted
    }
}