package com.techkingsley.drohealth.presentation.ui.doctors

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.PagerSnapHelper
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar
import com.techkingsley.drohealth.R
import com.techkingsley.drohealth.data.local.model.Appointment
import com.techkingsley.drohealth.data.local.model.AppointmentManager
import com.techkingsley.drohealth.data.local.model.AvailableDoctors
import com.techkingsley.drohealth.databinding.FragmentDoctorsBinding
import com.techkingsley.drohealth.presentation.ui.adapter.*
import com.techkingsley.drohealth.presentation.utils.AppUtils.setStatusBarColor


class DoctorsFragment : Fragment(R.layout.fragment_doctors), MorningScheduleAdapter.OnItemClickedListener,
    AfternoonScheduleAdapter.OnItemClickedListener, EveningScheduleAdapter.OnItemClickedListener, EarlyScheduleAdapter.OnItemClickedListener {

    private lateinit var viewBinding: FragmentDoctorsBinding
    private lateinit var morningScheduleAdapter: MorningScheduleAdapter
    private lateinit var eveningScheduleAdapter: EveningScheduleAdapter
    private lateinit var earlyScheduleAdapter: EarlyScheduleAdapter
    private lateinit var afternoonScheduleAdapter: AfternoonScheduleAdapter
    private lateinit var adapter: ConcatAdapter
    private lateinit var calendarView: CollapsibleCalendar
    private val appointmentManager = AppointmentManager
    private lateinit var pageSnapHelper: PagerSnapHelper
    private lateinit var doctorsRecyclerViewPagerSnapHelper: PagerSnapHelper

    companion object {
        @JvmStatic
        fun newInstance() = DoctorsFragment()
        private const val TAG = "DoctorsFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setStatusBarColor(requireActivity(), ContextCompat.getColor(requireContext(), R.color.turquoise), setUiVisibility = true)
        val hostActivity = (activity as AppCompatActivity)
        hostActivity.setSupportActionBar(viewBinding.doctorsFragmentToolbar)
        hostActivity.supportActionBar?.setDisplayShowTitleEnabled(false)
        pageSnapHelper = PagerSnapHelper()
        doctorsRecyclerViewPagerSnapHelper = PagerSnapHelper()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentDoctorsBinding.bind(requireView())
        calendarView = viewBinding.calendarView
        setUpCalendar()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.appointment_fragment_menu, menu)
    }

    private fun setUpCalendar() {
        calendarView.setCalendarListener(object : CollapsibleCalendar.CalendarListener {
            override fun onClickListener() {

            }

            override fun onDataUpdate() {

            }

            override fun onDayChanged() {

            }

            override fun onDaySelect() {
                val day = viewBinding.calendarView.selectedDay
                Log.i("Doc", "Selected Day: ${day?.year}  and day is ${day?.day}")
                val dayTime = day?.day
                dayTime?.let { buildRecyclerView(it) }
            }

            override fun onItemClick(v: View) {

            }

            override fun onMonthChange() {
            }

            override fun onWeekChange(position: Int) {

            }
        })
    }

    private fun buildRecyclerView(date: Int) {
        val result = appointmentManager.appointment.filter { it.dayOfWeek == date }
        Log.i(TAG, "$result")
        if (result.isNullOrEmpty().not()) {
            morningScheduleAdapter = MorningScheduleAdapter(result, this)
            afternoonScheduleAdapter = AfternoonScheduleAdapter(result, this)
            eveningScheduleAdapter = EveningScheduleAdapter(result, this)
            earlyScheduleAdapter = EarlyScheduleAdapter(result, this)
            val listOfAdapters = listOf(morningScheduleAdapter, afternoonScheduleAdapter, eveningScheduleAdapter, earlyScheduleAdapter)
            adapter = ConcatAdapter(listOfAdapters)
            viewBinding.availableTimeRecyclerview.adapter = adapter
            viewBinding.textNoAvailableTimeSlot.visibility = View.INVISIBLE
            viewBinding.availableTimeRecyclerview.visibility = View.VISIBLE
            viewBinding.indicator.visibility = View.VISIBLE
            pageSnapHelper.attachToRecyclerView(viewBinding.availableTimeRecyclerview)
            viewBinding.indicator.attachToRecyclerView(viewBinding.availableTimeRecyclerview, pageSnapHelper)
        } else {
            viewBinding.textNoAvailableTimeSlot.visibility = View.VISIBLE
            viewBinding.availableTimeRecyclerview.visibility = View.INVISIBLE
            viewBinding.indicator.visibility = View.INVISIBLE
        }
    }

    override fun onAppointmentTimeClicked(time: String) {
        Log.i(TAG, "time is $time")
        val availableDoctors = arrayListOf<AvailableDoctors>()
        appointmentManager.appointment.forEach { appointments ->
            appointments.availableDoctors.forEach { availableDocs ->
                if(availableDocs.time == time){
                    availableDoctors.add(availableDocs)
                }
            }
        }
        Log.i(TAG, "available doctors is ${availableDoctors.distinct()}")
        if (availableDoctors.isNullOrEmpty().not()) {
            val doctorsAdapter = DoctorsRecyclerAdapter(availableDoctors.distinct())
            viewBinding.availableDoctorsRecyclerview.adapter = doctorsAdapter
            viewBinding.textAvailableDoctorsCount.text = "(${availableDoctors.distinct().size})"
            viewBinding.availableDoctorsRecyclerview.visibility = View.VISIBLE
            viewBinding.textNoAvailableDoctors.visibility = View.INVISIBLE
            pageSnapHelper.attachToRecyclerView(viewBinding.availableTimeRecyclerview)
            viewBinding.doctorsRecyclerViewIndicator.attachToRecyclerView(viewBinding.availableDoctorsRecyclerview, doctorsRecyclerViewPagerSnapHelper)
            viewBinding.doctorsRecyclerViewIndicator.visibility = View.VISIBLE
        } else {
            viewBinding.textNoAvailableDoctors.visibility = View.VISIBLE
            viewBinding.availableDoctorsRecyclerview.visibility = View.INVISIBLE
            viewBinding.doctorsRecyclerViewIndicator.visibility = View.INVISIBLE
        }
    }
}