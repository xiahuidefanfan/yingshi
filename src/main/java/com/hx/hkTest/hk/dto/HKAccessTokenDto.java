package com.hx.hkTest.hk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: HKAccessTokenDto.java
 * 功能描述：
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2020年2月22日 下午11:09:28 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2020年2月22日     xiahui           v1.0.0               修改原因
 */
public class HKAccessTokenDto {
	// 获取的accessToken
	private String accessToken;	
	// 具体过期时间，精确到毫秒
	private long expireTime;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public long getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(long expireTime) {
		this.expireTime = expireTime;
	}
	
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
