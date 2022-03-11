package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	public void register(BoardVO board);
	
	public BoardVO get(int bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(int bno);
	
	// public List<BoardVO> getList();
	
	// 페이지 처리
	public List<BoardVO> getList(Criteria cri);
	
	// 데이터 전체 개수
	public int getTotal(Criteria cri);
}
