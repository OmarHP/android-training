package com.example.android.et019_testing;

import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Aptivist-U001 on 10/25/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityIntrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void whenSimpleNumber_shouldCalculateSum() throws Exception {
        onView(withId(R.id.a_main_et))
                .perform(typeText("1+1"));

        onView(withId(R.id.a_main_btn))
                .perform(click());

        onView(withId(R.id.a_main_tv)).check(matches(withText("2")));

    }
}
