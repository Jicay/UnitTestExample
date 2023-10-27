package com.jicay.unittests

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.hasMessage
import assertk.assertions.isEqualTo
import assertk.assertions.isInstanceOf
import org.junit.jupiter.api.Test


class CesarCipherTest {

    @Test
    fun `cipher 'A' with key 2 should return 'C'`() {
        // Arrange
        val char = 'A'
        val key = 2

        // Act
        val res = cipher(char, key)

        // Assert
        assertThat(res).isEqualTo('C')
    }

    @Test
    fun `cipher 'A' with key 0 should return 'A'`() {
        // Arrange
        val char = 'O'
        val key = 10479

        // Act
        val res = cipher(char, key)

        // Assert
        assertThat(res).isEqualTo('A')
    }

    @Test
    fun `cipher 'A' with key 5 should return 'F'`() {
        // Arrange
        val char = 'A'
        val key = 5

        // Act
        val res = cipher(char, key)

        // Assert
        assertThat(res).isEqualTo('F')
    }

    @Test
    fun `cipher 'Y' with key 5 should return 'D'`() {
        // Arrange
        val char = 'Y'
        val key = 5

        // Act
        val res = cipher(char, key)

        // Assert
        assertThat(res).isEqualTo('D')
    }

    @Test
    fun `cipher 'A' with key 53 should return 'B'`() {
        // Arrange
        val char = 'A'
        val key = 53

        // Act
        val res = cipher(char, key)

        // Assert
        assertThat(res).isEqualTo('B')
    }

    @Test
    fun `cipher 'A' with key -2 should throw an error`() {
        // Arrange
        val char = 'A'
        val key = -2

        // Act
        // Assert
        assertFailure { cipher(char, key) }
            .isInstanceOf(IllegalArgumentException::class)
            .hasMessage("Key must be positive")
    }
}