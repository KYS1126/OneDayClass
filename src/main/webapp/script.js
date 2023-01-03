function fn_submit() {
	var f = document.frm; //form태그 전체를 가르킨다

	if (f.jumin.value == '') {
		alert("주민등록번호를 입력해주십시오.");
		return false;
	}

	if (f.studentName.value == '') {
		alert("이름을 입력해주십시오.");
		return false;
	}

	if (f.phone.value == '') {
		alert("휴대폰번호를 입력해주십시오.");
		return false;
	}
	f.submit(); //form태그 전송
}

function fn_add() {
	var f = document.frm;

	if (f.jumin.value == '') {
		alert("주민등록번호를 입력해주십시오.");
		return false;
	}
	f.submit();
}

function classup() {
	var f = document.frm;

	if (f.className.value == '') {
		alert("클래스 이름을 입력해주십시오.");
		return false;
	}
	if (f.price.value == '') {
		alert("가격을 입력해주십시오.");
		return false;
	}
	if (f.day.value == '') {
		alert("개강날짜를 입력해주십시오.");
		return false;
	}
	if (f.time.value == '') {
		alert("소요시간을 입력해주십시오.");
		return false;
	}
	if (f.maxStudent.value == '') {
		alert("최대인원을 입력해주십시오.");
		return false;
	}
	if (f.place.value == '') {
		alert("주소를 입력해주십시오.");
		return false;
	}
	
	f.submit();

}

// function conf() {
//	var f = document.fo;
//	consol.log();

//	if (confirm("정말 삭제하시겠습니까?")) {
//		f.submit();		
//	} else {
//		return;
//	}
//}