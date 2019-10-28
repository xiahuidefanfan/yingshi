package com.hx.hkTest.yingshi.dto.device.select;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: VideoByTimeDto.java
 * 功能描述：根据时间获取存储文件信息返回封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月28日 下午2:03:42 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月28日     xiahui           v1.0.0        根据时间获取存储文件信息   
 */
public class VideoByTimeDto {
	
	// 回放源，0-系统自动选择，1-云存储，2-本地录像
	private int recType;
	// 文件开始时间
	private long startTime;
	// 文件结束时间
	private long endTime;
	// 设备序列号
	private String deviceSerial;	
	// 设备通道号
	private int channelNo;
	// 文件类型 0:ALARM 1:TIMING 2:IO 
	private String localType;
	// 云存储信息主键ID
	private long id;	
	// 文件ID
	private String fileId;
	// 文件所属用户ID
	private String ownerId;	
	// 文件类型0：目录1：视频文件2：图片文件3：音频文件
	private int fileType;
	// 文件名称
	private String fileName;	
	// 文件在云存储上的唯一索引
	private String fileIndex;	
	// 文件大小，单位B
	private long fileSize;	
	// 是否被锁定。1-锁定；0-未锁定
	private int locked;	
	// 创建时间
	private long createTime;	
	// 是否加密0--不加1--加密
	private int crypt;	
	// 验证码MD5值
	private String keyChecksum;	
	// 录像长度
	private long videoLong;
	// 封面图片地址
	private String coverPic;	
	// 下载路径
	private String downloadPath;
	public int getRecType() {
		return recType;
	}
	public void setRecType(int recType) {
		this.recType = recType;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
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
	public String getLocalType() {
		return localType;
	}
	public void setLocalType(String localType) {
		this.localType = localType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public int getFileType() {
		return fileType;
	}
	public void setFileType(int fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileIndex() {
		return fileIndex;
	}
	public void setFileIndex(String fileIndex) {
		this.fileIndex = fileIndex;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public int getLocked() {
		return locked;
	}
	public void setLocked(int locked) {
		this.locked = locked;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public int getCrypt() {
		return crypt;
	}
	public void setCrypt(int crypt) {
		this.crypt = crypt;
	}
	public String getKeyChecksum() {
		return keyChecksum;
	}
	public void setKeyChecksum(String keyChecksum) {
		this.keyChecksum = keyChecksum;
	}
	public long getVideoLong() {
		return videoLong;
	}
	public void setVideoLong(long videoLong) {
		this.videoLong = videoLong;
	}
	public String getCoverPic() {
		return coverPic;
	}
	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}
	public String getDownloadPath() {
		return downloadPath;
	}
	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
