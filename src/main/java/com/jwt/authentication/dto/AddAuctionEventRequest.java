package com.jwt.authentication.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AddAuctionEventRequest {
	
	private String name;
	private String startdate;
	private String enddate;
	private String eventflag;
	private String eventImage;
	
	public AddAuctionEventRequest() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getEventflag() {
		return eventflag;
	}

	public void setEventflag(String eventflag) {
		this.eventflag = eventflag;
	}

	public String getEventImage() {
		return eventImage;
	}

	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}

	public AddAuctionEventRequest(String name, String startdate, String enddate, String eventflag, String eventImage) {
		super();
		this.name = name;
		this.startdate = startdate;
		this.enddate = enddate;
		this.eventflag = eventflag;
		this.eventImage = eventImage;
	}

	@Override
	public String toString() {
		return "AddAuctionEventRequest [name=" + name + ", startdate=" + startdate + ", enddate=" + enddate
				+ ", eventflag=" + eventflag + ", eventImage=" + eventImage + "]";
	}
	
}
