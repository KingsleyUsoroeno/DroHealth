package com.techkingsley.drohealth.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techkingsley.drohealth.R
import com.techkingsley.drohealth.data.local.model.Services
import com.techkingsley.drohealth.databinding.LayoutServicesBinding

class ServicesAdapter(private val onItemClickedListener: OnItemClickedListener) : RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder>() {

    private var searchHistoryList = emptyList<Services>()

    interface OnItemClickedListener {
        fun onServiceClicked(services: Services)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_services, parent, false)
        val viewBinding = LayoutServicesBinding.bind(view)
        return ServicesViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return searchHistoryList.size
    }

    fun submitList(searchHistoryList: List<Services>) {
        this.searchHistoryList = searchHistoryList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.updateSearchHistory(searchHistoryList[position])
    }

    inner class ServicesViewHolder(private val viewBinding: LayoutServicesBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun updateSearchHistory(services: Services) {
            viewBinding.textServiceType.text = services.serviceType
            viewBinding.imgImage.setBackgroundResource(services.iconType)
            viewBinding.parentLayout.setBackgroundColor(services.backgroundColor)
        }
    }
}