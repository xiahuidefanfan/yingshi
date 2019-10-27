package com.hx.hkTest.yingshi.dto.device.select;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: DeviceListDto.java
 * 功能描述：查询用户下设备基本信息列表返回封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月26日 下午5:05:44 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月26日     xiahui           v1.0.0          设备基本信息列表
 */
public class DeviceListDto {

	// 设备序列号,存在英文字母的设备序列号，字母需为大写
	private String deviceSerial;
	// 设备名称
	private String deviceName;
	// 设备类型
	private String deviceType;
	// 在线状态：0-不在线，1-在线
	private int status;	
	// 具有防护能力的设备布撤防状态：0-睡眠，8-在家，16-外出，普通IPC布撤防状态：0-撤防，1-布防
	private int defence;
	// 设备版本号
	private int deviceVersion;
	
	public String getDeviceSerial() {
		return deviceSerial;
	}
	public void setDeviceSerial(String deviceSerial) {
		this.deviceSerial = deviceSerial;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public int getDeviceVersion() {
		return deviceVersion;
	}
	public void setDeviceVersion(int deviceVersion) {
		this.deviceVersion = deviceVersion;
	}
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
