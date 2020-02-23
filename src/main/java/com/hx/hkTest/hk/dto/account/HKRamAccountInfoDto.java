package com.hx.hkTest.hk.dto.account;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: HKRamAccountInfoDto.java
 * 功能描述：获取指定子账户信息封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2020年2月22日 下午9:11:13 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2020年2月22日     xiahui           v1.0.0              子账户信息封装
 */
public class HKRamAccountInfoDto {
	// 子账户Id
	private String accountId;
	// 子账户Name
	private String accountName;
	// 子账户所属应用的AppKey
	private String appKey;
	// 子账户状态，0为停用，1为启用
	private String accountStatus;
	
	private Policy policy;
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
