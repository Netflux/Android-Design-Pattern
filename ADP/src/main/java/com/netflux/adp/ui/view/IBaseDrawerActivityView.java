package com.netflux.adp.ui.view;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;


public interface IBaseDrawerActivityView extends IBaseActivityView {

	/**
	 * Get the {@link DrawerLayout Drawer Layout} that is wrapped by this component.
	 * @return The {@link DrawerLayout Drawer Layout}.
	 */
	DrawerLayout getDrawerLayout();

	/**
	 * Get the {@link NavigationView Navigation View} that is wrapped by this component.
	 * @return The {@link NavigationView Navigation View}.
	 */
	NavigationView getNavigationView();

}
