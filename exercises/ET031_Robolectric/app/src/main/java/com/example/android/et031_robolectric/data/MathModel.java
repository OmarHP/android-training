package com.example.android.et031_robolectric.data;

/**
 * Created by Aptivist-U001 on 11/2/2017.
 */

public class MathModel {

    private int valueCounter = 0;

    public int calculate() {
        valueCounter ++;
        return valueCounter;
    }
}
