package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the stages database table.
 * 
 */
@Entity
@Table(name="stages")
@NamedQuery(name="Stage.findAll", query="SELECT s FROM Stage s")
public class Stage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STAGE_ID")
	private Integer stageId;

	private int expiry;

	@Column(name="STAGE_CODE")
	private String stageCode;

	@Column(name="STAGE_NAME")
	private String stageName;
	
	//bi-directional many-to-one association to Activity
	@JsonBackReference
	@OneToMany(mappedBy="stage")
	private List<Activity> activities;

	//bi-directional many-to-one association to TrialStage
	@JsonBackReference
	@OneToMany(mappedBy="stage", fetch = FetchType.LAZY)
	private List<TrialStage> trialStages;

	//bi-directional many-to-one association to ProcessType
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="PROCESS_TYPE_ID")
	private ProcessType processType;

	public Stage() {
	}

	public Integer getStageId() {
		return this.stageId;
	}

	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}

	public int getExpiry() {
		return this.expiry;
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}

	public String getStageCode() {
		return this.stageCode;
	}

	public void setStageCode(String stageCode) {
		this.stageCode = stageCode;
	}

	public String getStageName() {
		return this.stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public List<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Activity addActivity(Activity stage) {
		getActivities().add(stage);
		stage.setStage(this);

		return stage;
	}

	public Activity removeActivity(Activity stage) {
		getActivities().remove(stage);
		stage.setStage(null);

		return stage;
	}

	public List<TrialStage> getTrialStages() {
		return this.trialStages;
	}

	public void setTrialStages(List<TrialStage> trialStages) {
		this.trialStages = trialStages;
	}

	public TrialStage addTrialStage(TrialStage trialStage) {
		getTrialStages().add(trialStage);
		trialStage.setStage(this);

		return trialStage;
	}

	public TrialStage removeTrialStage(TrialStage trialStage) {
		getTrialStages().remove(trialStage);
		trialStage.setStage(null);

		return trialStage;
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
		hash += (stageId != null ? stageId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		Stage other = (Stage) object;
		if ((this.stageId == null && other.stageId != null)
				|| (this.stageId != null && !this.stageId.equals(other.stageId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Stage[ orderNum=" + stageId + " ]";
	}
}