package com.namcha.models;

import java.util.Date;

import com.namcha.utils.DateUtil;

public class Content {
	private String id;
	private String category;
	private String eventName;
	private Date startDate;
	private Date endDate;
	private String location;
	private String description;
	private String button;

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

	public String getButton() { return "<a href=\"event-view-share.html?id=" + this.getId() + "&share=true\"><button type=\"button\" class=\"btn btn-default\">View</button></a>"; }

	public String getStartDateStr() { return DateUtil.convertToString(this.startDate); }

	public String getEndDateStr() { return DateUtil.convertToString(this.endDate); }
}
