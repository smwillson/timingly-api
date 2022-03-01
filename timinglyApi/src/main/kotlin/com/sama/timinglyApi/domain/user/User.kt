package com.sama.timinglyApi.domain.user

import java.util.*

data class User(

    val id: UUID = UUID.randomUUID(),

    val firstName: String,

    val lastName: String
)
