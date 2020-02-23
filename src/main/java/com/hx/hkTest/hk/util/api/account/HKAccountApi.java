package com.hx.hkTest.hk.util.api.account;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import com.alibaba.fastjson.JSONObject;
import com.hx.hkTest.common.cache.YingShiCache;
import com.hx.hkTest.common.constant.CommonConstant;
import com.hx.hkTest.common.enums.ErrorCodeEnum;
import com.hx.hkTest.common.exception.BusinsessException;
import com.hx.hkTest.hk.dto.account.HKRamAccountInfoDto;
import com.hx.hkTest.hk.dto.account.Policy;
import com.hx.hkTest.hk.util.api.AccessTokenApi;
import com.hx.hkTest.utils.HttpClientUtil;

/**
 * @ClassName: HKAccountApi.java
 * 功能描述：  序号	接口功能				描述
 *			1	创建子账户	                                    创建B(大账户)模式的子账户
 *			2	获取单个子账户信息		获取指定子账户信息
 *			3	获取子账户信息列表		分页获取应用下的子账户信息列表
 *			4	修改子账户密码			修改子账户密码
 *			5	设置子账户的授权策略		设置子账户的授权策略
 *			6	增加子账户权限			增加子账户授权策略中的授权语句
 *			7	删除子账户权限	                        删除子账户授权策略中某个设备的所有授权语句
 *			8	获取子账户AccessToken	获取子账户AccessToken
 *			9	删除子账户				删除子账户
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2020年2月22日 下午7:41:11 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2020年2月22日     xiahui           v1.0.0               修改原因
 */
public class HKAccountApi {
	
	/**
	 * 功能描述: 1.创建B(大账户)模式的子账户。
	 * @author xiahui
	 * @param: accountName：子账户名，4-40位英文字母、阿拉伯数字或下划线	
	 * @param: password：子账户密码，LowerCase(MD5(AppKey#密码明文))
	 * @date 2020年2月22日 下午8:01:54
	 */
	public static String ramAccountCreate(String accountName, String password) {
		if(StringUtils.isEmpty(accountName) || StringUtils.isEmpty(password)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("accountName", accountName); 
    	params.put("password", StringUtils.lowerCase(DigestUtils.md5DigestAsHex((
    			AccessTokenApi.APP_KEY + "#" + password).getBytes())));
    	JSONObject result = HttpClientUtil.doPost(RAM_ACCOUNT_CREATE, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return result.getJSONObject("data").getString("accountId");
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
		
	/**
	 * 功能描述: 2.获取指定子账户信息：
	 * 			1）如果accessToken参数是子账户类型的AccessToken，accountId和accountName参数可为空；
	 * 			       否则accountId和accountName其中一个必须不为空；
	 * 			2）如果两个都不为空，接口返回accountId的子账户信息
	 * @author xiahui
	 * @param: accessToken：授权过程获取的access_token	
	 * @param: accountId：子账户Id	
	 * @param: accountName：子账户name
	 * @date 2020年2月22日 下午8:01:54
	 */
	public static HKRamAccountInfoDto ramAccountGet(String accessToken, String accountId, String accountName) {
		if(StringUtils.isEmpty(accessToken)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		// 如果accessToken参数是子账户类型的AccessToken,accountId和accountName参数可为空, 否则accountId和accountName其中一个必须不为空
		if(!(accessToken.length() == 32 || (StringUtils.isNotEmpty(accountId) || StringUtils.isNotEmpty(accountName)))) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", accessToken);
    	params.put("accountId", accountId); 
    	params.put("accountName", accountName);
    	JSONObject result = HttpClientUtil.doPost(RAM_ACCOUNT_GET, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseObject(result.getString("data"), HKRamAccountInfoDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述: 3.设置子账户的授权策略
	 * @author xiahui
	 * @param: accessToken：授权过程获取的access_token
	 * @param: accountId：子账户Id
	 * @param: policy：授权策略
	 * @date 2020年2月23日 下午2:49:43
	 */
	public static boolean ramPolicyGet(String accessToken, String accountId, Policy policy) {
		if(StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(accountId) || null == policy) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", accessToken);
    	params.put("accountId", accountId); 
    	params.put("policy", JSONObject.toJSONString(policy));
    	JSONObject result = HttpClientUtil.doPost(RAM_POLICY_GET, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 创建B(大账户)模式的子账户。
	 */
	private static final String RAM_ACCOUNT_CREATE = "https://open.ys7.com/api/lapp/ram/account/create";
	/**
	 * 获取指定子账户信息。
	 */
	private static final String RAM_ACCOUNT_GET = "https://open.ys7.com/api/lapp/ram/account/get";
	/**
	 * 设置子账户的授权策略。
	 */
	private static final String RAM_POLICY_GET = "https://open.ys7.com/api/lapp/ram/policy/set";
	
	
}
