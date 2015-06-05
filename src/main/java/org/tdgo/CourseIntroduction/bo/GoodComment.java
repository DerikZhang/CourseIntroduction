package org.tdgo.CourseIntroduction.bo;

import java.io.Serializable;

public class GoodComment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer commentId;
	private Boolean good;
	
	public Boolean getGood() {
		return good;
	}
	public void setGood(Boolean good) {
		this.good = good;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	
}
