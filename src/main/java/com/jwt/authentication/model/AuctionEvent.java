package com.jwt.authentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AuctionEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String startdate;
	private String enddate;
	private String eventflag;
	private String eventImage;
	
	public AuctionEvent() {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public AuctionEvent(Integer id, String name, String startdate, String enddate, String eventflag,
			String eventImage) {
		super();
		this.id = id;
		this.name = name;
		this.startdate = startdate;
		this.enddate = enddate;
		this.eventflag = eventflag;
		this.eventImage = eventImage;
	}

	@Override
	public String toString() {
		return "AuctionEvent [id=" + id + ", name=" + name + ", startdate=" + startdate + ", enddate=" + enddate
				+ ", eventflag=" + eventflag + ", eventImage=" + eventImage + "]";
	}

}
