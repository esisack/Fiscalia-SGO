package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the trialStages database table.
 * 
 */
@Entity
@Table(name="trialStages")
public class TrialStage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TRIAL_STAGE_ID")
	private Integer trialStageId;

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

	//bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumn(name="ACTIVITY_ID")
	private Activity activity;

	//bi-directional many-to-one association to Court
	@ManyToOne
	@JoinColumn(name="COURT_ID")
	private Court court;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	//bi-directional many-to-one association to Stage
	@ManyToOne
	@JoinColumn(name="STAGE_ID")
	private Stage stage;

	//bi-directional many-to-one association to Trial
	@ManyToOne
	@JoinColumn(name="TRIAL_ID")
	private Trial trial;

	public TrialStage() {
	}

	public Integer getTrialStageId() {
		return this.trialStageId;
	}

	public void setTrialStageId(Integer trialStageId) {
		this.trialStageId = trialStageId;
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

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Court getCourt() {
		return this.court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Stage getStage() {
		return this.stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Trial getTrial() {
		return this.trial;
	}

	public void setTrial(Trial trial) {
		this.trial = trial;
	}


}