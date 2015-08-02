package cn.minxing.evillage.common.exception.base;

/**
 * @author 李彬峰
 *
 */
public class ErrorMessage {

	private String errormsg;

	public ErrorMessage(String errormsg) {
		this.errormsg = errormsg;
	}

	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

}
