package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.ActionBar

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setupList()
    }

    private fun setupList(){
        val listData=intent.getStringArrayExtra("key_result")?.toList()?: listOf<String>()
        val ltHistory=findViewById<ListView>(R.id.List)
        val adapter=HistoryAdapter(listData,this)
        ltHistory.setAdapter(adapter)
    }
}