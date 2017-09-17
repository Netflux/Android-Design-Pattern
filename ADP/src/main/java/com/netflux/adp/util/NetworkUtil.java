package com.netflux.adp.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public final class NetworkUtil {

	/**
	 * Check whether an active internet connection is available.
	 * @param context {@link Context Android Context.}
	 * @return Whether an active internet connection is available.
	 */
	public static boolean hasInternetConnection(Context context) {
		ConnectivityManager connectivityManager =
				(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

		return networkInfo != null && networkInfo.isConnectedOrConnecting();
	}

}
