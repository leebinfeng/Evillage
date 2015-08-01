package cn.minxing.evillage.common.exception.service;

import cn.minxing.evillage.common.exception.service.ApplicationServiceException;

/**
 * @author 李彬峰
 *
 */
public class RetrieveObjectException extends ApplicationServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RetrieveObjectException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public RetrieveObjectException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

}
