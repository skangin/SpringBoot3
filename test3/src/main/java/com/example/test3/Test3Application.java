package com.example.test3;

import com.example.test3.entity.Test;
import com.example.test3.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test3Application {

	public static void main(String[] args) {
		SpringApplication.run(Test3Application.class, args)
				.getBean(Test3Application.class).execute();
	}

	@Autowired
	TestRepository repository;

	private void execute(){
		setup();
	}

	private void setup(){
		System.out.println("--- 등록 처리 개시 ---");
		Test test1 = new Test(null,"JDK는 JRE와 컴파일러 등의 개발도구가 포함된다", true, "오윤석");

		Test test2 = new Test(null,"자바 프로그램을 개발하려면 JDK가 반드시 필요하다", true, "오윤석");

		Test test3 = new Test(null, "바이트 코드는 JVM이 독립적이지만 JVM은 운영체제에 종속적이다.", true, "오윤석");
		Test test4 = new Test(null,"자바 프로그램을 실행만 하려면 JRE를 설치해도 상관없다", true, "오윤석");
		Test test5 = new Test(null,"JVM은 운영체제별로 동일한 JVM이 사용된다.", false, "홍길동");
		//엔티티 생성

		//리스트에 엔티티를 저장
		List<Test> testList = new ArrayList<>();
		Collections.addAll(testList,test1,test2,test3,test4,test5);

		//등록 실행
		for(Test test : testList){
			service.insertTest(test);
		}

		System.out.println("등록처리 완료");
		//등록 확인



	}

	private void showList(){
		System.out.println("--- 모든 데이터 취득 개시 ---");
		Iterable<Test> testzes = service.selectAll();
		for(Test test : testzes){
			System.out.println(test);
		}
		System.out.println("--- 모든 데이터 취득 완료 ---");
	}

	private void showOne(){
		System.out.println("--- 1건 취득 개시 ---");
		Optional<Test> testOpt = service.selectOneById(1);
		if(testOpt.isPresent()){
			System.out.println(testOpt.get());
		}else{
			System.out.println("해당 데이터는 존재 하지 않습니다.");
		}
		System.out.println("--- 1건 취득 완료 ---");

}
