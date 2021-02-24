package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the jobs database table.
 * 
 */
@Entity
@Table(name="jobs")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JOB_ID")
	private Integer jobId;

	@Column(name="JOB_AREA_ID")
	private int jobAreaId;

	@Column(name="JOB_DESCRIPTION")
	private String jobDescription;

	@Column(name="JOB_NAME")
	private String jobName;

	//bi-directional many-to-one association to Employee
	@JsonBackReference
	@OneToMany(mappedBy="job")
	private List<Employee> employees;

	//bi-directional many-to-one association to Job
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="PARENT_JOB")
	private Job job;

	//bi-directional many-to-one association to Job
	@JsonBackReference
	@OneToMany(mappedBy="job")
	private List<Job> jobs;

	public Job() {
	}

	public Integer getJobId() {
		return this.jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public int getJobAreaId() {
		return this.jobAreaId;
	}

	public void setJobAreaId(int jobAreaId) {
		this.jobAreaId = jobAreaId;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setJob(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setJob(null);

		return employee;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Job addJob(Job job) {
		getJobs().add(job);
		job.setJob(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setJob(null);

		return job;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (jobId != null ? jobId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		Job other = (Job) object;
		if ((this.jobId == null && other.jobId != null)
				|| (this.jobId != null && !this.jobId.equals(other.jobId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Job[ orderNum=" + jobId + " ]";
	}
}