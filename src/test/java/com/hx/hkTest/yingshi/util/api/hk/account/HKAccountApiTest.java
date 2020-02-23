package com.hx.hkTest.yingshi.util.api.hk.account;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hx.hkTest.common.cache.YingShiCache;
import com.hx.hkTest.hk.dto.account.HKRamAccountInfoDto;
import com.hx.hkTest.hk.util.ApiUtil;

/**
 * @ClassName: HKAccountApiTest.java
 * 功能描述：海康子账号api测试
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2020年2月22日 下午8:16:17 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2020年2月22日     xiahui           v1.0.0               修改原因
 */
public class HKAccountApiTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(HKAccountApiTest.class);
	
	@Test
	public void ramAccountCreate(){
		String accountId = ApiUtil.ramAccountCreate("xiahuitest", "111111");
		System.out.println(accountId);
	}
	
	@Test
	public void ramAccountGet(){
		// 1.accessToken参数是大账户token,指定子账户名
		HKRamAccountInfoDto hkRamAccountInfoDto = ApiUtil.ramAccountGet(YingShiCache.getAccessToken(),
				null, "xiahuitest");
		LOGGER.info("查询结果为:{}", hkRamAccountInfoDto);
		
	}
}
