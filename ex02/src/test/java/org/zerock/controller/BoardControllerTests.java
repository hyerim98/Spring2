package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.service.BoardServiceTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//테스트 시 필요한 클래스를 지정
@RunWith(SpringJUnit4ClassRunner.class)
//스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지 명시(root-context.xml의 경로를 지정)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
// Controller 테스트를 위해 필요한 어노테이션
@WebAppConfiguration
public class BoardControllerTests {

	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	// 가짜 MVC : 가짜로 URL과 파라미터 등을 브라우저에서 사용하는 것처럼 만들어서 Controller를 실행
	private MockMvc mockMvc;
	
	// 모든 테스트 전에 매번 실행되는 메서드
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception{
		/*  
		 * MockMvcRequestBuilders라는 존재를 이용해서 GET 방식의 호출
		    이후에는 BoardController의 getList()에서 반환된 결과를 이용해서 Model에 어떤 데이터들이 담겨 있는지 확인
		 */
		log.info(
				"lidt : " + 
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	

	
	@Test
	public void testListPaging() throws Exception{
		/*  
		 * MockMvcRequestBuilders라는 존재를 이용해서 GET 방식의 호출
		    이후에는 BoardController의 getList()에서 반환된 결과를 이용해서 Model에 어떤 데이터들이 담겨 있는지 확인
		 */
		log.info(
				"paging List : " +
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
						.param("pageNum", "2")
						.param("amount", "10")
				)
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	/*@Test
	public void testRegister() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				// 전달해야 하는 파라미터들을 지정
				.param("title", "테스트 새글 제목")
				.param("content", "테스트 새글 내용")
				.param("writer", "user01")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
				
	}*/
	
	@Test
	public void testGet() throws Exception{
		log.info("testGet : " +
				mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "4"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	/*@Test
	public void testModify() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				// 전달해야 하는 파라미터들을 지정
				.param("bno", "4")
				.param("title", "수정된 테스트 새글 제목")
				.param("content", "수정된 테스트 새글 내용")
				.param("writer", "user00")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}*/
	
	/*@Test
	public void testRemove() throws Exception{
		
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				// 전달해야 하는 파라미터들을 지정
				.param("bno", "4")
				).andReturn().getModelAndView().getViewName()
		);
	}*/
}
