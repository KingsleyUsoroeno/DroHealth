package com.techkingsley.drohealth.presentation.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.techkingsley.drohealth.R
import com.techkingsley.drohealth.data.local.model.Appointment
import com.techkingsley.drohealth.databinding.LayoutEarlyScheduleBinding
import com.techkingsley.drohealth.databinding.LayoutMorningScheduleBinding

class MorningScheduleAdapter(private val appointments: List<Appointment>, private val onItemClickedListener: OnItemClickedListener) :
    RecyclerView.Adapter<MorningScheduleAdapter.DataViewHolder>() {

    interface OnItemClickedListener {
        fun onAppointmentTimeClicked(time: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_morning_schedule, parent, false)
        val viewBinding = LayoutMorningScheduleBinding.bind(view)
        return DataViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = appointments.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) = holder.bind(appointments[position])

    inner class DataViewHolder(private val view: LayoutMorningScheduleBinding) : RecyclerView.ViewHolder(view.root) {
        private val chipGroup = view.chipGroup
        fun bind(appointment: Appointment) {
            if (appointment.morningSchedule.availableTimes.isNullOrEmpty().not()) {
                val scheduleSize = appointment.morningSchedule.availableTimes.size
                view.textStartTimeSchedule.text = appointment.morningSchedule.availableTimes[0]
                view.textEndTimeSchedule.text = appointment.morningSchedule.availableTimes[scheduleSize - 1]
                for (schedule in appointment.morningSchedule.availableTimes) {
                    val chip = LayoutInflater.from(view.root.context).inflate(R.layout.layout_item_chip, null, false) as Chip
                    chip.text = schedule
                    chip.isClickable = true
                    chipGroup.addView(chip as View)

                    chip.setOnCheckedChangeListener { compoundButton, b ->
                        if (b) {
                            compoundButton.setTextColor(ContextCompat.getColor(view.root.context, R.color.white))
                            onItemClickedListener.onAppointmentTimeClicked(time = schedule)
                        } else {
                            compoundButton.setTextColor(ContextCompat.getColor(view.root.context, R.color.black))
                        }
                    }
                }
            }
        }
    }
}

class EarlyScheduleAdapter(private val appointments: List<Appointment>, private val onItemClickedListener: OnItemClickedListener) :
    RecyclerView.Adapter<EarlyScheduleAdapter.DataViewHolder>() {

    interface OnItemClickedListener {
        fun onAppointmentTimeClicked(time: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_early_schedule, parent, false)
        val viewBinding = LayoutEarlyScheduleBinding.bind(view)
        return DataViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = appointments.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) = holder.bind(appointment = appointments[position])

    inner class DataViewHolder(private val view: LayoutEarlyScheduleBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(appointment: Appointment) {
            if (appointment.earlySchedules.availableTimes.isNullOrEmpty().not()) {
                val schedules = appointment.earlySchedules.availableTimes
                val scheduleSize = schedules.size
                view.textStartTimeSchedule.text = schedules[0]
                view.textEndTimeSchedule.text = schedules[scheduleSize - 1]
                for (scheduleTime in schedules) {
                    Log.i("EarlyScheduleAdapter", scheduleTime)
                    val chip = LayoutInflater.from(view.root.context).inflate(R.layout.layout_item_chip, null, false) as Chip
                    chip.text = scheduleTime
                    chip.isClickable = true
                    view.chipGroup.addView(chip as View)

                    chip.setOnCheckedChangeListener { compoundButton, b ->
                        if (b) {
                            compoundButton.setTextColor(ContextCompat.getColor(view.root.context, R.color.white))
                            onItemClickedListener.onAppointmentTimeClicked(time = scheduleTime)
                        } else {
                            compoundButton.setTextColor(ContextCompat.getColor(view.root.context, R.color.black))
                        }
                    }
                }
            }
        }
    }
}