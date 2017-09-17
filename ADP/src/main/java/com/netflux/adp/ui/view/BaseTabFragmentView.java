package com.netflux.adp.ui.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netflux.adp.R;


public final class BaseTabFragmentView implements IBaseTabFragmentView {

	private View mRootView;
	private ViewPager mViewPager;
	private TabLayout mTabLayout;

	public BaseTabFragmentView(LayoutInflater inflater, ViewGroup container) {
		mRootView = inflater.inflate(R.layout.adp_view_base_tabfragment, container, false);
		mViewPager = (ViewPager) mRootView.findViewById(R.id.ADPViewPager);
		mTabLayout = (TabLayout) mRootView.findViewById(R.id.ADPTabLayout);
	}

	@Override
	public ViewPager getViewPager() {
		return mViewPager;
	}

	@Override
	public TabLayout getTabLayout() {
		return mTabLayout;
	}

	@Override
	public View getRootView() {
		return mRootView;
	}

}
