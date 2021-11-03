package com.sama.timinglyApi.domain.timesheet

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.*

//timesheets?userId=username1243&fromTime={iso-8601}&toTime={iso-8601}
@RestController
@RequestMapping("/timesheets")
class TimesheetController(val timesheetService: TimesheetService) {
    @GetMapping
    fun getTimesheets(
        @RequestParam("userId") userId: String,
        @RequestParam("fromTime") fromTime: Instant,
        @RequestParam("toTime") toTime: Instant
    ) = timesheetService.getTimesheetResponse(userId, fromTime, toTime)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{userId}")
    fun createTimesheet(userId:UUID) = timesheetService.createTimesheet(userId)
}
