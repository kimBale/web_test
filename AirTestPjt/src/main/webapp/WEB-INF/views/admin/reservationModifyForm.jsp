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
<link href="../resources/css/reservationForm.css" type="text/css" rel="stylesheet">
<script src="../resources/js/reservationForm.js" type="text/javascript"></script>
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
		<div>
			<a href="<%=request.getContextPath()%>/admin/reservationList" class="call_list">reservation_list</a>
			
			<%
					ReservationVo reservationVo = (ReservationVo) request.getAttribute("reservationVo");
			%>
			
			<form action="<%=request.getContextPath()%>/admin/reservationModifyConfirm" method="post" name="reservationModifyForm">
				<input type="hidden" name="r_no" value="<%=reservationVo.getR_no()%>">
				
				<table>
					<tr>
						<td colspan="4">Air reservation</td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" placeholder="예약자 이름 입력하세요." name="r_name" value="<%=reservationVo.getR_name()%>"></td>
						<td>메일</td>
						<td><input type="text" placeholder="예약자 메일 입력하세요." name="r_mail" value="<%=reservationVo.getR_mail()%>"></td>
					</tr>
					<tr>
						<td>출발지</td>
						<td>
							<select name="r_start_location">
								<option value="">선택</option>
								<option value="인천" <% if(reservationVo.getR_start_location().equals("인천")) {%> selected <%}%>>인천</option>
								<option value="김포" <% if(reservationVo.getR_start_location().equals("김포")) {%> selected <%}%>>김포</option>
								<option value="제주" <% if(reservationVo.getR_start_location().equals("제주")) {%> selected <%}%>>제주</option>
							</select>
						</td>
						<td>도착지</td>
						<td>
							<select name="r_end_location">
								<option value="">선택</option>
								<option value="오사카" <% if(reservationVo.getR_end_location().equals("오사카")) {%> selected<%}%>>오사카</option>
								<option value="상하이" <% if(reservationVo.getR_end_location().equals("상하이")) {%> selected<%}%>>상하이</option>
								<option value="하와이" <% if(reservationVo.getR_end_location().equals("하와이")) {%> selected<%}%>>하와이</option>								
							</select>
						</td>
					</tr>
					<tr>
						<td>가는날</td>
						<td><input type="text" name="r_start_date" placeholder="가는날을 입력하세요." value="<%=reservationVo.getR_start_date()%>"></td>
						<td>오는날</td>
						<td><input type="text" name="r_end_date" placeholder="오는날을 입력하세요." value="<%=reservationVo.getR_end_date()%>"></td>
					</tr>
					<tr>
						<td>성인<br>(12세 이상)</td>
						<td>
							<select name="r_adult_cnt">
								<option value="">선택</option>
								<option value=0 <% if(reservationVo.getR_adult_cnt()==0) {%> selected <%}%>>0</option>
								<option value=1 <% if(reservationVo.getR_adult_cnt()==1) {%> selected <%}%>>1</option>
								<option value=2 <% if(reservationVo.getR_adult_cnt()==2) {%> selected <%}%>>2</option>
								<option value=3 <% if(reservationVo.getR_adult_cnt()==3) {%> selected <%}%>>3</option>
								<option value=4 <% if(reservationVo.getR_adult_cnt()==4) {%> selected <%}%>>4</option>
							</select>
						</td>
						<td>소아<br>(24개월 미만)</td>
						<td>
							<select name="r_infant_cnt">
								<option value="">선택</option>
								<option value=0 <% if(reservationVo.getR_infant_cnt()==0) {%> selected <%}%>>0</option>
								<option value=1 <% if(reservationVo.getR_infant_cnt()==1) {%> selected <%}%>>1</option>
								<option value=2 <% if(reservationVo.getR_infant_cnt()==2) {%> selected <%}%>>2</option>
								<option value=3 <% if(reservationVo.getR_infant_cnt()==3) {%> selected <%}%>>3</option>
								<option value=4 <% if(reservationVo.getR_infant_cnt()==4) {%> selected <%}%>>4</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>유아<br>(12세 미만)</td>
						<td>
							<select name="r_child_cnt">
								<option value="">선택</option>
								<option value=0 <% if(reservationVo.getR_child_cnt()==0) {%> selected <%}%>>0</option>
								<option value=1 <% if(reservationVo.getR_child_cnt()==1) {%> selected <%}%>>1</option>
								<option value=2 <% if(reservationVo.getR_child_cnt()==2) {%> selected <%}%>>2</option>
								<option value=3 <% if(reservationVo.getR_child_cnt()==3) {%> selected <%}%>>3</option>
								<option value=4 <% if(reservationVo.getR_child_cnt()==4) {%> selected <%}%>>4</option>
							</select>
						</td>
						<td>좌석</td>
						<td>
							<select name="r_seat_type">
								<option value="">선택</option>
								<option value="일반석" <% if(reservationVo.getR_seat_type().equals("일반석")) {%> selected <%}%>>일반석</option>
								<option value="비지니스석" <% if(reservationVo.getR_seat_type().equals("비지니스석")) {%> selected <%}%>>비지니스석</option>
								<option value="일등석" <% if(reservationVo.getR_seat_type().equals("일등석")) {%> selected <%}%>>일등석</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="button" value="modify" onclick="reservationModifyFun()"> 
							<input type="reset" value="reset">
						</td>
					</tr>
				</table>
			</form>
			
		</div>
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