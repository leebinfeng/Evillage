package cn.minxing.evillage.core.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Satisfaction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Satisfaction", catalog = "minxing_e_village")
public class Satisfaction implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer satisfactionId;
	private String degree;
	private Timestamp appraisalTime;
	private String certificationId;

	// Constructors

	/** default constructor */
	public Satisfaction() {
	}

	/** full constructor */
	public Satisfaction(String degree, Timestamp appraisalTime,
			String certificationId) {
		this.degree = degree;
		this.appraisalTime = appraisalTime;
		this.certificationId = certificationId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "satisfaction_id", unique = true, nullable = false)
	public Integer getSatisfactionId() {
		return this.satisfactionId;
	}

	public void setSatisfactionId(Integer satisfactionId) {
		this.satisfactionId = satisfactionId;
	}

	@Column(name = "degree", nullable = false, length = 3)
	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Column(name = "appraisal_time", nullable = false, length = 0)
	public Timestamp getAppraisalTime() {
		return this.appraisalTime;
	}

	public void setAppraisalTime(Timestamp appraisalTime) {
		this.appraisalTime = appraisalTime;
	}

	@Column(name = "certification_id", nullable = false, length = 20)
	public String getCertificationId() {
		return this.certificationId;
	}

	public void setCertificationId(String certificationId) {
		this.certificationId = certificationId;
	}

}