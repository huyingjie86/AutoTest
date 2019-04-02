package com.example.myapplication;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(AndroidJUnit4.class)
public class Uiautomator2demo {
    public Instrumentation mInstrumentation;
    public UiDevice mUiDevice;
    private String packageName = "com.android.settings";
    private String clearCacheAppName = "使用指南";
    @Before
    public void setUp(){
        mInstrumentation= InstrumentationRegistry.getInstrumentation();
        mUiDevice=UiDevice.getInstance(mInstrumentation);
    }
    @Test
    public void clearCache() throws Exception {
        startApp(packageName);
        sleep(2);
        mUiDevice.swipe(260, 858, 310, 410, 100);
        mUiDevice.findObject(By.text("应用")).click();
        sleep(2);

        if (exsitObjByText(clearCacheAppName)) {
            mUiDevice.findObject(By.text(clearCacheAppName)).click();
            sleep(2);
            mUiDevice.findObject(By.textContains("内存已使用")).click();
            sleep(2);
            mUiDevice.findObject(By.text("清除数据")).click();
            sleep(2);
            mUiDevice.findObject(By.text("确定")).click();
        }
    }
    private boolean exsitObjByText(String text) throws Exception{
        return mUiDevice.hasObject(By.text(text));
    }

    private void sleep(float second) throws Exception{
        Thread.sleep(second > 0 ? (long) (second * 1000) : 1000);
    }

    public void startApp(String packageName){
            Context context = InstrumentationRegistry.getInstrumentation().getContext();
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
        }

    }
