package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the areas database table.
 * 
 */
@Entity
@Table(name="areas")
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AREA_ID")
	private Integer areaId;

	private String address;

	@Column(name="AREA_NAME")
	private String areaName;

	private String status;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="PARENT_AREA_ID")
	private Area area;

	//bi-directional many-to-one association to Area
	@OneToMany(mappedBy="area")
	private List<Area> areas;

	public Area() {
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Area addArea(Area area) {
		getAreas().add(area);
		area.setArea(this);

		return area;
	}

	public Area removeArea(Area area) {
		getAreas().remove(area);
		area.setArea(null);

		return area;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (areaId != null ? areaId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		Area other = (Area) object;
		if ((this.areaId == null && other.areaId != null)
				|| (this.areaId != null && !this.areaId.equals(other.areaId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Activity[ orderNum=" + areaId + " ]";
	}
}