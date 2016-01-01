package cn.minxing.evillage.core.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EvmcpMedicareAccount entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Medicare_Account", catalog = "minxing_e_village")
public class MedicareAccount implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String medicareId;
	private String bank;
	private String identityNumber;
	private Date openDate;
	private Integer cumulativePaymentMonth;
	private Integer pendingPaymentMonth;
	private Float monthPayment;
	private Float accountBalance;
	private String monthStatus;

	// Constructors

	/** default constructor */
	public MedicareAccount() {
	}

	/** full constructor */
	public MedicareAccount(String medicareId, String bank,
			String identityNumber, Date openDate,
			Integer cumulativePaymentMonth, Integer pendingPaymentMonth,
			Float monthPayment, Float accountBalance, String monthStatus) {
		this.medicareId = medicareId;
		this.bank = bank;
		this.identityNumber = identityNumber;
		this.openDate = openDate;
		this.cumulativePaymentMonth = cumulativePaymentMonth;
		this.pendingPaymentMonth = pendingPaymentMonth;
		this.monthPayment = monthPayment;
		this.accountBalance = accountBalance;
		this.monthStatus = monthStatus;
	}

	// Property accessors
	@Id
	@Column(name = "medicare_id", unique = true, nullable = false, length = 20)
	public String getMedicareId() {
		return this.medicareId;
	}

	public void setMedicareId(String medicareId) {
		this.medicareId = medicareId;
	}

	@Column(name = "bank", nullable = false, length = 20)
	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Column(name = "identity_number", nullable = false, length = 18)
	public String getIdentityNumber() {
		return this.identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "open_date", nullable = false, length = 0)
	public Date getOpenDate() {
		return this.openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	@Column(name = "cumulative_payment_month", nullable = false)
	public Integer getCumulativePaymentMonth() {
		return this.cumulativePaymentMonth;
	}

	public void setCumulativePaymentMonth(Integer cumulativePaymentMonth) {
		this.cumulativePaymentMonth = cumulativePaymentMonth;
	}

	@Column(name = "pending_payment_month", nullable = false)
	public Integer getPendingPaymentMonth() {
		return this.pendingPaymentMonth;
	}

	public void setPendingPaymentMonth(Integer pendingPaymentMonth) {
		this.pendingPaymentMonth = pendingPaymentMonth;
	}

	@Column(name = "month_payment", nullable = false, precision = 12, scale = 0)
	public Float getMonthPayment() {
		return this.monthPayment;
	}

	public void setMonthPayment(Float monthPayment) {
		this.monthPayment = monthPayment;
	}

	@Column(name = "account_balance", nullable = false, precision = 12, scale = 0)
	public Float getAccountBalance() {
		return this.accountBalance;
	}

	public void setAccountBalance(Float accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Column(name = "month_status", nullable = false, length = 10)
	public String getMonthStatus() {
		return this.monthStatus;
	}

	public void setMonthStatus(String monthStatus) {
		this.monthStatus = monthStatus;
	}

}