package cn.minxing.evillage.common.exception.dao;

import cn.minxing.evillage.common.exception.base.ApplicationRuntimeException;

/**
 * <p>
 * This exception hierarchy aims to let user code find and handle the kind of
 * error encountered without knowing the details of the particular data access
 * API in use (e.g. JDBC).
 * </p>
 * <p>
 * As this class is a runtime exception, there is no need for user code to catch
 * it or subclasses if any error is to be considered fatal (the usual case).
 * </p>
 * 
 * @author 李彬峰
 *
 */
public class ApplicationDataAccessException extends ApplicationRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationDataAccessException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public ApplicationDataAccessException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

}
