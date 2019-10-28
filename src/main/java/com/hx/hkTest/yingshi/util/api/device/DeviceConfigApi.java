package com.hx.hkTest.yingshi.util.api.device;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.CharEncoding;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.hx.hkTest.common.cache.YingShiCache;
import com.hx.hkTest.common.constant.CommonConstant;
import com.hx.hkTest.common.enums.ErrorCodeEnum;
import com.hx.hkTest.common.exception.BusinsessException;
import com.hx.hkTest.utils.HttpClientUtil;

/**
 * @ClassName: DeviceConfigApi.java
 * 功能描述：序号	接口功能	                                      描述
 *			1	设备布撤防	                            设置设备活动检测开关状态
 *		    2	关闭设备视频加密			关闭设备视频加密开关
 *			3	开启设备视频加密			打开设备视频加密开关
 *			4	获取wifi配置提示音开关状态	获取wifi配置或者设备重启提示音开关状态
 *			5	设置wifi配置提示音开关		设置wifi配置或者设备重启提示音开关状态
 *			6	获取镜头遮蔽开关状态		获取镜头遮蔽开关状态
 *			7	设置镜头遮蔽开关			设置镜头遮蔽开关
 *			8	获取声源定位开关状态		获取声源定位开关状态
 *			9	设置声源定位开关			设置声源定位开关
 *			10	获取设备布撤防时间计划		获取设备布撤防（活动检测）时间计划
 *			11	设置布撤防时间计划			设置布撤防（活动检测）时间计划
 *			12	获取摄像机指示灯开关状态	获取摄像机指示灯开关状态
 *			13	设置摄像机指示灯开关		设置摄像机指示灯开关
 *			14	获取全天录像开关状态		获取全天录像开关状态
 *			15	设置全天录像开关			设置全天录像开关
 *			16	获取移动侦测灵敏度配置		获取智能算法配置信息
 *  		17	设置移动侦测灵敏度			设置智能算法模式
 *			18	设置告警声音模式			设置设备告警声音模式
 *			19	开启或关闭设备下线通知		开启或关闭设备下线通知
 *			20	获取设备麦克风开关状态		获取设备麦克风即声音开关状态
 *			21	设置设备麦克风开关			设置设备麦克风即声音开关
 *			22	设置设备移动跟踪开关		设置设备移动跟踪开关
 *			23	获取设备移动跟踪开关状态	获取设备移动跟踪开关状态
 *			24	设置设备osd名称			设置设备预览时osd名称
 *			25	获取智能检测开关状态		获取设备智能检测开关状态
 *			26	设置智能检测开关状态		设置智能检测开关
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月28日 下午2:25:09 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月28日     xiahui           v1.0.0          设配配置接口
 */
public class DeviceConfigApi {
	
	/**
	 * 功能描述：1.对设备布撤防状态进行修改（活动检测开关），实现布防和撤防功能
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param isDefence：具有防护能力设备布撤防状态：0-睡眠，8-在家，16-外出，普通IPC设备布撤防状态：0-撤防，1-布防（必填）
	 * @return boolean：操作是否成功
	 * @date: 2019年10月28日 下午2:28:36
	 */
	public static boolean deviceDefenceSet(String deviceSerial, String isDefence) {
		if(StringUtils.isEmpty(deviceSerial) || StringUtils.isEmpty(isDefence)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("isDefence", isDefence);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_DEFENCE_SET, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
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
		if(StringUtils.isEmpty(deviceSerial) || StringUtils.isEmpty(validateCode)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("validateCode", validateCode);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_ENCRYPT_OFF, params, CharEncoding.UTF_8);
    	String code = result.getString("code");
    	if(CommonConstant.SUCCESS.equals(code) || ErrorCodeEnum.YINGSHI_60016.code().equals(code)) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：开启设备视频加密
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @return boolean：是否成功
	 * @date: 2019年10月28日 下午2:35:43
	 */
	public static boolean deviceEncryptOn(String deviceSerial) {
		if(StringUtils.isEmpty(deviceSerial)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_ENCRYPT_ON, params, CharEncoding.UTF_8);
    	String code = result.getString("code");
    	if(CommonConstant.SUCCESS.equals(code) || ErrorCodeEnum.YINGSHI_60019.code().equals(code)) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：获取wifi配置提示音开关状态
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @return boolean：提示音开关状态是否开启
	 * @date: 2019年10月28日 下午2:35:43
	 */
	public static boolean deviceSoundSwitchStatus(String deviceSerial) {
		if(StringUtils.isEmpty(deviceSerial)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_SOUND_SWITCH_STATUS, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		// 根据data中enable属性判断状态：0-关闭，1-开启
    		return DEVICE_SOUND_SWITCH_STATUS_ON.equals(result.getJSONObject("data").getString("enable")) ? true : false;
    	}else {
    		return false;
    	}
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
		if(StringUtils.isEmpty(deviceSerial)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("enable", enable);
    	params.put("channelNo", channelNo);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_SOUND_SWITCH_SET, params, CharEncoding.UTF_8);
    	String code = result.getString("code");
    	if(CommonConstant.SUCCESS.equals(code) || ErrorCodeEnum.YINGSHI_60022.code().equals(code)) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}

	/**
	 * 功能描述：获取镜头遮蔽开关状态
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @return boolean：镜头遮蔽开关状态是否开启
	 * @date: 2019年10月28日 下午2:35:43
	 */
	public static boolean deviceSceneSwitchStatus(String deviceSerial) {
		if(StringUtils.isEmpty(deviceSerial)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_SCENE_SWITCH_STATUS, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		// 根据data中enable属性判断状态：0-关闭，1-开启
    		return DEVICE_SOUND_SWITCH_STATUS_ON.equals(result.getJSONObject("data").getString("enable")) ? true : false;
    	}else {
    		return false;
    	}
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
		if(StringUtils.isEmpty(deviceSerial)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("enable", enable);
    	params.put("channelNo", channelNo);
    	JSONObject result = HttpClientUtil.doPost(DEVICE_SCENE_SWITCH_SET, params, CharEncoding.UTF_8);
    	String code = result.getString("code");
    	if(CommonConstant.SUCCESS.equals(code) || ErrorCodeEnum.YINGSHI_60022.code().equals(code)) {
    		return true;
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 对设备布撤防状态进行修改（活动检测开关），实现布防和撤防功能。
	 */
	private static final String DEVICE_DEFENCE_SET = "https://open.ys7.com/api/lapp/device/defence/set";
	
	/**
	 * 关闭设备视频加密。
	 */
	private static final String DEVICE_ENCRYPT_OFF = "https://open.ys7.com/api/lapp/device/encrypt/off";
	
	/**
	 * 开启设备视频加密
	 */
	private static final String DEVICE_ENCRYPT_ON = "https://open.ys7.com/api/lapp/device/encrypt/on";
	
	/**
	 * 获取wifi配置提示音开关状态
	 */
	private static final String DEVICE_SOUND_SWITCH_STATUS = "https://open.ys7.com/api/lapp/device/sound/switch/status";
	
	/**
	 * 设置wifi配置提示音开关
	 */
	private static final String DEVICE_SOUND_SWITCH_SET = "https://open.ys7.com/api/lapp/device/sound/switch/set";
	
	/**
	 * 获取镜头遮蔽开关状态
	 */
	private static final String DEVICE_SCENE_SWITCH_STATUS = "https://open.ys7.com/api/lapp/device/scene/switch/status";
	
	/**
	 * 设置镜头遮蔽开关
	 */
	private static final String DEVICE_SCENE_SWITCH_SET = "https://open.ys7.com/api/lapp/device/scene/switch/set";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 获取wifi配置提示音开关状态-开启
	 */
	private static final String DEVICE_SOUND_SWITCH_STATUS_ON = "1";
}
