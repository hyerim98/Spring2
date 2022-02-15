package com.sample.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


//테스트 시 필요한 클래스를 지정
@RunWith(SpringJUnit4ClassRunner.class)
//스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지 명시(root-context.xml의 경로를 지정)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info("Mybatis Annotation 사용");
		log.info(timeMapper.getClass().getName());
		log.info("time : " + timeMapper.getTime());
		
		log.info("XML 사용");
		log.info("getTime2 : " + timeMapper.getTime2());
	}
}
