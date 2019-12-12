package com.creditas.document.upload

import com.creditas.document.domain.DocumentKey
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class DocumentKeyTest {
    @Test
    fun `should generate document key`() {
        val key = DocumentKey.create()
        assertTrue(key.startsWith("DOC-"))
    }
}