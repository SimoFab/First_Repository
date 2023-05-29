package com.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional
@Repository
public class StudentRepositoryImpl implements StudentRepository {

	// Dependency Injection fornita da JPA sull'Entity Manager
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertStudent(Student student) {
		entityManager.persist(student);
	}

}
