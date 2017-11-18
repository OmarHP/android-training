package com.foo.umbrella.ui.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.foo.umbrella.R;
import com.foo.umbrella.UmbrellaApp;
import com.foo.umbrella.data.model.CurrentObservation;
import com.foo.umbrella.data.model.DisplayLocation;
import com.foo.umbrella.data.model.ForecastCondition;
import com.foo.umbrella.di.AppComponent;
import com.foo.umbrella.ui.settings.SettingsActivity;

import org.threeten.bp.LocalDate;

import java.util.List;
import java.util.TreeMap;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject
    MainPresenter presenter;
    @Inject
    SharedPreferences sharedPreferences;

    private RecyclerView rvDayForecast;
    private DayForecastAdapter dayForecastAdapter;
    private Toolbar toolbar;
    private TextView tvTemperature;
    private TextView tvCondition;
    private AppBarLayout appBarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        injectDependencies();
        rvDayForecast = (RecyclerView) findViewById(R.id.a_main_dayForecastList);
        dayForecastAdapter = new DayForecastAdapter(null);
        rvDayForecast.setAdapter(dayForecastAdapter);
        rvDayForecast.setLayoutManager(new LinearLayoutManager(this));

        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvTemperature = (TextView) findViewById(R.id.a_main_temp);
        tvCondition = (TextView) findViewById(R.id.a_main_condition);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.weather_forecast_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_action_settings){
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
        String zip = sharedPreferences.getString(getString(R.string.pref_zip_key), getString(R.string.pref_zip_default_value));
        presenter.loadWeatherForecast(zip);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @Override
    public void injectDependencies() {
        AppComponent appComponent = ((UmbrellaApp) getApplication()).getAppComponent();
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule())
                .build().inject(this);
    }

    @Override
    public void showProgres() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showWeatherForecast(CurrentObservation currentObservation, TreeMap<LocalDate, List<ForecastCondition>> days) {


        DisplayLocation displayLocation = currentObservation.getDisplayLocation();

        //Set current location
        String currentLocation =currentObservation.getDisplayLocation().getStateName()
                + ", " + displayLocation.getStateAbbreviation();
        toolbar.setTitle(currentLocation);

        //Set current temp
        String currentTemp;
        String celciusValue = getString(R.string.pref_unit_celcius_value);
        String defaultValue = getString(R.string.pref_unit_default_value);
        String preferedUnit = sharedPreferences.getString(getString(R.string.pref_unit_key), defaultValue);
        if(preferedUnit.equals(celciusValue)){
            currentTemp = currentObservation.getTempCelsius();
        }else{
            currentTemp = currentObservation.getTempFahrenheit();
        }

        tvTemperature.setText(currentTemp + "°");


        // Set current condition
        tvCondition.setText(currentObservation.getWeatherDescription());

        dayForecastAdapter.updateData(days, preferedUnit);


        if(Double.parseDouble(currentTemp) > 60){
            showWarmTheme();
        }else{
            showCoolTheme();
        }

    }

    @Override
    public void showWarmTheme() {
        appBarLayout.setBackground(new ColorDrawable(getResources().getColor(R.color.weather_warm)));
    }

    @Override
    public void showCoolTheme() {
        appBarLayout.setBackground(new ColorDrawable(getResources().getColor(R.color.weather_cool)));
    }
}
