package com.creditas.document.find

import java.util.*

data class FindDocumentResponse(var id : String, var externalId: String, var product: ProductResponse, var file: FileResponse)

data class ProductResponse(var name: String)

data class FileResponse(var name: String?, var size: Long)