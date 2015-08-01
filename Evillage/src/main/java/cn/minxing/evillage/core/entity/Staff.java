package cn.minxing.evillage.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Staff", catalog = "minxing_e_village")
public class Staff implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String staffNumber;
	private String department;
	private String position;
	private String identityNumber;

	// Constructors

	/** default constructor */
	public Staff() {
	}

	/** full constructor */
	public Staff(String staffNumber, String department, String position,
			String identityNumber) {
		this.staffNumber = staffNumber;
		this.department = department;
		this.position = position;
		this.identityNumber = identityNumber;
	}

	// Property accessors
	@Id
	@Column(name = "staff_number", unique = true, nullable = false, length = 20)
	public String getStaffNumber() {
		return this.staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	@Column(name = "department", nullable = false, length = 20)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "position", nullable = false, length = 20)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "identity_number", nullable = false, length = 18)
	public String getIdentityNumber() {
		return this.identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

}