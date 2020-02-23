package com.hx.hkTest.hk.dto.device.select;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: DeviceCapacityDto.java
 * 功能描述：根据设备序列号查询设备能力集接口返回封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月28日 上午11:24:47 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月28日     xiahui           v1.0.0        根据设备序列号查询设备能力集
 */
public class DeviceCapacityDto {
	
	 // 该设备型号是否支持云存储 0-不支持, 1-支持
	 private String support_cloud;
	 // 是否支持智能跟踪 0-不支持, 1-支持(C6B等云台摄像机支持)
	 private String support_intelligent_track;
     // 默认0，表示老的p2p协议；配置为1，表示该版本支持新的p2p协议
	 private String support_p2p_mode;
     // 视频播放比例 16-9表示16:9分辨率,默认16-9
	 private String support_resolution;
     // 是否支持对讲: 0-不支持, 1-全双工, 3-半双工
	 private String support_talk;
	 // 视频质量
	 private List<VideoQualityCapacity> video_quality_capacity;
     // 是否支持支持带userId的新WI-FI配置方式
     private String support_wifi_userId;
     // 是否支持设备远程授权获取密码, 0-不支持, 1-支持
	 private String support_remote_auth_randcode;
     // 是否支持设备升级 0-不支持, 1-支持
	 private String support_upgrade;
     // 是否支持支持智能无
	 private String support_smart_wifi;
     // 是否支持声源定位:0-不支持, 1-支持
	 private String support_ssl;
     // 是否支持微信互联:0-不支持, 1-支持
	 private String support_weixin;
     // 是否支持关闭镜头 0-不支持, 1-支持
	 private String ptz_close_scene;
     // 是否支持预置点告警联动 0-不支持, 1-支持(C6B等云台摄像机支持)
	 private String support_preset_alarm;
     // 是否支持关联设备 0-无关联设备, 1-关联监控点或N1, 2-关联探测器或A1, 3-关联监控点探测器或R1, 4关联多通道设备
	 private String support_related_device;
     // 是否支持留言 0-不支持, 1-支持
	 private String support_message;
     // 是否支持云台预置点 0-不支持, 1-支持
	 private String ptz_preset;
     // 是否支持WI-FI:0-不支持, 1-支持netsdk配置WI-FI,2-支持带userId的新WI-FI配置方式,3-支持一键配置WI-FI
	 private String support_wifi;
     /**
      * 该设备版本是否支持云存储 0-不支持, 1-支持
	  * 需要和support_cloud组合使用:
	  * support_cloud = 1 , support_cloud_version = 1 才支持云存储
	  * support_cloud =1 ,support_cloud_version = 0,该型号的设备支持云存储,但是当前固件版本不支持云存储
      * support_cloud = 0 该型号的设备不支持云存储
      */
	 private String support_cloud_version;
     // 是否支持中心镜像0-不支持, 1-支持
	 private String ptz_center_mirror;
     // 是否支持布撤防,活动检测开关
	 private String support_defence;
     // 是否支持云台上下转动 0-不支持, 1-支持
	 private String ptz_top_bottom;
     // 是否支持全景云台功能 0-不支持, 1-支持(C6B等云台摄像机支持).如存在能力集support_fullscreen_ptz_12(序号82),则优先参考能力集
	 private String support_fullscreen_ptz;
     // 是否支持布撤防计划 0-不支持， 1-支持,2-支持新的设备计划协议
	 private String support_defenceplan;
     // 是否支持存储格式化 0-不支持, 1-支持
	 private String support_disk;
     // 是否支持告警声音配置 0-不支持, 1-支持
	 private String support_alarm_voice;
     // 是否支持云台左右转动 0-不支持, 1-支持
	 private String ptz_left_right;
     // 是否支持修改设备加密密码: 0-不支持, 1-支持
	 private String support_modify_pwd;
     // 是否支持封面抓图: 0-不支持, 1-支持
	 private String support_capture;
     // 是否支持隐私保护 0-不支持, 1-支持
	 private String support_privacy;
     // 是否支持视频图像加密 0-不支持, 1-支持
	 private String support_encrypt;
     // 是否支持设备自动上下线 0-不支持, 1-支持
	 private String support_auto_offline;
	 
	 
	 
	 public String getSupport_cloud() {
		return support_cloud;
	}

	public void setSupport_cloud(String support_cloud) {
		this.support_cloud = support_cloud;
	}

	public String getSupport_intelligent_track() {
		return support_intelligent_track;
	}

	public void setSupport_intelligent_track(String support_intelligent_track) {
		this.support_intelligent_track = support_intelligent_track;
	}

	public String getSupport_p2p_mode() {
		return support_p2p_mode;
	}

	public void setSupport_p2p_mode(String support_p2p_mode) {
		this.support_p2p_mode = support_p2p_mode;
	}

	public String getSupport_resolution() {
		return support_resolution;
	}

	public void setSupport_resolution(String support_resolution) {
		this.support_resolution = support_resolution;
	}

	public String getSupport_talk() {
		return support_talk;
	}

	public void setSupport_talk(String support_talk) {
		this.support_talk = support_talk;
	}

	public String getSupport_wifi_userId() {
		return support_wifi_userId;
	}

	public void setSupport_wifi_userId(String support_wifi_userId) {
		this.support_wifi_userId = support_wifi_userId;
	}

	public String getSupport_remote_auth_randcode() {
		return support_remote_auth_randcode;
	}

	public void setSupport_remote_auth_randcode(String support_remote_auth_randcode) {
		this.support_remote_auth_randcode = support_remote_auth_randcode;
	}

	public String getSupport_upgrade() {
		return support_upgrade;
	}

	public void setSupport_upgrade(String support_upgrade) {
		this.support_upgrade = support_upgrade;
	}

	public String getSupport_smart_wifi() {
		return support_smart_wifi;
	}

	public void setSupport_smart_wifi(String support_smart_wifi) {
		this.support_smart_wifi = support_smart_wifi;
	}

	public String getSupport_ssl() {
		return support_ssl;
	}

	public void setSupport_ssl(String support_ssl) {
		this.support_ssl = support_ssl;
	}

	public String getSupport_weixin() {
		return support_weixin;
	}

	public void setSupport_weixin(String support_weixin) {
		this.support_weixin = support_weixin;
	}

	public String getPtz_close_scene() {
		return ptz_close_scene;
	}

	public void setPtz_close_scene(String ptz_close_scene) {
		this.ptz_close_scene = ptz_close_scene;
	}

	public String getSupport_preset_alarm() {
		return support_preset_alarm;
	}

	public void setSupport_preset_alarm(String support_preset_alarm) {
		this.support_preset_alarm = support_preset_alarm;
	}

	public List<VideoQualityCapacity> getVideo_quality_capacity() {
		return video_quality_capacity;
	}

	public void setVideo_quality_capacity(List<VideoQualityCapacity> video_quality_capacity) {
		this.video_quality_capacity = video_quality_capacity;
	}

	public String getSupport_related_device() {
		return support_related_device;
	}

	public void setSupport_related_device(String support_related_device) {
		this.support_related_device = support_related_device;
	}

	public String getSupport_message() {
		return support_message;
	}

	public void setSupport_message(String support_message) {
		this.support_message = support_message;
	}

	public String getPtz_preset() {
		return ptz_preset;
	}

	public void setPtz_preset(String ptz_preset) {
		this.ptz_preset = ptz_preset;
	}

	public String getSupport_wifi() {
		return support_wifi;
	}

	public void setSupport_wifi(String support_wifi) {
		this.support_wifi = support_wifi;
	}

	public String getSupport_cloud_version() {
		return support_cloud_version;
	}

	public void setSupport_cloud_version(String support_cloud_version) {
		this.support_cloud_version = support_cloud_version;
	}

	public String getPtz_center_mirror() {
		return ptz_center_mirror;
	}

	public void setPtz_center_mirror(String ptz_center_mirror) {
		this.ptz_center_mirror = ptz_center_mirror;
	}

	public String getSupport_defence() {
		return support_defence;
	}

	public void setSupport_defence(String support_defence) {
		this.support_defence = support_defence;
	}

	public String getPtz_top_bottom() {
		return ptz_top_bottom;
	}

	public void setPtz_top_bottom(String ptz_top_bottom) {
		this.ptz_top_bottom = ptz_top_bottom;
	}

	public String getSupport_fullscreen_ptz() {
		return support_fullscreen_ptz;
	}

	public void setSupport_fullscreen_ptz(String support_fullscreen_ptz) {
		this.support_fullscreen_ptz = support_fullscreen_ptz;
	}

	public String getSupport_defenceplan() {
		return support_defenceplan;
	}

	public void setSupport_defenceplan(String support_defenceplan) {
		this.support_defenceplan = support_defenceplan;
	}

	public String getSupport_disk() {
		return support_disk;
	}

	public void setSupport_disk(String support_disk) {
		this.support_disk = support_disk;
	}

	public String getSupport_alarm_voice() {
		return support_alarm_voice;
	}

	public void setSupport_alarm_voice(String support_alarm_voice) {
		this.support_alarm_voice = support_alarm_voice;
	}

	public String getPtz_left_right() {
		return ptz_left_right;
	}

	public void setPtz_left_right(String ptz_left_right) {
		this.ptz_left_right = ptz_left_right;
	}

	public String getSupport_modify_pwd() {
		return support_modify_pwd;
	}

	public void setSupport_modify_pwd(String support_modify_pwd) {
		this.support_modify_pwd = support_modify_pwd;
	}

	public String getSupport_capture() {
		return support_capture;
	}

	public void setSupport_capture(String support_capture) {
		this.support_capture = support_capture;
	}

	public String getSupport_privacy() {
		return support_privacy;
	}

	public void setSupport_privacy(String support_privacy) {
		this.support_privacy = support_privacy;
	}

	public String getSupport_encrypt() {
		return support_encrypt;
	}

	public void setSupport_encrypt(String support_encrypt) {
		this.support_encrypt = support_encrypt;
	}

	public String getSupport_auto_offline() {
		return support_auto_offline;
	}

	public void setSupport_auto_offline(String support_auto_offline) {
		this.support_auto_offline = support_auto_offline;
	}

	@Override
	 public String toString() {
		 return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	 }
	 
	 class VideoQualityCapacity {
		private String streamType;
		private String videoLevel;
		private String resolution;
		private String videoBitRate;
		private String maxBitRate;
		public String getStreamType() {
			return streamType;
		}
		public void setStreamType(String streamType) {
			this.streamType = streamType;
		}
		public String getVideoLevel() {
			return videoLevel;
		}
		public void setVideoLevel(String videoLevel) {
			this.videoLevel = videoLevel;
		}
		public String getResolution() {
			return resolution;
		}
		public void setResolution(String resolution) {
			this.resolution = resolution;
		}
		public String getVideoBitRate() {
			return videoBitRate;
		}
		public void setVideoBitRate(String videoBitRate) {
			this.videoBitRate = videoBitRate;
		}
		public String getMaxBitRate() {
			return maxBitRate;
		}
		public void setMaxBitRate(String maxBitRate) {
			this.maxBitRate = maxBitRate;
		}
		
		@Override
		public String toString() {
		    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
		}
	 }
}
