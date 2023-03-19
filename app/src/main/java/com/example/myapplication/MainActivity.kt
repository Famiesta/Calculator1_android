package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tv2: TextView
    private lateinit var textView1: TextView
    var ip1 = 0
    var ip2 = 0
    var method = ""
    var c = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv2 = findViewById(R.id.AC)
        SetupUI()
    }
        fun SetupUI() {
            textView1 = findViewById(R.id.input)
            val num0 = findViewById<Button>(R.id.num0)
            num0.setOnClickListener() {
                if (c == 1) {
                    textView1.text = ""
                    c = 0
                }
                val oldValue = textView1.text.toString()
                if (method.isEmpty() && ip1 == 0) {
                    ip1 = 0
                } else {
                    textView1.text = oldValue + "0"
                    ip2 = ip2 * 10 + 0
                }
            }
            val num1 = findViewById<Button>(R.id.num1)
            num1.setOnClickListener() {
                if (c == 1) {
                    textView1.text = ""
                    c = 0
                }
                val oldValue = textView1.text.toString()
                textView1.text = oldValue + "1"
                tv2.text = "C"
                if (method.isEmpty())
                    ip1 = ip1 * 10 + 1
                else ip2 = ip2 * 10 + 1
            }
            val num2 = findViewById<Button>(R.id.num2)
            num2.setOnClickListener() {
                if (c == 1) {
                    textView1.text = ""
                    c = 0
                }
                val oldValue = textView1.text.toString()
                textView1.text = oldValue + "2"
                tv2.text = "C"
                if (method.isEmpty()) ip1 = ip1 * 10 + 2
                else ip2 = ip2 * 10 + 2
            }
            val num3 = findViewById<Button>(R.id.num3)
            num3.setOnClickListener() {
                if (c == 1) {
                    textView1.text = ""
                    c = 0
                }
                val oldValue = textView1.text.toString()
                textView1.text = oldValue + "3"
                tv2.text = "C"
                if (method.isEmpty()) ip1 = ip1 * 10 + 3
                else ip2 = ip2 * 10 + 3
            }
            val num4 = findViewById<Button>(R.id.num4)
            num4.setOnClickListener() {
                if (c == 1) {
                    textView1.text = ""
                    c = 0
                }
                val oldValue = textView1.text.toString()
                textView1.text = oldValue + "4"
                tv2.text = "C"
                if (method.isEmpty()) ip1 = ip1 * 10 + 4
                else ip2 = ip2 * 10 + 4
            }
            val num5 = findViewById<Button>(R.id.num5)
            num5.setOnClickListener() {
                if (c == 1) {
                    textView1.text = ""
                    c = 0
                }
                val oldValue = textView1.text.toString()
                tv2.text = "C"
                textView1.text = oldValue + "5"
                if (method.isEmpty()) ip1 = ip1 * 10 + 5
                else ip2 = ip2 * 10 + 5
            }
            val num6 = findViewById<Button>(R.id.num6)
            num6.setOnClickListener() {
                if (c == 1) {
                    textView1.text = ""
                    c = 0
                }
                val oldValue = textView1.text.toString()
                tv2.text = "C"
                textView1.text = oldValue + "6"
                if (method.isEmpty()) {
                    ip1 = ip1 * 10 + 6
                } else {
                    ip2 = ip2 * 10 + 6
                }
            }
            val num7 = findViewById<Button>(R.id.num7)
            num7.setOnClickListener() {
                if (c == 1) {
                    textView1.text = ""
                    c = 0
                }
                val oldValue = textView1.text.toString()
                tv2.text = "C"
                textView1.text = oldValue + "7"
                if (method.isEmpty()) {
                    ip1 = ip1 * 10 + 7
                } else {
                    ip2 = ip2 * 10 + 7
                }
            }
            val num8 = findViewById<Button>(R.id.num8)
            num8.setOnClickListener() {
                if (c == 1) {
                    textView1.text = ""
                    c = 0
                }
                val oldValue = textView1.text.toString()
                tv2.text = "C"
                textView1.text = oldValue + "8"
                if (method.isEmpty()) {
                    ip1 = ip1 * 10 + 8
                } else {
                    ip2 = ip2 * 10 + 8
                }
            }
            val num9 = findViewById<Button>(R.id.num9)
            num9.setOnClickListener() {
                if (c == 1) {
                    textView1.text = ""
                    c = 0
                }
                val oldValue = textView1.text.toString()
                textView1.text = oldValue + "9"
                if (method.isEmpty()) ip1 = ip1 * 10 + 9
                else ip2 = ip2 * 10 + 9
            }
            val cong = findViewById<Button>(R.id.cong)
            cong.setOnClickListener() {
                val oldValue = textView1.text.toString()
                if (ip1 == 0) textView1.text = oldValue + "+"
                else if (method.isEmpty()) {
                    textView1.text = oldValue + "+"
                    method = "+"
                } else if (method == "*" || method == "/") {
                    textView1.text = ip1.toString() + "+"
                    method = "+"
                } else textView1.text = oldValue + "+"
            }
            val tru = findViewById<Button>(R.id.tru)
            var dem = 0
            tru.setOnClickListener() {
                val oldValue = textView1.text.toString()
                if (ip1 == 0) textView1.text = oldValue + "−"
                else if (method.isEmpty()) {
                    textView1.text = oldValue + "−"
                    method = "−"
                } else if (method == "*" || method == "/") {
                    textView1.text = ip1.toString() + "−"
                    method = "−"
                } else textView1.text = oldValue + "−"
            }
            val nhan = findViewById<Button>(R.id.nhan)
            nhan.setOnClickListener() {
                val oldValue = textView1.text.toString()
                if (ip1 == 0) textView1.text = oldValue + ""
                else if (ip1 != 0 && method.isEmpty()) {
                    textView1.text = oldValue + "×"
                    method = "*"
                } else if (method != "*") {
                    textView1.text = ip1.toString() + "×"
                    method = "*"
                }
            }
            val chia = findViewById<Button>(R.id.chia)
            chia.setOnClickListener() {
                val oldValue = textView1.text.toString()
                if (ip1 == 0) textView1.text = oldValue + ""
                else if (ip1 != 0 && method.isEmpty()) {
                    textView1.text = oldValue + "÷"
                    method = "/"
                } else if (method != "/") {
                    textView1.text = ip1.toString() + "÷"
                    method = "/"
                }

            }
            val butAC = findViewById<Button>(R.id.AC)
            butAC.setOnClickListener() {
                reStart()
                textView1.text = ""
                tv2.text = "AC"
            }
            val butResult = findViewById<Button>(R.id.bang)
            butResult.setOnClickListener() {
                if (method == "/") {
                    if (ip1 % ip2 == 0)
                        textView1.text = getResultDC().toString()
                    else textView1.text = getResultD().toString()
                } else textView1.text = getResultInt().toString()
                reStart()
                c = 1
            }
        }

        fun reStart() {
            ip1 = 0
            ip2 = 0
            method = ""
        }

        fun getResultInt(): Int {
            var result = 0
            when (method) {
                "+" -> result = ip1 + ip2
                "−" -> result = ip1 - ip2
                "*" -> result = ip1 * ip2
            }
            return result
        }

        fun getResultDC(): Int {
            var result1 = 0
            result1 = ip1 / ip2
            return result1
        }

        fun getResultD(): Double {
            var result2 = 0.0
            result2 = ip1.toDouble() / ip2.toDouble()
            return result2
        }
    }