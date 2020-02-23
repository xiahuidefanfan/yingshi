package com.hx.hkTest.dto.live;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: LiveVideoOpenDto.java
 * 功能描述：开通直播功能返回数据封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月26日 下午3:05:43 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月26日     xiahui           v1.0.0            开通直播
 */
public class LiveVideoOpenDto {
	
	// 设备序列号,存在英文字母的设备序列号，字母需为大写
	private String deviceSerial;
	// 通道号
	private int channelNo;
	// 设备开通状态码，参考下方返回码
	private String ret;	
	// 设备开通状态描述
	private String desc;
	
	public String getDeviceSerial() {
		return deviceSerial;
	}
	public void setDeviceSerial(String deviceSerial) {
		this.deviceSerial = deviceSerial;
	}
	public int getChannelNo() {
		return channelNo;
	}
	public void setChannelNo(int channelNo) {
		this.channelNo = channelNo;
	}
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
