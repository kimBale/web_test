<%@page import="com.our.air.member.vo.MemberVo"%>
<%@page import="com.our.air.reservation.vo.ReservationVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/css/common.css" type="text/css" rel="stylesheet">
<link href="../resources/css/reservationList.css" type="text/css" rel="stylesheet">
<script src="../resources/js/reservationList.js" type="text/javascript"></script>
</head>
<body>

	<%
		session = request.getSession();
		if(session.getAttribute("admin") == null) {
			
			%>
<div class="menu_wrap">
	<div class="content">
			<ul>
				<li><a href="<%=request.getContextPath()%>/admin/loginForm">admin login</a></li>
			</ul>
	</div>
</div>

			
<div class="section_wrap">
	<div class="content">
		<div>
			<form action="<%=request.getContextPath()%>/admin/loginConfirm" method="post" name="loginForm">
				<div><input type="text" name="a_mail" placeholder="메일 입력 하세요."></div>
				<div><input type="password" name="a_pw" placeholder="비밀번호 입력 하세요."></div>
				<div>			
					<input type="button" value="log-in" onclick="adminLoginFun()">
					<input type="reset" value="reset">
				</div>
			</form>
		</div>
	</div>
</div>

	<%} else {
		
		%>

<div class="menu_wrap">
	<div class="content">
			<ul>
				<li><a href="<%=request.getContextPath()%>/admin/reservationList">reservationList</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/memberList">memberList</a></li>
				<li>관리자 접속중</li>
				<li><a href="<%=request.getContextPath()%>/admin/logout">admin logout</a></li>
			</ul>
	</div>
</div>

<div class="section_wrap">
	<div class="content">
		<table>
			<tr>
				<td>번호</td>
				<td>메일</td>
				<td>비밀번호</td>
				<td>등록일</td>
				<td>수정일</td>
			</tr>
			<%
				List<MemberVo> memberVos = (List<MemberVo>) request.getAttribute("adminMemberVos");
				for(int i = 0; i<memberVos.size(); i++) {
			%>

			<tr>
				<td><%=(i+1)%>(<%=memberVos.get(i).getM_no()%>)</td>
				<td><%=memberVos.get(i).getM_mail()%></td>
				<td><%=memberVos.get(i).getM_pw()%></td>
				<td><%=memberVos.get(i).getM_reg_date()%></td>
				<td><%=memberVos.get(i).getM_mod_date()%></td>
			</tr>
			
			<%
				}
			%>
		</table>
	</div>
</div>
	<% } %>



<div class="footer_wrap">
	<div class="content">
	OOOOO (주) | 대표이사 홍길동 | 사업자등록번호 000-00-00000
	</div>
</div>


</body>
</html>