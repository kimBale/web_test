<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/css/common.css" type="text/css" rel="stylesheet">
<link href="../resources/css/joinForm.css" type="text/css" rel="stylesheet">
<script src="../resources/js/joinForm.js" type="text/javascript"></script>
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
		<div class="joinForm">
			<form action="<%=request.getContextPath()%>/member/joinConfirm" method="post" name="joinForm">
				<div><input type="text" name="m_mail" placeholder="메일 입력 하세요."></div>
				<div><input type="password" name="m_pw" placeholder="비밀번호 입력 하세요."></div>
				<div>			
					<input type="button" value="join" onclick="joinFun()">
					<input type="reset" value="reset">
				</div>
			</form>
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