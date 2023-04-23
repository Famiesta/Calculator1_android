package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class HistoryRecycleAdapter(val recycleData: List<String>, val context: Context) :
    RecyclerView.Adapter<HistoryRecycleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryRecycleAdapter.ViewHolder {
        val converView =
            LayoutInflater.from(context).inflate(R.layout.historyrecycle_item, parent, false)
        return ViewHolder(converView)
    }

    override fun onBindViewHolder(holder: HistoryRecycleAdapter.ViewHolder, position: Int) {
        val item = recycleData[position]
        holder.bindData(item)
    }

    override fun getItemCount(): Int {
        return recycleData.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val rvTitle: TextView
        private val rvTime: TextView

        init {
            rvTitle = view.findViewById(R.id.rvTittle)
            rvTime = view.findViewById(R.id.rvTime)
        }

        fun bindData(item: String) {
            rvTitle.text = item
            val formatDate = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US)
            val currentTime = Calendar.getInstance().time
            rvTime.text = formatDate.format(currentTime)
        }
    }


}