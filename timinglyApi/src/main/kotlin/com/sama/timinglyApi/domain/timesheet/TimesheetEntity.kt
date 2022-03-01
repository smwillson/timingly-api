package com.sama.timinglyApi.domain.timesheet

import com.sama.timinglyApi.entity.BaseEntity
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import org.hibernate.envers.Audited
import org.valiktor.functions.isGreaterThanOrEqualTo
import org.valiktor.functions.isNotNull
import org.valiktor.validate
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table

@Table(name = "time_sheet")
@Entity
@Audited
@SQLDelete(sql = "UPDATE time_sheet SET deleted = TRUE WHERE id = ?")
@Where(clause = "NOT deleted")
data class TimesheetEntity(
    val userId: UUID,

    val projectName: String?,

    val projectId: UUID,

    val date: LocalDateTime,

    @Enumerated(EnumType.STRING)
    val dayOfWeek: DayOfWeek,

    val hours: Double

) : BaseEntity() {

    init {
        validate(this) {
            validate(TimesheetEntity::hours).isGreaterThanOrEqualTo(0.0)

            validate(TimesheetEntity::dayOfWeek).isNotNull()
        }
    }

    companion object {
        fun from(timesheet: Timesheet): TimesheetEntity {
            return TimesheetEntity(
                userId = timesheet.userId,
                projectName = timesheet.projectName,
                projectId = timesheet.projectId,
                date = timesheet.date,
                dayOfWeek = timesheet.dayOfWeek,
                hours = timesheet.hours
            )
        }
    }
}
