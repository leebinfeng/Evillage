package cn.minxing.evillage.core.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EvmcpConstructionApplication entity. @author MyEclipse Persistence Tools
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
	private String applicant;
	private String staff;
	private Date applicationDate;
	private Date endDate;
	private String state;
	private String type;
	private String attachment;

	// Constructors

	/** default constructor */
	public ConstructionApplication() {
	}

	/** minimal constructor */
	public ConstructionApplication(Integer applicationId,
			String applicant, String staff, Date applicationDate, Date endDate,
			String state, String type) {
		this.applicationId = applicationId;
		this.applicant = applicant;
		this.staff = staff;
		this.applicationDate = applicationDate;
		this.endDate = endDate;
		this.state = state;
		this.type = type;
	}

	/** full constructor */
	public ConstructionApplication(Integer applicationId,
			String applicant, String staff, Date applicationDate, Date endDate,
			String state, String type, String attachment) {
		this.applicationId = applicationId;
		this.applicant = applicant;
		this.staff = staff;
		this.applicationDate = applicationDate;
		this.endDate = endDate;
		this.state = state;
		this.type = type;
		this.attachment = attachment;
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

	@Column(name = "applicant", nullable = false, length = 18)
	public String getApplicant() {
		return this.applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	@Column(name = "staff", nullable = false, length = 20)
	public String getStaff() {
		return this.staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
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

	@Column(name = "state", nullable = false, length = 20)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "type", nullable = false, length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "attachment", length = 225)
	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}