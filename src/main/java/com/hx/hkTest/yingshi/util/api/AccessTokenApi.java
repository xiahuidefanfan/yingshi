package com.hx.hkTest.yingshi.util.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.CharEncoding;

import com.alibaba.fastjson.JSONObject;
import com.hx.hkTest.common.constant.CommonConstant;
import com.hx.hkTest.common.enums.ErrorCodeEnum;
import com.hx.hkTest.common.exception.BusinsessException;
import com.hx.hkTest.utils.HttpClientUtil;

/**
 * @ClassName: AccessTokenApi.java
 * 功能描述：根据appKey和secret获取accessToken
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月26日 上午11:06:28 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月26日     xiahui           v1.0.0     根据appKey和secret获取accessToken
 */
public class AccessTokenApi {

	private static final String APP_KEY = "95d47096703347e39b79017d88a1f1d7";
	private static final String	SECRET = "5cdb8996f5cd7f82155c729ae00982cb";
	
	/**
	 * 根据appKey和secret获取accessToken
	 */
	private static final String GET_TOKEN_URL = "https://open.ys7.com/api/lapp/token/get";
	
	/**
	 * 功能描述：根据appKey和secret获取accessToken
	 * @author: xiahui
	 * @date: 2019年10月25日 下午6:52:13
	 */
	public static String getToken() {
		Map<String, String> params = new HashMap<>();
    	params.put("appKey", APP_KEY);
    	params.put("appSecret", SECRET);
    	JSONObject result = HttpClientUtil.doPost(GET_TOKEN_URL, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return result.getJSONObject("data").getString("accessToken");
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
}
