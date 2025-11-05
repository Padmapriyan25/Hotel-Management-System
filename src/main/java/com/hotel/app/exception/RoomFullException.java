package com.hotel.app.exception;

public class RoomFullException extends RuntimeException
{
	public RoomFullException(String message)
	{
		super(message);
	}
}
