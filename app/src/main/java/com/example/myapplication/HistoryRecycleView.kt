package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class HistoryRecycleView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_recycle_view)
        setupRV()
    }

    private fun setupRV() {
        val recycleData = intent.getStringArrayExtra("key_result")?.toList() ?: listOf<String>()
        val ltData = findViewById<RecyclerView>(R.id.rvHistory)
        val adapter = HistoryRecycleAdapter(recycleData, this)
        ltData.setAdapter(adapter)
    }
}