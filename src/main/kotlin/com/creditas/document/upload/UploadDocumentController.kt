package com.creditas.document.upload

import com.creditas.document.domain.Document
import com.creditas.document.domain.File
import com.creditas.document.domain.Product
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class UploadDocumentController(private val createDocument: CreateDocument) {

    @PostMapping("/api/v1/documents")
    fun upload(@RequestParam("file") multipart: MultipartFile, externalId: String, productName: String) : ResponseEntity<UploadDocumentResponse> {

        val document = Document(externalId, Product(productName), File(multipart.originalFilename, multipart.size));

        createDocument.create(document)

        return ResponseEntity.status(HttpStatus.CREATED).body(UploadDocumentResponse(document.key.toString()));
    }
}