package com.example.demo.entity;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Student_Table")
public class Student {

	@Id
	@GeneratedValue
	private int id;

	@Size(min = 3, message = "First name must be at least 3 characters")
	private String firstName;

	@Size(min = 3, message = "Last name must be at least 3 characters")
	private String lastName;

	@NotNull(message = "Date of Birth is mandatory")
	private LocalDate dob;

	@Pattern(regexp = "^[ABC]$", message = "Section should be either 'A', 'B', or 'C'")
	private String section;

	@Pattern(regexp = "^[MF]$", message = "Gender should be either 'M' or 'F'")
	private String gender;

	@Min(value = 0, message = "Marks should not be less than 0")
	@Max(value = 100, message = "Marks should not be greater than 100")
	private int mark1;

	@Min(value = 0, message = "Marks should not be less than 0")
	@Max(value = 100, message = "Marks should not be greater than 100")
	private int mark2;

	@Min(value = 0, message = "Marks should not be less than 0")
	@Max(value = 100, message = "Marks should not be greater than 100")
	private int mark3;

	private double total;

	private double average;

	private double result;

	public Student(int id, String firstName, String lastName, LocalDate dob, String section, String gender, int mark1,
			int mark2, int mark3, double total, double average, double result) {

		LocalDate curDate = LocalDate.now();

		if ((dob != null) && (curDate != null)) {
			int years = Period.between(dob, curDate).getYears();

			if (years < 15 || years > 20)
				throw new IllegalArgumentException(
						"Age should be greater than 15 year and less than or equal to 20 years.");
		}

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.section = section;
		this.gender = gender;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
		this.total = total;
		this.average = average;
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMark1() {
		return mark1;
	}

	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}

	public int getMark2() {
		return mark2;
	}

	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}

	public int getMark3() {
		return mark3;
	}

	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", section=" + section + ", gender=" + gender + ", mark1=" + mark1 + ", mark2=" + mark2 + ", mark3="
				+ mark3 + ", total=" + total + ", average=" + average + ", result=" + result + "]";
	}

}
