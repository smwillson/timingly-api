package com.sama.timinglyApi.domain.timesheet

import org.valiktor.functions.isGreaterThanOrEqualTo
import org.valiktor.validate
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.util.*

data class Timesheet(
    val id: UUID = UUID.randomUUID(),

    var projectId: UUID,

    var date: LocalDateTime,

//    val dayOfWeek: DayOfWeek?,

    var hours: Double,

    var isDeleted: Boolean

) {
    init {
        validate(this) {
            validate(Timesheet::hours).isGreaterThanOrEqualTo(0.0)
        }
    }

    companion object {
        fun from(entity: TimesheetEntity) = Timesheet(
            id = entity.id,
            isDeleted = entity.isDeleted,
            projectId = entity.projectId,
            date = entity.date,
            hours = entity.hours,
        )
    }
}
