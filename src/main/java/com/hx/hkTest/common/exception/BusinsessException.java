package com.hx.hkTest.common.exception;


import com.hx.hkTest.common.enums.ErrorCodeEnum;
import com.hx.hkTest.utils.StringParser;

/**
 * @ClassName: BusinsessException.java
 * 功能描述：业务异常
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2019年10月25日 下午6:33:09 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2019年10月25日     xiahui           v1.0.0           业务异常
 */
public class BusinsessException extends RuntimeException {

    /**
     * 异常码
     */
    protected String code;

    private static final long serialVersionUID = 3160241586346324994L;

    public BusinsessException() {
    }

    public BusinsessException(Throwable cause) {
        super(cause);
    }

    public BusinsessException(String message) {
        super(message);
    }

    public BusinsessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinsessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinsessException(String code, String msgFormat, Object... args) {
    	 super(StringParser.parseString(msgFormat, args));
        this.code = code;
    }

    public BusinsessException(ErrorCodeEnum codeEnum, Object... args) {
    	super(StringParser.parseString(codeEnum.msg(), args));
        this.code = codeEnum.code();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
