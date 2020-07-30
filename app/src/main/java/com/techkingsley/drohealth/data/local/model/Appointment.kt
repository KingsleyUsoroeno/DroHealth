package com.techkingsley.drohealth.data.local.model

data class Appointment(
    val dayOfWeek: Int,
    val morningSchedule: MorningSchedule,
    val afternoonSchedule: AfternoonSchedule,
    val eveningSchedule: EveningSchedule,
    val earlySchedules: EarlySchedule,
    val availableDoctors: List<AvailableDoctors>
)

data class AfternoonSchedule(
    val availableTimes: List<String>
)

data class EveningSchedule(
    val availableTimes: List<String>
)

data class EarlySchedule(
    val availableTimes: List<String>
)

data class AvailableDoctors(
    val time: String,
    val doctorName: String,
    val doctorType: String,
    val doctorProfileImage: Int,
    val doctorAppointmentPrice: String
)

data class MorningSchedule(
    val availableTimes: List<String>
)


