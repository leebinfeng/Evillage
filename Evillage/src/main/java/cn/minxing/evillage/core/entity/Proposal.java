package cn.minxing.evillage.core.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Proposal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Proposal", catalog = "minxing_e_village")
public class Proposal implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer proposalId;
	private String identityNumber;
	private String title;
	private String summary;
	private String content;
	private Timestamp submitTime;
	private String classification;

	// Constructors

	/** default constructor */
	public Proposal() {
	}

	/** full constructor */
	public Proposal(Integer proposalId, String identityNumber,
			String title, String summary, String content, Timestamp submitTime,
			String classification) {
		this.proposalId = proposalId;
		this.identityNumber = identityNumber;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.submitTime = submitTime;
		this.classification = classification;
	}

	// Property accessors
	@Id
	@Column(name = "proposal_id", unique = true, nullable = false)
	public Integer getProposalId() {
		return this.proposalId;
	}

	public void setProposalId(Integer proposalId) {
		this.proposalId = proposalId;
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

	@Column(name = "summary", nullable = false)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	@Column(name = "classification", nullable = false)
	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

}