<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/css/common.css" type="text/css" rel="stylesheet">
<link href="../resources/css/loginForm.css" type="text/css" rel="stylesheet">
<script src="../resources/js/loginForm.js" type="text/javascript"></script>
</head>
<body>
<div class="menu_wrap">
	<div class="content">
	<ul>
		<li><a href="<%=request.getContextPath()%>/">home</a></li>
		<li><a href="<%=request.getContextPath()%>/reservation/reservationForm">reservation</a></li>
		<li><a href="<%=request.getContextPath()%>/member/loginForm">login</a></li>
	</ul>
	</div>
</div>

<div class="section_wrap">
	<div class="content">
	죄송합니다. 아이디/비밀번호를 확인하세요.(<%=request.getAttribute("m_mail")%>)
		<div class="loginForm">
			<form action="<%=request.getContextPath()%>/member/loginConfirm" method="post" name="loginForm">
				<div><input type="text" name="m_mail" placeholder="메일 입력 하세요." value="<%=request.getAttribute("m_mail")%>"></div>
				<div><input type="password" name="m_pw" placeholder="비밀번호 입력 하세요."></div>
				<div>			
					<input type="button" value="log-in" onclick="loginFun()">
					<input type="reset" value="reset">
				</div>
			</form>
			<div>
				<a href="<%=request.getContextPath()%>/member/joinForm">join</a> 
				<a href="#none">search_password</a>
			</div>
		</div>
	</div>
</div>

<div class="footer_wrap">
	<div class="content">
	OOOOO (주) | 대표이사 홍길동 | 사업자등록번호 000-00-00000
	</div>
</div>


</body>
</html>