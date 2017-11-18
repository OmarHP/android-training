package com.example.android.et038_contentresolver2

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "${MainActivity::class.java.simpleName}_TAG_"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        a_main_consume.setOnClickListener({v -> consumeProvider()})
    }

    fun consumeProvider(){
        val cursor = contentResolver.query(Uri.parse("content://com.example.myapplication.provider"), null, null, null, null)
        cursor.let {
            while (cursor.moveToNext()){
                val id : Int =  cursor.getInt(0)
                val name : String =  cursor.getString(1)
                val age : Int =  cursor.getInt(2)
                Log.d(TAG, "$id $name $age")
            }
            cursor.close()
        }
    }
}
