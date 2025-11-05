package com.hotel.app.utilities;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExceptionStructure 
{
	private Class classInformation;
	private String errorMessage;
	private HttpStatus statusCode;
}
