package com.jicay.unittests

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe


class CesarCipherTest : FunSpec({

    test("cipher 'A' with key 2 should return 'C'") {
        // Arrange
        val char = 'A'
        val key = 2

        // Act
        val res = cipher(char, key)

        // Assert
        res shouldBe 'C'
    }

    test("cipher 'A' with key 0 should return 'A'") {
        // Arrange
        val char = 'O'
        val key = 10479

        // Act
        val res = cipher(char, key)

        // Assert
        res shouldBe 'A'
    }

    test("cipher 'A' with key 5 should return 'F'") {
        // Arrange
        val char = 'A'
        val key = 5

        // Act
        val res = cipher(char, key)

        // Assert
        res shouldBe 'F'
    }

    test("cipher 'Y' with key 5 should return 'D'") {
        // Arrange
        val char = 'Y'
        val key = 5

        // Act
        val res = cipher(char, key)

        // Assert
        res shouldBe 'D'
    }

    test("cipher 'A' with key 53 should return 'B'") {
        // Arrange
        val char = 'A'
        val key = 53

        // Act
        val res = cipher(char, key)

        // Assert
        res shouldBe 'B'
    }

    test("cipher 'A' with key -2 should throw an error") {
        // Arrange
        val char = 'A'
        val key = -2

        // Act
        // Assert
        shouldThrowWithMessage<IllegalArgumentException>("Key must be positive") {
            cipher(char, key)
        }
    }
})