package com.sample.mybatis;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//테스트 시 필요한 클래스를 지정
@RunWith(SpringJUnit4ClassRunner.class)
//스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지 명시(root-context.xml의 경로를 지정)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MySQLConnectionTest {
	// @Autowired와 같은 역할
	@Inject
	private DataSource ds;
	
	@Test
	public void testConnection() throws Exception {
		try(Connection con = ds.getConnection()) {
			System.out.println("\n >>>>>>>>>>> Connection 출력 : " + con + "\n");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
