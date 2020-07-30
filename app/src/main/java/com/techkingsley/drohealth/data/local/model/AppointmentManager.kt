package com.techkingsley.drohealth.data.local.model

import com.techkingsley.drohealth.R

object AppointmentManager {
    private val firstMorningSchedule = listOf(
        "06:00am", "06:30am", "07:00am", "07:30 am", "08:00am", "08:30am"
    )

    private val secondMorningSchedule = listOf(
        "07:00am", "07:30am", "08:00am", "08:30 am", "09:00 am", "10:30am"
    )

    private val thirdMorningSchedule = listOf(
        "10:00am", "10:30am", "11:00am", "11:30 am", "12:00 am", "13:30am"
    )

    private val afternoonAvailableTime = listOf(
        "10:00am", "10:30am", "11:00am", "11:30 am", "12:00 am", "13:30am"
    )

    private val secondAfternoonAvailableTime = listOf(
        "11:00am", "11:30am", "12:30am", "13:30 am", "14:00 am", "16:30am"
    )

    private val thirdAfternoonAvailableTime = listOf(
        "12:00am", "13:30am", "14:00am", "15:30 am", "16:00 am", "17:30am"
    )

    private val eveningAvailableTime = listOf(
        "17:00am", "17:30am", "18:00am", "18:30 am", "19:00 am", "22:30am"
    )

    val earlyAvailableTime = listOf(
        "06:00am", "06:30am", "07:00am", "07:30 am", "08:00 am", "08:30am"
    )

    private val availableDoctors = listOf(
        AvailableDoctors("06:00am", "Andrew", "Sex Doctor", R.drawable.profile_img, "18,000"),
        AvailableDoctors("07:30am", "Samuel", "Dentist", R.drawable.profile_img, "20,000"),
        AvailableDoctors("22:30am", "Van Persie", "Football Doctor", R.drawable.profile_img, "100,000"),
        AvailableDoctors("14:00am", "Margaret", "Physician", R.drawable.profile_img, "15,000"),
        AvailableDoctors("11:00am", "Sammy", "Mechanic Doctor", R.drawable.profile_img, "12,000"),
        AvailableDoctors("06:00am", "Femi", "Computer Doctor", R.drawable.profile_img, "45,000"),
        AvailableDoctors("06:30am", "Kingsley", "Programmer Doctor", R.drawable.profile_img, "39,000"),
        AvailableDoctors("06:00am", "Emmanuel", "Eye Doctor", R.drawable.profile_img, "25,000")
    )

    private val morningSchedule = MorningSchedule(availableTimes = firstMorningSchedule)
    private val secMorningSchedule = MorningSchedule(availableTimes = secondMorningSchedule)
    private val thMorningSchedule = MorningSchedule(availableTimes = thirdMorningSchedule)
    private val afternoonSchedule = AfternoonSchedule(availableTimes = afternoonAvailableTime)
    private val secAfternoonSchedule = AfternoonSchedule(availableTimes = secondAfternoonAvailableTime)
    private val thirdAfternoonSchedule = AfternoonSchedule(availableTimes = thirdAfternoonAvailableTime)
    private val eveningSchedule = EveningSchedule(availableTimes = eveningAvailableTime)
    private val earlySchedule = EarlySchedule(availableTimes = afternoonAvailableTime)

    val appointment = listOf(
        Appointment(
            dayOfWeek = 31,
            morningSchedule = thMorningSchedule,
            afternoonSchedule = thirdAfternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 1,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 2,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 3,
            morningSchedule = secMorningSchedule,
            afternoonSchedule = secAfternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 4,
            morningSchedule = secMorningSchedule,
            afternoonSchedule = thirdAfternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 5,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 6,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 7,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 8,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 9,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 10,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 11,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 12,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 13,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 14,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 15,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 16,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),
        Appointment(
            dayOfWeek = 17,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),


        Appointment(
            dayOfWeek = 18,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        ),

        Appointment(
            dayOfWeek = 19,
            morningSchedule = morningSchedule,
            afternoonSchedule = afternoonSchedule,
            eveningSchedule = eveningSchedule,
            earlySchedules = earlySchedule,
            availableDoctors = availableDoctors
        )
    )

}