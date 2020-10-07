package com.woxiangbo.listeners;

import com.woxiangbo.anno.Video;

import com.woxiangbo.recorder.VideoRecorder;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.lang.annotation.Annotation;


public class TestngListener extends TestListenerAdapter {
	private ThreadLocal<VideoRecorder> threadLocal = new ThreadLocal<>();
	public void onTestStart(ITestResult result) {
		Annotation annotation = result.getTestClass().getRealClass().getAnnotation(Video.class);
		if (annotation != null){
			String className = result.getTestClass().getName();
			String methodName = result.getMethod().getMethodName();
            Video video = (Video) annotation;
            threadLocal.set(new VideoRecorder(video.store(), className + "_" + methodName));
		}
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		try {
            VideoRecorder recorder = threadLocal.get();
            if (recorder != null) {
                recorder.stopRecording();
                String videoFile = recorder.getVideoFile();
                File file = new File(videoFile);
                file.delete();
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		try {
            VideoRecorder recorder = threadLocal.get();
            if (recorder != null) {
                recorder.stopRecording();
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
