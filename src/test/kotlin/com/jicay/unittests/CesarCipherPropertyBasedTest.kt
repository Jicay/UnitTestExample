package com.jicay.unittests

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.char.shouldBeInRange
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.char
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll

class CesarCipherPropertyBasedTest : FunSpec({

    test("decipher and cipher should be symmetric") {
        checkAll(Arb.char('A'..'Z'), Arb.int(min = 0)) { char, key ->
            decipher(cipher(char, key), key) shouldBe char
        }
    }

    test("result of cipher should always be between 'A' and 'Z'") {
        checkAll(Arb.char('A'..'Z'), Arb.int(min = 0)) { char, key ->
            cipher(char, key) shouldBeInRange 'A'..'Z'
        }
    }

    test("cipher should be circular") {
        checkAll(Arb.char('A'..'Z'), Arb.int(min = 26)) { char, key ->
            val encrypted = cipher(char, key)
            val moduloEncrypted = cipher(char, key % 26)
            encrypted shouldBe moduloEncrypted
        }
    }
})