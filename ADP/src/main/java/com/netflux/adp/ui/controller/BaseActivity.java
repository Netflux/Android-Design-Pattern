package com.netflux.adp.ui.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.netflux.adp.R;
import com.netflux.adp.ui.view.BaseActivityView;
import com.netflux.adp.ui.view.IBaseActivityView;
import com.netflux.adp.ui.view.IBaseView;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class BaseActivity extends AppCompatActivity {

	private static final String mTAG = "BaseActivity";

	public interface BackPressedListener {

		/**
		 * Callback when the 'Back' button is pressed.
		 * @return Whether the event was handled.
		 */
		boolean onBackPressed();

	}

	// Thread-safe list of listeners. Supports registration/unregistration from other threads
	private Set<BackPressedListener> mBackPressedListeners = Collections.newSetFromMap(
			new ConcurrentHashMap<BackPressedListener, Boolean>(1)
	);

	private IBaseActivityView mView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Create a new View component for this Activity
		createView();
	}

	@Override
	public void onBackPressed() {
		// Loop through all listeners and call the callback function
		// If a listener handles the event, exit prematurely
		for (BackPressedListener listener : mBackPressedListeners) {
			if (listener.onBackPressed()) return;
		}

		super.onBackPressed();
	}

	/**
	 * Register a {@link BackPressedListener listener} for 'Back' button events.
	 * @param listener The {@link BackPressedListener listener}.
	 */
	public void registerBackPressedListener(BackPressedListener listener) {
		if (listener != null) mBackPressedListeners.add(listener);
	}

	/**
	 * Unregister a {@link BackPressedListener listener} for 'Back' button events.
	 * @param listener The {@link BackPressedListener listener}.
	 */
	public void unregisterBackPressedListener(BackPressedListener listener) {
		if (listener != null) mBackPressedListeners.remove(listener);
	}

	/**
	 * Replace the current {@link Fragment fragment} with the provided {@link Fragment fragment}.
	 * @param fragClass The class of the new {@link Fragment fragment}.
	 * @param addToBackStack Whether the user can navigate back to the previous {@link Fragment fragment}.
	 * @param args {@link Bundle Arguments} to be passed to the new {@link Fragment fragment}.
	 */
	public void replaceFragment(Class<? extends Fragment> fragClass, boolean addToBackStack,
								Bundle args) {

		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		Fragment newFragment;

		try {
			newFragment = fragClass.newInstance();
			if (args != null) newFragment.setArguments(args);
		} catch (InstantiationException | IllegalAccessException e) {
			Log.e(mTAG, "Failed to instantiate new fragment", e);
			return;
		}

		if (addToBackStack) {
			ft.addToBackStack(null);
		}

		ft.replace(R.id.ADPBaseView, newFragment, fragClass.getClass().getSimpleName());
		ft.commit();
	}

	/**
	 * Create the default {@link IBaseActivityView View} for the {@link BaseActivity Activity}.
	 */
	protected void createView() {
		setView(new BaseActivityView(this, null));
	}

	/**
	 * Get the default {@link Toolbar Toolbar} for the {@link BaseActivity Activity}.
	 * @return The {@link Toolbar Toolbar}.
	 */
	public Toolbar getToolbar() {
		return mView.getToolbar();
	}

	/**
	 * Resets several commonly-used properties of the toolbar.
	 * 1. Clear options menu items.
	 * 2. Reset menu item click listener.
	 * 3. Reset navigation icon.
	 * 4. Reset navigation click listener.
	 */
	public void resetToolbar() {
		Toolbar toolbar = getToolbar();
		toolbar.getMenu().clear();
		toolbar.setOnMenuItemClickListener(null);
		toolbar.setNavigationIcon(null);
		toolbar.setNavigationOnClickListener(null);
	}

	/**
	 * Get the default {@link IBaseActivityView View} for the {@link BaseActivity Activity}.
	 * @return The {@link IBaseActivityView View}.
	 */
	protected IBaseActivityView getView() {
		return mView;
	}

	/**
	 * Set the default {@link IBaseActivityView View} for the {@link BaseActivity Activity}.
	 * @param view The {@link IBaseActivityView View}.
	 */
	protected void setView(IBaseActivityView view) {
		mView = view;
		setContentView(mView.getRootView());
	}

}
