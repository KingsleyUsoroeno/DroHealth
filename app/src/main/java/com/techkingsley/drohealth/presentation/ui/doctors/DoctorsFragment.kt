package com.techkingsley.drohealth.presentation.ui.doctors

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.techkingsley.drohealth.R
import com.techkingsley.drohealth.databinding.FragmentDoctorsBinding

class DoctorsFragment : Fragment(R.layout.fragment_doctors) {

    private lateinit var viewBinding: FragmentDoctorsBinding

    companion object {
        @JvmStatic
        fun newInstance() = DoctorsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val hostActivity = (activity as AppCompatActivity)
        hostActivity.setSupportActionBar(viewBinding.doctorsFragmentToolbar)
        hostActivity.supportActionBar?.setDisplayShowTitleEnabled(false)
        //setStatusBarColor(ContextCompat.getColor(requireContext(), R.color.turquoise))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentDoctorsBinding.bind(requireView())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.appointment_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    private fun setStatusBarColor(color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            activity?.window?.statusBarColor = color
        }
    }
}