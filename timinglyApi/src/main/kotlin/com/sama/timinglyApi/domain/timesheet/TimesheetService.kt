package com.sama.timinglyApi.domain.timesheet

import com.sama.timinglyApi.getDatesOfWeek
import com.sama.timinglyApi.getFirstDayOfWeek
import com.sama.timinglyApi.getLastDayOfWeek
import com.sama.timinglyApi.isDayBetweenStartAndEndOfWeek
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import java.util.*

@Service
class TimesheetService(val timesheetRepository: TimesheetRepository) {
    fun getTimesheetResponse(userId: String, fromTime: Instant, toTime: Instant): TimesheetResponse {
        // get timesheets -> findByUserId
        // check not null
        val week = Calendar.getInstance(TimeZone.getTimeZone("UTC")).get(Calendar.WEEK_OF_YEAR)
        val DEFAULT_ZONE_ID = ZoneId.of("UTC")
        val endOfWeek = LocalDateTime.now(DEFAULT_ZONE_ID).getLastDayOfWeek()
        val startOfWeek = LocalDateTime.now(DEFAULT_ZONE_ID).getFirstDayOfWeek()
        var day = startOfWeek
        while (day.isDayBetweenStartAndEndOfWeek(endOfWeek)) {
            println(day)
            day = day.plus(1, ChronoUnit.DAYS)
        }

        val timesheet = Timesheet(
            id = UUID.randomUUID(),
            projectId = UUID.randomUUID(),
            date = LocalDateTime.now(),
//            dayOfWeek = LocalDateTime.parse(LocalDateTime.now().toString()).dayOfWeek,
            hours = 9.0,
            isDeleted = false
        )

        val timesheet2 = Timesheet(
            id = UUID.randomUUID(),
            projectId = UUID.randomUUID(),
            date = LocalDateTime.now().plus(1, ChronoUnit.DAYS),
//            dayOfWeek = LocalDateTime.parse(LocalDateTime.now().toString()).dayOfWeek,
            hours = 6.5,
            isDeleted = false
        )

        val timesheet3 = Timesheet(
            id = UUID.randomUUID(),
            projectId = UUID.randomUUID(),
            date = LocalDateTime.now().plus(1, ChronoUnit.DAYS),
//            dayOfWeek = LocalDateTime.parse(LocalDateTime.now().toString()).dayOfWeek,
            hours = 10.0,
            isDeleted = false
        )
//        println(timesheet.date.truncatedTo(ChronoUnit.DAYS))
        val totalTimesheets = mutableListOf(timesheet, timesheet2, timesheet3)
        val defaultTimesheet = Timesheet(
            id = UUID.randomUUID(),
            projectId = UUID.randomUUID(),
            date = LocalDateTime.now().plus(1, ChronoUnit.DAYS),
//            dayOfWeek = LocalDateTime.parse(LocalDateTime.now().toString()).dayOfWeek,
            hours = 0.0,
            isDeleted = false
        )

// TODO : how to filter by project and default sheets for missing projects????
        val timesheetsForWeek = mutableMapOf<String, List<Timesheet>>()
        val datesForWeek = getDatesOfWeek(startOfWeek, endOfWeek)
        val allTimesheets = timesheetRepository.findAll()
        println(allTimesheets)
//        for (date in datesForWeek) {
//            val thisTimesheet =
//                totalTimesheets.filter { timesheet -> timesheet.date.truncatedTo(ChronoUnit.DAYS).isEqual(date) }
//            if (thisTimesheet.isNotEmpty()) {
//                timesheetsForWeek[date.truncatedTo(ChronoUnit.DAYS).toString()] = thisTimesheet
//                // create a LocalDateTime Object
//                // create a LocalDateTime Object
//                val local = LocalDateTime.parse(timesheet.date.toString())
//
//                // get dayofweek for this LocalDateTime
//
//                // get dayofweek for this LocalDateTime
//                val dayofweek = local.dayOfWeek
//
//                // print result
//
//                // print result
//                println(
//                    "Day of Week: " +
//                        dayofweek
//                )
//            } else {
//                timesheetsForWeek[date.toString()] = mutableListOf(defaultTimesheet)
//            }
//        }
        return TimesheetResponse(
            timesheetsForWeek

        )
    }

    fun createTimesheet(userId: UUID): CreateTimesheetResponse {

        return CreateTimesheetResponse(timeSheetId = UUID.randomUUID().toString())
    }
}
