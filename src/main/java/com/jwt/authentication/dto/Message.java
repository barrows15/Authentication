package com.jwt.authentication.dto;

public class Message {

	private String id;
	
	private String message;

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + "]";
	}
	
}
