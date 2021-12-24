package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/*
 * Test code
  	- Junit 4.10 이상의 버전을 사용해야 한다
 */

// 테스트 시 필요한 클래스를 지정
@RunWith(SpringJUnit4ClassRunner.class)
// 스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지 명시(root-context.xml의 경로를 지정)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// Lombok을 이용해서 로그를 기록하는 Logger를 변수로 생성(Log4j의 라이브러리와 설정이 존재한다면 바로 사용 가능)
@Log4j
public class SampleTests {
	
	// 정상적으로 주입이 가능하다면 Restaurant 타입의 객체를 주입 
	@Setter(onMethod_ = {@Autowired}) // setter 메서드의 생성 시 메서드에 추가할 어노테이션을 지정
	private Restaurant restaurant;
	// JUnit에서 해당 메서드가 jUnit 상에서 단위 테스트의 대상인지를 알려줌
	@Test
	public void testExist() {
		assertNotNull(restaurant); // restaurant 변수가 null이 아니어야만 테스트 성공한다는 의미
		
		log.info(restaurant);
		log.info("------------------------------------");
		log.info(restaurant.getChef());
	}
}
