package org.tdgo.CourseIntroduction.vo;

import java.io.Serializable;
import java.util.Map;

public class Result implements Serializable{

	/**
	 * 
	 */

	public boolean isEmpty(){
		if(this.getMessage()==""||this.getMessage()==null){
			if(this.getErrorCode()==""||this.getErrorCode()==null){
				if(this.getParams()==null){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String message;
	private Map<String, Object> params;
	
	public Result() {

	}

	public Result(String errorCode,String message,Map<String, Object> params) {
		this.errorCode = errorCode;
		this.message = message;
		this.params = params;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
}
