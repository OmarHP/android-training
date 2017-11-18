package com.foo.umbrella.ui.main;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foo.umbrella.R;
import com.foo.umbrella.UmbrellaUtil;
import com.foo.umbrella.data.model.ForecastCondition;

import org.threeten.bp.LocalDate;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by Aptivist-U001 on 11/1/2017.
 */

public class DayForecastAdapter extends RecyclerView.Adapter<DayForecastAdapter.ViewHolder> {


    private TreeMap<LocalDate, List<ForecastCondition>> dataSet;
    private String preferedUnit = "fahrenheit";

    public DayForecastAdapter(TreeMap<LocalDate, List<ForecastCondition>> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.day_forecast_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LocalDate localDate = (LocalDate) dataSet.keySet().toArray()[position];
        holder.bind(localDate, dataSet.get(localDate));
    }

    @Override
    public int getItemCount() {
        return dataSet == null ? 0 : dataSet.size();
    }

    public void updateData(TreeMap<LocalDate, List<ForecastCondition>> dataSet, String preferedUnit) {
        this.dataSet = dataSet;
        this.preferedUnit = preferedUnit;
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private RecyclerView rvHourForecast;
        private HourForecastAdapter hourForecastAdapter;


        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.l_dayitem_title);
            rvHourForecast = (RecyclerView) itemView.findViewById(R.id.l_dayitem_hourForecastList);
            hourForecastAdapter = new HourForecastAdapter(null);
            rvHourForecast.setAdapter(hourForecastAdapter);
            rvHourForecast.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        }

        public void bind(LocalDate localDate, List<ForecastCondition> hours){
            title.setText(UmbrellaUtil.getNameOfDay(localDate));
            hourForecastAdapter.updateDataSet(hours, preferedUnit);
        }
    }
}
