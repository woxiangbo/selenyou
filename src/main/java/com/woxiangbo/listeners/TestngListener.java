package com.woxiangbo.listeners;

import com.woxiangbo.anno.Video;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.lang.annotation.Annotation;


public class TestngListener extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult result) {
        Annotation annotation = result.getTestClass().getRealClass().getAnnotation(Video.class);
        if (annotation != null) {

            String className = result.getTestClass().getName();
            String methodName = result.getMethod().getMethodName();

            Video video = (Video) annotation;
            String store = video.store();


        }
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);

    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);

    }


}
