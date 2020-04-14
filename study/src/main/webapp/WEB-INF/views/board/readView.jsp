<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='readForm']");
			
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "/board/updateView");
				formObj.attr("method", "get");
				formObj.submit();				
			})
			
			// 삭제
			$(".delete_btn").on("click", function(){
				formObj.attr("action", "/board/delete");
				formObj.attr("method", "post");
				formObj.submit();
			})
			
			// 취소
			$(".list_btn").on("click", function(){
				
				location.href = "/board/list";
			})
		})
	</script>
<body>
	<header>
	<%@include file="nav.jsp"%>
	</header>
<div class="container">
	 <div class="row">
	 	<table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
	 		<thead>
	 			<tr>
	 				<th colspan="3" style="background-color: #eeeeee; text-align: center;">게시판 글 보기</th>			
	 			</tr>
	 		</thead><thead>
	 		</thead><tbody>
	 			<tr>
	 			<td style="width: 20%;">글제목</td>
	 			<td colspan="2">${read.title}</td>
	 			</tr>
	 			<tr>
	 				<td>작성자</td>
	 				<td colspan="2">${read.writer}</td>
	 			</tr>
	 			<tr>
	 				<td>작성일자</td>
	 				<td colspan="2"><fmt:formatDate value="${read.regdate}" pattern="yyyy-MM-dd" />	</td>
	 			</tr>
	 			<tr>
	 				<td>내용</td>
	 				<td colspan="2" style="min-height: 200px; text-align: left;">${read.content}</td>
	 			</tr>
	 			
	 			
	 		</tbody>
	 	</table>
	 	<a href="table" class="btn btn-primary">목록</a>
	    <a href="/board/updateView?bno=${read.bno}" class="btn btn-primary pull-right">수정</a>
		<button type="submit" class="delete_btn">삭제</button>
	 	
	 	
	 </div>
	</div> 
</body>
</html>