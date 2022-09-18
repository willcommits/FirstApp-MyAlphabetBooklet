package com.example.myalphabetbook

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast

class homeactivity : AppCompatActivity() {
    lateinit var preference:SharedPreferences
    companion object{
        var isSecondScreen=true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeactivity)
        preference=getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        setButtonsA_L()
        setButtonS_Z()



    }

    fun changeScreen(alphabet: Int) {
        val intent = Intent(this@homeactivity, MainActivity::class.java)
        intent.putExtra("LetterValue", alphabet)
          startActivity(intent)
        isSecondScreen=true
        val editor=preference.edit()
        editor.putBoolean("isSecondScreen", isSecondScreen)
        editor.commit()

    }

    override fun onResume() {
        super.onResume()
        var lettervalue:Boolean=intent.getBooleanExtra("isSecond",true)
        val isLoggedIn= preference.getBoolean("isSecondScreen",false)
        if(lettervalue!=true){
            val editor=preference.edit()
            editor.putBoolean("isSecondScreen", lettervalue)
            editor.commit()
            return;
        }
        if(isLoggedIn!=false){

            val intent=Intent(this@homeactivity,MainActivity::class.java)
            startActivity(intent)
            return;
        }
    }

    override fun onPause() {
        super.onPause()
    }
    fun setButtonS_Z(){
        val S: Button = findViewById(R.id.S)
        val T: Button = findViewById(R.id.T)
        val U: Button = findViewById(R.id.U)
        val V: Button = findViewById(R.id.v)
        val W: Button = findViewById(R.id.W)
        val X: Button = findViewById(R.id.X)
        val Y: Button = findViewById(R.id.Y)
        val Z: Button = findViewById(R.id.Z)
        val helpclicklistener = HelpClickListener()
        S.setOnClickListener(helpclicklistener)
        T.setOnClickListener(helpclicklistener)
        U.setOnClickListener(helpclicklistener)
        V.setOnClickListener(helpclicklistener)
        W.setOnClickListener(helpclicklistener)
        X.setOnClickListener(helpclicklistener)
        Y.setOnClickListener(helpclicklistener)
        Z.setOnClickListener(helpclicklistener)
    }
    fun setButtonsA_L(){
        val A: Button = findViewById(R.id.A)
        val B: Button = findViewById(R.id.B)
        val C: Button = findViewById(R.id.C)
        val D: Button = findViewById(R.id.D)
        val E: Button = findViewById(R.id.E)
        val F: Button = findViewById(R.id.F)
        val G: Button = findViewById(R.id.G)
        val H: Button = findViewById(R.id.H)
        val I: Button = findViewById(R.id.I)
        val J: Button = findViewById(R.id.J)
        val K: Button = findViewById(R.id.K)
        val L: Button = findViewById(R.id.L)
        val M: Button = findViewById(R.id.M)
        val N: Button = findViewById(R.id.N)
        val O: Button = findViewById(R.id.O)
        val P: Button = findViewById(R.id.P)
        val Q: Button = findViewById(R.id.Q)
        val R: Button = findViewById(R.id.R)

        val helpclicklistener = HelpClickListener()
        A.setOnClickListener(helpclicklistener)
        B.setOnClickListener(helpclicklistener)
        C.setOnClickListener(helpclicklistener)
        D.setOnClickListener(helpclicklistener)
        E.setOnClickListener(helpclicklistener)
        F.setOnClickListener(helpclicklistener)
        G.setOnClickListener(helpclicklistener)
        H.setOnClickListener(helpclicklistener)
        I.setOnClickListener(helpclicklistener)
        J.setOnClickListener(helpclicklistener)
        K.setOnClickListener(helpclicklistener)
        L.setOnClickListener(helpclicklistener)
        M.setOnClickListener(helpclicklistener)
        N.setOnClickListener(helpclicklistener)
        O.setOnClickListener(helpclicklistener)
        P.setOnClickListener(helpclicklistener)
        Q.setOnClickListener(helpclicklistener)
        R.setOnClickListener(helpclicklistener)

    }

    inner class HelpClickListener : View.OnClickListener {
        override fun onClick(v: View?) {
            val view = v?.rootView
            when (v?.id) {

                R.id.A -> {
                    changeScreen(0)
                }

                R.id.B -> {
                    changeScreen(1)
                }

                R.id.C -> {
                    changeScreen(2)
                }
                R.id.D -> {
                    changeScreen(3)
                }
                R.id.E -> {
                    changeScreen(4)
                }
                R.id.F -> {
                    changeScreen(5)
                }
                R.id.G -> {
                    changeScreen(6)
                }
                R.id.H -> {
                    changeScreen(7)
                }
                R.id.I -> {
                    changeScreen(8)
                }
                R.id.J -> {
                    changeScreen(9)
                }
                R.id.K -> {
                    changeScreen(10)
                }
                R.id.L -> {
                    changeScreen(11)
                }

                R.id.M -> {
                    changeScreen(12)
                }

                R.id.N -> {
                    changeScreen(13)
                }

                R.id.O -> {
                    changeScreen(14)
                }
                R.id.P -> {
                    changeScreen(15)
                }
                R.id.Q -> {
                    changeScreen(16)
                }
                R.id.R -> {
                    changeScreen(17)
                }
                //not all working
                R.id.S -> {
                    changeScreen(18)
                }
                R.id.T -> {
                    changeScreen(19)
                }
                R.id.U -> {
                    changeScreen(20)
                }
                R.id.v -> {
                    changeScreen(21)
                }
                R.id.W -> {
                    changeScreen(22)
                }
                R.id.X -> {
                    changeScreen(23)
                }
                R.id.Y -> {
                    changeScreen(24)
                }
                R.id.Z -> {
                    changeScreen(25)
                }
                //K has issue
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.custom_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.Search->{
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                return true
            }
            else ->super.onOptionsItemSelected(item)
        }

    }
}