package com.example.android.hw001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.hw001.R;

public class DescrActivity extends AppCompatActivity {

    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descr);
        contact = getIntent().getParcelableExtra("CONTACT_INFO");
        ((TextView)findViewById(R.id.a_descr_tv_name)).setText(contact.getName());
    }


    public void saveDescr(View view) {
        String descr = ((EditText)findViewById(R.id.a_descr_et_descr)).getText().toString();
        contact.setDescription(descr);
        Intent intent = new Intent();
        intent.putExtra("UPDATED_CONTACT", contact);
        setResult(RESULT_OK, intent);
        finish();
    }
}
