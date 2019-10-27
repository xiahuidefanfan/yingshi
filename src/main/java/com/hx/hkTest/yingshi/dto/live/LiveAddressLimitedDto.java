package com.hx.hkTest.yingshi.dto.live;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: LiveAddressLimitedDto.java
 * 功能描述：获取指定有效期的直播地址接口返回封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月26日 下午2:59:22 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月26日     xiahui           v1.0.0          有效期的直播地址
 */
public class LiveAddressLimitedDto extends LiveVideoCommonDto{
	// 开始时间
	private long beginTime;
	// 过期时间
	private long endTime;
	
	public long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
