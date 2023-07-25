package com.example.demo;

import com.example.demo.entity.Test;
import com.example.demo.repository.MemberCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJdbSampleApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringDataJdbSampleApplication.class, args)
				.getBean(SpringDataJdbSampleApplication.class).execute();
	}

	@Autowired
	MemberCrudRepository repository;

	private void execute(){
		executeInsert();
		executeSelect();
	}

	private void executeInsert(){
		Test test = new Test(null,"이순신");
		test = repository.save(test);
		System.out.println("등록데이터: "+test);
	}

	private void executeSelect(){
		System.out.println("전체데이터 취득");
		Iterable<Test> tests = repository.findAll();
		for(Test test : tests){
			System.out.println(test);
		}
	}

}
