package cn.minxing.evillage.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CertificationType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Certification_Type", catalog = "minxing_e_village")
public class CertificationType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer typeId;
	private String type;

	// Constructors

	/** default constructor */
	public CertificationType() {
	}

	/** full constructor */
	public CertificationType(Integer typeId, String type) {
		this.typeId = typeId;
		this.type = type;
	}

	// Property accessors
	@Id
	@Column(name = "type_id", unique = true, nullable = false)
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "type", nullable = false, length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}