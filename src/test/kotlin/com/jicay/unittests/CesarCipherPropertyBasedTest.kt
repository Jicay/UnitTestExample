package com.jicay.unittests

import assertk.assertThat
import assertk.assertions.isBetween
import assertk.assertions.isEqualTo
import net.jqwik.api.ForAll
import net.jqwik.api.Property
import net.jqwik.api.constraints.CharRange
import net.jqwik.api.constraints.IntRange

class CesarCipherPropertyBasedTest {

    @Property
    fun `decipher and cipher should be symmetric`(
        @ForAll char: @CharRange(from = 'A', to = 'Z') Char,
        @ForAll key: @IntRange(min = 0) Int
    ) {
        assertThat(decipher(cipher(char, key), key)).isEqualTo(char)
    }

    @Property
    fun `result of cipher should always be between 'A' and 'Z'`(
        @ForAll char: @CharRange(from = 'A', to = 'Z') Char,
        @ForAll key: @IntRange(min = 0) Int
    ) {
        assertThat(cipher(char, key)).isBetween('A', 'Z')
    }

    @Property
    fun `cipher should be circular`(
        @ForAll char: @CharRange(from = 'A', to = 'Z') Char,
        @ForAll key: @IntRange(min = 26) Int
    ) {
        val encrypted = cipher(char, key)
        val moduloEncrypted = cipher(char, key % 26)
        assertThat(encrypted).isEqualTo(moduloEncrypted)
    }
}