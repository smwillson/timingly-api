package com.sama.timinglyApi

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters

fun LocalDateTime.getFirstDayOfWeek(): LocalDateTime {
    return this.with(LocalTime.MIN).with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))
}
fun LocalDateTime.getLastDayOfWeek(): LocalDateTime {
    return this.with(LocalTime.MIN).with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
}
fun LocalDateTime.isDayBetweenStartAndEndOfWeek(endOfWeek: LocalDateTime): Boolean {
    return this.isBefore(endOfWeek) || this.isEqual(endOfWeek)
}

fun getDatesOfWeek(startDate: LocalDateTime, endDate: LocalDateTime):
    MutableList<LocalDateTime> {
    var day = startDate
    var datesOfWeek = mutableListOf<LocalDateTime>(startDate)
    while (day.isDayBetweenStartAndEndOfWeek(endDate)) {
        day = day.plus(1, ChronoUnit.DAYS)
        datesOfWeek.add(day)
    }
    return datesOfWeek
}
