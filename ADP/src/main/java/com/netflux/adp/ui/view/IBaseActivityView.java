package com.netflux.adp.ui.view;

import android.support.v7.widget.Toolbar;


public interface IBaseActivityView extends IBaseView {

	/**
	 * Get the {@link Toolbar Toolbar} that is wrapped by this component.
	 * @return The {@link Toolbar Toolbar}.
	 */
	Toolbar getToolbar();

}
