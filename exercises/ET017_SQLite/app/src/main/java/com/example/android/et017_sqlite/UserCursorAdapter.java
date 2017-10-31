package com.example.android.et017_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Aptivist-U001 on 10/25/2017.
 */

public class UserCursorAdapter extends CursorAdapter {

    public UserCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    public class ViewHolder{

        public TextView textView;
        public View view;

        public ViewHolder(View view){
            this.view = view;
            textView = view.findViewById(android.R.id.text1);
        }

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_activated_1, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(UsersOpenHelper.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndex(UsersOpenHelper.COLUMN_NAME));
        int age = cursor.getInt(cursor.getColumnIndex(UsersOpenHelper.COLUMN_AGE));
        ((ViewHolder) view.getTag()).textView.setText(id + " " + name + " " + age);

    }
}
