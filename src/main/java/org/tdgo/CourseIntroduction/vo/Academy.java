package org.tdgo.CourseIntroduction.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="academy")
public class Academy implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer academyID;
	@Column(name="name",length=255,nullable=false)
	private String name;
	

	@Id
	@Column(name="academy_id",insertable=false,updatable=false)
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	public Integer getAcademyID() {
		return academyID;
	}
	public void setAcademyID(Integer academyID) {
		this.academyID = academyID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
