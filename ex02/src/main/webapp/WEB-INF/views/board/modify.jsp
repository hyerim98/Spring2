<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<%@include file = "../includes/header.jsp" %>

		<div class="row">
              <div class="col-lg-12">
                  <h1 class="page-header">Board Modify Page</h1>
              </div>
             <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        
        <div class="row">
        	<div class="col-lg-12">
        		<div class="panel panel-default">
        			<div class="panel-heading">Board Modify Page</div>
        			<div class="panel-body">
        				<form role="form" action="/board/modify" method="post">
        				
        				<input type="hidden" id="pageNum" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
	        	        <input type="hidden" id="amount" name="amount" value='<c:out value="${cri.amount}"/>'>
	        	        <input type="hidden" name="keyword" value='<c:out value="${cri.keyword}"/>'/>
                        <input type="hidden" name="type" value='<c:out value="${cri.type}"/>'/>
	        	        	
	        				<div class="form-group">
	        					<label>Bno</label>
	        					<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly">
	        				</div>
	        					
	        				<div class="form-group">
	        					<label>Title</label>
	        					<input class="form-control" name="title" value='<c:out value="${board.title}"/>'>
	        				</div>
	        					
	        				<div class="form-group">
	        					<label>Text Area</label>
	        					<textarea class="form-control" rows="3" name="content"><c:out value="${board.content}"/></textarea>
	        				</div>
	        					
	        				<div class="form-group">
	        					<label>Writer</label>
	        					<input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly="readonly">
	        				</div>
	        				
	        				<div class="form-group" style="display:none">
	        					<label>regDate</label>
	        					<input class="form-control" name="regdate" value='<fmt:formatDate pattern="yyyy/mm/dd" value="${board.regdate}"/>' readonly="readonly">
	        				</div>
	        				
	        				<div class="form-group" style="display:none">
	        					<label>updateDate</label>
	        					<input class="form-control" name="writer" value=''<fmt:formatDate pattern="yyyy/mm/dd" value="${board.updateDate}"/>' readonly="readonly">
	        				</div>
	        					
	        				<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
	        				<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
	        				<button type="submit" data-oper='list' class="btn btn-info">List</button>
        				</form>
        			</div>
        		</div>
        	</div>
        </div>
        
        <script>
        	$(document).ready(function(){
        		var formObj = $("form");
        		
        		$('button').on("click", function(e){
        			// 버튼 클릭 시 '/board/modify'로 가는 것을 막는다
        			e.preventDefault();
        			
        			var operation = $(this).data("oper");
        			
        			console.log(operation);
        			
        			if(operation == 'remove'){
        				formObj.attr("action", "/board/remove");
        			}
        			else if(operation == 'list'){
        				formObj.attr("action", "/board/list").attr("method", "get");
        				// form에서 필요한 내용만 잠시 복사 후
        				var pageNumTag = $("input[name='pageNum']").clone();
        				var amountTag = $("input[name='amount']").clone();
        				var keywordTag = $("input[name='keyword']").clone();
        				var typeTag = $("input[name='type']").clone();
        				// 안의 내용을 다 비움
        				formObj.empty();
        				// 필요한 파라미터만 붙여서 이동
        				formObj.append(pageNumTag);
        				formObj.append(amountTag);
        				formObj.append(keywordTag);
        				formObj.append(typeTag);
        			}
        			// 'modify'를 클릭한거면 기본 설정인 '/board/modify'로 이동
        			formObj.submit();
        		});
        	})
        </script>
        
 <%@include file = "../includes/footer.jsp" %>