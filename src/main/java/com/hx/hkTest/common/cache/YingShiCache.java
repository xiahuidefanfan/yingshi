package com.hx.hkTest.common.cache;

import com.hx.hkTest.yingshi.util.api.AccessTokenApi;

public class YingShiCache {
	public static String accessToken = null;
	
	/**
	 * 功能描述：accessToken缓存
	 * @author: xiahui
	 * @date: 2019年10月26日 下午1:45:05
	 */
	public static String getAccessToken() {
		if(null == accessToken) {
			synchronized (YingShiCache.class) {
				if(null == accessToken) {
					accessToken = AccessTokenApi.getToken();
				}
			}
		}
		return accessToken;
	}
}
