function reservationFun() {
	console.log('reservationFun() INIT');
	
	var reservationForm = document.reservationForm;
	if (reservationForm.r_name.value == '') {
		alert('예약자 이름을 입력하세요.');
		reservationForm.r_name.focus();
		
	} else if (reservationForm.r_mail.value == '') {
		alert('예약자 메일주소를 입력하세요.');
		reservationForm.r_mail.focus();
		
	} else if (reservationForm.r_start_location.value == '') {
		alert('출발지를 선택하세요.');
		reservationForm.r_start_location.focus();
		
	} else if (reservationForm.r_end_location.value == '') {
		alert('도착지를 선택하세요.');
		reservationForm.r_end_location.focus();
		
	} else if (reservationForm.r_start_date.value == '') {
		alert('가는날을 입력하세요.');
		reservationForm.r_start_date.focus();
		
	} else if (reservationForm.r_end_date.value == '') {
		alert('오는날을 입력하세요.');
		reservationForm.r_end_date.focus();
		
	} else if (reservationForm.r_adult_cnt.value == '') {
		alert('성인수를 선택하세요.');
		reservationForm.r_adult_cnt.focus();
		
	} else if (reservationForm.r_infant_cnt.value == '') {
		alert('소아수를 선택하세요.');
		reservationForm.r_infant_cnt.focus();
		
	} else if (reservationForm.r_child_cnt.value == '') {
		alert('유아수를 선택하세요.');
		reservationForm.r_child_cnt.focus();
		
	} else if (reservationForm.r_seat_type.value == '') {
		alert('좌석 타입을 선택하세요.');
		reservationForm.r_seat_type.focus();
		
	} else {
		reservationForm.submit();
		
	}
	
}


// 예약 수정
function reservationModifyFun() {
	console.log('reservationModifyFun() INIT');
	
	var reservationModifyForm = document.reservationModifyForm;
	if (reservationModifyForm.r_name.value == '') {
		alert('예약자 이름을 입력하세요.');
		reservationModifyForm.r_name.focus();
		
	} else if (reservationModifyForm.r_mail.value == '') {
		alert('예약자 메일주소를 입력하세요.');
		reservationModifyForm.r_mail.focus();
		
	} else if (reservationModifyForm.r_start_location.value == '') {
		alert('출발지를 선택하세요.');
		reservationModifyForm.r_start_location.focus();
		
	} else if (reservationModifyForm.r_end_location.value == '') {
		alert('도착지를 선택하세요.');
		reservationModifyForm.r_end_location.focus();
		
	} else if (reservationModifyForm.r_start_date.value == '') {
		alert('가는날을 입력하세요.');
		reservationModifyForm.r_start_date.focus();
		
	} else if (reservationModifyForm.r_end_date.value == '') {
		alert('오는날을 입력하세요.');
		reservationModifyForm.r_end_date.focus();
		
	} else if (reservationModifyForm.r_adult_cnt.value == '') {
		alert('성인수를 선택하세요.');
		reservationModifyForm.r_adult_cnt.focus();
		
	} else if (reservationModifyForm.r_infant_cnt.value == '') {
		alert('소아수를 선택하세요.');
		reservationModifyForm.r_infant_cnt.focus();
		
	} else if (reservationModifyForm.r_child_cnt.value == '') {
		alert('유아수를 선택하세요.');
		reservationModifyForm.r_child_cnt.focus();
		
	} else if (reservationModifyForm.r_seat_type.value == '') {
		alert('좌석 타입을 선택하세요.');
		reservationModifyForm.r_seat_type.focus();
		
	} else {
		reservationModifyForm.submit();
		
	}
	
}