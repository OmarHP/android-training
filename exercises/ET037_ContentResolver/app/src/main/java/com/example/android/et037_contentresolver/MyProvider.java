package com.example.android.et037_contentresolver;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Aptivist-U001 on 11/8/2017.
 */

public class MyProvider extends ContentProvider {

    private static final String TAG = MyProvider.class.getSimpleName() + "_TAG_";

    private static final String AUTHORITY = "com.example.myapplication.provider";
    private static final String BASE_URL = "content://";

    public static final Uri CONTENT_URI = Uri.parse(BASE_URL + AUTHORITY);

    public MyProvider() {
        Log.d(TAG, "MyProvider: ");
    }

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate: ");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Log.d(TAG, "query: ");

        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"_ID","NAME","AGE"});
        matrixCursor.addRow(new Object[]{1,"Omar", 27});
        matrixCursor.addRow(new Object[]{2,"Edwin", 26});
        matrixCursor.addRow(new Object[]{3,"Jose", 27});
        matrixCursor.addRow(new Object[]{4,"Alfredo", 35});
        matrixCursor.addRow(new Object[]{5,"Isaias", 35});

        return matrixCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        Log.d(TAG, "getType: ");
        return ContentResolver.CURSOR_DIR_BASE_TYPE;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Log.d(TAG, "insert: ");
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.d(TAG, "delete: ");
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.d(TAG, "update: ");
        return 0;
    }

}
