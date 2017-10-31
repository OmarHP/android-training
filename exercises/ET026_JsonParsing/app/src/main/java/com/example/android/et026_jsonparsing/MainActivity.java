package com.example.android.et026_jsonparsing;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";
    private Button button;
    private Handler handler;

    private static final String MY_JSON  = "[\n" +
            "    {\"name\" : \"Juan\", \"age\": 20, \"grade\": 8.1},\n" +
            "    {\"name\" : \"Miguel\", \"age\": 23, \"grade\": 8.3},\n" +
            "    {\"name\" : \"Roberto\", \"age\": 39, \"grade\": 9.3},\n" +
            "    {\"name\" : \"Luis\", \"age\": 19, \"grade\": 6.9},\n" +
            "    {\"name\" : \"Gaudencio\", \"age\": 25, \"grade\": 4.3}\n" +
            "]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.a_main_btn);
        button.setOnClickListener(this);
        handler = new MyHandler();
        try {
            List<Student> students = parseJson(MY_JSON);
            for (Student student : students) {
                Log.d(TAG, "onCreate: " + student);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private static List<Student> parseJson(String myJson) throws JSONException {
        List<Student> students = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(myJson);
        for (int i = 0; i < jsonArray.length(); i++) {
            //Log.d(TAG, "parseJson: " + jsonArray.getJSONObject(i));
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            double grade = jsonObject.getDouble("grade");
            students.add(new Student(name, age, grade));
        }
        return students;
    }


    @Override
    public void onClick(View view) {
        new DownloadThread(handler).start();
    }

    private static class MyHandler extends Handler{
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String json = msg.getData().getString("MY_KEY");
                try {
                    parseJson(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

    }
}
