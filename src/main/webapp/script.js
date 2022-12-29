function fn_submit () {
	var f = document.frm; //form태그 전체를 가르킨다
		
	if(f.jumin.value == ''){
		alert("주민등록번호를 입력해주십시오.");
		return false;
	}	
	
	if(f.studentName.value == ''){
		alert("이름을 입력해주십시오.");
		return false;
	}
	
	if(f.phone.value == ''){
		alert("휴대폰번호를 입력해주십시오.");
		return false;
	}
	f.submit(); //form태그 전송
}

function fn_add () {
	var f = document.frm;
	
	if(f.jumin.value == '') {
		alert("주민등록번호를 입력해주십시오.");
		return false;
	}
	f.submit();
}