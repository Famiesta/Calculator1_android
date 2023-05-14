package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class HistoryRecycleView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_recycle_view)
        setupRV()
    }

    private fun setupRV() {
        val recycleData = intent.getSerializableExtra("key_result")as? List<CalculatorResult>?: listOf()
        val ltData = findViewById<RecyclerView>(R.id.rvHistory)
        val adapter = HistoryRecycleAdapter(recycleData, this)
        ltData.setAdapter(adapter)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}