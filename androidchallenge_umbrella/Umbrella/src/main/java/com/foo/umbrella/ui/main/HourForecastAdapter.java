package com.foo.umbrella.ui.main;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.foo.umbrella.R;
import com.foo.umbrella.UmbrellaUtil;
import com.foo.umbrella.data.model.ForecastCondition;

import java.util.List;

/**
 * Created by Aptivist-U001 on 11/1/2017.
 */

public class HourForecastAdapter extends RecyclerView.Adapter<HourForecastAdapter.ViewHolder> {

    private List<ForecastCondition> dataSet;
    private String preferedUnit = "fahrenheit";

    public HourForecastAdapter(List<ForecastCondition> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hour_forecast_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ForecastCondition forecastCondition = dataSet.get(position);
        holder.bind(forecastCondition);
    }

    @Override
    public int getItemCount() {
        return dataSet == null ? 0 : dataSet.size();
    }

    public void updateDataSet(List<ForecastCondition> dataSet, String preferedUnit){
        this.dataSet = dataSet;
        this.preferedUnit = preferedUnit;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView date;
        private ImageView image;
        private TextView temperature;

        public ViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.l_houritem_date);
            image = (ImageView) itemView.findViewById(R.id.l_houritem_image);
            temperature = (TextView) itemView.findViewById(R.id.l_houritem_temperature);
        }

        public void bind(ForecastCondition forecastCondition){
            Context context = itemView.getContext();

            int color = Color.BLACK;
            if(forecastCondition.getIsMax())
                color = context.getResources().getColor(R.color.weather_warm);
            if(forecastCondition.getIsMin())
                color = context.getResources().getColor(R.color.weather_cool);

            date.setTextColor(color);
            temperature.setTextColor(color);

            date.setText(forecastCondition.getDisplayTime());
            String temp = preferedUnit.equals("fahrenheit") ?
                    forecastCondition.getTempFahrenheit()
                    : forecastCondition.getTempCelsius();
            temperature.setText(temp + "°");

            Drawable icon = context.getResources()
                    .getDrawable(
                            UmbrellaUtil.getConditionImage(forecastCondition.getIcon()));

            Drawable backgroundDrawable = DrawableCompat.wrap(icon).mutate();
            DrawableCompat.setTint(backgroundDrawable, color);

            image.setBackground(backgroundDrawable);


        }
    }
}
