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
		<table>
			<tr>
				<td>번호</td>
				<td>예약자</td>
				<td>출발지</td>
				<td>도착지</td>
				<td>가는날</td>
				<td>오는날</td>
				<td>성인</td>
				<td>소아</td>
				<td>유아</td>
				<td>좌석</td>
				<td>예약등록일</td>
				<td>예약수정일</td>
				<td>수정 / 취소</td>
			</tr>
			<%
				List<ReservationVo> reservationVos = (List<ReservationVo>) request.getAttribute("reservationVos");
				for(int i = 0; i<reservationVos.size(); i++) {
			%>

			<tr>
				<td><%=(i+1)%></td>
				<td><%=reservationVos.get(i).getR_name()%></td>
				<td><%=reservationVos.get(i).getR_start_location()%></td>
				<td><%=reservationVos.get(i).getR_end_location()%></td>
				<td><%=reservationVos.get(i).getR_start_date()%></td>
				<td><%=reservationVos.get(i).getR_end_date()%></td>
				<td><%=reservationVos.get(i).getR_adult_cnt()%></td>
				<td><%=reservationVos.get(i).getR_infant_cnt()%></td>
				<td><%=reservationVos.get(i).getR_child_cnt()%></td>
				<td><%=reservationVos.get(i).getR_seat_type()%></td>
				<td><%=reservationVos.get(i).getR_reg_date()%></td>
				<td><%=reservationVos.get(i).getR_mod_date()%></td>
				<td>
					<a href="<%=request.getContextPath()%>/reservation/reservationModifyForm?r_no=<%=reservationVos.get(i).getR_no()%>">수정</a>
					 / 
					<a href="#none" onclick="cancelReservationFun('<%=request.getContextPath()%>/reservation/reservationCancel?r_no=<%=reservationVos.get(i).getR_no()%>')">취소</a>
				</td>
			</tr>
			
			<%
				}
			%>
		</table>
	</div>
</div>

<div class="footer_wrap">
	<div class="content">
	OOOOO (주) | 대표이사 홍길동 | 사업자등록번호 000-00-00000
	</div>
</div>


</body>
</html>