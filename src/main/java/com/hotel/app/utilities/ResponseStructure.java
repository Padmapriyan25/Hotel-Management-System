package com.hotel.app.utilities;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseStructure<T>
{
	private T data;
	private LocalDateTime localDateTime;
	private String message;
	private int statusCode;
}
