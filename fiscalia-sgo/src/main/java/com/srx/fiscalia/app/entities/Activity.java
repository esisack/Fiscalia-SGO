package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the activities database table.
 * 
 */
@Entity
@Table(name="activities")
@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ACTIVITY_ID")
	private Integer activityId;

	@Column(name="ACTIVITY_CODE")
	private String activityCode;

	@Column(name="ACTIVITY_NAME")
	private String activityName;

	private int expiry;

	//bi-directional many-to-one association to Stage
	@ManyToOne
	@JoinColumn(name="STAGE_ID")
	private Stage stage;

	//bi-directional many-to-one association to TrialStage
	@OneToMany(mappedBy="activity")
	private List<TrialStage> trialStages;

	public Activity() {
	}

	public Integer getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityCode() {
		return this.activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public int getExpiry() {
		return this.expiry;
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}

	public Stage getStage() {
		return this.stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public List<TrialStage> getTrialStages() {
		return this.trialStages;
	}

	public void setTrialStages(List<TrialStage> trialStages) {
		this.trialStages = trialStages;
	}

	public TrialStage addTrialStage(TrialStage trialStage) {
		getTrialStages().add(trialStage);
		trialStage.setActivity(this);

		return trialStage;
	}

	public TrialStage removeTrialStage(TrialStage trialStage) {
		getTrialStages().remove(trialStage);
		trialStage.setActivity(null);

		return trialStage;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (activityId != null ? activityId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		Activity other = (Activity) object;
		if ((this.activityId == null && other.activityId != null)
				|| (this.activityId != null && !this.activityId.equals(other.activityId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Activity[ orderNum=" + activityId + " ]";
	}

}