package com.hx.hkTest.hk.util.api;

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
import com.hx.hkTest.dto.live.LiveAddressLimitedDto;
import com.hx.hkTest.dto.live.LiveVideoCloseDto;
import com.hx.hkTest.dto.live.LiveVideoListDto;
import com.hx.hkTest.dto.live.LiveVideoOpenDto;
import com.hx.hkTest.utils.HttpClientUtil;

/**
 * @ClassName: LiveApi.java
 * 功能描述：序号	接口功能	                                      描述
 *			1	获取用户下直播视频列表	          获取用户下的直播地址列表
 *		    2	获取指定有效期的直播地址	获取指定有效期的直播地址
 *			3	开通直播功能	                            批量开通直播功能
 *			4	获取直播地址	                            批量获取设备的直播地址信息
 *			5	关闭直播功能	                            批量关闭直播功能
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月26日 上午11:09:20 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月26日     xiahui           v1.0.0            直播接口
 */
public class LiveApi {
	
	/**
	 * 功能描述：该接口适用于已经开通过直播的用户，用以获取账号下的视频地址列表。
	 * @author: xiahui
	 * @param pageStart：分页起始页，从0开始（非必填）
	 * @param pageSize： 分页大小，默认为10，最大为50（非必填）
	 * @return List<LiveVideoListDto>: 视频地址列表
	 * @date: 2019年10月26日 下午2:08:21
	 */
	public static List<LiveVideoListDto> liveVideoList(String pageStart, String pageSize){
		if(!StringUtils.isEmpty(pageSize) && Integer.valueOf(pageSize) > 50) {
			throw new RuntimeException("分页大小不能超过50!");
		}
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("pageStart", pageStart);
    	params.put("pageSize", pageSize);
    	JSONObject result = HttpClientUtil.doPost(LIVE_VIDEO_LIST, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseArray(result.getString("data"), LiveVideoListDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：该接口适用于已经开通过直播的用户，用以根据设备序列号和通道号获取指定有效期的直播地址
	 * @author: xiahui
	 * @param deviceSerial：设备序列号,存在英文字母的设备序列号，字母需为大写（必填）
	 * @param channelNo：通道号，IPC设备填1（必填）
	 * @param expireTime：地址过期时间：单位秒数，最大默认62208000（即720天），最小默认300（即5分钟）。非必选参数，为空时返回对应设备和通道的永久地址（非必填）
	 * @return LiveAddressLimitedDto：直播地址
	 * @date: 2019年10月26日 下午2:19:06
	 */
	public static LiveAddressLimitedDto liveAddressLimited(String deviceSerial, String channelNo, String expireTime){
		if(StringUtils.isEmpty(deviceSerial) || StringUtils.isEmpty(channelNo)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("deviceSerial", deviceSerial);
    	params.put("channelNo", channelNo);
    	params.put("expireTime", expireTime);
    	JSONObject result = HttpClientUtil.doPost(LIVE_ADDRESS_LIMITED, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return result.getObject("data", LiveAddressLimitedDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：该接口用于根据序列号和通道号批量开通直播功能（只支持可观看视频的设备）
	 * @author: xiahui
	 * @param source：直播源，[设备序列号]:[通道号],[设备序列号]:[通道号]的形式，例如427734222:1,423344555:3，均采用英文符号（必填）
	 * @return List<LiveVideoOpenDto>：开通明细，需业务自己判断明细信息
	 * @date: 2019年10月26日 下午2:31:01
	 */
	public static List<LiveVideoOpenDto> liveVideoOpen(String source) {
		if(StringUtils.isEmpty(source)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("source", source);
    	JSONObject result = HttpClientUtil.doPost(LIVE_VIDEO_OPEN, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseArray(result.getString("data"), LiveVideoOpenDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：该接口用于根据序列号和通道号批量获取设备的直播地址信息，开通直播后才可获取直播地址 该接口获取直播地址固定不变,永久有效。
	 * @author: xiahui
	 * @param source：直播源，[设备序列号]:[通道号],[设备序列号]:[通道号]的形式，例如427734222:1,423344555:3，均采用英文符号（必填）
	 * @return List<LiveVideoOpenDto>：直播地址信息明细，需业务自己判断明细信息
	 * @date: 2019年10月26日 下午2:31:01
	 */
	public static List<LiveVideoOpenDto> liveAddressGet(String source) {
		if(StringUtils.isEmpty(source)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("source", source);
    	JSONObject result = HttpClientUtil.doPost(LIVE_ADDRESS_GET, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseArray(result.getString("data"), LiveVideoOpenDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 功能描述：该接口用于根据序列号和通道号批量关闭直播功能。
	 * @author: xiahui
	 * @param source：直播源，[设备序列号]:[通道号],[设备序列号]:[通道号]的形式，例如427734222:1,423344555:3，均采用英文符号（必填）
	 * @return List<LiveVideoCloseDto>：关闭地址信息明细，需业务自己判断明细信息
	 * @date: 2019年10月26日 下午2:31:01
	 */
	public static List<LiveVideoCloseDto> liveVideoClose(String source) {
		if(StringUtils.isEmpty(source)) {
			throw new BusinsessException(ErrorCodeEnum.YINGSHI_10001);
		}
		Map<String, String> params = new HashMap<>();
    	params.put("accessToken", YingShiCache.getAccessToken());
    	params.put("source", source);
    	JSONObject result = HttpClientUtil.doPost(LIVE_VIDEO_CLOSE, params, CharEncoding.UTF_8);
    	if(CommonConstant.SUCCESS.equals(result.getString("code"))) {
    		return JSONObject.parseArray(result.getString("data"), LiveVideoCloseDto.class);
    	}else {
    		throw new BusinsessException(ErrorCodeEnum.getEnum(result.getString("code")));
    	}
	}
	
	/**
	 * 该接口适用于已经开通过直播的用户，用以获取账号下的视频地址列表。
	 */
	private static final String LIVE_VIDEO_LIST = "https://open.ys7.com/api/lapp/live/video/list";
	
	/**
	 * 该接口适用于已经开通过直播的用户，用以根据设备序列号和通道号获取指定有效期的直播地址。
	 */
	private static final String LIVE_ADDRESS_LIMITED = "https://open.ys7.com/api/lapp/live/address/limited";
	
	/**
	 * 该接口用于根据序列号和通道号批量开通直播功能（只支持可观看视频的设备）。
	 */
	private static final String LIVE_VIDEO_OPEN = "https://open.ys7.com/api/lapp/live/video/open";
	
	/**
	 * 该接口用于根据序列号和通道号批量获取设备的直播地址信息，开通直播后才可获取直播地址 该接口获取直播地址固定不变,永久有效。
	 */
	private static final String LIVE_ADDRESS_GET = "https://open.ys7.com/api/lapp/live/address/get";
	
	/**
	 * 该接口用于根据序列号和通道号批量关闭直播功能。
	 */
	private static final String LIVE_VIDEO_CLOSE = "https://open.ys7.com/api/lapp/live/video/close";
}	
