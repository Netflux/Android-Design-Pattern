package com.netflux.adp.ui.view;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netflux.adp.R;


public final class BaseActivityView implements IBaseActivityView {

	private View mRootView;
	private Toolbar mToolbar;

	public BaseActivityView(Context context, ViewGroup container) {
		mRootView = LayoutInflater.from(context).inflate(R.layout.adp_view_base, container);
		mToolbar = (Toolbar) mRootView.findViewById(R.id.ADPToolbar);
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
