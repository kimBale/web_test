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
		<div>
			<a href="<%=request.getContextPath()%>/reservation/reservationList" class="call_list">reservation_list</a>
			
			<form action="<%=request.getContextPath()%>/reservation/reservationConfirm" method="post" name="reservationForm">
				<table>
					<tr>
						<td colspan="4">Air reservation</td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" placeholder="예약자 이름 입력하세요." name="r_name"></td>
						<td>메일</td>
						<td><input type="text" placeholder="예약자 메일 입력하세요." name="r_mail" value="<%=session.getAttribute("loginMember")%>"></td>
					</tr>
					<tr>
						<td>출발지</td>
						<td>
							<select name="r_start_location">
								<option value="">선택</option>
								<option value="인천">인천</option>
								<option value="김포">김포</option>
								<option value="제주">제주</option>
							</select>
						</td>
						<td>도착지</td>
						<td>
							<select name="r_end_location">
								<option value="">선택</option>
								<option value="오사카">오사카</option>
								<option value="상하이">상하이</option>
								<option value="하와이">하와이</option>								
							</select>
						</td>
					</tr>
					<tr>
						<td>가는날</td>
						<td><input type="text" name="r_start_date" placeholder="가는날을 입력하세요."></td>
						<td>오는날</td>
						<td><input type="text" name="r_end_date" placeholder="오는날을 입력하세요."></td>
					</tr>
					<tr>
						<td>성인<br>(12세 이상)</td>
						<td>
							<select name="r_adult_cnt">
								<option value="">선택</option>
								<option value=0>0</option>
								<option value=1>1</option>
								<option value=2>2</option>
								<option value=3>3</option>
								<option value=4>4</option>
							</select>
						</td>
						<td>소아<br>(24개월 미만)</td>
						<td>
							<select name="r_infant_cnt">
								<option value="">선택</option>
								<option value=0>0</option>
								<option value=1>1</option>
								<option value=2>2</option>
								<option value=3>3</option>
								<option value=4>4</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>유아<br>(12세 미만)</td>
						<td>
							<select name="r_child_cnt">
								<option value="">선택</option>
								<option value=0>0</option>
								<option value=1>1</option>
								<option value=2>2</option>
								<option value=3>3</option>
								<option value=4>4</option>
							</select>
						</td>
						<td>좌석</td>
						<td>
							<select name="r_seat_type">
								<option value="">선택</option>
								<option value="일반석">일반석</option>
								<option value="비지니스석">비지니스석</option>
								<option value="일등석">일등석</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="button" value="reservation" onclick="reservationFun()"> 
							<input type="reset" value="reset">
						</td>
					</tr>
				</table>
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