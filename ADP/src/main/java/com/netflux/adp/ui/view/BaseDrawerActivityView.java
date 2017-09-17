package com.netflux.adp.ui.view;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netflux.adp.R;


public final class BaseDrawerActivityView implements IBaseDrawerActivityView {

	private View mRootView;
	private Toolbar mToolbar;
	private DrawerLayout mDrawerLayout;
	private NavigationView mNavigationView;

	public BaseDrawerActivityView(Context context, ViewGroup container) {
		mRootView = LayoutInflater.from(context).inflate(R.layout.adp_view_base_drawer, container);
		mToolbar = (Toolbar) mRootView.findViewById(R.id.ADPToolbar);
		mDrawerLayout = (DrawerLayout) mRootView.findViewById(R.id.ADPDrawerLayout);
		mNavigationView = (NavigationView) mRootView.findViewById(R.id.ADPNavigationView);
	}

	@Override
	public DrawerLayout getDrawerLayout() {
		return mDrawerLayout;
	}

	@Override
	public NavigationView getNavigationView() {
		return mNavigationView;
	}

	@Override
	public Toolbar getToolbar() {
		return mToolbar;
	}

	@Override
	public View getRootView() {
		return mRootView;
	}

}
