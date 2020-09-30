package com.chenxiangbo.listeners;

import com.chenxiangbo.Video;

import com.chenxiangbo.recorder.VideoRecorder;
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
			threadLocal.set(new VideoRecorder("C:\\vt",  className + "_" + methodName));

		}
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		try {
			threadLocal.get().stopRecording();
//			String videoFile = threadLocal.get().getVideoFile();
//			File file = new File(videoFile);
//			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		try {
			threadLocal.get().stopRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
