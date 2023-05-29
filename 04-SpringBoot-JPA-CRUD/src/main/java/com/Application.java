package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Student;
import com.service.StudentService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	@Resource(name = "studentToInsert1")
	private Student studentToInsert1;

	@Resource(name = "studentToInsert2")
	private Student studentToInsert2;

	@Resource(name = "studentToInsert3")
	private Student studentToInsert3;

	@Resource(name = "studentToInsert4")
	private Student studentToInsert4;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		studentService.insertStudent(studentToInsert1);
		studentService.insertStudent(studentToInsert2);
		studentService.insertStudent(studentToInsert3);
		studentService.insertStudent(studentToInsert4);

	}

}
