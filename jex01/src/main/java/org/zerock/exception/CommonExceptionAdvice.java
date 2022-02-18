package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

// 해당 객체가 스프링의 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시하는 용도로 사용
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	// 해당 메서드가 ()에 들어가는 예외 타입을 처리한다는 것을 의미
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error("Exception ........" + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "error_page";
	}

}
