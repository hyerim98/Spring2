package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	
	// setter 메서드의 생성 시 메서드에 추가할 어노테이션을 지정
	@Setter(onMethod_ = @Autowired)
	private Chef chef;

}
