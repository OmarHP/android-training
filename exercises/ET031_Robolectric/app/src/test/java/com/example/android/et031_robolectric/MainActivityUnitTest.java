package com.example.android.et031_robolectric;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.apache.tools.ant.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


/**
 * Created by Aptivist-U001 on 11/2/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityUnitTest {
//    @Test
//    public void whenClickButton_textViewShouldChangeText() throws Exception {
//        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
//        Button button = mainActivity.findViewById(R.id.a_main_btn);
//        TextView textView = mainActivity.findViewById(R.id.a_main_counter);
//
//        button.performClick();
//        assertEquals("123", textView.getText());
//    }

    private MainActivity mainActivity;
    private TextView textView;
    private Button button;
    private ProgressBar progressBar;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        textView = mainActivity.findViewById(R.id.a_main_counter);
        button = mainActivity.findViewById(R.id.a_main_btn);
        progressBar = mainActivity.findViewById(R.id.a_main_progress);
    }


    @After
    public void tearDown() throws Exception {
        mainActivity = null;
        textView = null;
        button = null;
        progressBar = null;
    }

    @Test
    public void showProgress_progressBarShouldBeVisible() throws Exception {
        //Setup stage
        progressBar.setVisibility(View.GONE);

        //Action stage
        mainActivity.showProgress();

        //Result stage
        assertEquals(View.VISIBLE, progressBar.getVisibility());
    }

    @Test
    public void incrementCounter_textViewShouldBeUpdated() throws Exception {
        //Setup stage
        textView.setText("");
        int counter = 5;
        //Action stage;
        mainActivity.incrementCounter(counter);
        //Result stage
        assertEquals(5 + "", textView.getText().toString() );
    }

    @Test
    public void hideProgress_ProgressBarShouldBeGone() throws Exception {
        //Setup stage
        progressBar.setVisibility(View.VISIBLE);
        //Action stage
        mainActivity.hideProgress();
        //Result stage
        assertEquals(View.GONE, progressBar.getVisibility());
    }

    @Test
    public void showError_toastShouldPopUp() throws Exception {
        String error = "Couldn't be found";

        mainActivity.showError(error);

        assertEquals(error, ShadowToast.getTextOfLatestToast());
    }
}
