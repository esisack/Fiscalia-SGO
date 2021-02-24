package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trial_team database table.
 * 
 */
@Entity
@Table(name="trial_team")
@NamedQuery(name="TrialTeam.findAll", query="SELECT t FROM TrialTeam t")
public class TrialTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TRIAL_TEAM_ID")
	private Integer trialTeamId;

	@Column(name="TRIAL_ID")
	private int trialId;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	public TrialTeam() {
	}

	public Integer getTrialTeamId() {
		return this.trialTeamId;
	}

	public void setTrialTeamId(Integer trialTeamId) {
		this.trialTeamId = trialTeamId;
	}

	public int getTrialId() {
		return this.trialId;
	}

	public void setTrialId(int trialId) {
		this.trialId = trialId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (trialTeamId != null ? trialTeamId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		TrialTeam other = (TrialTeam) object;
		if ((this.trialTeamId == null && other.trialTeamId != null)
				|| (this.trialTeamId != null && !this.trialTeamId.equals(other.trialTeamId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.TrialTeam[ orderNum=" + trialTeamId + " ]";
	}
}