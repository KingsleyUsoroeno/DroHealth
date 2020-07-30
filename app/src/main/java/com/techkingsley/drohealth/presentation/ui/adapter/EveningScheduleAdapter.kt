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
import com.techkingsley.drohealth.databinding.LayoutEveningScheduleBinding

class EveningScheduleAdapter(private val appointments: List<Appointment>, private val onItemClickedListener: OnItemClickedListener) :
    RecyclerView.Adapter<EveningScheduleAdapter.DataViewHolder>() {

    interface OnItemClickedListener {
        fun onAppointmentTimeClicked(time: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_evening_schedule, parent, false)
        val viewBinding = LayoutEveningScheduleBinding.bind(view)
        return DataViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = appointments.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) = holder.bind(appointment = appointments[position])

    inner class DataViewHolder(private val view: LayoutEveningScheduleBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(appointment: Appointment) {
            if (appointment.eveningSchedule.availableTimes.isNullOrEmpty().not()) {
                val schedules = appointment.eveningSchedule.availableTimes
                val scheduleSize = schedules.size
                view.textStartTimeSchedule.text = schedules[0]
                view.textEndTimeSchedule.text = schedules[scheduleSize - 1]
                for (schedule in schedules) {
                    Log.i("EveningScheduleAdapter", "Evening schedules is $schedules")
                    val chip = LayoutInflater.from(view.root.context).inflate(R.layout.layout_item_chip, null, false) as Chip
                    chip.text = schedule
                    chip.isClickable = true
                    view.chipGroup.addView(chip as View)

                    chip.setOnCheckedChangeListener { compoundButton, b ->
                        if (b) {
                            compoundButton.setTextColor(ContextCompat.getColor(view.root.context, R.color.white))
                            onItemClickedListener.onAppointmentTimeClicked(schedule)
                        } else {
                            compoundButton.setTextColor(ContextCompat.getColor(view.root.context, R.color.black))
                        }
                    }
                }
            }
        }
    }
}