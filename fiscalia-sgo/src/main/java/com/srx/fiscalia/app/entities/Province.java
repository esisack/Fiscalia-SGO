package com.srx.fiscalia.app.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the provinces database table.
 * 
 */
@Entity
@Table(name="provinces")
@NamedQuery(name="Province.findAll", query="SELECT p FROM Province p")
public class Province implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROVINCE_ID")
	private Integer provinceId;

	@Column(name="PROVINCE_CODE")
	private String provinceCode;

	@Column(name="PROVINCE_NAME")
	private String provinceName;

	private String status;
	

	//bi-directional many-to-one association to City
	@JsonBackReference
	@OneToMany(mappedBy="province")
	private List<City> cities;


	//bi-directional many-to-one association to Country
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	public Province() {
	}

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceCode() {
		return this.provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		city.setProvince(this);

		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		city.setProvince(null);

		return city;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (provinceId != null ? provinceId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		Province other = (Province) object;
		if ((this.provinceId == null && other.provinceId != null)
				|| (this.provinceId != null && !this.provinceId.equals(other.provinceId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.srx.model.entities.Province[ orderNum=" + provinceId + " ]";
	}
}