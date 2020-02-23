package com.hx.hkTest.hk.dto.device.select;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: DeviceCameraListDto.java
 * 功能描述：获取指定设备的通道信息接口返回封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月28日 上午10:25:15 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月28日     xiahui           v1.0.0            通道信息
 */
public class DeviceCameraListDto {
	
	// 设备序列号
	private String deviceSerial;	
	// IPC序列号
	private String ipcSerial;
	// 通道号
	private int channelNo;	
	// 设备名
	private String deviceName;
	// 通道名
	private String channelName;	
	// 在线状态：0-不在线，1-在线,-1设备未上报
	private int status;	
	// 图片地址（大图），若在萤石客户端设置封面则返回封面图片，未设置则返回默认图片
	private String picUrl;
	// 是否加密，0：不加密，1：加密
	private int isEncrypt;
	// 视频质量：0-流畅，1-均衡，2-高清，3-超清
	private int videoLevel;	
	// 当前通道是否关联IPC：true-是，false-否。设备未上报或者未关联都是false
	private boolean relatedIpc;
	public String getDeviceSerial() {
		return deviceSerial;
	}
	public void setDeviceSerial(String deviceSerial) {
		this.deviceSerial = deviceSerial;
	}
	public String getIpcSerial() {
		return ipcSerial;
	}
	public void setIpcSerial(String ipcSerial) {
		this.ipcSerial = ipcSerial;
	}
	public int getChannelNo() {
		return channelNo;
	}
	public void setChannelNo(int channelNo) {
		this.channelNo = channelNo;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public int getIsEncrypt() {
		return isEncrypt;
	}
	public void setIsEncrypt(int isEncrypt) {
		this.isEncrypt = isEncrypt;
	}
	public int getVideoLevel() {
		return videoLevel;
	}
	public void setVideoLevel(int videoLevel) {
		this.videoLevel = videoLevel;
	}
	public boolean isRelatedIpc() {
		return relatedIpc;
	}
	public void setRelatedIpc(boolean relatedIpc) {
		this.relatedIpc = relatedIpc;
	}	
		
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
