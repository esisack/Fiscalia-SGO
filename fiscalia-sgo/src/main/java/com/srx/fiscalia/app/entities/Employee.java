package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID")
	private Integer employeeId;

	private String address;

	@Column(name="CELL_PHONE")
	private int cellPhone;

	private String city;

	@Column(name="EMPLOYEE_CODE")
	private String employeeCode;

	private String enabled;

	private int extension;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String mail;

	@Column(name="OTHER_PHONE")
	private int otherPhone;

	private int phone;

	private String status;

	//bi-directional many-to-one association to Contact
	@JsonBackReference
	@OneToMany(mappedBy="employee")
	private List<Contact> contacts;


	@JsonManagedReference
	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="CITY_ID")
	private City cityBean;


	//bi-directional many-to-one association to Country
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;


	//bi-directional many-to-one association to Job
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	private Job job;



	//bi-directional many-to-one association to User
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	//bi-directional many-to-one association to Evento
	@JsonBackReference
	@OneToMany(mappedBy="employee", fetch = FetchType.LAZY)
	private List<Evento> eventos;

	//bi-directional many-to-one association to Issue
	@JsonBackReference
	@OneToMany(mappedBy="employee1", fetch = FetchType.LAZY)
	private List<Issue> issues1;

	//bi-directional many-to-one association to Issue
	@JsonBackReference
	@OneToMany(mappedBy="employee2", fetch = FetchType.LAZY)
	private List<Issue> issues2;

	//bi-directional many-to-one association to TrialStage
	@JsonBackReference
	@OneToMany(mappedBy="employee", fetch = FetchType.LAZY)
	private List<TrialStage> trialStages;

	//bi-directional many-to-one association to TrialTeam
	@JsonBackReference
	@OneToMany(mappedBy="employee", fetch = FetchType.LAZY)
	private List<TrialTeam> trialTeams;

	//bi-directional many-to-one association to Trial
	@JsonBackReference
	@OneToMany(mappedBy="employee", fetch = FetchType.LAZY)
	private List<Trial> trials;

	public Employee() {
	}

	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(int cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public int getExtension() {
		return this.extension;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getOtherPhone() {
		return this.otherPhone;
	}

	public void setOtherPhone(int otherPhone) {
		this.otherPhone = otherPhone;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setEmployee(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setEmployee(null);

		return contact;
	}

	public City getCityBean() {
		return this.cityBean;
	}

	public void setCityBean(City cityBean) {
		this.cityBean = cityBean;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setEmployee(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setEmployee(null);

		return evento;
	}

	public List<Issue> getIssues1() {
		return this.issues1;
	}

	public void setIssues1(List<Issue> issues1) {
		this.issues1 = issues1;
	}

	public Issue addIssues1(Issue issues1) {
		getIssues1().add(issues1);
		issues1.setEmployee1(this);

		return issues1;
	}

	public Issue removeIssues1(Issue issues1) {
		getIssues1().remove(issues1);
		issues1.setEmployee1(null);

		return issues1;
	}

	public List<Issue> getIssues2() {
		return this.issues2;
	}

	public void setIssues2(List<Issue> issues2) {
		this.issues2 = issues2;
	}

	public Issue addIssues2(Issue issues2) {
		getIssues2().add(issues2);
		issues2.setEmployee2(this);

		return issues2;
	}

	public Issue removeIssues2(Issue issues2) {
		getIssues2().remove(issues2);
		issues2.setEmployee2(null);

		return issues2;
	}

	public List<TrialStage> getTrialStages() {
		return this.trialStages;
	}

	public void setTrialStages(List<TrialStage> trialStages) {
		this.trialStages = trialStages;
	}

	public TrialStage addTrialStage(TrialStage trialStage) {
		getTrialStages().add(trialStage);
		trialStage.setEmployee(this);

		return trialStage;
	}

	public TrialStage removeTrialStage(TrialStage trialStage) {
		getTrialStages().remove(trialStage);
		trialStage.setEmployee(null);

		return trialStage;
	}

	public List<TrialTeam> getTrialTeams() {
		return this.trialTeams;
	}

	public void setTrialTeams(List<TrialTeam> trialTeams) {
		this.trialTeams = trialTeams;
	}

	public TrialTeam addTrialTeam(TrialTeam trialTeam) {
		getTrialTeams().add(trialTeam);
		trialTeam.setEmployee(this);

		return trialTeam;
	}

	public TrialTeam removeTrialTeam(TrialTeam trialTeam) {
		getTrialTeams().remove(trialTeam);
		trialTeam.setEmployee(null);

		return trialTeam;
	}

	public List<Trial> getTrials() {
		return this.trials;
	}

	public void setTrials(List<Trial> trials) {
		this.trials = trials;
	}

	public Trial addTrial(Trial trial) {
		getTrials().add(trial);
		trial.setEmployee(this);

		return trial;
	}

	public Trial removeTrial(Trial trial) {
		getTrials().remove(trial);
		trial.setEmployee(null);

		return trial;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (employeeId != null ? employeeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		Employee other = (Employee) object;
		if ((this.employeeId == null && other.employeeId != null)
				|| (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Employee[ orderNum=" + employeeId + " ]";
	}
}