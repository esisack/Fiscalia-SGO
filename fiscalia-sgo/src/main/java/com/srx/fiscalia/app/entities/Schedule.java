package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the schedules database table.
 * 
 */
@Entity
@Table(name="schedules")
@NamedQuery(name="Schedule.findAll", query="SELECT s FROM Schedule s")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SCHEDULE_ID")
	private Integer scheduleId;

	private String analysis;

	private String asumptions;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="DUE_DATE")
	private Date dueDate;

	@Temporal(TemporalType.DATE)
	@Column(name="NOTIFICATION_DATE")
	private Date notificationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="PROCESS_TERM")
	private Date processTerm;

	private String status;

	@Temporal(TemporalType.DATE)
	@Column(name="SUBMISSION_DATE")
	private Date submissionDate;

	private String title;


	@OneToMany(mappedBy = "schedule")
	private List<Note> notes;
	
	public Schedule() {
	}

	public Integer getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getAnalysis() {
		return this.analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getAsumptions() {
		return this.asumptions;
	}

	public void setAsumptions(String asumptions) {
		this.asumptions = asumptions;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getNotificationDate() {
		return this.notificationDate;
	}

	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}

	public Date getProcessTerm() {
		return this.processTerm;
	}

	public void setProcessTerm(Date processTerm) {
		this.processTerm = processTerm;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSubmissionDate() {
		return this.submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (scheduleId != null ? scheduleId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		Schedule other = (Schedule) object;
		if ((this.scheduleId == null && other.scheduleId != null)
				|| (this.scheduleId != null && !this.scheduleId.equals(other.scheduleId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Schedule[ orderNum=" + scheduleId + " ]";
	}
}