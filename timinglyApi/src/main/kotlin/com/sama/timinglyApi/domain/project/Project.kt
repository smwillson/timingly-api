package com.sama.timinglyApi.domain.project

import java.util.*

data class Project(
    val id: UUID = UUID.randomUUID(),

    val userId: UUID,

    val projectName: String,

    val projectDescription: String?,

    val isDeleted: Boolean
)
