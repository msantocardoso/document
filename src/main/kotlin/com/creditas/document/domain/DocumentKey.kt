package com.creditas.document.domain

class DocumentKey private constructor(prefix : String) : Key(prefix) {
    companion object {
        fun create() : String = DocumentKey("DOC").value
    }
}