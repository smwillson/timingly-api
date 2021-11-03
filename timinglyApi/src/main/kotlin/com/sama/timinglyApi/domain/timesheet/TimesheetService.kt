package com.sama.timinglyApi.domain.timesheet

import java.time.Instant
import java.util.*

class TimesheetService {
    fun getTimesheetResponse(userId: String, fromTime: Instant, toTime: Instant): TimesheetResponse {
        //get timesheets -> findByUserId
        //check not null

        val timesheet = Timesheet(
            id = UUID.randomUUID(),
            userId = UUID.randomUUID(),
            projectId = UUID.randomUUID(),
            projectName = "random project",
            date = Instant.now(),
            hours = 8.5
        )
        return TimesheetResponse(
            userName = "Samwell Tarley",
            userId = UUID.randomUUID().toString(),
            rangeEndDate = Instant.now(),
            rangeStartDate = Instant.now(),
            timesheets = listOf(timesheet)

        )
    }

    fun createTimesheet(userId: UUID): CreateTimesheetResponse {
        return CreateTimesheetResponse(timeSheetId = UUID.randomUUID().toString())
    }
}