package com.spring.apirest.error;

public class ClienteErrorType {
	
	private String errorMesage;
	
	public ClienteErrorType(String errorMessage) {
		this.errorMesage = errorMessage;
	}
	
	public String getErrorMesage() {
		return errorMesage;
	}
	

}
