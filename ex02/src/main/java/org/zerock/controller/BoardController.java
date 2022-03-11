package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

// 스프링의 빈으로 인식할 수 있도록 
@Controller
@Log4j
@RequestMapping("/board/*")
// 생성자를 만들고 자동으로 주입
@AllArgsConstructor
public class BoardController {
	// 만약 @AllArgsConstructor가 없다면 @Setter(onMethod_ = {@Autowired})를 이용하여 처리
	private BoardService service;
	
	/*@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getList());
	}*/
	
	@GetMapping("/list")
	public void list_page(Model model, Criteria cri) {
		cri.setStartPage(cri.getPageNum() * cri.getAmount() - cri.getAmount());
		cri.setEndPage(cri.getPageNum() * cri.getAmount());
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri)));
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	// RedirectAttributes : 새롭게 등록된 게시물의 제목을 같이 전달하기 위해 사용, 단 한번만 사용 가능하게 보관
	//                      주로 경고창이나 모달창 등을 보여주는 방식으로 처리
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register : " + board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getTitle());
		
		// 등록 작업이 끝난 후 다시 목록 화면으로 이동
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	// @RequestParam : 파라미터 이름과 변수 이름을 기준으로 동작하기 때문에 생략해도 무방
	public void get(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify....");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify : " + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "successModify");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(int bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove... " + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "successRemove");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
}
