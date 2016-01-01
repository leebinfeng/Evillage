package cn.minxing.evillage.core.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EvmcpInformation entity. @author MyEclipse Persistence Tools
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
	private String staff;
	private Timestamp releaseTime;
	private String title;
	private String content;
	private String tag;
	private String attachment;

	// Constructors

	/** default constructor */
	public Information() {
	}

	/** full constructor */
	public Information(Integer infoId, String staff,
			Timestamp releaseTime, String title, String content, String tag,
			String attachment) {
		this.infoId = infoId;
		this.staff = staff;
		this.releaseTime = releaseTime;
		this.title = title;
		this.content = content;
		this.tag = tag;
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

	@Column(name = "staff", nullable = false, length = 20)
	public String getStaff() {
		return this.staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
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

	@Column(name = "tag", nullable = false, length = 20)
	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Column(name = "attachment", nullable = false)
	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}