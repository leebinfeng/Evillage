package cn.minxing.evillage.core.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EVMCP_Message", catalog = "minxing_e_village")
public class Message implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer messageId;
	private Timestamp pushTime;
	private Integer staffNumber;
	private String title;
	private String content;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(Integer messageId, Timestamp pushTime,
			Integer staffNumber, String title, String content) {
		this.messageId = messageId;
		this.pushTime = pushTime;
		this.staffNumber = staffNumber;
		this.title = title;
		this.content = content;
	}

	// Property accessors
	@Id
	@Column(name = "message_id", unique = true, nullable = false)
	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	@Column(name = "push_time", nullable = false, length = 0)
	public Timestamp getPushTime() {
		return this.pushTime;
	}

	public void setPushTime(Timestamp pushTime) {
		this.pushTime = pushTime;
	}

	@Column(name = "staff_number", nullable = false)
	public Integer getStaffNumber() {
		return this.staffNumber;
	}

	public void setStaffNumber(Integer staffNumber) {
		this.staffNumber = staffNumber;
	}

	@Column(name = "title", nullable = false, length = 20)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", nullable = false, length = 225)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}