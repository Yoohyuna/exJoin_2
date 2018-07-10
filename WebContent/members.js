/**
 * 
 */

function infoConfirm(){
	if(document.reg_form.id.value.length==0){
		alert("아이디는 필수 사항 입니다.");
		reg_form.id.focus();
		return;
	}
	if(document.reg_form.id.value.length<0){
		alert("아이디는 4글자 이상 이어야 합니다.");
		reg_form.id.focus();
		return;
	}
	if(document.reg_form.pw.value.length==0){
		alert("비밀번호는 필수 사항 입니다.");
		reg_form.pw.focus();
		return;
	}
	if(document.reg_form.pw.value != document.reg_form.pw_checked.value){
		alert("비밀번호가 일치하지 않습니다.");
		reg_form.pw.focus();
		return;
	}
	if(document.reg_form.name.value.length == 0) {
		alert("이름은 필수 사항입니다.");
		reg_form.name.focus();
		return;
	}
	if(document.reg_form.eMail.value.length == 0) {
		alert("메일은 필수 사항입니다.");
		reg_form.eMail.focus();
		return;
	}
	document.reg_form.submit();
}

function undateInfoConfirm(){
	if(document.reg_form.pw.value == "") {
		alert("패스워드를 입력하세요.");
		document.reg_form.pw.focus();
		return;
	}
	
	if(document.reg_form.pw.value != document.reg_form.pw_check.value) {
		alert("패스워드가 일치하지 않습니다.");
		reg_form.pw.focus();
		return;
	}
	
	if(document.reg_form.eMail.value.length == 0) {
		alert("메일은 필수 사항입니다.");
		reg_form.eMail.focus();
		return;
	}
	
	document.reg_form.submit();
	
}