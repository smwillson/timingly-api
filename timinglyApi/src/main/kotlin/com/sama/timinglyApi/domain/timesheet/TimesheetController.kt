package com.sama.timinglyApi.domain.timesheet

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

//timesheets?userId=username1243&fromTime={iso-8601}&toTime={iso-8601}
@RestController
@RequestMapping("/api")
class TimesheetController(val timesheetService: TimesheetService) {
    @GetMapping("/timesheets")
    fun getTimesheets(
        @RequestParam("userId") userId: String,
        @RequestParam("fromTime") fromTime: Instant,
        @RequestParam("toTime") toTime: Instant
    ) = timesheetService.getTimesheetResponse(userId, fromTime, toTime)
}
