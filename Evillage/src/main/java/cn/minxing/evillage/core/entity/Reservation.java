package cn.minxing.evillage.core.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EvmcpReservation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Reservation", catalog = "minxing_e_village")
public class Reservation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reservationId;
	private Date applicationDate;
	private Date takeDate;
	private String type;
	private String applicant;

	// Constructors

	/** default constructor */
	public Reservation() {
	}

	/** full constructor */
	public Reservation(String reservationId, Date applicationDate,
			Date takeDate, String type, String applicant) {
		this.reservationId = reservationId;
		this.applicationDate = applicationDate;
		this.takeDate = takeDate;
		this.type = type;
		this.applicant = applicant;
	}

	// Property accessors
	@Id
	@Column(name = "reservation_id", unique = true, nullable = false, length = 16)
	public String getReservationId() {
		return this.reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "application_date", nullable = false, length = 0)
	public Date getApplicationDate() {
		return this.applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "take_date", nullable = false, length = 0)
	public Date getTakeDate() {
		return this.takeDate;
	}

	public void setTakeDate(Date takeDate) {
		this.takeDate = takeDate;
	}

	@Column(name = "type", nullable = false, length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "applicant", nullable = false, length = 18)
	public String getApplicant() {
		return this.applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

}