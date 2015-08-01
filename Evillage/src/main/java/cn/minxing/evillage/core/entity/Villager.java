package cn.minxing.evillage.core.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Villager entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Villager", catalog = "minxing_e_village")
public class Villager implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String identityNumber;
	private String fullName;
	private String gender;
	private String ethnicity;
	private Date birthday;
	private String nativePlace;
	private String homeAddress;
	private String workAddress;
	private String landlines;
	private String mobiles;
	private String job;
	private String inMigrant;

	// Constructors

	/** default constructor */
	public Villager() {
	}

	/** full constructor */
	public Villager(String identityNumber, String fullName, String gender,
			String ethnicity, Date birthday, String nativePlace,
			String homeAddress, String workAddress, String landlines,
			String mobiles, String job, String inMigrant) {
		this.identityNumber = identityNumber;
		this.fullName = fullName;
		this.gender = gender;
		this.ethnicity = ethnicity;
		this.birthday = birthday;
		this.nativePlace = nativePlace;
		this.homeAddress = homeAddress;
		this.workAddress = workAddress;
		this.landlines = landlines;
		this.mobiles = mobiles;
		this.job = job;
		this.inMigrant = inMigrant;
	}

	// Property accessors
	@Id
	@Column(name = "identity_number", unique = true, nullable = false, length = 18)
	public String getIdentityNumber() {
		return this.identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	@Column(name = "full_name", nullable = false, length = 50)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "gender", nullable = false, length = 2)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "ethnicity", nullable = false, length = 50)
	public String getEthnicity() {
		return this.ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", nullable = false, length = 0)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "native_place", nullable = false, length = 225)
	public String getNativePlace() {
		return this.nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	@Column(name = "home_address", nullable = false, length = 225)
	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Column(name = "work_address", nullable = false, length = 225)
	public String getWorkAddress() {
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	@Column(name = "landlines", nullable = false, length = 15)
	public String getLandlines() {
		return this.landlines;
	}

	public void setLandlines(String landlines) {
		this.landlines = landlines;
	}

	@Column(name = "mobiles", nullable = false, length = 11)
	public String getMobiles() {
		return this.mobiles;
	}

	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;
	}

	@Column(name = "job", nullable = false, length = 50)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "in_migrant", nullable = false, length = 2)
	public String getInMigrant() {
		return this.inMigrant;
	}

	public void setInMigrant(String inMigrant) {
		this.inMigrant = inMigrant;
	}

}