package com.example.demo;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class DemoApplication {

	@Bean
	CommandLineRunner insert(StudentRepository r) {
		Student s = new Student();
		s.setDob(LocalDate.of(2000, Month.DECEMBER, 14));
		s.setEmail("AAA@BBB.com");
		s.setName("AAA");
		r.save(s);
		return null;
	}
	@Bean
	CommandLineRunner insert2(StudentRepository r) {
		Student S = new Student();
		S.setDob(LocalDate.of(1992, Month.JANUARY, 5));
		S.setEmail("BBB@CCC.com");
		S.setName("BBB");
		r.save(S);
		return null;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}