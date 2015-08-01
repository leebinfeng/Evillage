package cn.minxing.evillage.core.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Report entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Report", catalog = "minxing_e_village")
public class Report implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer reportId;
	private String identityNumber;
	private String title;
	private String content;
	private Timestamp submitTime;
	private String classification;

	// Constructors

	/** default constructor */
	public Report() {
	}

	/** full constructor */
	public Report(Integer reportId, String identityNumber, String title,
			String content, Timestamp submitTime, String classification) {
		this.reportId = reportId;
		this.identityNumber = identityNumber;
		this.title = title;
		this.content = content;
		this.submitTime = submitTime;
		this.classification = classification;
	}

	// Property accessors
	@Id
	@Column(name = "report_id", unique = true, nullable = false)
	public Integer getReportId() {
		return this.reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	@Column(name = "identity_number", nullable = false, length = 18)
	public String getIdentityNumber() {
		return this.identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	@Column(name = "title", nullable = false, length = 20)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "submit_time", nullable = false, length = 0)
	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	@Column(name = "classification", nullable = false, length = 20)
	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

}