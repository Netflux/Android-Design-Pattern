package com.netflux.adp.ui.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;


public interface IBaseTabFragmentView extends IBaseView {

	/**
	 * Get the {@link ViewPager View Pager} that is wrapped by this component.
	 * @return The {@link ViewPager View Pager}.
	 */
	ViewPager getViewPager();

	/**
	 * Get the {@link TabLayout Tab Layout} that is wrapped by this component.
	 * @return The {@link TabLayout Tab Layout}.
	 */
	TabLayout getTabLayout();

}
