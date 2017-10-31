package com.example.android.et025_compoundviews;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Aptivist-U001 on 10/29/2017.
 */

public class MyCompoundView extends LinearLayout {
    private ImageView imageView;
    private TextView textView;

    private static final String DEFAULT_IMAGE = "http://i.imgur.com/DvpvklR.png";
    private static final String DEFAULT_TEXT  = "Omar Ham";
    private String imageLoaded;
    private String textLoaded;

    LinearLayout.LayoutParams layoutParams;

    public MyCompoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        imageView = new ImageView(context);
        textView = new TextView(context);

        imageView.setMaxWidth(200);
        imageView.setMaxHeight(200);
        this.addView(imageView);
        this.addView(textView);

        this.setOrientation(VERTICAL);

        imageLoaded = imageLoaded == null ? DEFAULT_IMAGE : imageLoaded;
        textLoaded = textLoaded == null ? DEFAULT_TEXT :  textLoaded;

        Picasso.with(getContext()).load(imageLoaded).into(imageView);
        textView.setText(textLoaded);

        layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(5,5,5,5);
        setPadding(10,10,10,10);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        setLayoutParams(layoutParams);
    }

    public void setImage(String url){
        imageLoaded = url;
        Picasso.with(getContext()).load(imageLoaded).into(imageView);
    }

    public void setText(String msg){
        textLoaded = msg;
        textView.setText(msg);
    }






}
