package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.entity.Student;

@Configuration
public class EntityBeanConfiguration {

	@Bean(name = "studentToInsert1")
	public Student getStudentToInsert1() {
		return new Student("Michele", "Cerqua", 18);
	}

	@Bean(name = "studentToInsert2")
	public Student getStudentToInsert2() {
		return new Student("Miguel", "Cerquas", 19);
	}

	@Bean(name = "studentToInsert3")
	public Student getStudentToInsert3() {
		return new Student("Mihail", "Cerkwoskji", 19);
	}

	@Bean(name = "studentToInsert4")
	public Student getStudentToInsert4() {
		return new Student("Michelle", "Cerqouis", 19);
	}

}
