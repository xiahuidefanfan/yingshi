package com.hx.hkTest.hk.dto.device.select;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: CameraListDto.java
 * 功能描述：摄像头列表接口返回封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月28日 上午10:06:54 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月28日     xiahui         v1.0.0            摄像头列表接口返回封装
 */
public class CameraListDto {
	
	// 设备序列号
	private String deviceSerial;
	// 通道号
	private int channelNo;
	// 通道名
	private String channelName;	
	// 在线状态：0-不在线，1-在线
	private int status;
	// 图片地址（大图），若在萤石客户端设置封面则返回封面图片，未设置则返回默认图片
	private String picUrl;
	// 是否加密，0：不加密，1：加密
	private int isEncrypt;
	// 视频质量：0-流畅，1-均衡，2-高清，3-超清
	private int videoLevel;
    // 分享设备的权限字段
	private int permission;
	
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
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
