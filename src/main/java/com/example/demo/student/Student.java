package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import jakarta.persistence.*;

@Entity
@Table
public class Student {
	@Id
	@SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	@Transient
	private Integer age;

	public Student() {
		this.id = 0L; // Set a default value for id, or leave it as null if it's nullable in the
						// database
		this.name = ""; // Set default value for name
		this.email = ""; // Set default value for email
		this.dob = LocalDate.of(2000, Month.JANUARY, 1); // Set a default date of birth
		this.age = 0; // Set default value for age
	}

	public Student(Long id, String name, String email, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", dob=" + dob
				+ ", age=" + age + '}';
	}
}
