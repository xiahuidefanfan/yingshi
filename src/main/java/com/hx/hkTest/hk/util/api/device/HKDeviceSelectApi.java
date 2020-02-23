package com.hx.hkTest.hk.util.api.device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.CharEncoding;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.hx.hkTest.common.cache.YingShiCache;
import com.hx.hkTest.common.constant.CommonConstant;
import com.hx.hkTest.common.enums.ErrorCodeEnum;
import com.hx.hkTest.common.exception.BusinsessException;
import com.hx.hkTest.hk.dto.device.select.CameraListDto;
import com.hx.hkTest.hk.dto.device.select.DeviceCameraListDto;
import com.hx.hkTest.hk.dto.device.select.DeviceCapacityDto;
import com.hx.hkTest.hk.dto.device.select.DeviceInfoDto;
import com.hx.hkTest.hk.dto.device.select.DeviceListDto;
import com.hx.hkTest.hk.dto.device.select.DeviceSupportEzvizDto;
import com.hx.hkTest.hk.dto.device.select.StatusGetDto;
import com.hx.hkTest.hk.dto.device.select.VideoByTimeDto;
import com.hx.hkTest.utils.HttpClientUtil;

/**
 * @ClassName: HKDeviceSelectApi.java
 * 功能描述：  序号	接口功能	                                    描述
 *			1	获取设备列表	                        获取用户下的设备列表
 *		    2	获取单个设备信息	                        获取指定设备的信息
 *			3	获取摄像头列表	                        获取用户下的摄像头列表
 *			4	获取设备状态信息	                        根据序列号获取设备的状态信息
 *			5	获取指定设备通道信息	            根据序列号获取设备的通道信息
 *			6	查询设备是否支持萤石协议	根据设备型号以及设备版本号查询设备是否支持萤石协议
 *			7	查询设备能力集	                        根据设备序列号查询设备能力集
 *			8	根据时间获取存储文件信息	该接口用于根据时间获取存储文件信息
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月26日 下午4:56:08 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月26日     xiahui           v1.0.0            设备查询
 */
public class HKDeviceSelectApi {
	
	/**
	 * 功能描述：查询用户下设备基本信息列表
	 * @author: xiahui
	 * @param pageStart：分页起始页，从0开始（非必填）
	 * @param pageSize：分页大小，默认为10，最大为50（非必填）	
	 * @return List<DeviceListDto>：基本信息列表
	 * @date: 2019年10月26日 下午5:08:37
	 */
	public static List<DeviceListDto> deviceList(String pageStart, String pageSize) {
		if(!StringUtils.isEmpty(pageStart) && Integer.valueOf(pageSize) > 50) {
			throw new RuntimeException("分页大小不能超过50!");
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("pageStart", pageStart);
    	params.put("pageSize", pageSize);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_LIST, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseArray(result.getString("data"), DeviceListDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：查询用户下指定设备的基本信息
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @return DeviceInfoDto：设备的基本信息
	 * @date: 2019年10月26日 下午5:18:41
	 */
	public static DeviceInfoDto deviceInfo(String deviceSerial){
		if(StringUtils.isEmpty(deviceSerial)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_INFO, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseObject(result.getString("data"), DeviceInfoDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
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
		if(!StringUtils.isEmpty(pageStart) && Integer.valueOf(pageSize) > 50) {
			throw new RuntimeException("分页大小不能超过50!");
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("pageStart", pageStart);
    	params.put("pageSize", pageSize);
    	JSONObject result = HttpClientUtil.doPost(CAMERA_LIST, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseArray(result.getString("data"), CameraListDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
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
		if(!StringUtils.isEmpty(deviceSerial) && Integer.valueOf(channel) > 50) {
			throw new RuntimeException("分页大小不能超过50!");
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("channel", channel);
    	JSONObject result = HttpClientUtil.doPost(STATUS_GET, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseObject(result.getString("data"), StatusGetDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：获取指定设备的通道信息
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）	
	 * @return DeviceCameraListDto：通道信息
	 * @date: 2019年10月28日 上午10:26:37
	 */
	public static DeviceCameraListDto deviceCameraList(String deviceSerial) {
		if(StringUtils.isEmpty(deviceSerial)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_CAMERA_LIST, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseObject(result.getString("data"), DeviceCameraListDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
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
		if(StringUtils.isEmpty(appKey) || StringUtils.isEmpty(model) || StringUtils.isEmpty(version)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("appKey", appKey);
    	params.put("model", model);
    	params.put("version", version);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_SUPPORT_EZVIZ, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseArray(result.getString("data"), DeviceSupportEzvizDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：根据设备序列号查询设备能力集
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）	
	 * @return DeviceCapacityDto：设备能力集
	 * @date: 2019年10月28日 上午10:26:37
	 */
	public static DeviceCapacityDto deviceCapacity(String deviceSerial) {
		if(StringUtils.isEmpty(deviceSerial)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_CAPACITY, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseObject(result.getString("data"), DeviceCapacityDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
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
		if(StringUtils.isEmpty(deviceSerial)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("channelNo", channelNo);
    	params.put("startTime", startTime);
    	params.put("endTime", endTime);
    	params.put("recType", recType);
    	JSONObject result = HttpClientUtil.doPost(VIDEO_BY_TIME, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseArray(result.getString("data"), VideoByTimeDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}

	/**
	 * 查询用户下设备基本信息列表
	 */
	private static final String DEVICE_LIST = "https://open.ys7.com/api/lapp/device/list";

	/**
	 * 获取单个设备信息
	 */
	private static final String DEVICE_INFO = "https://open.ys7.com/api/lapp/device/info";
	
	/**
	 * 获取监控点列表
	 */
	private static final String CAMERA_LIST = "https://open.ys7.com/api/lapp/camera/list";
	
	/**
	 * 该接口用于根据序列号通道号获取设备状态信息
	 */
	private static final String STATUS_GET = "https://open.ys7.com/api/lapp/device/status/get";
	
	/**
	 * 获取指定设备的通道信息
	 */
	private static final String DEVICE_CAMERA_LIST = "https://open.ys7.com/api/lapp/device/camera/list";
	
	/**
	 * 查询设备是否支持萤石协议
	 */
	private static final String DEVICE_SUPPORT_EZVIZ = "https://open.ys7.com/api/lapp/device/support/ezviz";
	
	/**
	 * 根据设备序列号查询设备能力集
	 */
	private static final String DEVICE_CAPACITY = "https://open.ys7.com/api/lapp/device/capacity";
	
	/**
	 * 该接口用于根据时间获取存储文件信息
	 */
	private static final String VIDEO_BY_TIME = "https://open.ys7.com/api/lapp/video/by/time";
}
