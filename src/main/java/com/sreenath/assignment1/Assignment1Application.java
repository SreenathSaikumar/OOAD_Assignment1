package com.sreenath.assignment1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment1Application implements CommandLineRunner {
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	collegeSubjectRepository subjectRepository;

	public static void main(String[] args) {
		SpringApplication.run(Assignment1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		collegeSubject javascript = new collegeSubject("javascript", "Javascript language skill");
		collegeSubject ruby = new collegeSubject("ruby", "Ruby language skill");
		collegeSubject emberjs = new collegeSubject("emberjs", "Emberjs framework");
		collegeSubject angularjs = new collegeSubject("angularjs", "Angularjs framework");

		subjectRepository.save(javascript);
		subjectRepository.save(ruby);
		subjectRepository.save(emberjs);
		subjectRepository.save(angularjs);

		List<Student> students = new LinkedList<>();
		students.add(new Student("John", "Smith", "john.smith@example.com",
				Arrays.asList(javascript, ruby)));
		students.add(new Student("Mark", "Johnson", "mjohnson@example.com",
				Arrays.asList(emberjs, ruby)));
		students.add(new Student("Michael", "Williams", "michael.williams@example.com",
				Arrays.asList(angularjs, ruby)));
		students.add(new Student("Fred", "Miller", "f.miller@example.com",
				Arrays.asList(emberjs, angularjs, javascript)));
		students.add(new Student("Bob", "Brown", "brown@example.com",
				Arrays.asList(emberjs)));
		for(Student temp:students)
		{
			studentRepository.save(temp);
		}
//		studentRepository.save(students);
	}
}
