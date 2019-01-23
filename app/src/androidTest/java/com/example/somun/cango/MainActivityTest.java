package com.example.somun.cango;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    /**
     *Test for map in canGo app.
     */
    @Rule
    public android.support.test.rule.ActivityTestRule<MainActivity>mainActivityActivityTestRule = new android.support.test.rule.ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity = null;

    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityActivityTestRule.getActivity();
    }
    @Test
    public void TestLaunch(){
        View view= mainActivity.findViewById(R.id.button2);
        assertNotNull(view);

    }
    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}