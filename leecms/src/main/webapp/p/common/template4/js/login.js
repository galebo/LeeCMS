
function killerrors() {
return true;
}
window.onerror = killerrors;
var nowTitle = '用户中心';
function checkform(){
$.ajax({
	type: "post",
	dataType: "text",
	url: "/ids/cn/haier_do_loginajax.jsp",
	data: {
	   'returnUrl':$("#returnUrl").val(),
	   'loginType':$("#loginType").val(),
	   'loginKey':$("#loginKey").val(),
	   'userName':$("#uc_login_username").val(),
	   'password':$("#uc_login_password").val(),
	   'autoLogin':$("#uc_login_cookie").attr("checked"),
	   'cookieTime':$("#js_cookieTime").val()
	},
	error : function(XMLHttpRequest, textStatus, errorThrown){
	},
	success: function(returnData){
		var temp_result = jQuery.trim(returnData);
		if(temp_result=='ok'||temp_result=='show;ok'){
			document.location.href=$("#returnUrl").val();
		}else if(temp_result.indexOf("url;")>-1){
			var url=temp_result.substring(temp_result.indexOf("url;")+4,temp_result.length);
			if(url.indexOf("activeemail.jsp")>-1){
				$("#yuserName").val(url.split(";")[1]);
				$("#yemail").val(url.split(";")[2]);
				$("#newlogin").attr("action",url.split(";")[0]);
				$("#newlogin").submit();
			}else if(url.indexOf("haier_lognoactive.jsp")>-1){
				$("#yuserName").val(url.split(";")[1]);
				$("#newlogin").attr("action",url.split(";")[0]);
				$("#newlogin").submit();
			}else{
				document.location.href=url;
			}
		}else if(temp_result.indexOf("show;")>-1){
			if(typeof($("#uc_login_authcode").val())=='undefined'){
				//document.location.reload();
				$("#showverifycode").html('<td height="50" align="right" valign="middle">验证码：</td><td height="50" colspan="3" valign="middle" class="js_mmjs_validation_fe_wrap"><div class="uc_login_authcode_wrap"><span class="il_box js_il_box"><input name="verifycode" id="uc_login_authcode" tabindex="3" type="text" class="js_uc_login_authcode_input jsv_required haier_txz01" title="请输入验证码" /></span><span class="uc_login_authcode_pic"><span id="verifyCodeId" class="verifyCodeId"></span></span><span><a href="#" onclick="refreshVerifyCode();" style="padding-left: 5px;" >看不清?</a></span></div><span id="msgyzm" class="info_error js_validation_marke_info"></span></td>');
				$("#thirdshow").attr("style","margin-top:10");
			}
				var msgerror=temp_result.split(";")[1];
				if(msgerror.indexOf("不存在该用户")>-1||msgerror.indexOf("用户名或密码错误")>-1||msgerror.indexOf("对应的用户存在多个")>-1){
					msgerror="您输入的账号或密码不正确，请重新输入。";
				}
				if(typeof($("#msgyzm").val())=='undefined'){
					$("#loginmessage").html(msgerror);
				}else{
					$("#msgyzm").html(msgerror);
				}
			
			refreshVerifyCode();
		}else{
			if(temp_result.indexOf("不存在该用户")>-1||temp_result.indexOf("用户名或密码错误")>-1||temp_result.indexOf("对应的用户存在多个")>-1){
				temp_result="您输入的账号或密码不正确，请重新输入。";
			}
			if(typeof($("#msgyzm").val())=='undefined'){
				$("#loginmessage").html(temp_result);
			}else{
				$("#msgyzm").html(temp_result);
			}
		}
	}
});
return false;
}


jQuery(function(){
	jQuery('.js_loading_bubble_box').hide();
	$('input[type="text"]').each(function() {
		$(this).keydown(function(event){
			if(event.keyCode==32) return false;
		});
	});
});
// 刷新验证码功能   
function refreshVerifyCode() {
	jQuery("#verifyCodeId").children().remove().end().append("<img align='middle' src='abc.code?random=" + Math.random() +"'/>");
}

function checkloginUserName(obj){
	var userNameValue =jQuery.trim(jQuery(obj).val());
	var email_regexp = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	
	if( email_regexp.test(userNameValue) ){
		jQuery("#loginType").val("email");
		jQuery("#loginKey").val(userNameValue);
	}else{
		jQuery("#loginType").val("userName");
		jQuery("#loginKey").val(userNameValue);
	}
}

jQuery(function(){
		
		//用户登录页面
		jQuery('#uc_login_username').blur(function(){
			if(jQuery.trim(jQuery('#uc_login_username').val()).length > 0 ){
				jQuery("#uc_login_username").parent().siblings(".info_error").html("");
			}else{
				jQuery("#uc_login_username").parent().siblings(".info_error").html("请输入登录账号");
				//jQuery("#uc_login_username").attr("class",usernameclass_error);
			}
		});
		jQuery('#uc_login_password').blur(function(){
			if(jQuery('#uc_login_password').val().length > 0 && jQuery('#uc_login_password').val().length < 6){
				jQuery("#uc_login_password").parent().siblings(".info_error").html("密码应大6个字符");
			}else if(jQuery('#uc_login_password').val().length >= 6){
				jQuery("#uc_login_password").parent().siblings(".info_error").html("");
			}else{
				jQuery("#uc_login_password").parent().siblings(".info_error").html("请输入密码");
				//jQuery("#uc_login_username").attr("class",password_class_error);
			}
		});
		jQuery('#uc_login_authcode').blur(function(){
			var login_authcode_val = jQuery.trim(jQuery("#uc_login_authcode").val());
			if(login_authcode_val.length == 0 ){
				jQuery("#uc_login_authcode").parent().parent().siblings(".info_error").html("请输入验证码");
			}else{
				if(checkVerifyCode(login_authcode_val)){
					jQuery("#uc_login_authcode").parent().parent().siblings(".info_error").html("");
				}else{
					jQuery("#uc_login_authcode").parent().parent().siblings(".info_error").html("验证码输入错误");
				}
			}
		});
		
		jQuery('.js_uc_login_submit_my').click(function(){
			var username= jQuery.trim(jQuery("#uc_login_username").val());
			var password = jQuery("#uc_login_password").val();
			var authcode = jQuery.trim(jQuery("#uc_login_authcode").val());
			var usernameBl = false;
			var passwordBl = false;
			var authcodeBl = false;
			if(username==""){
				jQuery("#uc_login_username").parent().siblings(".info_error").html("请输入用户名");
				usernameBl = false;
			}else{
				jQuery("#uc_login_username").parent().siblings(".info_error").html("");
				usernameBl = true;
			}
			if(password==""){
				jQuery("#uc_login_password").parent().siblings(".info_error").html("请输入密码");
				passwordBl = false;
			//}else if(password.length < 6){
			//	jQuery("#uc_login_password").parent().siblings(".info_error").html("密码应大6个字符");
			//	passwordBl = false;
			}else{
				jQuery("#uc_login_password").parent().siblings(".info_error").html("");
				passwordBl = true;
			}
			
			
			if(typeof(jQuery("#uc_login_authcode").val()) == "undefined"){
				jQuery("#uc_login_authcode").parent().parent().siblings(".info_error").html("");
				authcodeBl = true;
			}else{
				if(authcode==""){
					jQuery("#uc_login_authcode").parent().parent().siblings(".info_error").html("请输入验证码");
					authcodeBl = false;
				}else if(authcode.length > 0){
					jQuery("#uc_login_authcode").parent().parent().siblings(".info_error").html("");
					if(!checkVerifyCode(authcode)){
						jQuery("#uc_login_authcode").parent().parent().siblings(".info_error").html("验证码不正确");
					}else{
						jQuery("#uc_login_authcode").parent().parent().siblings(".info_error").html("");
						authcodeBl = true;
					}
				}
			}
			if(usernameBl && passwordBl && authcodeBl){
				jQuery("#my_submit").click();
			}
		}); 
});
//验证 验证码 是否正确
function checkVerifyCode(verifycode){
	var surl = "/ids/cn/haier_asyncCode.jsp";
	var cv_result = false;
	$.ajax({
			type: "post",
			dataType: "text",
			url: surl,
			async: false,
			data: {'verifycode':verifycode},
			error : function(XMLHttpRequest, textStatus, errorThrown){
				return "error";
			},
			success: function(returnData){
				
				var temp_result = jQuery.trim(returnData);
				
				if(temp_result === "true"){
					cv_result = temp_result;
				}		
			}
		});
	return cv_result;
}