package com.sama.timinglyApi.domain.timesheet

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TimesheetRepository : JpaRepository<TimesheetEntity, UUID> {

    fun findByUserId(userId: UUID): Optional<TimesheetEntity>
}