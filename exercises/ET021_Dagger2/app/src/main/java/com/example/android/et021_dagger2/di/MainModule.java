package com.example.android.et021_dagger2.di;

import android.content.Context;

import com.example.android.et021_dagger2.DateHelper;
import com.example.android.et021_dagger2.MainActivity;
import com.example.android.et021_dagger2.PreferencesManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */

@Module
public class MainModule {

    private Context context;

    public MainModule(Context context){
        this.context = context;
    }

    @Provides
    public DateHelper provideDateHelper(){
        return new DateHelper();
    }

    @Provides
    public PreferencesManager providePreferencesManager(){
        return new PreferencesManager(context);
    }
}
