package com.creditas.document.find

import com.creditas.document.domain.Document
import com.creditas.document.upload.DocumentRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class FindDocument(private val documentRepository : DocumentRepository) {

    fun all() : List<Document> {
        return documentRepository.findAll().toList()
    }

    fun findByKey(key: String) : Optional<Document> {
        return documentRepository.findByKey(key)
    }
}