package com.sama.timinglyApi.domain.timesheet

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TimesheetRepository : JpaRepository<TimesheetEntity, UUID> {

//    fun findByUserId(userId: UUID): Optional<TimesheetEntity>
}
