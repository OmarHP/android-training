package com.example.android.hw001;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_SELECT_CONTACT = 23;
    private static final int REQUEST_ADD_DESCR = 85;
    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";
    private TextView tvContactName;
    private Contact pickedContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContactName = (TextView) findViewById(R.id.a_main_tv_contac_name);
    }

    public void pickContact(View view) {
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK);
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        if(pickContactIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(pickContactIntent, REQUEST_SELECT_CONTACT);
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult: " + data);
        switch (requestCode){
            case REQUEST_ADD_DESCR:
                if(resultCode == RESULT_OK) {
                    pickedContact = data.getParcelableExtra("UPDATED_CONTACT");
                    updateViewContact();
                }
                break;
            case REQUEST_SELECT_CONTACT:
                if(resultCode == RESULT_OK) {
                    setPickedContact(data);
                }
                break;
        }
    }

    private void setPickedContact(Intent data){
        // Get the URI and query the content provider for the phone number
        Uri contactUri = data.getData();
        String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};
        Cursor cursor = getContentResolver().query(contactUri, projection,
                null, null, null);
        // If the cursor returned is valid, get the phone number
        if (cursor != null && cursor.moveToFirst()) {
            int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            String number = cursor.getString(numberIndex);
            String name = cursor.getString(nameIndex);
            // Do something with the phone number
            pickedContact = new Contact(name, number, null);
            updateViewContact();
        }
    }

    private void updateViewContact(){
        if(pickedContact!=null){
            tvContactName.setText(pickedContact.getName());
            ((TextView)findViewById(R.id.a_main_tv_contac_name_label)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.a_main_tv_contac_name)).setVisibility(View.VISIBLE);
            ((Button)findViewById(R.id.a_main_btn_detail)).setVisibility(View.VISIBLE);
            ((Button)findViewById(R.id.a_main_btn_desc)).setVisibility(View.VISIBLE);
        }
    }

    public void showDetails(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("CONTACT_INFO", pickedContact);
        startActivity(intent);
    }

    public void addDescr(View view) {
        Intent intent = new Intent(this, DescrActivity.class);
        intent.putExtra("CONTACT_INFO", pickedContact);
        startActivityForResult(intent, REQUEST_ADD_DESCR);
    }
}
