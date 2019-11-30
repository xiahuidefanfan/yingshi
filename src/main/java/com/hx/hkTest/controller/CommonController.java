package com.hx.hkTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hx.hkTest.common.support.ResponseData;

@Controller
@RequestMapping("/dingtalk/web/query/")
public class CommonController {
	
	@RequestMapping("/common/getTrialFeatures.json")
	@ResponseBody
    public ResponseData getTrialFeatures() {
		ResponseData data = new ResponseData();
		data.setHttpStatus("200");
		data.setSuccess(true);
		String trialFeaturesJson = "{\"dingMoreThanOne\":true,\"defaultApproverEnabled\":true,\"pcSignEntryEnable\":true,\"supplySuiteEnable\":true,\"templateCenterEnabled\":true,\"swAppEnable\":false,\"enableMoneyThousandth\":false,\"enableAutoTaskNode\":false,\"substituteSubmitEnable\":true,\"enableSettingMoreVacationDeptVisibility\":false,\"mobileSettingEnable\":true,\"attendSmartCalculatorEnable\":false,\"outContactsApprovalEnable\":false,\"showOpenModeInFormDesign\":false,\"createApprovalGroupChat\":false,\"mobileConditionSettingEnable\":true,\"formDesignerMobileEnable\":true,\"newWorkFlowForecastEnable\":false,\"mobileSettingLabelEnable\":false,\"enterprisePayForThirdParty\":true,\"useLdbForCustomActioner\":true,\"sendAbnormalProcessEnabled\":true,\"hrmUpgradeTextSelectEnable\":true,\"enableSettingVacationVisibility\":true,\"enableSpecialCharacters\":true,\"enableGenerationTemplateQRCode\":true,\"hrmDismissionReasonCustom\":true,\"showForecastModelEnable\":true,\"processVisibilityCheckEnable\":true,\"operatorApprovalToChatClose\":true,\"timeAndLocationComponentEnabled\":true,\"cloudPrintEnable\":false,\"textnotFontEnable\":true,\"dyncAflowEnable\":true,\"invoiceEnable\":true,\"revokeLeaveEnabled\":true,\"hrmHireTrialEnable\":false,\"hrmRegularEnable\":false,\"hrmPromotionEnable\":false,\"alitripEnable\":true,\"newWorkOvertimeEnable\":true,\"newOpConfirm\":true,\"batchOvertime\":true,\"newLeaveOA\":true,\"superManagerEnable\":true,\"operatorApprovalToChat\":true,\"approvalToChatClose\":true,\"corpPermissionNew\":true,\"labelMatchEnable\":true,\"richTextEnable\":false,\"relateFieldEnable\":true,\"enableOvertimeV2\":true,\"approveDesignCenter\":true,\"addCommentToIm\":true,\"newBreastfeedingCorp\":false,\"bizSuitSubmit\":false,\"robotEnable\":true,\"batchOvertimeV2\":true,\"linkageEnable\":true,\"newLeaveEntryEnable\":true,\"leaveMultiCondition\":true,\"newFeaturesLearnEnable\":true,\"showWorkflowSurvey\":false,\"processUpgradeV2Enable\":true,\"cacheInput\":true,\"handSignEnable\":true,\"bizAliasEnable\":false,\"newGooutSuite\":false,\"qianyueEnable\":false,\"dyncStaticSwitchEnable\":false,\"labelNullRender\":false,\"newOpNotConfirm\":false,\"atToDing\":false,\"syncStarTask\":false,\"approvalToChat\":true,\"canModify\":false,\"actionAppendEnable\":false,\"quickDingEnable\":false,\"quickGuideEnable\":false,\"showOpenComponent\":false,\"attendGetToPost\":false,\"dingpanEditEnable\":false,\"reportEnable\":false,\"esignOpen\":false,\"removeOriValueEnable\":false,\"revertEnable\":true}";
		JSONObject.parse(trialFeaturesJson);
		System.out.println(JSONObject.parse(trialFeaturesJson));
		data.setData(JSONObject.parse(trialFeaturesJson));
		return data;
	}
	
	@RequestMapping("/process/getIconUrlMap.json")
	@ResponseBody
    public ResponseData getIconUrlMap() {
		ResponseData data = new ResponseData();
		data.setHttpStatus("200");
		data.setSuccess(true);
		String getIconUrlMap = "{\"attendance_supplementary\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1nsnvCNnaK1RjSZFBXXcW7VXa-102-102.png\",\"goods\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1nGe6CIfpK1RjSZFOXXa6nFXa-102-102.png\",\"official\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1xQaZCQvoK1RjSZPfXXXPKFXa-102-102.png\",\"discount\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1Eny_CSzqK1RjSZFpXXakSXXa-102-102.png\",\"general_log\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1KMniCNYaK1RjSZFnXXa80pXa-102-102.png\",\"salary\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1uNncCMHqK1RjSZFkXXX.WFXa-102-102.png\",\"biz\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB10uW.CNjaK1RjSZFAXXbdLFXa-112-112.png\",\"trip\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1cbCYCPTpK1RjSZKPXXa3UpXa-112-112.png\",\"datacurve\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1JVSVCHPpK1RjSZFFXXa5PpXa-102-102.png\",\"recruitment\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1zzK.CFzqK1RjSZFCXXbbxVXa-102-102.png\",\"leave\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1Yfa0CG6qK1RjSZFmXXX0PFXa-112-112.png\",\"payment\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1kXfXCOrpK1RjSZFhXXXSdXXa-102-102.png\",\"tag\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB13f_aCQzoK1RjSZFlXXai4VXa-102-102.png\",\"meeting\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1jY10CSrqK1RjSZK9XXXyypXa-102-102.png\",\"cooperation\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1ii16CSzqK1RjSZPxXXc4tVXa-102-102.png\",\"repeat_order\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1CODaCFzqK1RjSZFCXXbbxVXa-102-102.png\",\"schoolLog\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1L9m_CNTpK1RjSZFMXXbG_VXa-102-102.png\",\"datapie\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1YzS5CNTpK1RjSZFKXXa2wXXa-102-102.png\",\"contract\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1w.y9CQvoK1RjSZFNXXcxMVXa-112-112.png\",\"pay\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1KE9_CSzqK1RjSZFpXXakSXXa-112-112.png\",\"collection\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB11pS_CFzqK1RjSZSgXXcpAVXa-102-102.png\",\"warehouse\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1ThOzCSzqK1RjSZPcXXbTepXa-102-102.png\",\"courier\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1FNG.CMHqK1RjSZFgXXa7JXXa-102-102.png\",\"temporaryNotice\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1f.q.CQPoK1RjSZKbXXX1IXXa-102-102.png\",\"procurement\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1oQi.CSzqK1RjSZFpXXakSXXa-112-112.png\",\"daily\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1WWW1CRLoK1RjSZFuXXXn0XXa-112-112.png\",\"monthly\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB11_DaCQzoK1RjSZFlXXai4VXa-112-112.png\",\"exchange\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1JKe.CSzqK1RjSZFHXXb3CpXa-102-102.png\",\"departure\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1U9iBCSzqK1RjSZPcXXbTepXa-102-102.png\",\"favorite\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1MniUCHPpK1RjSZFFXXa5PpXa-102-102.png\",\"schoolStatement\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB100_vCNnaK1RjSZFtXXbC2VXa-102-102.png\",\"dutyLog\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB15692CRLoK1RjSZFuXXXn0XXa-102-102.png\",\"love\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1.rbgCNjaK1RjSZFAXXbdLFXa-102-102.png\",\"timefades\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1Y8PlCNjaK1RjSZKzXXXVwXXa-112-112.png\",\"visiting\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1jba9CFzqK1RjSZFoXXbfcXXa-102-102.png\",\"conference\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB11UW.CNTpK1RjSZFMXXbG_VXa-102-102.png\",\"schoolAttendance\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1ueq.CQvoK1RjSZFDXXXY3pXa-102-102.png\",\"house\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB11PG5CMHqK1RjSZJnXXbNLpXa-102-102.png\",\"weekly\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1qN_eCNYaK1RjSZFnXXa80pXa-112-112.png\",\"out\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1bHOWCSzqK1RjSZFjXXblCFXa-112-112.png\",\"common\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1e76lCOLaK1RjSZFxXXamPFXa-112-112.png\",\"inchapter\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1V2S8CHrpK1RjSZTEXXcWAVXa-102-102.png\",\"cashier\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB11X99CNTpK1RjSZFKXXa2wXXa-102-102.png\",\"gas\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1ErvbCMHqK1RjSZJnXXbNLpXa-102-102.png\",\"behavior\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1t695CFYqK1RjSZLeXXbXppXa-102-102.png\",\"department\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1uiy8CHvpK1RjSZPiXXbmwXXa-102-102.png\",\"class\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1SjS9COrpK1RjSZFhXXXSdXXa-102-102.png\",\"business\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1yf_bCQvoK1RjSZFDXXXY3pXa-112-112.png\",\"propaganda\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1r798CFzqK1RjSZSgXXcpAVXa-102-102.png\",\"jobs\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB13ca1CMDqK1RjSZSyXXaxEVXa-102-102.png\",\"relieve\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1Qm56CSzqK1RjSZPxXXc4tVXa-102-102.png\",\"positive\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1_YG.COrpK1RjSZFhXXXSdXXa-102-102.png\",\"message\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1zmS2CQvoK1RjSZFDXXXY3pXa-102-102.png\",\"follow\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB10TS9CNTpK1RjSZFKXXa2wXXa-102-102.png\",\"work_instructions\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1AbDaCMHqK1RjSZFPXXcwapXa-102-102.png\",\"fly\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB1S_i0CQvoK1RjSZFNXXcxMVXa-102-102.png\",\"maintenance\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB197e_CHrpK1RjSZTEXXcWAVXa-102-102.png\",\"promotion\":\"https:\\/\\/gw.alicdn.com\\/tfs\\/TB13yiWCPDpK1RjSZFrXXa78VXa-102-102.png\"}";
		JSONObject.parse(getIconUrlMap);
		System.out.println(JSONObject.parse(getIconUrlMap));
		data.setData(JSONObject.parse(getIconUrlMap));
		return data;
	}
	
	@RequestMapping("/login/getLoginUserInfo.json")
	@ResponseBody
    public ResponseData getLoginUserInfo() {
		ResponseData data = new ResponseData();
		data.setHttpStatus("200");
		data.setSuccess(true);
		String getLoginUserInfo = "{\"orgName\":\"夏辉试用\",\"name\":\"夏辉\",\"corpId\":\"ding81905d303637580f35c2f4657eb6378f\",\"userId\":\"manager5551\"}";
		JSONObject.parse(getLoginUserInfo);
		System.out.println(JSONObject.parse(getLoginUserInfo));
		data.setData(JSONObject.parse(getLoginUserInfo));
		return data;
	}
	
	@RequestMapping("/dir/dirList.json")
	@ResponseBody
    public ResponseData dirList() {
		ResponseData data = new ResponseData();
		data.setHttpStatus("200");
		data.setSuccess(true);
		String dirList = "{\"errorMsg\":\"\",\"errorCode\":\"\",\"result\":[{\"dirId\":\"16ded3b519c4d0b5ddfbde445408d6b4\",\"dirName\":\"假勤管理\",\"children\":[]},{\"dirId\":\"16ded3b519c070ed862005744f2a6ccd\",\"dirName\":\"人事管理\",\"children\":[]},{\"dirId\":\"16ded3b519c1781e2e367f947f1a5a4c\",\"dirName\":\"财务管理\",\"children\":[]},{\"dirId\":\"16ded3b519c226172dcb50e4032b1d35\",\"dirName\":\"业务管理\",\"children\":[]},{\"dirId\":\"16ded3b519c49feb8163abc4957ba8ec\",\"dirName\":\"行政管理\",\"children\":[]},{\"dirId\":\"16ded3b519c7eb205f88a374cac84537\",\"dirName\":\"法务管理\",\"children\":[]},{\"dirId\":\"other\",\"dirName\":\"其他\",\"children\":[]}]}";
		JSONObject.parse(dirList);
		System.out.println(JSONObject.parse(dirList));
		data.setData(JSONObject.parse(dirList));
		return data;
	}
	
	@RequestMapping("/process/getProcessVisible.json")
	@ResponseBody
    public ResponseData getProcessVisible() {
		ResponseData data = new ResponseData();
		data.setHttpStatus("200");
		data.setSuccess(true);
		String getProcessVisible = "";
		JSONObject.parse(getProcessVisible);
		System.out.println(JSONObject.parse(getProcessVisible));
		data.setData(JSONObject.parse(getProcessVisible));
		return data;
	}
	
	@RequestMapping("/process/getProcessManagerList.json")
	@ResponseBody
    public ResponseData getProcessManagerList() {
		ResponseData data = new ResponseData();
		data.setHttpStatus("200");
		data.setSuccess(true);
		String getProcessManagerList = "";
		JSONObject.parse(getProcessManagerList);
		System.out.println(JSONObject.parse(getProcessManagerList));
		data.setData(JSONObject.parse(getProcessManagerList));
		return data;
	}
	
	@RequestMapping("/form/getForm.json")
	@ResponseBody
    public ResponseData getForm() {
		ResponseData data = new ResponseData();
		data.setHttpStatus("200");
		data.setSuccess(true);
		String getForm = "";
		JSONObject.parse(getForm);
		System.out.println(JSONObject.parse(getForm));
		data.setData(JSONObject.parse(getForm));
		return data;
	}
}
