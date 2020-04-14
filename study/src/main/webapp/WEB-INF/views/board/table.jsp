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
<body>
	<header>
	<%@include file="nav.jsp"%>
	</header>
<div class="container">
  <h2>Spring 게시판</h2>
  <p></p>
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>게시글 번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
      </tr>
    </thead>
    <tbody>
     	<c:forEach items="${list}" var = "list">
							<tr>
								<td><c:out value="${list.bno}" /></td>
								<td><a href="/board/readView?bno=${list.bno}"><c:out value="${list.title}" /></a></td>
								<td><c:out value="${list.writer}" /></td>
								<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
		
	</tbody>
		</table>
		<a href="writeView" class="btn btn-primary pull-right">글쓰기</a>
		</div>
</body>
</html>