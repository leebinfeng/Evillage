package cn.minxing.evillage.common.exception.service;

import cn.minxing.evillage.common.exception.base.ApplicationRuntimeException;

/**
 * @author 李彬峰
 *
 */
public class ApplicationServiceException extends ApplicationRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationServiceException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public ApplicationServiceException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

}
