package com.hx.hkTest.yingshi.util.api;

import org.junit.Test;

import com.hx.hkTest.hk.dto.HKAccessTokenDto;
import com.hx.hkTest.hk.util.api.AccessTokenApi;

public class AccessTokenApiTest {

	/**
	 * 功能描述：获取accessToken
	 * @author: xiahui
	 * @date: 2019年10月26日 下午2:01:32
	 */
	@Test
	public void getToken() {
		HKAccessTokenDto token = AccessTokenApi.getToken();
		System.out.println(token);
	}
}
