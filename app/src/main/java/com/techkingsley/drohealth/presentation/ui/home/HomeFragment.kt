package com.techkingsley.drohealth.presentation.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.techkingsley.drohealth.R
import com.techkingsley.drohealth.data.local.model.Services
import com.techkingsley.drohealth.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home), ServicesAdapter.OnItemClickedListener {

    private lateinit var viewBinding: FragmentHomeBinding

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val hostActivity = (activity as AppCompatActivity)
        hostActivity.setSupportActionBar(viewBinding.homeFragmentToolbar)
        hostActivity.supportActionBar?.setDisplayShowTitleEnabled(false)
        hostActivity.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_settings)
        hostActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setUpRecyclerView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentHomeBinding.bind(requireView())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_fragment_menu, menu)
    }

    private fun setUpRecyclerView() {
        val colorBlue = ContextCompat.getColor(requireContext(), R.color.blue)
        val colorPink = ContextCompat.getColor(requireContext(), R.color.pink)
        val colorPurple = ContextCompat.getColor(requireContext(), R.color.purple)
        val services = listOf(
            Services("Book an appointment", R.drawable.ic_calendar_appointment, colorBlue),
            Services("Order Medication", R.drawable.ic_checkup, colorPink),
            Services("Book a diagnostic test", R.drawable.ic_microscope, colorPurple)
        )

        val tagAdapter = ServicesAdapter(this)
        tagAdapter.submitList(services)
        viewBinding.servicesRecyclerview.adapter = tagAdapter
    }

    override fun onServiceClicked(services: Services) {
        // Handle onclick of services here
    }
}