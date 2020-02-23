package com.hx.hkTest.hk.util.api.device;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.codec.CharEncoding;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.hx.hkTest.common.cache.YingShiCache;
import com.hx.hkTest.common.constant.CommonConstant;
import com.hx.hkTest.common.enums.ErrorCodeEnum;
import com.hx.hkTest.common.exception.BusinsessException;
import com.hx.hkTest.utils.HttpClientUtil;

/**
 * @ClassName: HKDeviceManageApi.java
 * 功能描述：  序号	接口功能	                        描述
 *			1	添加设备	                        添加设备到账号下
 *			2	删除设备	                        删除账号下指定设备
 *			3	修改设备名称	            修改设备名称
 *			4	设备抓拍图片	            抓拍设备的当前画面
 *			5	NVR设备关联IPC	    NVR设备关联IPC
 *			6	NVR设备删除IPC	    NVR设备删除IPC
 *			7	修改设备视频加密密码	修改设备视频加密密码
 *			8	生成设备配网二维码	生成设备扫描配网二维码二进制数据
 *			9	修改通道名称	            修改通道名称
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月26日 下午3:28:43 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月26日     xiahui           v1.0.0           设备管理接口
 */
public class HKDeviceManageApi {
	
	/**
	 * 功能描述：添加设备到账号下
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param validateCode：设备验证码，设备机身上的六位大写字母（必填）
	 * @return boolean：是否添加成功
	 * @date: 2019年10月26日 下午3:33:13
	 */
	public static boolean deviceAdd(String deviceSerial, String validateCode) {
		if(StringUtils.isEmpty(deviceSerial) || StringUtils.isEmpty(validateCode)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("validateCode", validateCode);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_ADD, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：删除设备
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @return boolean：是否删除成功
	 * @date: 2019年10月26日 下午3:33:13
	 */
	public static boolean deviceDelete(String deviceSerial) {
		if(StringUtils.isEmpty(deviceSerial)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_DELETE, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：修改设备名称
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @return deviceName：设备名称，长度不大于50字节，不能包含特殊字符（必填）
	 * @return boolean：是否修改成功
	 * @date: 2019年10月26日 下午3:33:13
	 */
	public static boolean deviceNameUpdate(String deviceSerial, String deviceName) {
		if(StringUtils.isEmpty(deviceSerial) || StringUtils.isEmpty(deviceName)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}else if(deviceName.length() > 50 || Pattern.compile(CommonConstant.SPECIAL_CHARACTER_REGEX).matcher(deviceName).find()) {
			throw new RuntimeException("设备名称，长度不大于50字节，不能包含特殊字符!");
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("deviceName", deviceName);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_NAME_UPDATE, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
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
		if(StringUtils.isEmpty(deviceSerial) || StringUtils.isEmpty(channelNo)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("channelNo", channelNo);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_CAPTURE, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
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
		if(StringUtils.isEmpty(deviceSerial) || StringUtils.isEmpty(ipcSerial)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("ipcSerial", ipcSerial);
    	params.put("channelNo", channelNo);
    	params.put("validateCode", validateCode);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_IPC_ADD, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
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
		if(StringUtils.isEmpty(deviceSerial) || StringUtils.isEmpty(ipcSerial)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("ipcSerial", ipcSerial);
    	params.put("channelNo", channelNo);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_IPC_DELETE, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：修改设备视频加密密码
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param oldPassword：设备旧的加密密码（必填）	
	 * @param newPassword：设备新的加密密码，长度大超过12字节（必填）
	 * @return boolean：是否修改成功
	 * @date: 2019年10月26日 下午4:18:14
	 */
	public static boolean devicePasswordUpdate(String deviceSerial, String oldPassword, String newPassword) {
		if(StringUtils.isEmpty(deviceSerial) || StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}else if(newPassword.length() < 12) {
			throw new RuntimeException("设备新的加密密码长度不能少于12个字节!");
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("oldPassword", oldPassword);
    	params.put("newPassword", newPassword);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_PASSWORD_UPDATE, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：生成设备配网二维码
	 * @author: xiahui
	 * @param ssid：路由器SSID，即WIFI名称，建议不要设置中文名称（必填）	
	 * @param password：WIFI密码（必填）
	 * @return String：成的二维码二进制数据
	 * @date: 2019年10月26日 下午4:24:30
	 */
	public static String deviceWifiQrcode(String ssid, String password) {
		if(StringUtils.isEmpty(ssid) || StringUtils.isEmpty(password)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("ssid", ssid);
    	params.put("password", password);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_WIFI_QRCODE, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return result.getJSONObject("data").getString("imageData");
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
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
		if(StringUtils.isEmpty(deviceSerial) || StringUtils.isEmpty(name)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}else if(name.length() > 50 || Pattern.compile(CommonConstant.SPECIAL_CHARACTER_REGEX).matcher(name).find()) {
			throw new RuntimeException("通道名称，长度不大于50字节，不能包含特殊字符!");
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("name", name);
    	params.put("channelNo", channelNo);
    	JSONObject result = HttpClientUtil.doPost(CAMERA_NAME_UPDATE, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 添加设备到账号下
	 */
	private static final String DEVICE_ADD = "https://open.ys7.com/api/lapp/device/add"; 
	
	/**
	 * 删除设备
	 */
	private static final String DEVICE_DELETE = "https://open.ys7.com/api/lapp/device/delete"; 
	
	/**
	 * 修改设备名称
	 */
	private static final String DEVICE_NAME_UPDATE = "https://open.ys7.com/api/lapp/device/name/update"; 
	
	/**
	 * 设备抓拍图片
	 */
	private static final String DEVICE_CAPTURE = "https://open.ys7.com/api/lapp/device/capture";
	
	/**
	 * NVR设备关联IPC
	 */
	private static final String DEVICE_IPC_ADD = "https://open.ys7.com/api/lapp/device/ipc/add";
	
	/**
	 * NVR设备删除IPC
	 */
	private static final String DEVICE_IPC_DELETE = "https://open.ys7.com/api/lapp/device/ipc/delete";
	
	/**
	 * 修改设备视频加密密码
	 */
	private static final String DEVICE_PASSWORD_UPDATE = "https://open.ys7.com/api/lapp/device/password/update";
	
	/**
	 * 该接口用于生成设备扫描配网二维码二进制数据，需要自行转换成图片（300x300像素大小）
	 */
	private static final String DEVICE_WIFI_QRCODE = "https://open.ys7.com/api/lapp/device/wifi/qrcode";
	
	/**
	 * 修改通道名称
	 */
	private static final String CAMERA_NAME_UPDATE = "https://open.ys7.com/api/lapp/camera/name/update";

}
