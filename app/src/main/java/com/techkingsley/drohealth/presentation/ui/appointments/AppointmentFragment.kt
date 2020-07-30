package com.techkingsley.drohealth.presentation.ui.appointments

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.techkingsley.drohealth.R
import com.techkingsley.drohealth.presentation.utils.AppUtils

class AppointmentFragment : Fragment(R.layout.fragment_appointment) {

    companion object {
        @JvmStatic
        fun newInstance() = AppointmentFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AppUtils.setStatusBarColor(requireActivity(), ContextCompat.getColor(requireContext(), R.color.white))
    }
}