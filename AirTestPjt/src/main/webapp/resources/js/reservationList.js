function cancelReservationFun(uri) {
	console.log('uri : ' + uri);
	
	if(confirm('정말 취소하겠습니까?')) {
		location.href = uri;
	}
	
}