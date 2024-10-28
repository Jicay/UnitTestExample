package com.jicay.unittests

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

class AdditionTest : FunSpec({

    test("add numbers 1 and 2 should equals to 3") {
        // Arrange
        val a = 1
        val b = 2
        val addOperator = AddOperator()

        // Act
        val res = addOperator.add(a, b)

        // Assert
        res shouldBe 3
    }

    test("identity of addition") {
        checkAll<Int> { a ->
            // Arrange
            val addOperator = AddOperator()

            // Act
            val res = addOperator.add(a, 0)

            // Assert
            res shouldBe a
        }
    }

    test("associativity of addition") {
        checkAll<Int, Int> { a, b ->
            // Arrange
            val addOperator = AddOperator()

            // Act
            val res1 = addOperator.add(a, b)
            val res2 = addOperator.add(b, a)

            // Assert
            res1 shouldBe res2

        }
    }

    test("cipher should be circular") {
        checkAll<Int, Int, Int> { a, b, c ->
            // Arrange
            val addOperator = AddOperator()

            // Act
            val res1 = addOperator.add(a, addOperator.add(b, c))
            val res2 = addOperator.add(addOperator.add(a, b), c)

            // Assert
            res1 shouldBe res2

        }
    }
})

class AddOperator {
    fun add(a: Int, b: Int) = a + b
}
