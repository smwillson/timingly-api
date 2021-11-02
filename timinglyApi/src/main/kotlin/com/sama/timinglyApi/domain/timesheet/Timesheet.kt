package com.sama.timinglyApi.domain.timesheet

import org.valiktor.functions.isGreaterThanOrEqualTo
import org.valiktor.functions.isNotNull
import org.valiktor.validate
import java.time.Instant
import java.util.*

data class Timesheet(
    val id: UUID = UUID.randomUUID(),

    val userId: UUID,

    var projectName: String?,

    var projectId: UUID,

    var date: Instant,

    var hours: Double

) {
    init {
        validate(this) {
            validate(Timesheet::userId).isNotNull()

            validate(Timesheet::projectId).isNotNull()

            validate(Timesheet::date).isNotNull()

            validate(Timesheet::hours).isNotNull().isGreaterThanOrEqualTo(0F)
        }
    }
    companion object{
        fun from(entity: TimesheetEntity)= Timesheet(
            id = entity.id,
            userId = entity.userId,
            projectName = entity?.projectName,
            projectId = entity.projectId,
            date = entity.date,
            hours = entity.hours
        )
    }
}
