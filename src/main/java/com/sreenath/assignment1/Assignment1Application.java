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
		collegeSubject ooad = new collegeSubject("OOAD with Java", "Object Oriented Design with Java");
		collegeSubject cd = new collegeSubject("CD", "Compiler Design");
		collegeSubject cc = new collegeSubject("CC", "Cloud Computing");
		collegeSubject tdl = new collegeSubject("TDL", "Topics in Deep Learning");
		collegeSubject air=new collegeSubject("AIR","Algorithms for Information Retrieval");

		subjectRepository.save(ooad);
		subjectRepository.save(cd);
		subjectRepository.save(cc);
		subjectRepository.save(tdl);
		subjectRepository.save(air);

		List<Student> students = new LinkedList<>();
		students.add(new Student("John", "Smith", "john.smith@example.com",
				Arrays.asList(ooad,cd,cc)));
		students.add(new Student("Mark", "Johnson", "mjohnson@example.com",
				Arrays.asList(cc,tdl)));
		students.add(new Student("Michael", "Williams", "michael.williams@example.com",
				Arrays.asList(air,cd,ooad)));
		students.add(new Student("Fred", "Miller", "f.miller@example.com",
				Arrays.asList(cd,cc,tdl,air)));
		students.add(new Student("Bob", "Brown", "brown@example.com",
				Arrays.asList(ooad)));
		for(Student temp:students)
		{
			studentRepository.save(temp);
		}
//		studentRepository.save(students);
	}
}
