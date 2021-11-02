package com.sama.timinglyApi.domain.timesheet

import java.time.Instant
import java.util.*

data class TimesheetResponse(
    val userName: String,
    val userId:UUID,
    val rangeStartDate: Instant,
    val rangeEndDate: Instant,
    val timesheets: List<Timesheet>
)


