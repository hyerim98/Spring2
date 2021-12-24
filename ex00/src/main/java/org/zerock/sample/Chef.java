package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

// 스프링에서 관리해야 하는 대상
@Component
// 결합한 형태로 한 번에 자주 사용되는 모든 메서드들을 생성할 수 있다(세부적인 설정이 필요 없는 경우라면 @Data를 이용)
@Data
public class Chef {

}
