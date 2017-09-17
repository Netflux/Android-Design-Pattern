package com.netflux.adp.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public final class BackgroundThreadPoster {

	private static final BackgroundThreadPoster mInstance = new BackgroundThreadPoster();

	public static BackgroundThreadPoster getInstance() { return mInstance; }

	private final ExecutorService mBackgroundExecutor;

	private BackgroundThreadPoster() { mBackgroundExecutor = Executors.newCachedThreadPool(); }

	/**
	 * Executes a {@link Runnable} object on a random background thread.
	 * @param runnable The object (task) to run.
	 */
	public void post(Runnable runnable) { mBackgroundExecutor.execute(runnable); }

}
