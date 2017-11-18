package com.foo.umbrella;

import org.threeten.bp.LocalDate;

/**
 * Created by Aptivist-U001 on 11/1/2017.
 */

public class UmbrellaUtil {

    public static int getConditionImage(String icon){
        switch (icon){
            case "mostlycloudy":
                return R.drawable.weather_cloudy;

            case "cloudy":
                return R.drawable.weather_cloudy;

            case "partlycloudy":
                return R.drawable.weather_partlycloudy;

            case "clear":
                return R.drawable.weather_sunny;

            default:
                return R.drawable.weather_windy_variant;
        }
    }


    public static String getNameOfDay(LocalDate localDate){
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        if(localDate.equals(today)) {
            return "Today";
        }else if (localDate.equals(tomorrow)){
            return "Tomorrow";
        }else{
            return localDate.getDayOfWeek().name();
        }
    }
}
