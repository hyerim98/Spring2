package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
// 계층 구조상 주로 비즈니스 영역을 담당하는 개체임을 표시
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		log.info("register...... " + board);
		
		mapper.insert(board);
		
	}

	@Override
	public BoardVO get(int bno) {
		log.info("get.........");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modifyy......");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(int bno) {
		log.info("remove.......");
		return mapper.delete(bno) == 1;
	}

	/*@Override
	public List<BoardVO> getList() {
		log.info("getList...........");
		return mapper.getList();
	}*/
	
	// 페이지 처리
	@Override
	public List<BoardVO> getList(Criteria cri){
		log.info("Page getList...........");
		log.info("type : " + cri.getType());
		log.info("keyword : " + cri.getKeyword());
		log.info("type size : " + cri.getTypeArr().length);
		cri.setTypeArray(cri.getTypeArr());
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count..........");
		return mapper.getTotalCount(cri);
	}

}
