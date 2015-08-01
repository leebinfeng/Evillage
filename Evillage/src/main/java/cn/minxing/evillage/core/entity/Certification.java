package cn.minxing.evillage.core.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Certification entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Certification", catalog = "minxing_e_village")
public class Certification implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String certificationId;
	private String title;
	private Timestamp checkDate;
	private String staffNumber;
	private String identityNumber;
	private String reason;
	private String remark;
	private Integer type;

	// Constructors

	/** default constructor */
	public Certification() {
	}

	/** full constructor */
	public Certification(String certificationId, String title,
			Timestamp checkDate, String staffNumber, String identityNumber,
			String reason, String remark, Integer type) {
		this.certificationId = certificationId;
		this.title = title;
		this.checkDate = checkDate;
		this.staffNumber = staffNumber;
		this.identityNumber = identityNumber;
		this.reason = reason;
		this.remark = remark;
		this.type = type;
	}

	// Property accessors
	@Id
	@Column(name = "certification_id", unique = true, nullable = false, length = 20)
	public String getCertificationId() {
		return this.certificationId;
	}

	public void setCertificationId(String certificationId) {
		this.certificationId = certificationId;
	}

	@Column(name = "title", nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "check_date", nullable = false, length = 0)
	public Timestamp getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Timestamp checkDate) {
		this.checkDate = checkDate;
	}

	@Column(name = "staff_number", nullable = false, length = 20)
	public String getStaffNumber() {
		return this.staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	@Column(name = "identity_number", nullable = false, length = 18)
	public String getIdentityNumber() {
		return this.identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	@Column(name = "reason", nullable = false, length = 225)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "remark", nullable = false, length = 225)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}