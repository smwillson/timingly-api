package com.sama.timinglyApi.domain.timesheet

import org.valiktor.functions.isGreaterThanOrEqualTo
import org.valiktor.functions.isNotNull
import org.valiktor.validate
import java.time.LocalDateTime
import java.util.UUID

data class Timesheet(
    val id: UUID = UUID.randomUUID(),

    val userId: UUID,

    var projectName: String?,

    var projectId: UUID,

    var date: LocalDateTime,

    var hours: Double

) {
    init {
        validate(this) {
            validate(Timesheet::userId).isNotNull()

            validate(Timesheet::projectId).isNotNull()

            validate(Timesheet::date).isNotNull()

            validate(Timesheet::hours).isNotNull().isGreaterThanOrEqualTo(0.0)
        }
    }
    companion object {
        fun from(entity: TimesheetEntity) = Timesheet(
            id = entity.id,
            userId = entity.userId,
            projectName = entity?.projectName,
            projectId = entity.projectId,
            date = entity.date,
            hours = entity.hours
        )
    }
}
