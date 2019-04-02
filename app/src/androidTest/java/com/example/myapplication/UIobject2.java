package com.example.myapplication;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UIobject2 {
    public Instrumentation mInstrumentation;
    public UiDevice mUiDevice;

    @Before
    public void setUp(){
    mInstrumentation = InstrumentationRegistry.getInstrumentation();
    mUiDevice = UiDevice.getInstance(mInstrumentation);
    }

    @Test
    public void uiObj2(){
        UiObject2 list = mUiDevice.findObject(By.clazz("android.widget.ListView"));
        UiObject2 child = list.findObject(By.clazz(TextView.class));
        Log.i("test", child.getText());

    }
}

