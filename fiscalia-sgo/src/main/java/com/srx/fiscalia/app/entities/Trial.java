package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the trials database table.
 * 
 */
@Entity
@Table(name="trials")
public class Trial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TRIAL_ID")
	private Integer trialId;

	private String analysis;

	private String asumptions;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="DUE_DATE")
	private Date dueDate;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="NOTIFICATION_DATE")
	private Date notificationDate;

	private int progress;

	private String status;

	@Temporal(TemporalType.DATE)
	@Column(name="SUBMISSION_DATE")
	private Date submissionDate;

	private String title;

	//bi-directional many-to-one association to File
	@OneToMany(mappedBy="trial")
	private List<File> files;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="trial")
	private List<Note> notes;

	//bi-directional many-to-one association to TrialStage
	@OneToMany(mappedBy="trial")
	private List<TrialStage> trialStages;

	@JsonManagedReference
	//bi-directional many-to-one association to Employee
	@ManyToOne()
	@JoinColumn(name="COMPANY_ID")
	private Company company;
	
	@JsonManagedReference
	//bi-directional many-to-one association to Employee
	@ManyToOne()
	@JoinColumn(name="ATTORNEY_ID")
	private Company attorney;
	
	@JsonManagedReference
	//bi-directional many-to-one association to Court
	@ManyToOne()
	@JoinColumn(name="COURT_ID")
	private Court court;

	@JsonManagedReference
	//bi-directional many-to-one association to Employee
	@ManyToOne()
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	@JsonManagedReference
	//bi-directional many-to-one association to ProcessType
	@ManyToOne()
	@JoinColumn(name="PROCESS_TYPE_ID")
	private ProcessType processType;

	public Trial() {
	}

	public Integer getTrialId() {
		return this.trialId;
	}

	public void setTrialId(Integer trialId) {
		this.trialId = trialId;
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

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getNotificationDate() {
		return this.notificationDate;
	}

	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}

	public int getProgress() {
		return this.progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
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

	public List<File> getFiles() {
		return this.files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public File addFile(File file) {
		getFiles().add(file);
		file.setTrial(this);

		return file;
	}

	public File removeFile(File file) {
		getFiles().remove(file);
		file.setTrial(null);

		return file;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setTrial(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setTrial(null);

		return note;
	}

	public List<TrialStage> getTrialStages() {
		return this.trialStages;
	}

	public void setTrialStages(List<TrialStage> trialStages) {
		this.trialStages = trialStages;
	}

	public TrialStage addTrialStage(TrialStage trialStage) {
		getTrialStages().add(trialStage);
		trialStage.setTrial(this);

		return trialStage;
	}

	public TrialStage removeTrialStage(TrialStage trialStage) {
		getTrialStages().remove(trialStage);
		trialStage.setTrial(null);

		return trialStage;
	}

	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Company getAttorney() {
		return attorney;
	}

	public void setAttorney(Company attorney) {
		this.attorney = attorney;
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

	public ProcessType getProcessType() {
		return this.processType;
	}

	public void setProcessType(ProcessType processType) {
		this.processType = processType;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (trialId != null ? trialId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		Trial other = (Trial) object;
		if ((this.trialId == null && other.trialId != null)
				|| (this.trialId != null && !this.trialId.equals(other.trialId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Activity[ orderNum=" + trialId + " ]";
	}
}