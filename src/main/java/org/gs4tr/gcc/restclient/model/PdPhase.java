package org.gs4tr.gcc.restclient.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PdPhase extends GCBasicModel {

	@JsonProperty("dateEnded")
	private Date dateEnded;
	@JsonProperty("dueDate")
	private DueDate dueDate;
	@JsonProperty("name")
	private String name;
	@JsonProperty("status")
	private PdPhaseStatus pdPhaseStatus;

	public PdPhase() {

	}

	public Date getDateEnded() {
		return dateEnded;
	}

	public void setDateEnded(Date dateEnded) {
		this.dateEnded = dateEnded;
	}

	public DueDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(DueDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PdPhaseStatus getPdPhaseStatus() {
		return pdPhaseStatus;
	}

	public void setPdPhaseStatus(PdPhaseStatus pdPhaseStatus) {
		this.pdPhaseStatus = pdPhaseStatus;
	}

	public static class DueDate {
		@JsonProperty("critical")
		private Boolean isCritical;
		@JsonProperty("date")
		private Date date;

		public DueDate() {

		}

		public Boolean getIsCritical() {
			return isCritical;
		}

		public void setIsCritical(Boolean isCritical) {
			this.isCritical = isCritical;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
	}

	public static class PdPhaseStatus {
		@JsonProperty("name")
		private String name;
		@JsonProperty("value")
		private Long value;

		public PdPhaseStatus() {

		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getValue() {
			return value;
		}

		public void setValue(Long value) {
			this.value = value;
		}

	}
}
