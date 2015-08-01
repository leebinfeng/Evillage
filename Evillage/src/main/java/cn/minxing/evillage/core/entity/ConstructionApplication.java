package cn.minxing.evillage.core.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ConstructionApplication entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Construction_Application", catalog = "minxing_e_village")
public class ConstructionApplication implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer applicationId;
	private String identityNumber;
	private String staffNumber;
	private Date applicationDate;
	private Date endDate;
	private String currentState;

	// Constructors

	/** default constructor */
	public ConstructionApplication() {
	}

	/** full constructor */
	public ConstructionApplication(Integer applicationId,
			String identityNumber, String staffNumber, Date applicationDate,
			Date endDate, String currentState) {
		this.applicationId = applicationId;
		this.identityNumber = identityNumber;
		this.staffNumber = staffNumber;
		this.applicationDate = applicationDate;
		this.endDate = endDate;
		this.currentState = currentState;
	}

	// Property accessors
	@Id
	@Column(name = "application_id", unique = true, nullable = false)
	public Integer getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	@Column(name = "identity_number", nullable = false, length = 18)
	public String getIdentityNumber() {
		return this.identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	@Column(name = "staff_number", nullable = false, length = 20)
	public String getStaffNumber() {
		return this.staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "application_date", nullable = false, length = 0)
	public Date getApplicationDate() {
		return this.applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false, length = 0)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "current_state", nullable = false, length = 50)
	public String getCurrentState() {
		return this.currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

}