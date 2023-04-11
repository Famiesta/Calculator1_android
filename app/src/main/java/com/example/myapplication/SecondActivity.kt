package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setupList()
    }

    private fun setupList(){
        val listData=intent.getStringArrayListExtra("key_result")?.toList()?: listOf<String>()
        val ltHistory=findViewById<ListView>(R.id.List)
        val adapter=HistoryAdapter(listData,this)
        ltHistory.setAdapter(adapter)
    }
}