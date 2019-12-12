package com.creditas.document.domain

import java.util.*

abstract class Key (prefix : String) {
    val value = "${prefix.trim().toUpperCase()}-${UUID.randomUUID().toString().toUpperCase()}"
}