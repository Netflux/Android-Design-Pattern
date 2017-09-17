package com.netflux.adp.ui.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;


public class BaseFragment extends Fragment implements BaseActivity.BackPressedListener {

	/**
	 * Replace the current {@link Fragment fragment} with the provided {@link Fragment fragment}.
	 * @param fragClass The class of the new {@link Fragment fragment}.
	 * @param addToBackStack Whether the user can navigate back to the previous {@link Fragment fragment}.
	 * @param args {@link Bundle Arguments} to be passed to the new {@link Fragment fragment}.
	 */
	public void replaceFragment(Class<? extends Fragment> fragClass, boolean addToBackStack,
								Bundle args) {
		((BaseActivity) getActivity()).replaceFragment(fragClass, addToBackStack, args);
	}

	/**
	 * Get the default {@link Toolbar Toolbar} for the {@link BaseActivity Activity}.
	 * @return The {@link Toolbar Toolbar}.
	 */
	public Toolbar getToolbar() {
		return ((BaseActivity) getActivity()).getToolbar();
	}

	/**
	 * Callback when the Back button is pressed.
	 * @return Whether the Back button event was handled.
	 */
	@Override
	public boolean onBackPressed() {
		return false;
	}

	/**
	 * Ensure that any underlying parent components extends the {@link BaseActivity BaseActivity}.
	 * This is important to allow navigation between the parent and this component.
	 * If valid, register this fragment as a 'Back' pressed listener.
	 * @param context The parent component.
	 */
	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

		try {
			BaseActivity activity = (BaseActivity) context;
			activity.registerBackPressedListener(this);
		} catch (ClassCastException e) {
			throw new ClassCastException(context.toString() + " must extend BaseActivity");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();

		((BaseActivity) getActivity()).unregisterBackPressedListener(this);
	}

}
