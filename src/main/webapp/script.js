const autoHyphen2 = (target) => {
	target.value = target.value
		.replace(/[^0-9]/g, '')
		.replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}

function fn_submit() {
	var f = document.frm; //form태그 전체를 가르킨다
	var juminRule = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$/;
	if (f.jumin.value == '') {
		alert("주민등록번호를 입력해주십시오.");
		return false;
	}

	if (!juminRule.test(f.jumin.value)) {
		alert("주민등록번호 형식에 맞게 입력하세요");
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

