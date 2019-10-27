package com.hx.hkTest.yingshi.util.api;

import org.junit.Test;

public class AccessTokenApiTest {

	/**
	 * 功能描述：获取accessToken
	 * @author: xiahui
	 * @date: 2019年10月26日 下午2:01:32
	 */
	@Test
	public void getToken() {
		String token = AccessTokenApi.getToken();
		System.out.println(token);
	}
}
