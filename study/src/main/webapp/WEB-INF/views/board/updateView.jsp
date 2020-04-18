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
			// 취소
			$(".list_btn").on("click", function(){
				
				location.href = "/board/table";
			})
		})
	</script>
<body>
	<header>
	<%@include file="nav.jsp"%>
	</header>
<div class="container">
	 <div class="row">
	 
	 <form method="post" action="/board/update">
	 <input type="hidden" name="bno" value="${JUN.bno}" readonly="readonly"/>
	 	<table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
	 		<thead>
	 			<tr>
	 				<th colspan="10" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기 양식</th>			
	 			</tr>
	 		</thead><thead>
	 		
	 		</thead><tbody>
	 		
	 			<tr>
	 			<td><input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="50" value="${JUN.title}"></td>
	 			</tr>
	 			<tr>
	 			<td><textarea class="form-control" placeholder="글 내용" name="content" maxlength="2048" style="height: 350px;">${JUN.content}</textarea></td>
	 			</tr>
	 			<tr>
	 			<td><input type="text" class="form-control" placeholder="작성자" name="writer" maxlength="50" value="${JUN.writer}"></td>
	 			</tr>
	 			
	 		</tbody>
	 	</table>
	 	<input type="submit" class="btn btn-primary pull-right" value="수정하기">
		<button type="submit" class="cancel_btn">취소</button>
	 	</form>
	 	
	 </div>
	</div>
</body>
</html>