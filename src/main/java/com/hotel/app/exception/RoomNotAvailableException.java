package com.hotel.app.exception;

public class RoomNotAvailableException extends RuntimeException
{
	public RoomNotAvailableException(String message)
	{
		super(message);
	}
}
