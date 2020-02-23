package com.hx.hkTest.hk.dto.device.select;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: DeviceSupportEzvizDto.java
 * 功能描述：查询设备是否支持萤石协议
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月28日 上午10:47:43 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月28日     xiahui           v1.0.0      查询设备是否支持萤石协议
 */
public class DeviceSupportEzvizDto {
	
	// 设备型号
	private String model; 
	// 设备版本号,当isSupport=0时,返回最近支持的版本,当isSupport=1时,返回当前版本
	private String version;	
	// 是否支持萤石协议, 0:不支持, 1:支持
	private int isSupport;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getIsSupport() {
		return isSupport;
	}
	public void setIsSupport(int isSupport) {
		this.isSupport = isSupport;
	}		
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
