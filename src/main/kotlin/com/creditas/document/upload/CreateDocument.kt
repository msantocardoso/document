package com.creditas.document.upload

import com.creditas.document.domain.Document
import org.springframework.stereotype.Service

@Service
class CreateDocument(private val documentRepository: DocumentRepository) {

    fun create(document: Document) {
        documentRepository.save(document)
    }

}
