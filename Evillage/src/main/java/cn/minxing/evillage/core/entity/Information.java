package cn.minxing.evillage.core.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Information entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Information", catalog = "minxing_e_village")
public class Information implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer infoId;
	private String staffNumber;
	private Timestamp releaseTime;
	private String title;
	private String content;
	private String classification;
	private String attachment;

	// Constructors

	/** default constructor */
	public Information() {
	}

	/** full constructor */
	public Information(Integer infoId, String staffNumber,
			Timestamp releaseTime, String title, String content,
			String classification, String attachment) {
		this.infoId = infoId;
		this.staffNumber = staffNumber;
		this.releaseTime = releaseTime;
		this.title = title;
		this.content = content;
		this.classification = classification;
		this.attachment = attachment;
	}

	// Property accessors
	@Id
	@Column(name = "info_id", unique = true, nullable = false)
	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	@Column(name = "staff_number", nullable = false, length = 20)
	public String getStaffNumber() {
		return this.staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	@Column(name = "release_time", nullable = false, length = 0)
	public Timestamp getReleaseTime() {
		return this.releaseTime;
	}

	public void setReleaseTime(Timestamp releaseTime) {
		this.releaseTime = releaseTime;
	}

	@Column(name = "title", nullable = false, length = 50)
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

	@Column(name = "classification", nullable = false, length = 20)
	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Column(name = "attachment", nullable = false)
	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}