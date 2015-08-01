package cn.minxing.evillage.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CertificationTemplate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Certification_Template", catalog = "minxing_e_village")
public class CertificationTemplate implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer templateId;
	private String templateName;
	private String templateTitle;
	private String reason;
	private String remark;
	private Integer type;

	// Constructors

	/** default constructor */
	public CertificationTemplate() {
	}

	/** full constructor */
	public CertificationTemplate(Integer templateId, String templateName,
			String templateTitle, String reason, String remark, Integer type) {
		this.templateId = templateId;
		this.templateName = templateName;
		this.templateTitle = templateTitle;
		this.reason = reason;
		this.remark = remark;
		this.type = type;
	}

	// Property accessors
	@Id
	@Column(name = "template_id", unique = true, nullable = false)
	public Integer getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	@Column(name = "template_name", nullable = false, length = 50)
	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	@Column(name = "template_title", nullable = false, length = 50)
	public String getTemplateTitle() {
		return this.templateTitle;
	}

	public void setTemplateTitle(String templateTitle) {
		this.templateTitle = templateTitle;
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