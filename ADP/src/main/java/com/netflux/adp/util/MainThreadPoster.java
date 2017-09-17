package com.netflux.adp.util;

import android.os.Handler;
import android.os.Looper;


public final class MainThreadPoster {

	private static final MainThreadPoster mInstance = new MainThreadPoster();

	public static MainThreadPoster getInstance() { return mInstance; }

	private final Handler mMainHandler;

	private MainThreadPoster() { mMainHandler = new Handler(Looper.getMainLooper()); }

	/**
	 * Executes a {@link Runnable} object on the main (UI) thread.
	 * @param runnable The object (task) to run.
	 */
	public void post(Runnable runnable) { mMainHandler.post(runnable); }

}
