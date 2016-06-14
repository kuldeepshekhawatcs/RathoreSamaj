package com.society.domain;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.metamodel.source.annotations.attribute.type.LobTypeResolver;
import org.springframework.cglib.beans.BeanCopier.Generator;
@Entity
@Table(name="candidate")
public class Candidate implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
@Column
private String firstName;
@Column
private String middleName;
@Column	
private String lastName;
@Column	
private String age;
@Column	
private String dob;
@Column
	private String gender;
@Column
	private String candidateMobileNumber;
@Column
	private String parentMobileNumber;
@Column
	private String address;
@Column
	private String occupation;
@Column
	private String education;
@Column
	private String annualIncome;
@Column
	private String maritalStatus;
@Column
	private String location;
@Column
	private String profession;
@Column
	private String incomeLevel;
@Column
	private String height;
@Column
	private String religion;
@Column
	private String lifeStyle;
@Column

	private String language;
@Column
	private String diet;
@Column
	private String complexion;
@Column
	private String contactPerson;
@Column
@Lob
private Blob image;

	public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public Blob getImage() {
	return image;
}
public void setImage(Blob image) {
	this.image = image;
}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCandidateMobileNumber() {
		return candidateMobileNumber;
	}
	public void setCandidateMobileNumber(String candidateMobileNumber) {
		this.candidateMobileNumber = candidateMobileNumber;
	}
	public String getParentMobileNumber() {
		return parentMobileNumber;
	}
	public void setParentMobileNumber(String parentMobileNumber) {
		this.parentMobileNumber = parentMobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getIncomeLevel() {
		return incomeLevel;
	}
	public void setIncomeLevel(String incomeLevel) {
		this.incomeLevel = incomeLevel;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getLifeStyle() {
		return lifeStyle;
	}
	public void setLifeStyle(String lifeStyle) {
		this.lifeStyle = lifeStyle;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
	/**
	 * @return the complexion
	 */
	public String getComplexion() {
		return complexion;
	}
	/**
	 * @param complexion the complexion to set
	 */
	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}
	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}
	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
}
