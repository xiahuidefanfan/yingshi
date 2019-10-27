package com.hx.hkTest.yingshi.dto.live;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: LiveAddressGetDto.java
 * 功能描述：获取直播地址接口返回数据封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月26日 下午3:10:55 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月26日     xiahui           v1.0.0            直播地址
 */
public class LiveAddressGetDto extends LiveVideoCommonDto{
	
	// 状态码：优先判断该错误码，返回200即表示成功。
	private String ret;
	// 状态描述
	private String desc;
	public String getRet() {
		return ret;
	}
	public void setRet(String ret) {
		this.ret = ret;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}	
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
