<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<%@include file = "../includes/header.jsp" %>

		<div class="row">
              <div class="col-lg-12">
                  <h1 class="page-header">Board Read Page</h1>
              </div>
             <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        
        <div class="row">
        	<div class="col-lg-12">
        		<div class="panel panel-default">
        			<div class="panel-heading">Board Read Page</div>
        			
        			<div class="panel-body">
        				<div class="form-group">
        					<label>Bno</label>
        					<input class="form-control" value='<c:out value="${board.bno}"/>' readonly="readonly">
        				</div>
        					
        				<div class="form-group">
        					<label>Title</label>
        					<input class="form-control" value='<c:out value="${board.title}"/>' readonly="readonly">
        				</div>
        					
        				<div class="form-group">
        					<label>Text Area</label>
        					<textarea class="form-control" rows="3" name='content' readonly="readonly"><c:out value="${board.content}"/></textarea>
        				</div>
        					
        				<div class="form-group">
        					<label>Writer</label>
        					<input class="form-control" value='<c:out value="${board.writer}"/>' readonly="readonly">
        				</div>
        					
        				<!-- 나중에 다양한 상황 처리를 위해 버튼 클릭 이벤트를 form으로 처리 -->
        				<button data-oper='modify' class="btn btn-default">Modify</button>
	        	        <button data-oper='list' class="btn btn-info">List</button>
	        	        
	        	        <form id="operForm" action="/board/modify" method="get">
	        	        	<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'>
	        	        	<input type="hidden" id="pageNum" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
	        	        	<input type="hidden" id="amount" name="amount" value='<c:out value="${cri.amount}"/>'>
	        	        	<input type="hidden" name="keyword" value='<c:out value="${cri.keyword}"/>'/>
                            <input type="hidden" name="type" value='<c:out value="${cri.type}"/>'/>
	        	        </form>
        			</div>
        		</div>
        	</div>
        </div>
        
        <script>
        	$(document).ready(function(){
        		var operForm = $("#operForm");
        		
        		$("button[data-oper='modify']").on("click", function(e){
        			operForm.attr("action", "/board/modify").submit();
        		});
        		
        		$("button[data-oper='list']").on("click", function(e){
        			// bno 태그를 지우고 submit()
        			operForm.find("#bno").remove();
        			operForm.attr("action", "/board/list").submit();
        		});
        	})
        	
        </script>
 <%@include file = "../includes/footer.jsp" %>