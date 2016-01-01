package cn.minxing.evillage.core.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EvmcpCertificate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Certificate", catalog = "minxing_e_village")
public class Certificate implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String certificationId;
	private String title;
	private Timestamp checkDate;
	private String staff;
	private String applicant;
	private Integer type;
	private String attachment;
	private String content;
	private String status;

	// Constructors

	/** default constructor */
	public Certificate() {
	}

	/** minimal constructor */
	public Certificate(String certificationId, String title,
			Timestamp checkDate, String staff, String applicant, Integer type,
			String content, String status) {
		this.certificationId = certificationId;
		this.title = title;
		this.checkDate = checkDate;
		this.staff = staff;
		this.applicant = applicant;
		this.type = type;
		this.content = content;
		this.status = status;
	}

	/** full constructor */
	public Certificate(String certificationId, String title,
			Timestamp checkDate, String staff, String applicant, Integer type,
			String attachment, String content, String status) {
		this.certificationId = certificationId;
		this.title = title;
		this.checkDate = checkDate;
		this.staff = staff;
		this.applicant = applicant;
		this.type = type;
		this.attachment = attachment;
		this.content = content;
		this.status = status;
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

	@Column(name = "staff", nullable = false, length = 20)
	public String getStaff() {
		return this.staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	@Column(name = "applicant", nullable = false, length = 18)
	public String getApplicant() {
		return this.applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "attachment", length = 225)
	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "status", nullable = false, length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}