package cn.minxing.evillage.core.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EvmcpEvaluation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Evaluation", catalog = "minxing_e_village")
public class Evaluation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer evaluationId;
	private String rate;
	private Timestamp appraisalTime;
	private String applicant;
	private String staff;
	private String comment;

	// Constructors

	/** default constructor */
	public Evaluation() {
	}

	/** full constructor */
	public Evaluation(String rate, Timestamp appraisalTime,
			String applicant, String staff, String comment) {
		this.rate = rate;
		this.appraisalTime = appraisalTime;
		this.applicant = applicant;
		this.staff = staff;
		this.comment = comment;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "evaluation_id", unique = true, nullable = false)
	public Integer getEvaluationId() {
		return this.evaluationId;
	}

	public void setEvaluationId(Integer evaluationId) {
		this.evaluationId = evaluationId;
	}

	@Column(name = "rate", nullable = false, length = 10)
	public String getRate() {
		return this.rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	@Column(name = "appraisal_time", nullable = false, length = 0)
	public Timestamp getAppraisalTime() {
		return this.appraisalTime;
	}

	public void setAppraisalTime(Timestamp appraisalTime) {
		this.appraisalTime = appraisalTime;
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

	@Column(name = "comment", nullable = false, length = 225)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}