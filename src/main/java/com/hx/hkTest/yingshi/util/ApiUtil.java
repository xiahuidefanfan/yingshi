package com.hx.hkTest.yingshi.util;

import java.util.List;

import com.hx.hkTest.yingshi.dto.device.select.CameraListDto;
import com.hx.hkTest.yingshi.dto.device.select.DeviceCameraListDto;
import com.hx.hkTest.yingshi.dto.device.select.DeviceCapacityDto;
import com.hx.hkTest.yingshi.dto.device.select.DeviceInfoDto;
import com.hx.hkTest.yingshi.dto.device.select.DeviceListDto;
import com.hx.hkTest.yingshi.dto.device.select.DeviceSupportEzvizDto;
import com.hx.hkTest.yingshi.dto.device.select.StatusGetDto;
import com.hx.hkTest.yingshi.dto.device.select.VideoByTimeDto;
import com.hx.hkTest.yingshi.dto.live.LiveAddressLimitedDto;
import com.hx.hkTest.yingshi.dto.live.LiveVideoCloseDto;
import com.hx.hkTest.yingshi.dto.live.LiveVideoListDto;
import com.hx.hkTest.yingshi.dto.live.LiveVideoOpenDto;
import com.hx.hkTest.yingshi.util.api.AccessTokenApi;
import com.hx.hkTest.yingshi.util.api.LiveApi;
import com.hx.hkTest.yingshi.util.api.device.DeviceConfigApi;
import com.hx.hkTest.yingshi.util.api.device.DeviceManageApi;
import com.hx.hkTest.yingshi.util.api.device.DeviceSelectApi;

/**
 * @ClassName: ApiUtil.java
 * 功能描述：萤石api工具类
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月25日 下午6:52:26 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月25日     xiahui           v1.0.0          萤石api工具类
 */
public class ApiUtil {
	
	/**
	 * 功能描述：根据appKey和secret获取accessToken
	 * @author: xiahui
	 * @date: 2019年10月25日 下午6:52:13
	 */
	public static String getAccessToken() {
		return AccessTokenApi.getToken();
	}
	
	/**
	 * 功能描述：该接口适用于已经开通过直播的用户，用以获取账号下的视频地址列表。
	 * @author: xiahui
	 * @param @param pageStart：分页起始页，从0开始
	 * @param @param pageSize： 分页大小，默认为10，最大为50
	 * @date: 2019年10月26日 下午2:08:21
	 */
	public static List<LiveVideoListDto> liveVideoList(String pageStart, String pageSize){
		return LiveApi.liveVideoList(pageStart, pageSize);
	}
	
	/**
	 * 功能描述：该接口适用于已经开通过直播的用户，用以根据设备序列号和通道号获取指定有效期的直播地址
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param channelNo：通道号，IPC设备填1（必填）
	 * @param expireTime：地址过期时间：单位秒数，最大默认62208000（即720天），最小默认300（即5分钟）。非必选参数，为空时返回对应设备和通道的永久地址（非必填）
	 * @return VideoDto：直播地址
	 * @date: 2019年10月26日 下午2:19:06
	 */
	public static LiveAddressLimitedDto liveAddressLimited(String deviceSerial, String channelNo, String expireTime){
		return LiveApi.liveAddressLimited(deviceSerial, channelNo, expireTime);
	}
	
	/**
	 * 功能描述：该接口用于根据序列号和通道号批量开通直播功能（只支持可观看视频的设备）
	 * @author: xiahui
	 * @param source：直播源，[设备序列号]:[通道号],[设备序列号]:[通道号]的形式，例如427734222:1,423344555:3，均采用英文符号（必填）
	 * @return boolean：是否成功
	 * @date: 2019年10月26日 下午2:31:01
	 */
	public static List<LiveVideoOpenDto> liveVideoOpen(String source) {
		return LiveApi.liveVideoOpen(source);
	}
	
	/**
	 * 功能描述：该接口用于根据序列号和通道号批量获取设备的直播地址信息，开通直播后才可获取直播地址 该接口获取直播地址固定不变,永久有效。
	 * @author: xiahui
	 * @param source：直播源，[设备序列号]:[通道号],[设备序列号]:[通道号]的形式，例如427734222:1,423344555:3，均采用英文符号（必填）
	 * @return boolean：是否成功
	 * @date: 2019年10月26日 下午2:31:01
	 */
	public static List<LiveVideoOpenDto> liveAddressGet(String source) {
		return LiveApi.liveAddressGet(source);
	}
	
	/**
	 * 功能描述：该接口用于根据序列号和通道号批量关闭直播功能。
	 * @author: xiahui
	 * @param source：直播源，[设备序列号]:[通道号],[设备序列号]:[通道号]的形式，例如427734222:1,423344555:3，均采用英文符号（必填）
	 * @return List<LiveVideoCloseDto>：关闭地址信息明细，需业务自己判断明细信息
	 * @date: 2019年10月26日 下午2:31:01
	 */
	public static List<LiveVideoCloseDto> liveVideoClose(String source) {
		return LiveApi.liveVideoClose(source);
	}
	
	/**
	 * 功能描述：添加设备到账号下
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param validateCode：设备验证码，设备机身上的六位大写字母（必填）
	 * @return boolean：是否添加成功
	 * @date: 2019年10月26日 下午3:33:13
	 */
	public static boolean deviceAdd(String deviceSerial, String validateCode) {
		return DeviceManageApi.deviceAdd(deviceSerial, validateCode);
	}
	
	/**
	 * 功能描述：删除设备
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @return boolean：是否删除成功
	 * @date: 2019年10月26日 下午3:33:13
	 */
	public static boolean deviceDelete(String deviceSerial) {
		return DeviceManageApi.deviceDelete(deviceSerial);
	}
	
	/**
	 * 功能描述：抓拍设备当前画面，该接口仅适用于IPC或者关联IPC的DVR设备，该接口并非预览时的截图功能。海康型号设备可能不支持萤石协议抓拍功能，
	 * 使用该接口可能返回不支持或者超时。注意：设备抓图能力有限，请勿频繁调用，建议每个摄像头调用的间隔4s以上。
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param channelNo：通道号，IPC设备填写1（必填）
	 * @return boolean：是否设置成功
	 * @date: 2019年10月26日 下午3:51:48
	 */
	public static boolean deviceCapture(String deviceSerial, String channelNo) {
		return DeviceManageApi.deviceCapture(deviceSerial, channelNo);
	}
	
	/**
	 * 功能描述：NVR设备关联IPC
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param ipcSerial：待关联的IPC设备序列号（必填）
	 * @param channelNo：非必选参数，不为空表示给指定通道关联IPC，为空表示给通道1关联IPC（非必填）
	 * @param validateCode：非必选参数，IPC设备验证码，默认为空（非必填）
	 * @return boolean：是否关联成功
	 * @date: 2019年10月26日 下午4:01:35
	 */
	public static boolean deviceIpcAdd(String deviceSerial, String ipcSerial, String channelNo, String validateCode) {
		return DeviceManageApi.deviceIpcAdd(deviceSerial, ipcSerial, channelNo, validateCode);
	}
	
	/**
	 * 功能描述：NVR设备删除IPC
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param ipcSerial：待关联的IPC设备序列号（必填）
	 * @param channelNo：非必选参数，不为空表示给指定通道关联IPC，为空表示给通道1关联IPC（非必填）
	 * @return boolean：是否解除关联成功
	 * @date: 2019年10月26日 下午4:01:35
	 */
	public static boolean deviceIpcDelete(String deviceSerial, String ipcSerial, String channelNo) {
		return DeviceManageApi.deviceIpcDelete(deviceSerial, ipcSerial, channelNo);
	}
	
	/**
	 * 功能描述：修改设备视频加密密码
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写
	 * @param oldPassword：设备旧的加密密码	
	 * @param newPassword：设备新的加密密码，长度大超过12字节
	 * @return boolean：是否修改成功
	 * @date: 2019年10月26日 下午4:18:14
	 */
	public static boolean devicePasswordUpdate(String deviceSerial, String oldPassword, String newPassword) {
		return DeviceManageApi.devicePasswordUpdate(deviceSerial, oldPassword, newPassword);
	}
	
	/**
	 * 功能描述：生成设备配网二维码
	 * @author: xiahui
	 * @param ssid：路由器SSID，即WIFI名称，建议不要设置中文名称	
	 * @param password：WIFI密码
	 * @return String：成的二维码二进制数据
	 * @date: 2019年10月26日 下午4:24:30
	 */
	public static String deviceWifiQrcode(String ssid, String password) {
		return DeviceManageApi.deviceWifiQrcode(ssid, password);
	}
	
	/**
	 * 功能描述：修改通道名称
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param name：通道名称，长度不大于50字节，不能包含特殊字符（必填）
	 * @param channelNo：非必选参数，不为空表示修改指定通道名称，为空表示修改通道1名称（非必填）
	 * @return boolean：是否修改成功
	 * @date: 2019年10月26日 下午4:39:00
	 */
	public static boolean cameraNameUpdate(String deviceSerial, String name, String channelNo) {
		return DeviceManageApi.cameraNameUpdate(deviceSerial, name, channelNo);
	}
	
	/**
	 * 功能描述：查询用户下设备基本信息列表
	 * @author: xiahui
	 * @param pageStart：分页起始页，从0开始
	 * @param pageSize：分页大小，默认为10，最大为50	
	 * @return List<DeviceListDto>：基本信息列表
	 * @date: 2019年10月26日 下午5:08:37
	 */
	public static List<DeviceListDto> deviceList(String pageStart, String pageSize) {
		return DeviceSelectApi.deviceList(pageStart, pageSize);
	}
	
	/**
	 * 功能描述：查询用户下指定设备的基本信息
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @return DeviceInfoDto：设备的基本信息
	 * @date: 2019年10月26日 下午5:18:41
	 */
	public static DeviceInfoDto deviceInfo(String deviceSerial){
		return DeviceSelectApi.deviceInfo(deviceSerial);
	}
	
	/**
	 * 功能描述：获取监控点列表
	 * @author: xiahui
	 * @param pageStart：分页起始页，从0开始（非必填）
	 * @param pageSize：分页大小，默认为10，最大为50（非必填）	
	 * @return List<CameraListDto>：监控点列表
	 * @date: 2019年10月28日 上午10:09:42
	 */
	public static List<CameraListDto> cameraList(String pageStart, String pageSize) {
		return DeviceSelectApi.cameraList(pageStart, pageSize);
	}
	
	/**
	 * 功能描述：该接口用于根据序列号通道号获取设备状态信息
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param channel：通道号,默认为1（非必填）	
	 * @return StatusGetDto：设备状态信息
	 * @date: 2019年10月28日 上午10:09:42
	 */
	public static StatusGetDto statusGet(String deviceSerial, String channel) {
		return DeviceSelectApi.statusGet(deviceSerial, channel);
	}
	
	/**
	 * 功能描述：获取指定设备的通道信息
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写	
	 * @return DeviceCameraListDto：通道信息
	 * @date: 2019年10月28日 上午10:26:37
	 */
	public static DeviceCameraListDto deviceCameraList(String deviceSerial) {
		return DeviceSelectApi.deviceCameraList(deviceSerial);
	}
	
	/**
	 * 功能描述：查询设备是否支持萤石协议
	 * @author: xiahui
	 * @param appKey：用户appKey（必填）
	 * @param model：设备型号（必填）
	 * @param version：设备版本号	（必填）
	 * @return boolean：是否支持萤石协议
	 * @date: 2019年10月28日 上午10:41:18
	 */
	public static List<DeviceSupportEzvizDto> deviceSupportEzviz(String appKey, String model, String version) {
		return DeviceSelectApi.deviceSupportEzviz(appKey, model, version);
	}
	
	/**
	 * 功能描述：根据设备序列号查询设备能力集
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）	
	 * @return DeviceCapacityDto：设备能力集
	 * @date: 2019年10月28日 上午10:26:37
	 */
	public static DeviceCapacityDto deviceCapacity(String deviceSerial) {
		return DeviceSelectApi.deviceCapacity(deviceSerial);
	}


	/**
	 * 功能描述：该接口用于根据时间获取存储文件信息
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param channelNo：通道号，非必选，默认为1（非必填）
	 * @param startTime：起始时间，时间格式为：1378345128000。非必选，默认为当天0点（非必填）
	 * @param endTime：结束时间，时间格式为：1378345128000。非必选，默认为当前时间（非必填）
	 * @param recType：回放源，0-系统自动选择，1-云存储，2-本地录像。非必选，默认为0（非必填）
	 * @return List<VideoByTimeDto>：存储文件信息
	 * @date: 2019年10月28日 下午2:06:51
	 */
	public static List<VideoByTimeDto> videoByTime(String deviceSerial, String channelNo, String startTime,
			String endTime, String recType) {
		return DeviceSelectApi.videoByTime(deviceSerial, channelNo, startTime, endTime, recType);
	}
	
	/**
	 * 功能描述：1.对设备布撤防状态进行修改（活动检测开关），实现布防和撤防功能
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param isDefence：具有防护能力设备布撤防状态：0-睡眠，8-在家，16-外出，普通IPC设备布撤防状态：0-撤防，1-布防（必填）
	 * @return boolean：操作是否成功
	 * @date: 2019年10月28日 下午2:28:36
	 */
	public static boolean deviceDefenceSet(String deviceSerial, String isDefence) {
		return DeviceConfigApi.deviceDefenceSet(deviceSerial, isDefence);
	}
	
	/**
	 * 功能描述：关闭设备视频加密
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param validateCode：设备验证码，设备机身上的六位大写字母（必填）
	 * @return boolean：是否成功
	 * @date: 2019年10月28日 下午2:35:43
	 */
	public static boolean deviceEncryptOff(String deviceSerial, String validateCode) {
		return DeviceConfigApi.deviceEncryptOff(deviceSerial, validateCode);
	}
	
	/**
	 * 功能描述：开启设备视频加密
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @return boolean：是否成功
	 * @date: 2019年10月28日 下午2:35:43
	 */
	public static boolean deviceEncryptOff(String deviceSerial) {
		return DeviceConfigApi.deviceEncryptOn(deviceSerial);
	}
	
	/**
	 * 功能描述：获取wifi配置提示音开关状态
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @return boolean：提示音开关状态是否开启
	 * @date: 2019年10月28日 下午2:35:43
	 */
	public static boolean deviceSoundSwitchStatus(String deviceSerial) {
		return DeviceConfigApi.deviceSoundSwitchStatus(deviceSerial);
	}
	
	/**
	 * 功能描述：设置wifi配置提示音开关
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param enable：状态：0-关闭，1-开启
	 * @param channelNo：通道号，不传表示设备本身
	 * @return boolean：操作是否成功
	 * @date: 2019年10月28日 下午2:48:31
	 */
	public static boolean deviceSoundSwitchSet(String deviceSerial, String enable, String channelNo) {
		return DeviceConfigApi.deviceSoundSwitchSet(deviceSerial, enable, channelNo);
	}
	
	/**
	 * 功能描述：获取镜头遮蔽开关状态
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @return boolean：镜头遮蔽开关状态是否开启
	 * @date: 2019年10月28日 下午2:35:43
	 */
	public static boolean deviceSceneSwitchStatus(String deviceSerial) {
		return DeviceConfigApi.deviceSceneSwitchStatus(deviceSerial);
	}
	
	/**
	 * 功能描述：设置镜头遮蔽开关
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param enable：状态：0-关闭，1-开启
	 * @param channelNo：通道号，不传表示设备本身
	 * @return boolean：操作是否成功
	 * @date: 2019年10月28日 下午2:48:31
	 */
	public static boolean deviceSceneSwitchSet(String deviceSerial, String enable, String channelNo) {
		return DeviceConfigApi.deviceSceneSwitchSet(deviceSerial, enable, channelNo);
	}
}
