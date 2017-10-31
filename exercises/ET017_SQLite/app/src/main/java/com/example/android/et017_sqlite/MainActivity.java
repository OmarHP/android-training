package com.example.android.et017_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";
    private EditText etId;
    private EditText etName;
    private EditText etAge;
    private ListView lvUsers;
    private UserCursorAdapter userCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etId = (EditText) findViewById(R.id.a_main_et_id);
        etName = (EditText) findViewById(R.id.a_main_et_name);
        etAge = (EditText) findViewById(R.id.a_main_et_age);
        lvUsers = (ListView) findViewById(R.id.a_main_lv_users);
        userCursorAdapter = new UserCursorAdapter(this, null);
        lvUsers.setAdapter(userCursorAdapter);

    }

    public void saveMagic(View view) {
        UsersOpenHelper usersOpenHelper = new UsersOpenHelper(this);
        SQLiteDatabase sqLiteDatabase = usersOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(UsersOpenHelper.COLUMN_ID, etId.getText().toString());
        contentValues.put(UsersOpenHelper.COLUMN_NAME, etName.getText().toString());
        contentValues.put(UsersOpenHelper.COLUMN_AGE, etAge.getText().toString());
        sqLiteDatabase.insert(UsersOpenHelper.TABLE_NAME, null, contentValues);
    }

    public void loadMagic(View view) {
        UsersOpenHelper usersOpenHelper = new UsersOpenHelper(this);
        SQLiteDatabase sqLiteDatabase = usersOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(UsersOpenHelper.TABLE_NAME, null, null, null, null, null, null);
        userCursorAdapter.changeCursor(cursor);
        userCursorAdapter.notifyDataSetChanged();
    }

    private void parseInfo(Cursor cursor) {
        Log.d(TAG, "parseInfo: " + cursor.getColumnIndex(UsersOpenHelper.COLUMN_ID));
        int id = cursor.getInt(cursor.getColumnIndex(UsersOpenHelper.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndex(UsersOpenHelper.COLUMN_NAME));
        int age = cursor.getInt(cursor.getColumnIndex(UsersOpenHelper.COLUMN_AGE));
        Log.d(TAG, "parseInfo: " + id + " " + name + " " +age);
    }
}
