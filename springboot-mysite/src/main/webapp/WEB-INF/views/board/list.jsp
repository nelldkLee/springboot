<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:set var="count" value="${function:length(list)}"/>
					<c:forEach items="${list}" var="vo" varStatus="status">				
					<tr>
						<%-- <td>${count-status.index}</td> --%>
						<td>${vo.no}</td>
						<td style="text-align:left; padding-left: ${vo.depth *20}px" >
							<c:if test="${vo.depth > 0}">
								<img src="${pageContext.servletContext.contextPath}/assets/images/reply.png">
							</c:if>
							<a href="${pageContext.servletContext.contextPath}/board/read?no=${vo.no}">${vo.title}</a>
						</td>
						<td>${vo.userName}</td>
						<td>${vo.hit}</td>
						<td>${vo.regDate}</td>
						<td>
							<c:if test="${authUser.no eq vo.userNo }">
								<a href="${pageContext.servletContext.contextPath}/board/delete?no=${vo.no}" class="del">삭제</a>
							</c:if>
						</td>
					</tr>
					</c:forEach>
				</table>
				<div class="bottom">
					<a href="${pageContext.servletContext.contextPath}/board/register" id="new-book">글쓰기</a>
				</div>				
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>