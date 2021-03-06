package cn.minxing.evillage.common.exception.base;

import cn.minxing.evillage.common.util.NestedExceptionUtils;

/**
 * @author 李彬峰
 *
 */
public abstract class ApplicationRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construct a {@code ApplicationRuntimeException} with the specified detail
	 * message.
	 * 
	 * @param msg
	 *            the detail message
	 */
	public ApplicationRuntimeException(String msg) {
		super(msg);
	}

	/**
	 * Construct a {@code ApplicationRuntimeException} with the specified detail
	 * message and nested exception.
	 * 
	 * @param msg
	 *            the detail message
	 * @param cause
	 *            the nested exception
	 */
	public ApplicationRuntimeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Return the detail message, including the message from the nested
	 * exception if there is one.
	 */
	@Override
	public String getMessage() {
		return NestedExceptionUtils
				.buildMessage(super.getMessage(), getCause());
	}

	/**
	 * Retrieve the innermost cause of this exception, if any
	 * 
	 * @return the innermost exception, or {@code null} if none
	 */
	public Throwable getRootCause() {
		Throwable rootCause = null;
		Throwable cause = getCause();
		while (cause != null && cause != rootCause) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}

	/**
	 * Retrieve the most specific cause of this exception, that is, either the
	 * innermost cause (root cause) or this exception itself.
	 * <p>
	 * Differs from {@link #getRootCause()} in that it falls back to the present
	 * exception if there is no root cause.
	 * 
	 * @return the most specific cause (never {@code null})
	 */
	public Throwable getMostSpecificCause() {
		Throwable rootCause = getRootCause();
		return (rootCause != null ? rootCause : this);
	}

	/**
	 * Check whether this exception contains an exception of the given type:
	 * either it is of the given class itself or it contains a nested cause of
	 * the given type.
	 * 
	 * @param exType
	 *            the exception type to look for
	 * @return whether there is a nested exception of the specified type
	 */
	public boolean contains(Class<?> exType) {
		if (exType == null) {
			return false;
		}
		if (exType.isInstance(this)) {
			return true;
		}
		Throwable cause = getCause();
		if (cause == this) {
			return false;
		}
		if (cause instanceof ApplicationRuntimeException) {
			return ((ApplicationRuntimeException) cause).contains(exType);
		} else {
			while (cause != null) {
				if (exType.isInstance(cause)) {
					return true;
				}
				if (cause.getCause() == cause) {
					break;
				}
				cause = cause.getCause();
			}
			return false;
		}
	}

}
