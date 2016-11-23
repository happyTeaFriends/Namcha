package com.namcha.models;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Content {
	private String id;
	private String category;
	private String eventName;
	private OffsetDateTime startDate;
	private String startDateStr;
	private OffsetDateTime endDate;
	private String endDateStr;
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

	public OffsetDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}

	public OffsetDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(OffsetDateTime endDate) {
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

	public String getButton() { return button; }

	public void setButton(String button) { this.button = button; }

	public String getStartDateStr() { return this.startDate.format(DateTimeFormatter.ISO_LOCAL_DATE); }

	public String getEndDateStr() { return this.endDate.format(DateTimeFormatter.ISO_LOCAL_DATE); }
}
