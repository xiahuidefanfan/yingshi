package com.hx.hkTest.dto.live;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: LiveVideoCommonDto.java
 * 功能描述：直播接口-公共返回数据
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月26日 上午11:13:47 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月26日     xiahui           v1.0.0            直播信息
 */
public class LiveVideoCommonDto {
	//设备序列号,存在英文字母的设备序列号，字母需为大写
	private String deviceSerial;
	// 通道号
	private int channelNo;
	// 设备名称
	private String deviceName;
	// HLS流畅直播地址
	private String liveAddress;	
	// HLS高清直播地址
	private String hdAddress;
	// RTMP流畅直播地址
	private String rtmp;	
	// RTMP高清直播地址
	private String rtmpHd;
	// 地址使用状态：0-未使用或直播已关闭，1-使用中，2-已过期，3-直播已暂停，0状态不返回地址，其他返回
	private int status;
	// 地址异常状态：0-正常，1-设备不在线，2-设备开启视频加密，3-设备删除，4-失效，5-未绑定，6-账户下流量已超出，7-设备接入限制，0/1/2/6状态返回地址，其他不返回
	private int exception;
	
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
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getLiveAddress() {
		return liveAddress;
	}
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	public String getHdAddress() {
		return hdAddress;
	}
	public void setHdAddress(String hdAddress) {
		this.hdAddress = hdAddress;
	}
	public String getRtmp() {
		return rtmp;
	}
	public void setRtmp(String rtmp) {
		this.rtmp = rtmp;
	}
	public String getRtmpHd() {
		return rtmpHd;
	}
	public void setRtmpHd(String rtmpHd) {
		this.rtmpHd = rtmpHd;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getException() {
		return exception;
	}
	public void setException(int exception) {
		this.exception = exception;
	}
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
