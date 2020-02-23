package com.hx.hkTest.common.enums;

/**
 * @ClassName: ErrorCodeEnum.java
 * 功能描述：错误码枚举
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月25日 下午6:39:27 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月25日     xiahui           v1.0.0           错误码枚举
 */
public enum ErrorCodeEnum {
	
	/***************************************萤石错误提示***********************************/
	YINGSHI_10001("10001", "萤石接口参数错误！"),
	YINGSHI_10002("10002", "accessToken异常或过期!"),
	YINGSHI_10005("10005", "appKey异常！"),
	YINGSHI_10013("10013", "无权限调用！"),
	YINGSHI_10017("10017", "appKey不存在！"),
	YINGSHI_10026("10026", "设备数量超出个人版限制，当前设备无法操作，请充值企业版！"),
	YINGSHI_10030("10030", "appkey和appSecret不匹配！"),
	YINGSHI_10031("10031", "子账户或萤石用户没有权限！"),
	YINGSHI_10032("10032", "子账户名不存在！"),
	YINGSHI_10033("10033", "子账号未设置授权策略！"),
	YINGSHI_10034("10034", "子账号已存在！"),
	YINGSHI_10035("10035", "获取子账户AccessToken异常！"),
	YINGSHI_10036("10036", "子账号被禁用！"),
	YINGSHI_10051("10051", "无权限进行抓图！"),
	YINGSHI_20002("20002", "设备不存在！"),
	YINGSHI_20006("20006", "网络异常！"),
	YINGSHI_20007("20007", "设备不在线！"),
	YINGSHI_20008("20008", "设备响应超时！"),
	YINGSHI_20010("20010", "设备验证码错误！"),
	YINGSHI_20011("20011", "设备添加失败！"),
	YINGSHI_20013("20013", "设备已被别人添加！"),
	YINGSHI_20014("20014", "deviceSerial不合法！"),
	YINGSHI_20017("20017", "设备已被自己添加！"),
	YINGSHI_20018("20018", "该用户不拥有该设备	！"),
	YINGSHI_20032("20032", "该用户下该通道不存在！"),
	YINGSHI_50000("50000", "服务器异常！"),
	YINGSHI_60012("60012", "未知错误！"),
	YINGSHI_60016("60016", "加密未开启，无需关闭！"),
	YINGSHI_60017("60017", "设备抓图失败！"),
	YINGSHI_60019("60019", "加密已开启！"),
	YINGSHI_60020("60020", "不支持该命令！"),
	YINGSHI_60022("60022", "已是当前状态！"),
	YINGSHI_60024("60024", "取消订阅操作失败！"),
	YINGSHI_60040("60040", "添加的设备不在同一局域网！"),
	YINGSHI_60041("60041", "添加的设备被其他设备关联或响应超时！"),
	YINGSHI_60042("60042", "添加的设备密码错误！"),
	YINGSHI_60043("60043", "添加的设备超出最大数量！"),
	YINGSHI_60044("60044", "添加的设备网络不可达超时！"),
	YINGSHI_60045("60045", "添加的设备的IP和其他通道的IP冲突！"),
	YINGSHI_60046("60046", "添加的设备的IP和本设备的IP冲突！"),
	YINGSHI_60047("60047", "码流类型不支持！"),
	YINGSHI_60048("60048", "带宽超出系统接入带宽！"),
	YINGSHI_60049("60049", "IP或者端口不合法！"),
	YINGSHI_60050("60050", "添加的设备版本不支持需要升级才能接入！"),
	YINGSHI_60051("60051", "添加的设备不支持接入！"),
	YINGSHI_60052("60052", "添加的设备通道号出错！"),
	YINGSHI_60053("60053", "添加的设备分辨率不支持！"),
	YINGSHI_60054("60054", "添加的设备账号被锁定！"),
	YINGSHI_60055("60055", "添加的设备取码流出错！"),
	YINGSHI_60056("60056", "删除设备失败！"),
	YINGSHI_60057("60057", "删除的设备未关联！"),
	YINGSHI_60061("60061", "账户流量已超出或未购买，限制开通！"),
	YINGSHI_60062("60062", "该通道直播已开通！"),
	YINGSHI_49999("49999", "数据异常	！");
	
	private String code;
	private String msg;

	public String getMsg() {
		return String.format("错误码:%s,%s", code, msg);
	}

	public String getCode() {
		return code;
	}

	ErrorCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public static ErrorCodeEnum getEnum(String code) {
		for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
			if (ele.getCode().equals(code)) {
				return ele;
			}
		}
		return null;
	}
}
