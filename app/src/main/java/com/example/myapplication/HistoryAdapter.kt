package com.example.myapplication

import android.content.Context
import android.icu.text.CaseMap.Title
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextClock
import android.widget.TextView
import java.sql.Time

class HistoryAdapter(listData: List<String>, context:Context) : BaseAdapter() {
    private var listData: List<String> = emptyList()
    private var context: Context
    init {
        this.listData = listData
        this.context=context
    }

    override fun getCount(): Int {
        return listData.size
    }

    override fun getItem(p0: Int): Any {
        return listData[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val item = listData[p0]
        var convertView = p1
        convertView=LayoutInflater.from(context).inflate(R.layout.history_items,p2,false)
        val Title=convertView.findViewById<TextView>(R.id.Title)
        Title.setText(item)
        val Time=convertView.findViewById<TextClock>(R.id.Time)
        return convertView
    }
}


