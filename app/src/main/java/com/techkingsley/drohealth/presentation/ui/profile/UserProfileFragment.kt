package com.techkingsley.drohealth.presentation.ui.profile

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.techkingsley.drohealth.R
import com.techkingsley.drohealth.presentation.utils.AppUtils

class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {

    companion object {
        @JvmStatic
        fun newInstance() = UserProfileFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AppUtils.setStatusBarColor(requireActivity(), ContextCompat.getColor(requireContext(), R.color.white))
    }
}