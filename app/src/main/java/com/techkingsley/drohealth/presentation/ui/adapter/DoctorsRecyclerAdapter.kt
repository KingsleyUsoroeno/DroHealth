package com.techkingsley.drohealth.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techkingsley.drohealth.R
import com.techkingsley.drohealth.data.local.model.Appointment
import com.techkingsley.drohealth.data.local.model.AvailableDoctors
import com.techkingsley.drohealth.databinding.LayoutAvailableDoctorsBinding

class DoctorsRecyclerAdapter(private val availableDoctors: List<AvailableDoctors>) : RecyclerView.Adapter<DoctorsRecyclerAdapter.DoctorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_available_doctors,parent,false)
        val viewBinding = LayoutAvailableDoctorsBinding.bind(view)
        return DoctorsViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return availableDoctors.size
    }

    override fun onBindViewHolder(holder: DoctorsViewHolder, position: Int) {
        holder.bind(availableDoctors[position])
    }

    inner class DoctorsViewHolder(val view: LayoutAvailableDoctorsBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(doctors: AvailableDoctors) {
            view.doctorsProfileImage.setImageResource(doctors.doctorProfileImage)
            view.doctors = doctors
            view.executePendingBindings()
        }
    }

}