package com.stefan.exceptions;

public class ImageUploadException extends RuntimeException {

	private static final long serialVersionUID = 1L;	
	
	public ImageUploadException(String exceptionMessage, Exception e){
		throw new RuntimeException(exceptionMessage, e);
	}
	
	public ImageUploadException(String exceptionMessage){
		throw new RuntimeException(exceptionMessage);
	}
}
