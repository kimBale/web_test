function loginFun() {
	console.log('loginFun() INIT');
	
	var loginForm = document.loginForm;
	
	if(loginForm.m_mail.value == "") {
		alert("메일을 입력하세요");
		loginForm.m_mail.focus();
		
	} else if(loginForm.m_pw.value == "") {
		alert("비밀번호를 입력하세요");
		loginForm.m_pw.focus();
		
	} else {
		loginForm.submit();
		
	}
}

function adminLoginFun() {
	console.log('adminLoginFun() INIT');
	
	var loginForm = document.loginForm;
	
	if(loginForm.a_mail.value == "") {
		alert("관리자 메일을 입력하세요");
		loginForm.a_mail.focus();
		
	} else if(loginForm.a_pw.value == "") {
		alert("관리자 비밀번호를 입력하세요");
		loginForm.a_pw.focus();
		
	} else {
		loginForm.submit();
		
	}
}


