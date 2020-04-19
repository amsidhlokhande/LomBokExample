package com.amsidh.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity(name = "PERSON")
public class PersonEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 111527763810280438L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer personId;
	private String name;
	private Date dateOfBirth;

	@Embedded
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "ADDRESS", joinColumns = { @JoinColumn(name = "PERSONID") })
	private List<AddressEntity> address = new ArrayList<AddressEntity>();

	public PersonEntity() {
		super();
	}

	public PersonEntity(Integer personId, String name, Date dateOfBirth, List<AddressEntity> address) {
		super();
		this.personId = personId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<AddressEntity> getAddress() {
		return address;
	}

	public void setAddress(List<AddressEntity> address) {
		this.address.addAll(address);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonEntity other = (PersonEntity) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersonEntity [personId=" + personId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address="
				+ address + "]";
	}

}
