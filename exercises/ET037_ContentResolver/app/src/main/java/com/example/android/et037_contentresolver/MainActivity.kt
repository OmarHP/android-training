package com.example.android.et037_contentresolver

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "${MainActivity::class.java.simpleName}_TAG_"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        a_main_btn_load.setOnClickListener({v -> startContactsActivity()})

        a_main_btn_read.setOnClickListener({v -> readFromProvider()})
    }

    fun startContactsActivity(){
        val intent = Intent(this, ContactsActivity::class.java)
        startActivity(intent)
    }

    fun readFromProvider(){
        val cursor = contentResolver.query(MyProvider.CONTENT_URI, null, null, null, null)
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
