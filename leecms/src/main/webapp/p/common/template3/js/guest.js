String.prototype.trim = function() {
	// 用正则表达式将前后空格  
	// 用空字符串替代。  
	return this.replace(/(^\s*)|(\s*$)/g, "");
};

function Check(theform) {
	if (theform.Title.value == "") {
		alert("你还没有填写留言主题！");
		theform.Title.focus();
		return (false);
	}
	if (theform.Content.value == "") {
		alert("你还没有填写留言内容！");
		theform.Content.focus();
		return (false);
	}
	if (theform.Content.value.length > 800) {
		alert("留言内容不能多于800字！");
		theform.Content.focus();
		return (false);
	}
	if (theform.Uname.value == "") {
		alert("姓名不能为空！");
		theform.Uname.focus();
		return (false);
	}
	if (theform.Tel.value == "") {
		alert("联系电话不能为空！");
		theform.Tel.focus();
		return (false);
	}
	if (theform.Rand.value == "") {
		alert("请输入四位验证码！！");
		theform.Rand.focus();
		return (false);
	}

}

function checkMail(str) {
	var strReg = "";
	var r;
	var strText = str;
	//strReg=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/i; 
	strReg = /^\w+((-\w+)|(\.\w+))*\@{1}\w+\.{1}\w{2,4}(\.{0,1}\w{2}){0,1}/ig;
	r = strText.search(strReg);
	if (r == -1) {
		return false;
	} else {
		return true;
	}
}