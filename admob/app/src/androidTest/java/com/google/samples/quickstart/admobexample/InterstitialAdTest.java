package com.google.samples.quickstart.admobexample;


import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.google.samples.quickstart.admobexample.kotlin.FirstFragment;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class InterstitialAdTest {

    @Test
    public void interstitialAdTest() {
        FragmentScenario<FirstFragment> fragment = FragmentScenario.launchInContainer(FirstFragment.class);

        // Confirm that banner ad appears
        onView(withId(R.id.adView))
                .check(matches(isDisplayed()));

        // Click show interstitial button
        ViewInteraction showInterstitialButton = onView(
                allOf(withId(R.id.loadInterstitialButton),
                        withText(R.string.interstitial_button_text),
                        isDisplayed()));
        showInterstitialButton.perform(click());

        // Click close interstitial button
        ViewInteraction closeInterstitialButton = onView(
                allOf(withContentDescription("Interstitial close button"), isDisplayed()));
        closeInterstitialButton.perform(click());

        // Confirm that we're on the second activity
        onView(withText(R.string.second_fragment_content))
                .check(matches(isDisplayed()));
    }
}
