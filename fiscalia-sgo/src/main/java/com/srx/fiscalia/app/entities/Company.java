package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the companies database table.
 * 
 */
@Entity
@Table(name="companies")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMPANY_ID")
	private Integer companyId;

	private String address;

	private String city;

	@Column(name="CITY_ID")
	private int cityId;

	@Column(name="COMPANY_CODE")
	private String companyCode;

	@Column(name="COMPANY_NAME")
	private String companyName;

	@Column(name="COMPANY_TYPE")
	private String companyType;

	private int fax;

	private String mail;

	private int phone;

	private String status;
	
	@JsonBackReference
	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="company")
	private Set<Trial> trialsByCompany;
	
	@JsonBackReference
	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="attorney")
	private Set<Trial> trialsByAttorney;

	public Company() {
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyType() {
		return this.companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public int getFax() {
		return this.fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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


	public Set<Trial> getTrialsByCompany() {
		return trialsByCompany;
	}

	public void setTrialsByCompany(Set<Trial> trialsByCompany) {
		this.trialsByCompany = trialsByCompany;
	}

	public Set<Trial> getTrialsByAttorney() {
		return trialsByAttorney;
	}

	public void setTrialsByAttorney(Set<Trial> trialsByAttorney) {
		this.trialsByAttorney = trialsByAttorney;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (companyId != null ? companyId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		Company other = (Company) object;
		if ((this.companyId == null && other.companyId != null)
				|| (this.companyId != null && !this.companyId.equals(other.companyId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Activity[ orderNum=" + companyId + " ]";
	}
}