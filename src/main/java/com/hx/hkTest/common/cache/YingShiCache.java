package com.hx.hkTest.common.cache;

import com.hx.hkTest.hk.dto.HKAccessTokenDto;
import com.hx.hkTest.hk.util.api.AccessTokenApi;

/**
 * @ClassName: YingShiCache.java
 * 功能描述：海康大账号token
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2020年2月22日 下午11:33:04 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2020年2月22日     xiahui           v1.0.0            海康大账号token
 */
public class YingShiCache {
	private static String accessToken = null;
	private static long expireTime = -1;
	
	/**
	 * 功能描述：获取accessToken
	 * @author: xiahui
	 * @date: 2019年10月26日 下午1:45:05
	 */
	public static String getAccessToken() {
		if(System.currentTimeMillis() >= expireTime) {
			synchronized (YingShiCache.class) {
				if(System.currentTimeMillis() >= expireTime) {
					HKAccessTokenDto hkAccessTokenDto = AccessTokenApi.getToken();
					accessToken = hkAccessTokenDto.getAccessToken();
					expireTime = hkAccessTokenDto.getExpireTime();
				}
			}
		}
		return accessToken;
	}
	
}
