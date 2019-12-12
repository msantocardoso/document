package com.creditas.document.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class Document (var externalId: String, var product: Product, var file: File) {
    @Id
    var id : UUID = UUID.randomUUID()
    @Indexed
    var key: String = DocumentKey.create()
}