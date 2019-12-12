package com.creditas.document.upload

import com.creditas.document.domain.Document
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DocumentRepository : CrudRepository <Document, String> {
    fun findByKey(key: String) : Optional<Document>
}