package com.sama.timinglyApi.domain.timesheet

import com.sama.timinglyApi.entity.BaseEntity
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import org.valiktor.functions.isGreaterThanOrEqualTo
import org.valiktor.functions.isNotNull
import org.valiktor.validate
import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.Table

@Table(name = "time_sheet")
@Entity
@SQLDelete(sql = "UPDATE time_sheet SET deleted = TRUE WHERE id = ?")
@Where(clause = "NOT deleted")
data class TimesheetEntity(
    var userId: UUID,

    var projectName: String?,

    var projectId: UUID,

    var date: Instant,

    var hours: Float
) : BaseEntity() {
    init {
        validate(this) {
            validate(TimesheetEntity::userId).isNotNull()

            validate(TimesheetEntity::projectId).isNotNull()

            validate(TimesheetEntity::date).isNotNull()

            validate(TimesheetEntity::hours).isNotNull().isGreaterThanOrEqualTo(0F)
        }
    }

    companion object {
        fun from(timesheet: Timesheet): TimesheetEntity {
            val entity = TimesheetEntity(
                userId = timesheet.userId,
                projectName = timesheet.projectName,
                projectId = timesheet.projectId,
                date = timesheet.date,
                hours = timesheet.hours
            )
            return entity
        }
    }
}

