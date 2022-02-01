package com.sama.timinglyApi.domain.timesheet

data class TimesheetResponse(
    val timesheetsForDate: MutableMap<String, List<Timesheet> >,
)

data class CreateTimesheetResponse(val timeSheetId: String)
/*
{
    "1-16-2021": [
        {
            "name": "Project A",
            "hours": 13
        },
        {
            "name": "Project B",
            "hours": 1
        }

    ],
    "1-17-2021": [
        {
            "name": "Project A",
            "hours": 2
        },
        {
            "name": "Project B",
            "hours": 0
        }

    ],
    "1-18-2021": [
        {
            "name": "Project A",
            "hours": 0
        },
        {
            "name": "Project B",
            "hours": 0
        }

    ],

}
* */
