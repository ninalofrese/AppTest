package com.example.apptest;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginInstrumentedTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void login() {
        onView(withId(R.id.login_edit_text_id)).perform(typeText("admin@digitalhouse.com"));
        closeSoftKeyboard();
        onView(withId(R.id.senha_edit_text_id)).perform(typeText("senha123"));
        closeSoftKeyboard();
        onView(withId(R.id.ok_button)).perform(click());
        onView(withId(R.id.imc_title_text_id)).check(matches(isDisplayed()));
    }


    @Test
    public void loginInvalido() {
        onView(withId(R.id.login_edit_text_id)).perform(typeText("admin@digitalhouse.com"));
        closeSoftKeyboard();
        onView(withId(R.id.senha_edit_text_id)).perform(typeText("senha312"));
        closeSoftKeyboard();
        onView(withId(R.id.ok_button)).perform(click());

        onView(withId(R.id.login_edit_text_id)).check(matches(hasErrorText("Login/senha inválido(s)")));
    }
}
