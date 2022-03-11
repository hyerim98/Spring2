package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * 페이징 처리를 위한 클래스
 */

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	private int startPage;
	private int endPage;
	
	private String type;
	private String keyword;
	private String[] typeArray;
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.startPage = pageNum * amount - amount;
		this.endPage = pageNum * amount;
	}
	
	
	public String[] getTypeArr() {
		return type == null? new String[] {}: type.split("");
	}
}
