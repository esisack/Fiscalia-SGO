package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the courts database table.
 * 
 */
@Entity
@Table(name="courts")
@NamedQuery(name="Court.findAll", query="SELECT c FROM Court c")
public class Court implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COURT_ID")
	private Integer courtId;

	private String address;

	@Column(name="CITY_ID")
	private int cityId;

	@Column(name="COURT_NAME")
	private String courtName;

	private String nomination;

	private String status;


	//bi-directional many-to-one association to TrialStage
	@JsonBackReference
	@OneToMany(mappedBy="court")
	private List<TrialStage> trialStages;


	//bi-directional many-to-one association to Trial
	@JsonBackReference
	@OneToMany(mappedBy="court")
	private List<Trial> trials;

	public Court() {
	}

	public Integer getCourtId() {
		return this.courtId;
	}

	public void setCourtId(Integer courtId) {
		this.courtId = courtId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCourtName() {
		return this.courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public String getNomination() {
		return this.nomination;
	}

	public void setNomination(String nomination) {
		this.nomination = nomination;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<TrialStage> getTrialStages() {
		return this.trialStages;
	}

	public void setTrialStages(List<TrialStage> trialStages) {
		this.trialStages = trialStages;
	}

	public TrialStage addTrialStage(TrialStage trialStage) {
		getTrialStages().add(trialStage);
		trialStage.setCourt(this);

		return trialStage;
	}

	public TrialStage removeTrialStage(TrialStage trialStage) {
		getTrialStages().remove(trialStage);
		trialStage.setCourt(null);

		return trialStage;
	}

	public List<Trial> getTrials() {
		return this.trials;
	}

	public void setTrials(List<Trial> trials) {
		this.trials = trials;
	}

	public Trial addTrial(Trial trial) {
		getTrials().add(trial);
		trial.setCourt(this);

		return trial;
	}

	public Trial removeTrial(Trial trial) {
		getTrials().remove(trial);
		trial.setCourt(null);

		return trial;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (courtId != null ? courtId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		Court other = (Court) object;
		if ((this.courtId == null && other.courtId != null)
				|| (this.courtId != null && !this.courtId.equals(other.courtId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Activity[ orderNum=" + courtId + " ]";
	}
}