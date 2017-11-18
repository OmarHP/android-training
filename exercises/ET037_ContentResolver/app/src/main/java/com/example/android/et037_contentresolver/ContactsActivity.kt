package com.example.android.et037_contentresolver

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_contacts.*

class ContactsActivity : AppCompatActivity() {

    val TAG = "${ContactsActivity::class.java.simpleName}_TAG_"
    lateinit var contacts: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        contacts = ArrayList()

        val cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        ,null , null, null, null)

        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            val number= cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            contacts.add("$name - $number")
            Log.d(TAG, "$name - $number")
        }

        cursor.close()

        a_contacts_rv_list.adapter = ContactsAdapter(contacts)
        a_contacts_rv_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    class ContactsAdapter(var contacts: ArrayList<String>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

        override fun onBindViewHolder(holder: ContactsAdapter.ViewHolder?, position: Int) {
            holder!!.bind(contacts.get(position))
        }

        override fun getItemCount(): Int {
            return contacts.size
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ContactsAdapter.ViewHolder {
            val inflater = LayoutInflater.from(parent!!.context)
            val view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
            return ViewHolder(view)
        }
        
        companion object class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var textView: TextView = itemView.findViewById(android.R.id.text1)

            fun bind(contact: String){
                textView.setText(contact)
            }
        }

    }
}


