package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trial_models database table.
 * 
 */
@Entity
@Table(name="trial_models")
@NamedQuery(name="TrialModel.findAll", query="SELECT t FROM TrialModel t")
public class TrialModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TRIAL_MODEL_ID")
	private Integer trialModelId;

	private String analysis;

	private String asumptions;

	private String description;

	private String status;

	private String title;

	//bi-directional many-to-one association to ProcessType
	@ManyToOne
	@JoinColumn(name="PROCESS_TYPE_ID")
	private ProcessType processType;

	public TrialModel() {
	}

	public Integer getTrialModelId() {
		return this.trialModelId;
	}

	public void setTrialModelId(Integer trialModelId) {
		this.trialModelId = trialModelId;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		hash += (trialModelId != null ? trialModelId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		TrialModel other = (TrialModel) object;
		if ((this.trialModelId == null && other.trialModelId != null)
				|| (this.trialModelId != null && !this.trialModelId.equals(other.trialModelId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.TrialModel[ orderNum=" + trialModelId + " ]";
	}
}