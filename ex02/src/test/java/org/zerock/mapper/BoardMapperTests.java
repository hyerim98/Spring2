package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//테스트 시 필요한 클래스를 지정
@RunWith(SpringJUnit4ClassRunner.class)
//스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지 명시(root-context.xml의 경로를 지정)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	/*@Test
	public void testPaging() {
		Criteria cri = new Criteria(2, 10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		log.info("paging data.......... : " + list);
		list.forEach(board -> log.info(board.getBno()));
	}*/
	
	// 검색 처리
	@Test
	public void testSerach() {
		Criteria cri = new Criteria();
		cri.setKeyword("user00");
		cri.setType("TW");
		cri.setTypeArray(cri.getTypeArr());
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		log.info("search data............." + list.size());
		list.forEach(board -> log.info(board));
	}
	
	/* @Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(2);
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		log.info("DELETE COUNT : " + mapper.delete(2));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(3);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT : " + count);
	}*/
}
