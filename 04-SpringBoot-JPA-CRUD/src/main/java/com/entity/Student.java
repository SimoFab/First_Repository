package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

/*
 * Se il Persistence Provider è Hibernate, possiamo anche omettere l'implements Serializable
 * sull'entity poiché lo fa lui in automatico. Questo non avviene con altri PP come ad esempio
 * Eclipse Link, che considererebbe questa omissione come un errore
 */

@Entity
@NamedQueries({ @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
		@NamedQuery(name = "Student.findAllByLastName", query = "SELECT s FROM Student s WHERE s.lastName = :lastName"),
		@NamedQuery(name = "Student.findAllByLastNameOrderByLastNameDesc", query = "SELECT s FROM Student s WHERE s.lastName = :lastName ORDER BY s.lastName DESC"),
		@NamedQuery(name = "Student.findAllByLastNameStartingWith", query = "SELECT s FROM Student s WHERE s.lastName LIKE :prefix"), // baeldung
																																		// docet
		@NamedQuery(name = "Student.findAllByAgeGreaterThan", query = "SELECT s FROM Student s WHERE s.age > :age") })
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private Integer age;

	// Jpa vuole che esista cmq il costruttore vuoto di default (ed Hibernate
	// controllerà che esista) anche se ne esistono altri custom
	protected Student() {
	}

	// Costruttore per l'insert
	public Student(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	// Costruttore per l'update
	public Student(Integer id, String firstName, String lastName, Integer age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student id: " + id + "\nFirst name: " + firstName + "\nLast name: " + lastName + "\nAge: " + age + "\n";
	}

}
