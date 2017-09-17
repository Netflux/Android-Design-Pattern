package com.netflux.adp.data;

import com.netflux.adp.util.MainThreadPoster;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class BaseDBModel<T> {

	public interface ModelListener<T> {

		/**
		 * Callback when the list of database entries has been fetched.
		 * @param entries The list of entries.
		 */
		void onFetched(List<T> entries);

		/**
		 * Callback when the database entry has been updated.
		 * @param entry The updated entry.
		 */
		void onUpdated(T entry);

	}

	private BaseDBOpenHelper mDBOpenHelper;

	public BaseDBModel(BaseDBOpenHelper openHelper) {
		mDBOpenHelper = openHelper;
	}

	// Thread-safe list of listeners. Supports registration/unregistration from other threads
	private Set<ModelListener<T>> mListeners = Collections.newSetFromMap(
			new ConcurrentHashMap<ModelListener<T>, Boolean>(1)
	);

	/**
	 * Notify all {@link ModelListener<T> listeners} that the list of database entries has been fetched.
	 * @param entries The list of entries.
	 */
	protected void notifyFetched(final List<T> entries) {
		MainThreadPoster.getInstance().post(new Runnable() {
			@Override
			public void run() {
				for (ModelListener<T> listener : mListeners) {
					listener.onFetched(entries);
				}
			}
		});
	}

	/**
	 * Notify all {@link ModelListener<T> listeners} that the database entry has been updated.
	 * @param entry The updated entry.
	 */
	protected void notifyUpdated(final T entry) {
		MainThreadPoster.getInstance().post(new Runnable() {
			@Override
			public void run() {
				for (ModelListener<T> listener : mListeners) {
					listener.onUpdated(entry);
				}
			}
		});
	}

	/**
	 * Register a {@link ModelListener<T> listener} for database model events.
	 * @param listener The {@link ModelListener<T> listener}.
	 */
	public void registerListener(ModelListener<T> listener) {
		if (listener != null) mListeners.add(listener);
	}

	/**
	 * Unregister a {@link ModelListener<T> listener} for database model events.
	 * @param listener The {@link ModelListener<T> listener}.
	 */
	public void unregisterListener(ModelListener<T> listener) {
		if (listener != null) mListeners.remove(listener);
	}

	/**
	 * Get the default {@link BaseDBOpenHelper Database Open Helper} for the {@link BaseDBModel model}.
	 * @return The {@link BaseDBOpenHelper Database Open Helper}.
	 */
	public BaseDBOpenHelper getDBOpenHelper() {
		return mDBOpenHelper;
	}

}
