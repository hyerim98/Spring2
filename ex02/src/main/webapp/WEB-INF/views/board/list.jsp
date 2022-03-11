<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<%@include file = "../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">

            			<div class="panel-heading">
                            Board List Page
                            <button id="regBtn" type="button" class="btn btn-xs pull-right">Register New Board</button>
                        </div>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>#번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                
                                <c:forEach items="${list}" var="board">
                                	<tr>
                                		<td><c:out value="${board.bno}"/></td>
                                		<td><a class='move' href='<c:out value="${board.bno}"/>'><c:out value="${board.title}"/></a></td>
                                		<td><c:out value="${board.writer}"/></td>
                                		<td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${board.regdate}"/></td>
                                		<td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${board.updateDate}"/></td>
                                	</tr>
                                </c:forEach>
                               
                            </table>
                            
                            <div class="row">
                            	<div class="col-lg-12">
                            		<form id="searchForm" action="/board/list" method="get">
                            			<select name="type">
                            				<option value=""
                            					<c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
                            				<option value="T" 
                            					<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
                            				<option value="C" 
                            					<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
                            				<option value="W" 
                            					<c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
                            				<option value="TC"
                            					<c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목 or 내용</option>
                            				<option value="TW"
                            					<c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목 or 작성자</option>
                            				<option value="TWC"
                            					<c:out value="${pageMaker.cri.type eq 'TWC'?'selected':''}"/>>제목 or 내용 or 작성자</option>
                            			</select>
                            			<input type="text" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"/>'/>
                            			<input type="hidden" name="pageNum" value='<c:out value="${pageMaker.cri.pageNum}"/>'/>
                            			<input type="hidden" name="amount" value='<c:out value="${pageMaker.cri.amount}"/>'/>
                            			<button class="btn btn-default">Search</button>
                            		</form>
                            	</div>
                            </div>
                            
                            <div class="pull-right">
                            	<ul class="pagination">
                            		<c:if test="${pageMaker.prev}">
                            			<li class="paginate_button previous"><a href="${pageMaker.startPage - 1}">Previous</a></li>
                            		</c:if>
                            		
                            		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                            			<li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active' : ' '}"><a href="${num}">${num}</a></li>
                            		</c:forEach>
                            		
                            		<c:if test="${pageMaker.next}">
                            			<li class="paginate_button next"><a href="${pageMaker.endPage + 1}">Next</a></li>
                            		</c:if>
                            		
          
              
                            	</ul>
                            </div>
                            
                            <!-- 페이지 번호 처리 -->
                            <form id="actionForm" action="/board/list" method="get">
                            	<input type="hidden" name = "pageNum" value="${pageMaker.cri.pageNum}">
                            	<input type="hidden" name = "amount" value="${pageMaker.cri.amount}">
                            	<input type="hidden" name="type" value='<c:out value="${pageMaker.cri.type}"/>'/>
                            	<input type="hidden" name=keyword value='<c:out value="${pageMaker.cri.keyword}"/>'/>
                            </form>
                            
                            <!-- modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <script>
            	$(document).ready(function(){
            		var result = '<c:out value="${result}"/>';
            		
            		checkModal(result);
            		
            		// 모달 창을 보여준 후에 history에 쌓이는 상태는 모달창을 보여줄 필요가 없는 상태로 표시
            		history.replaceState({}, null, null);
            		
            		function checkModal(result){
            			if(result == '' || history.state){
            				return;
            			}
            			else if(result == 'successModify'){
            				$(".modal-body").html("게시글이 정상적으로 수정되었습니다.");
                			$("#myModal").modal("show");
                			return;
            			}
            			else if(result == 'successRemove'){
            				$(".modal-body").html("게시글이 정상적으로 삭제되었습니다.");
                			$("#myModal").modal("show");
                			return;
            			}
            			
            			$(".modal-body").html("' " + result + " '" + "의 게시글이 정상적으로 등록되었습니다.");
            			$("#myModal").modal("show");
            		}
            		
            		
            		$("#regBtn").on("click", function(){
            			self.location = "/board/register";
            		});
            		
            		/* 페이지 이동 처리 */
            		var actionForm = $("#actionForm");
            		
            		$(".paginate_button a").on("click", function(e){
            			e.preventDefault();
            			console.log('click');
            			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
            			actionForm.submit();
            		});
            		
            		/* 게시물의 제목을 클릭했을 때 이동하도록 이벤트 처리 */
            		$(".move").on("click", function(e){
            			e.preventDefault();
            			actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
            			console.log('href : ' + $(this).attr("href"));
            			actionForm.attr("action", "/board/get");
            			actionForm.submit();
            		})
            		
	            	/* 검색 버튼의 이벤트 처리 */
	            	var searchForm = $("#searchForm");
	            	
	            	$("#searchForm button").on("click", function(e){
	            		if(!searchForm.find("option:selected").val()){
	            			alert("검색 종류를 선택하세요");
	            			return false;
	            		}
	            		
	            		if(!searchForm.find("input[name='keyword']").val()){
	            			alert("키워드를 입력하세요");
	            			return false;
	            		}
	            		
	            		searchForm.find("input[name='pageNum']").val("1");
	            		// 검색 버튼을 클릭하면 <form> 태그의 전송은 막고, 페이지 번호는 1이 되도록 처리
	            		e.preventDefault();
	            		
	            		searchForm.submit();
	            	});
            	});
            </script>
            
            
	<%@include file = "../includes/footer.jsp" %>