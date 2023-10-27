package com.jicay.unittests

import assertk.assertThat
import assertk.assertions.isBetween
import assertk.assertions.isEqualTo
import net.jqwik.api.ForAll
import net.jqwik.api.Property
import net.jqwik.api.constraints.CharRange
import net.jqwik.api.constraints.IntRange
import org.junit.jupiter.api.Test

class AdditionTest {

    @Test
    fun `add numbers 1 and 2 should equals to 3`() {
        // Arrange
        val a = 1
        val b = 2
        val addOperator = AddOperator()

        // Act
        val res = addOperator.add(a, b)

        // Assert
        assertThat(res).isEqualTo(3)
    }

    @Property
    fun `identity of addition`(
        @ForAll a: Int
    ) {
        // Arrange
        val addOperator = AddOperator()

        // Act
        val res = addOperator.add(a, 0)

        // Assert
        assertThat(res).isEqualTo(a)
    }

    @Property
    fun `associativity of addition`(
        @ForAll a: Int,
        @ForAll b: Int
    ) {
        // Arrange
        val addOperator = AddOperator()

        // Act
        val res1 = addOperator.add(a, b)
        val res2 = addOperator.add(a, b)

        // Assert
        assertThat(res1).isEqualTo(res2)
    }

    @Property
    fun `cipher should be circular`(
        @ForAll a: Int,
        @ForAll b: Int,
        @ForAll c: Int
    ) {
        // Arrange
        val addOperator = AddOperator()

        // Act
        val res1 = addOperator.add(a, addOperator.add(b, c))
        val res2 = addOperator.add(addOperator.add(a, b), c)

        // Assert
        assertThat(res1).isEqualTo(res2)
    }
}

class AddOperator {
    fun add(a: Int, b: Int) = a + b
}
