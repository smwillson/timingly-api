package com.sama.timinglyApi.domain.timesheet

import org.valiktor.functions.isGreaterThanOrEqualTo
import org.valiktor.validate
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.util.*

data class Timesheet(
    val id: UUID = UUID.randomUUID(),

    val userId: UUID,

    var projectName: String?,

    var projectId: UUID,

    var date: LocalDateTime,

    val dayOfWeek: DayOfWeek,

    var hours: Double

) {
    init {
        validate(this) {
            validate(Timesheet::hours).isGreaterThanOrEqualTo(0.0)
        }
    }

    companion object {
        fun from(entity: TimesheetEntity) = Timesheet(
            id = entity.id,
            userId = entity.userId,
            projectName = entity?.projectName,
            projectId = entity.projectId,
            date = entity.date,
            dayOfWeek = entity.dayOfWeek,
            hours = entity.hours,
        )
    }
}
