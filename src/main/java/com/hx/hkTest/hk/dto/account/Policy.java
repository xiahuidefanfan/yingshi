package com.hx.hkTest.hk.dto.account;

/**
 * @ClassName: Policy.java
 * 功能描述：授权策略
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2020年2月23日 下午2:46:45 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2020年2月23日     xiahui           v1.0.0               授权策略
 */
public class Policy {
	private Statement Statement;

	public Statement getStatement() {
		return Statement;
	}

	public void setStatement(Statement statement) {
		Statement = statement;
	}
}
