package com.netflux.adp.ui.controller;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;

import com.netflux.adp.R;
import com.netflux.adp.ui.view.BaseDrawerActivityView;


public class BaseDrawerActivity extends BaseActivity {

	private boolean mIsDrawerOpen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mIsDrawerOpen = false;
	}

	@Override
	protected void createView() {
		setView(new BaseDrawerActivityView(this, null));
	}

	@Override
	protected void onStart() {
		super.onStart();

		// Setup 'Menu' icon to open/close the drawer
		getToolbar().setNavigationIcon(getToolbarIcon());
		getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mIsDrawerOpen) {
					getDrawerLayout().closeDrawer(Gravity.START);
				} else {
					getDrawerLayout().openDrawer(Gravity.START);
				}

				mIsDrawerOpen = !mIsDrawerOpen;
			}
		});
	}

	@Override
	public void onBackPressed() {
		if (mIsDrawerOpen) {
			getDrawerLayout().closeDrawer(Gravity.START);
			mIsDrawerOpen = false;
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public void resetToolbar() {
		Toolbar toolbar = getToolbar();
		toolbar.getMenu().clear();
		toolbar.setOnMenuItemClickListener(null);
		toolbar.setNavigationIcon(getToolbarIcon());
		toolbar.setNavigationOnClickListener(null);
	}

	private Drawable getToolbarIcon() {
		// Retrieve the toolbar icon colour
		TypedValue typedValue = new TypedValue();
		int colour = getTheme().resolveAttribute(R.attr.actionBarIconColor, typedValue, true) ?
				typedValue.data : Color.TRANSPARENT;

		// Apply the toolbar icon colour
		Drawable icon = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_menu_24dp, null);
		if (icon != null) icon.setColorFilter(colour, PorterDuff.Mode.SRC_ATOP);

		return icon;
	}

	public DrawerLayout getDrawerLayout() {
		return ((BaseDrawerActivityView) getView()).getDrawerLayout();
	}

	public NavigationView getNavigationView() {
		return ((BaseDrawerActivityView) getView()).getNavigationView();
	}

}
