package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.init;
import static androidx.test.espresso.intent.Intents.release;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShowActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> rule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Before
    public void a() {
        init();
    }
    @After
    public void b() {
        release();
    }
    @Test
    public void c() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name))
                .perform(replaceText("Edmonton"),  closeSoftKeyboard());
        onView(withId(R.id.button_confirm)).perform(click());
        onData(is("Edmonton"))
                .inAdapterView(withId(R.id.city_list))
                    .perform(click());
        intended(hasComponent(ShowActivity.class.getName()));
    }
    @Test
    public void d(){
        onView(withId(R.id.button_add)). perform(click());
        onView(withId(R.id.editText_name)) .perform(replaceText("Calgary"), closeSoftKeyboard());
        onView(withId(R.id.button_confirm)).perform(click( ));
        onData(is("Calgary"))
                .inAdapterView(withId(R.id.city_list))
                    .perform(click());
        onView(withId(R.id.text_city))
                    .check(matches(withText("Calgary")));
    }
    @Test
    public void e() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name))
                .perform(replaceText("Toronto"), closeSoftKeyboard());
        onView(withId(R.id.button_confirm)).perform(click());
        onData(is("Toronto"))
                .inAdapterView(withId(R.id.city_list))
                    .perform(click()) ;
        onView(withId(R.id.button_back)).perform(click());
        onView(withId(R.id.button_add))
                    .check(matches(isDisplayed()));
    }
}