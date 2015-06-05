package org.tdgo.CourseIntroduction.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="opterater")
public class Operater implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer opteraterId;
	@Column(name="user_name",length=255,nullable=false)
	private String userName;
	@Column(name="password",length=255,nullable=false)
	private String password;
	
	@Id
	@Column(name="operater_id",insertable=false,updatable=false)
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	public Integer getOpteraterId() {
		return opteraterId;
	}
	public void setOpteraterId(Integer opteraterId) {
		this.opteraterId = opteraterId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
