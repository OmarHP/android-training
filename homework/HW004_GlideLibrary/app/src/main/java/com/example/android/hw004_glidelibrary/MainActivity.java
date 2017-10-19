package com.example.android.hw004_glidelibrary;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Spinner spExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.a_main_iv_image);
        spExample = (Spinner) findViewById(R.id.a_main_sp_example);
    }


    public void doMagic(View view) {
        String option = spExample.getSelectedItem().toString();
        switch (option){
            case "Basic usage":
                Glide.with(this)
                        .load("http://via.placeholder.com/300.png")
                        .into(imageView);
                break;
            case "Advanced usage":
                Glide.with(this)
                        .load("http://via.placeholder.com/300.png")
                        .override(300, 200)
                        .into(imageView);
                break;
            case "Placeholder and error images":
                Glide.with(this)
                        .load("http://via.placeholder.com/300.png")
                        .placeholder(R.drawable.placeholder)
                        .error(R.drawable.imagenotfound)
                        .into(imageView);
                break;
            case "Cropping image":
                Glide.with(this)
                        .load("http://via.placeholder.com/300.png")
                        .override(300,200)
                        .centerCrop()
                        .into(imageView);
                break;
            case "Fitting image":
                Glide.with(this)
                        .load("http://via.placeholder.com/300.png")
                        .override(300,200)
                        .fitCenter()
                        .into(imageView);
                break;
            case "Loading errors":
                Glide.with(this)
                        .load("http://noexistesdsfsf/300.png")
                        .placeholder(R.drawable.placeholder)
                        .error(R.drawable.imagenotfound)
                        .listener(new RequestListener<String, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                // log exception
                                Toast.makeText(MainActivity.this, "Error loading image:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                return false; // important to return false so the error placeholder can be placed
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .into(imageView);
                break;
            case "Rounder corners":
                int radius = 30; // corner radius, higher value = more rounded
                int margin = 10; // crop margin, set to 0 for corners with no crop
                Glide.with(this)
                        .load("http://via.placeholder.com/300.png")
                        .bitmapTransform(new RoundedCornersTransformation(this, radius, margin))
                        .into(imageView);
                break;

            case "Circle crop":
                Glide.with(this)
                        .load("http://via.placeholder.com/300.png")
                        .bitmapTransform(new CropCircleTransformation(this))
                        .into(imageView);
                break;
            case "Blur":
                Glide.with(this)
                        .load("http://via.placeholder.com/300.png")
                        .bitmapTransform(new BlurTransformation(this))
                        .into(imageView);
                break;
            case "Multiple transformations":
                Glide.with(this)
                        .load("http://via.placeholder.com/300.png")
                        .bitmapTransform(new BlurTransformation(this, 25), new CropCircleTransformation(this))
                        .into(imageView);
                break;
        }

        new AsyncTask(){

            @Override
            protected Object doInBackground(Object[] params) {
                Glide.get(MainActivity.this).clearDiskCache();

                return  null;
            }

            @Override
            protected void onPostExecute(Object o) {
                Glide.get(MainActivity.this).clearMemory();
            }
        }.execute();
    }
}
