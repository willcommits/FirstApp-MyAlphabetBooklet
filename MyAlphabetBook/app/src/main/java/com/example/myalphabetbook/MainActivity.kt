package com.example.myalphabetbook


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import java.io.File
import java.io.FileInputStream


class MainActivity : AppCompatActivity() {
    lateinit var adapters: Adapters
    lateinit var viewpager: ViewPager2
    lateinit var preference:SharedPreferences
    lateinit var pref:SharedPreferences
    lateinit var next:Button
    lateinit var Previous:Button
    lateinit var firstpage:Button
    lateinit var lastpage:Button
    lateinit var overview:Button
    lateinit var overviewArrow:ImageView
    lateinit var menu:ImageView
     companion object{
         var isFirstScreen=false;
         var bmlist= mutableListOf<Bitmap>()
         var list = mutableListOf<Int>()
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        preference=getSharedPreferences("App",Context.MODE_PRIVATE)
        pref=getSharedPreferences("MYApp",Context.MODE_PRIVATE)

         list = mutableListOf<Int>(R.drawable.slide01,R.drawable.slide02,R.drawable.slide03,R.drawable.slide04,R.drawable.slide05,
            R.drawable.slide06,R.drawable.slide07,R.drawable.slide08,R.drawable.slide09,R.drawable.slide10,R.drawable.slide11,R.drawable.slide12
            ,R.drawable.slide13,R.drawable.slide14,R.drawable.slide15,R.drawable.slide16,R.drawable.slide17,R.drawable.slide18,R.drawable.slide19,
            R.drawable.slide20,R.drawable.slide21,R.drawable.slide22,R.drawable.slide23,R.drawable.slide24,R.drawable.slide25,R.drawable.slide26)
         var thread=LoadImagesThread()
        thread.start()
        thread.join()

        viewpager = findViewById(R.id.viewpager)
        viewpager.adapter = adapters
        //set current Intent
        var lettervalue:Int=intent.getIntExtra("LetterValue",0)
        viewpager.setCurrentItem(lettervalue,false)
        next=findViewById(R.id.next)
        Previous=findViewById(R.id.prev)
        firstpage=findViewById(R.id.firstpage)
        lastpage=findViewById(R.id.LastPage)
        overviewArrow=findViewById(R.id.overviewarrow)
        next.setOnClickListener(){
            viewpager.setCurrentItem(viewpager.currentItem+1,true)

        }
        Previous.setOnClickListener(){
            viewpager.setCurrentItem(viewpager.currentItem-1,true)
        }
        firstpage.setOnClickListener(){
            viewpager.setCurrentItem(0,true)
        }

        lastpage.setOnClickListener(){
            viewpager.setCurrentItem(25,true)
        }
        overviewArrow.setOnClickListener(){
            val intent=Intent(this,homeactivity::class.java)
            intent.putExtra("isSecond",false)
            startActivity(intent)
        }

    }
    inner class LoadImagesThread:Thread(){
        override fun run() {


            for (i in list){
               val b=BitmapFactory.decodeResource(resources,i)
                bmlist.add(b)

            }
            adapters = Adapters(this@MainActivity)
            adapters.setContentList(bmlist)
        }
    }


    override fun onResume() {
        super.onResume()

        var lettervalue:Int=intent.getIntExtra("LetterValue",-1)
        val id= preference.getInt("id",0)
        if(lettervalue==-1){
            viewpager.setCurrentItem(id,true
            )
        }
        else{
            viewpager.setCurrentItem(lettervalue,true)
        }


    }

    override fun onPause() {
        super.onPause()
        val editor=preference.edit()
        editor.putInt("id",viewpager.currentItem)
        editor.commit()

    }



}