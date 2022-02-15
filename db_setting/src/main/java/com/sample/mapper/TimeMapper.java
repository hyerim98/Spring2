package com.sample.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("SELECT now() FROM dual")
	public String getTime();
	
	// XML mapper와 같이 쓰기
	public String getTime2();

}
