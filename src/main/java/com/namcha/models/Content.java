package com.namcha.models;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Content {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private int count;
	private String id;
	private String category;
	private String eventName;
	private Date startDate;
	private Date endDate;
	private String startDateStr;
	private String endDateStr;
	private String location;
	private String description;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartDateStr() {
		return dateFormat.format(startDate);
	}

	public String getEndDateStr() {
		return dateFormat.format(endDate);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getButton() {
		String btnHTML = "<input type='button' class='btn btn-default' id='viewBtn" + count + "' onclick=\"window.location='event-view-share.html?share=true&id="+this.getId()+"'\" value='View'/>";
		return  btnHTML;
	}

}
