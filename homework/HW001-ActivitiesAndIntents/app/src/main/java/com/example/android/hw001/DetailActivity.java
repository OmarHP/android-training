package com.example.android.hw001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.hw001.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Contact contact = getIntent().getParcelableExtra("CONTACT_INFO");
        ((TextView)findViewById(R.id.a_detail_tv_name)).setText(contact.getName());
        ((TextView)findViewById(R.id.a_detail_tv_phone)).setText(contact.getPhone());
        ((TextView)findViewById(R.id.a_detail_tv_descr)).setText(contact.getDescription());

    }

}
