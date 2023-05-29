package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repository.StudentRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.TransactionRequiredException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void insertStudent(Student student) {
		try {
			studentRepository.insertStudent(student);
			System.out.println("Inserimento avvenuto con successo");
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			System.err.println("Inserimento falito.");
		}
	}

}
