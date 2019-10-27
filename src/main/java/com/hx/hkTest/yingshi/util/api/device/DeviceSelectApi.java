package com.hx.hkTest.yingshi.util.api.device;

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
import com.hx.hkTest.utils.HttpClientUtil;
import com.hx.hkTest.yingshi.dto.device.select.DeviceInfoDto;
import com.hx.hkTest.yingshi.dto.device.select.DeviceListDto;

/**
 * @ClassName: DeviceSelectApi.java
 * 功能描述：序号	接口功能	描述
 *			1	获取设备列表	获取用户下的设备列表
 *		    2	获取单个设备信息	获取指定设备的信息
 *			3	获取摄像头列表	获取用户下的摄像头列表
 *			4	获取设备状态信息	根据序列号获取设备的状态信息
 *			5	获取指定设备通道信息	根据序列号获取设备的通道信息
 *			6	查询设备是否支持萤石协议	根据设备型号以及设备版本号查询设备是否支持萤石协议
 *			7	查询设备能力集	根据设备序列号查询设备能力集
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
public class DeviceSelectApi {
	
	/**
	 * 功能描述：查询用户下设备基本信息列表
	 * @author: xiahui
	 * @param pageStart：分页起始页，从0开始（非必填）
	 * @param pageSize：分页大小，默认为10，最大为50（非必填）	
	 * @return List<DeviceListDto>：基本信息列表
	 * @date: 2019年10月26日 下午5:08:37
	 */
	public static List<DeviceListDto> deviceList(String pageStart, String pageSize) {
		if(!StringUtils.isEmpty(pageSize) && Integer.valueOf(pageSize) > 50) {
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
	 * 查询用户下设备基本信息列表
	 */
	public static final String DEVICE_LIST = "https://open.ys7.com/api/lapp/device/list";

	/**
	 * 获取单个设备信息
	 */
	public static final String DEVICE_INFO = "https://open.ys7.com/api/lapp/device/info";

}
