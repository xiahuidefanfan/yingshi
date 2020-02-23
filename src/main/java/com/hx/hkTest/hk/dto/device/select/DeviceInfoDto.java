package com.hx.hkTest.hk.dto.device.select;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: DeviceInfoDto.java
 * 功能描述：查询用户下指定设备的基本信息返回封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月26日 下午5:17:41 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月26日     xiahui           v1.0.0         用户下指定设备的基本信息
 */
public class DeviceInfoDto {
	// 设备序列号
	private String deviceSerial;
    // 设备名称
	private String deviceName;	
	// 设备型号，如CS-C2S-21WPFR-WX
	private String model;	
	// 在线状态：0-不在线，1-在线
	private int status;
	// 具有防护能力的设备布撤防状态：0-睡眠，8-在家，16-外出，普通IPC布撤防状态：0-撤防，1-布防
	private int defence;
	// 是否加密：0-不加密，1-加密
	private int isEncrypt;
	// 告警声音模式：0-短叫，1-长叫，2-静音
	private int alarmSoundMode;
	// 设备下线是否通知：0-不通知 1-通知
	private int offlineNotify;
	// 设备大类
	private String category;
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
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
	public int getIsEncrypt() {
		return isEncrypt;
	}
	public void setIsEncrypt(int isEncrypt) {
		this.isEncrypt = isEncrypt;
	}
	public int getAlarmSoundMode() {
		return alarmSoundMode;
	}
	public void setAlarmSoundMode(int alarmSoundMode) {
		this.alarmSoundMode = alarmSoundMode;
	}
	public int getOfflineNotify() {
		return offlineNotify;
	}
	public void setOfflineNotify(int offlineNotify) {
		this.offlineNotify = offlineNotify;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
