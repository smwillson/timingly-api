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
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table

@Table(name = "timesheets")
@Entity
@Audited
@SQLDelete(sql = "UPDATE timesheets SET is_deleted = TRUE WHERE id = ?")
@Where(clause = "NOT is_deleted")
data class TimesheetEntity(

    @Column(name = "project_id")
    val projectId: UUID,

    @Column(name = "time_sheet_date")
    val date: LocalDateTime,

//    @Enumerated(EnumType.STRING)
//    val dayOfWeek: DayOfWeek,

    val hours: Double,


    val isDeleted: Boolean = false

) : BaseEntity() {

    init {
        validate(this) {
            validate(TimesheetEntity::hours).isGreaterThanOrEqualTo(0.0)

//            validate(TimesheetEntity::dayOfWeek).isNotNull()
        }
    }

    companion object {
        fun from(timesheet: Timesheet): TimesheetEntity {
            return TimesheetEntity(
                projectId = timesheet.projectId,
                date = timesheet.date,
//                dayOfWeek = timesheet.dayOfWeek,
                hours = timesheet.hours,
                isDeleted = timesheet.isDeleted
            )
        }
    }
}
