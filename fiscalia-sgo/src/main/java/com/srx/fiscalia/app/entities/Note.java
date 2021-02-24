package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the notes database table.
 * 
 */
@Entity
@Table(name="notes")
@NamedQuery(name="Note.findAll", query="SELECT n FROM Note n")
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NOTE_ID")
	private Integer noteId;

	private String description;

	@ManyToOne
	@JoinColumn(name="SCHEDULE_ID")
	private Schedule schedule;

	private String status;

	private String title;

	//bi-directional many-to-one association to Trial
	@ManyToOne
	@JoinColumn(name="TRIAL_ID")
	private Trial trial;

	public Note() {
	}

	public Integer getNoteId() {
		return this.noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
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

	public Trial getTrial() {
		return this.trial;
	}

	public void setTrial(Trial trial) {
		this.trial = trial;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (noteId != null ? noteId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		Note other = (Note) object;
		if ((this.noteId == null && other.noteId != null)
				|| (this.noteId != null && !this.noteId.equals(other.noteId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Note[ orderNum=" + noteId + " ]";
	}
}