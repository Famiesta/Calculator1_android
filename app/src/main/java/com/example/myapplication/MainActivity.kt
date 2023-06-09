package com.example.myapplication

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var tv2: TextView
    private lateinit var textView1: TextView
    var ip1 = 0
    var ip2 = 0
    var ip3 = 0.0
    var ob1 = 1
    var ob2 = 1
    var method = ""
    var c = 0
    var listResult: ArrayList<CalculatorResult> = arrayListOf()
    val resultLauncherLambda =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val data: Intent? = result.data
            Log.e(
                "MainActivity",
                "Second Activity callback: " + data?.getSerializableExtra("key_result")
            )
        }
    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable("key_result",listResult)
        outState.putInt("ip1",ip1)
        outState.putInt("ip2",ip2)
        outState.putString("method",method)
        outState.putInt("ob1",ob1)
        outState.putInt("ob2",ob2)
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)
        listResult =  savedInstanceState.getSerializable("key_result") as? ArrayList<CalculatorResult> ?: arrayListOf()
        //textView1.text = listResult.last().result
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv2 = findViewById(R.id.AC)
        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        drawer = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.leftMenu)
        navigationView.setNavigationItemSelectedListener { item->
            when(item.itemId) {
                R.id.action_setting -> {
                    goToRecycleActivity()
                }
                else -> {

                }
            }
            return@setNavigationItemSelectedListener true
        }
        //setup listener for drawer and actionbar
        toggle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        //show drawe menu toggle button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        setSupportActionBar(toolbar)
        if (savedInstanceState != null){
            ip1 = savedInstanceState.getInt("ip1")
            ip2 = savedInstanceState.getInt("ip2")
            method = savedInstanceState.getString("method").toString()
            ob1 = savedInstanceState.getInt("ob1")
            ob2 = savedInstanceState.getInt("ob2")
        }
        SetupUI()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        when (item.itemId) {
            R.id.action_history -> {
                goToRecycleActivity()
            }

            else -> {

            }
        }
        return super.onOptionsItemSelected(item)
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
            if (ip1 == 0) {
                textView1.text = oldValue
            } else if (method.isEmpty() && ip1 != 0) {
                textView1.text = oldValue + "0"
                ip1 = ip1 * 10 + 0
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
            tv2.text = "C"
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
            } else if (method != "+") {
                textView1.text = ip1.toString() + "+"
                method = "+"
            } else textView1.text = oldValue + "+"
        }
        val tru = findViewById<Button>(R.id.tru)
        var dem = 0
        tru.setOnClickListener() {
            val oldValue = textView1.text.toString()
            if (ip1 == 0 && ob1 == 1) {
                textView1.text = oldValue + "−"
                ob1 = -1
            } else if (method.isEmpty() && ip1 != 0) {
                textView1.text = oldValue + "−"
                method = "−"
            } else if (method != "−") {
                textView1.text = ip1.toString() + "−"
                method = "−"
            } else if (ip2 == 0 && ob2 == 1) {
                textView1.text = oldValue + "−"
                ob2 = -1
            } else if (c == 1) {

            }
        }
        val nhan = findViewById<Button>(R.id.nhan)
        nhan.setOnClickListener() {
            val oldValue = textView1.text.toString()
            if (ip1 == 0) textView1.text = oldValue + ""
            else if (ip1 != 0 && method.isEmpty()) {
                textView1.text = oldValue + "×"
                method = "×"
            } else if (method != "×") {
                textView1.text = ip1.toString() + "×"
                method = "×"
            }
        }
        val chia = findViewById<Button>(R.id.chia)
        chia.setOnClickListener() {
            val oldValue = textView1.text.toString()
            if (ip1 == 0) textView1.text = oldValue + ""
            else if (ip1 != 0 && method.isEmpty()) {
                textView1.text = oldValue + "÷"
                method = "÷"
            } else if (method != "÷") {
                textView1.text = ip1.toString() + "÷"
                method = "÷"
            }
        }
        val butAC = findViewById<Button>(R.id.AC)
        butAC.setOnClickListener() {
            if (ip2 != 0) {
                ip2 = 0
                ob2 = 1
                textView1.text = printInC(ob1, ip1) + method
            } else if (method.isNotEmpty()) {
                method = ""
                textView1.text = printInC(ob1, ip1)
            } else {
                reStart()
                textView1.text = ""
                tv2.text = "AC"
            }
        }
        val butResult = findViewById<Button>(R.id.bang)
        butResult.setOnClickListener() {
            val calendar = Calendar.getInstance().time
            val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US)
            val oldValue = textView1.text.toString()
            if (method.isEmpty()) {
                textView1.text = getResultInt().toString()
                reStartExcept1()
            } else {
                if (method == "÷" && (ip1 % ip2 != 0)) {
                    val tam = getResultD().toString()
                    textView1.text = tam
                    val newValue = (oldValue + "=" + tam)
                    listResult.add(CalculatorResult(newValue, formatter.format(calendar)))
                } else {
                    val tam = getResultInt().toString()
                    textView1.text = tam
                    val newValue = oldValue + "=" + tam
                    listResult.add(CalculatorResult(newValue, formatter.format(calendar)))
                }
                reStart()
            }
            c = 1
        }
    }

    fun reStart() {
        ip1 = 0
        ip2 = 0
        ob1 = 1
        ob2 = 1
        method = ""
    }

    fun reStartExcept1() {
        ip2 = 0
        ob2 = 0
        method = ""
    }

    fun getResultInt(): Int {
        var result = 0
        if (method.isEmpty() && ip1 != 0) {
            result = ip1 * ob1
        } else when (method) {
            "+" -> result = (ip1 * ob1) + (ip2 * ob2)
            "−" -> result = (ip1 * ob1) - (ip2 * ob2)
            "×" -> result = (ip1 * ob1) * (ip2 * ob2)
            "÷" -> result = (ip1 * ob1) / (ip2 * ob2)
        }
        ip1 = result
        return result
    }

    fun getResultD(): Double {
        var result2 = 0.0
        result2 = (ip1 * ob1).toDouble() / (ip2 * ob2).toDouble()
        return result2
    }

    fun printInC(ob: Int, num: Int): String {
        var tv3 = ""
        if (ob == -1) {
            tv3 = "−" + num.toString()
        } else {
            tv3 = num.toString()
        }
        tv2.text = "AC"
        return tv3
    }

    /*fun goToSecondActivity(){
        val intent=Intent(this,SecondActivity::class.java)
        intent.putExtra("key_result",listResult.toTypedArray())
        startActivity(intent)
        //resultLauncherLambda.launch(intent)
    }*/
    fun goToRecycleActivity() {
        val intent = Intent(this, HistoryRecycleView::class.java)
        intent.putExtra("key_result", listResult)
        //startActivity(intent)
        resultLauncherLambda.launch(intent)
    }
    /*fun continue(){
        if(c==1){

        }
    }*/
}
//arraylist
//ListView
//RecycleView


