package com.creditas.document.find

import com.creditas.document.domain.Document
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class FindDocumentController(private val findDocument : FindDocument) {

    @GetMapping("/api/v1/documents")
    fun findAll() : ResponseEntity<List<FindDocumentResponse>> {

        val documents: List<FindDocumentResponse> = findDocument.all().map {
            FindDocumentResponse(
                it.key,
                it.externalId,
                ProductResponse(it.product.name),
                FileResponse(it.file.name, it.file.size)
            )
        }

        return ResponseEntity.ok(documents);
    }

    @GetMapping("/api/v1/documents/{id}")
    fun findAll(@PathVariable("id") id: String) : ResponseEntity<FindDocumentResponse> {

        val documentFound: Optional<Document> = findDocument.findByKey(id)

        if(documentFound.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }

        val result: Document = documentFound.get()
        val document: FindDocumentResponse = FindDocumentResponse(
            result.key,
            result.externalId,
            ProductResponse(result.product.name),
            FileResponse(result.file.name, result.file.size)
        )

        return ResponseEntity.ok(document);
    }
}