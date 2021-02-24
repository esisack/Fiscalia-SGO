package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the process_types database table.
 * 
 */
@Entity
@Table(name="process_types")
public class ProcessType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROCESS_TYPE_ID")
	private Integer processTypeId;

	@Column(name="PROCESS_TYPE_CODE")
	private String processTypeCode;

	@Column(name="PROCESS_TYPE_NAME")
	private String processTypeName;

	//bi-directional many-to-one association to Stage
	@JsonBackReference
	@OneToMany(mappedBy="processType")
	private List<Stage> stages;

	//bi-directional many-to-one association to TrialModel
	@JsonBackReference
	@OneToMany(mappedBy="processType")
	private List<TrialModel> trialModels;

	//bi-directional many-to-one association to Trial
	@JsonBackReference
	@OneToMany(mappedBy="processType")
	private List<Trial> trials;

	public ProcessType() {
	}

	public Integer getProcessTypeId() {
		return this.processTypeId;
	}

	public void setProcessTypeId(Integer processTypeId) {
		this.processTypeId = processTypeId;
	}

	public String getProcessTypeCode() {
		return this.processTypeCode;
	}

	public void setProcessTypeCode(String processTypeCode) {
		this.processTypeCode = processTypeCode;
	}

	public String getProcessTypeName() {
		return this.processTypeName;
	}

	public void setProcessTypeName(String processTypeName) {
		this.processTypeName = processTypeName;
	}

	public List<Stage> getStages() {
		return this.stages;
	}

	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}

	public Stage addStage(Stage stage) {
		getStages().add(stage);
		stage.setProcessType(this);

		return stage;
	}

	public Stage removeStage(Stage stage) {
		getStages().remove(stage);
		stage.setProcessType(null);

		return stage;
	}

	public List<TrialModel> getTrialModels() {
		return this.trialModels;
	}

	public void setTrialModels(List<TrialModel> trialModels) {
		this.trialModels = trialModels;
	}

	public TrialModel addTrialModel(TrialModel trialModel) {
		getTrialModels().add(trialModel);
		trialModel.setProcessType(this);

		return trialModel;
	}

	public TrialModel removeTrialModel(TrialModel trialModel) {
		getTrialModels().remove(trialModel);
		trialModel.setProcessType(null);

		return trialModel;
	}

	public List<Trial> getTrials() {
		return this.trials;
	}

	public void setTrials(List<Trial> trials) {
		this.trials = trials;
	}

	public Trial addTrial(Trial trial) {
		getTrials().add(trial);
		trial.setProcessType(this);

		return trial;
	}

	public Trial removeTrial(Trial trial) {
		getTrials().remove(trial);
		trial.setProcessType(null);

		return trial;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (processTypeId != null ? processTypeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		ProcessType other = (ProcessType) object;
		if ((this.processTypeId == null && other.processTypeId != null)
				|| (this.processTypeId != null && !this.processTypeId.equals(other.processTypeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.ProcessType[ orderNum=" + processTypeId + " ]";
	}
}