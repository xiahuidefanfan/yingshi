package com.hx.hkTest.hk.dto.account;

/**
 * @ClassName: Statement.java
 * 功能描述：授权策略细则
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2020年2月23日 下午2:46:38 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2020年2月23日     xiahui           v1.0.0             授权策略细则
 */
public class Statement {
	// 权限列表 例如："Permission": "GET,UPDATE,REAL"
	private String Permission;		
	// 资源列表 例如 ：["dev:469631729", "dev:519928976","cam:544229080:1"]
	private String[] Resource;
	public String getPermission() {
		return Permission;
	}
	public void setPermission(String permission) {
		Permission = permission;
	}
	public String[] getResource() {
		return Resource;
	}
	public void setResource(String[] resource) {
		Resource = resource;
	}
}
