package com.netflux.adp.ui.controller;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netflux.adp.ui.view.BaseTabFragmentView;
import com.netflux.adp.ui.view.IBaseTabFragmentView;


public class BaseTabFragment extends BaseFragment {

	private IBaseTabFragmentView mView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mView = new BaseTabFragmentView(inflater, container);

		return mView.getRootView();
	}

	public ViewPager getViewPager() {
		return mView.getViewPager();
	}

	public TabLayout getTabLayout() {
		return mView.getTabLayout();
	}

}
