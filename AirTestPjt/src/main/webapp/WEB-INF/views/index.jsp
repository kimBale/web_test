<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./resources/css/common.css" type="text/css" rel="stylesheet">
<link href="./resources/css/index.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="menu_wrap">
	<div class="content">
	<%
		session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			
			%>
			<ul>
				<li><a href="<%=request.getContextPath()%>/">home</a></li>
				<li><a href="<%=request.getContextPath()%>/reservation/reservationForm">reservation</a></li>
				<li><a href="<%=request.getContextPath()%>/member/loginForm">login</a></li>
			</ul>
	<%} else {
		
		%>
			<ul>
				<li><a href="<%=request.getContextPath()%>/">home</a></li>
				<li><a href="<%=request.getContextPath()%>/reservation/reservationForm">reservation</a></li>
				<li><%=session.getAttribute("loginMember")%>님 안녕하세요.</li>
				<li><a href="<%=request.getContextPath()%>/member/logout">logout</a></li>
			</ul>
	<% } %>
	</div>
</div>

<div class="section_wrap">
	<div class="content">
	Air Reservation Service.
	</div>
</div>

<div class="footer_wrap">
	<div class="content">
	OOOOO (주) | 대표이사 홍길동 | 사업자등록번호 000-00-00000
	</div>
</div>


</body>
</html>