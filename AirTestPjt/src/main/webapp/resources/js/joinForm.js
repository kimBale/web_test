function joinFun() {
	console.log('joinFun() INIT');
	
	var joinForm = document.joinForm;
	
	if(joinForm.m_mail.value == "") {
		alert("메일을 입력하세요");
		joinForm.m_mail.focus();
		
	} else if(joinForm.m_pw.value == "") {
		alert("비밀번호를 입력하세요");
		joinForm.m_pw.focus();
		
	} else {
		joinForm.submit();
		
	}
}
