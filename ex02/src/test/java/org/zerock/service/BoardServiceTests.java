package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapperTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//테스트 시 필요한 클래스를 지정
@RunWith(SpringJUnit4ClassRunner.class)
//스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지 명시(root-context.xml의 경로를 지정)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	/*@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		service.register(board);
	}*/
	
	/*@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}*/
	
	// 페이지 처리
	@Test
	public void testGetList() {
		Criteria cri = new Criteria(2, 10);
		service.getList(cri).forEach(board -> log.info(board));
	}
	
	@Test
	public void testGet() {
		log.info(service.get(3));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(4);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("제목 수정합니다");
		log.info("MODIFY RESULT :  " + service.modify(board));
	}
	
	/*@Test
	public void testDelete() {
		log.info("REMOVE RESULT : " + service.remove(3));
	}*/
	
	
}
