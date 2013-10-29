<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<title>用户登录|海尔家电家居 - 美好住居生活解决方案提供商</title>



<link href="a.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="http://www.haier.com/cn/images/LAB.min.js"></script>
<script type="text/javascript" src="http://www.haier.com/cn/images/jquery-1.5.2.min.js"></script>
<script type="text/javascript" src="http://www.haier.com/cn/images/swfobject.js"></script>

<script type="text/javascript" src="http://www.haier.com/cn/images/jquery-ui-1.8.11.custom.min.js"></script>
<script type="text/javascript" src="http://www.haier.com/cn/images/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="http://www.haier.com/cn/images/jquery.mmext.js"></script>


<link href="css/a.css" type="text/css" rel="stylesheet" />

</head>
<body onload="refreshVerifyCode();">

<!-- START header --> 

          <!-- END header --> 
          
          <!-- START main content -->
          <div class="login_content">
			<div class="login_cnt_left">
				<div class="login_logo">
					<div style="float:left;"><a href=""><img src="images/user1102_r1_c1.jpg" style="float:left;" /></a>
					</div>
					<div style="width:63px; height:28px; float:left; margin:0px; text-align:center; padding-top:12px; font-size:18px; font-family:'微软雅黑'; color:#303030;">通行证</div>
					<div style="clear:both;"></div>
				</div>
				<div class="login_img"></div>
			</div>
			<div class="login_cnt_right">
				<div class="login_box" style="position:relative">
				<div class="gaodu"></div>
				<form id="my_login_form" action="#" method="post" onsubmit="return checkform()">
					<input type="hidden" name="returnUrl" id="returnUrl" value="" />
					<input type="hidden" name="loginType" id="loginType" value="" />
					<input type="hidden" name="loginKey" id="loginKey" value="" />

					<table width="430" border="0" align="center" cellpadding="0" cellspacing="0" class="login_info">
					  <tr>
						<td width="88" height="50" align="right" valign="middle">登录名：</td>
						<td width="198" height="50" valign="middle" class="js_mmjs_validation_fe_wrap">
							<div class="uc_login_username_wrap il_box js_il_box">
								<input name="userName" onblur="checkloginUserName(this)" id="uc_login_username" tabindex="1" type="text" class="js_uc_login_username_input jsv_required haier_txz01" title="请输入用户名" />
								<label for="uc_login_username">用户名/手机号/电子邮箱 </label>
							</div>
							<span class="info_error js_validation_marke_info"></span>
						</td>
						<td width="144" height="50" valign="middle"><a style="color:#606060;" target="_blank" href="haier_regUser.jsp">注册新账号？</a></td>
					  </tr>
					  

					  <tr>
						<td height="50" align="right" valign="middle">密码：</td>
						<td height="50" valign="middle" class="js_mmjs_validation_fe_wrap">
							<div class="uc_login_password_wrap il_box js_il_box">
								<input name="password" id="uc_login_password" tabindex="2" type="password" class="js_uc_login_password_input jsv_required jsv_minlength_6 haier_txz01"  onKeyDown= "if(event.keyCode==32)return false;"  title="请输入密码|密码应大于6个字符" />
                                <label for="uc_login_password">请输入密码</label>
							</div>
							<span id="loginmessage" class="info_error js_validation_marke_info" style="width: 270px;line-height: 15px;"></span>
						</td>
						<td height="50" valign="middle"><span><a style="color:#606060;" href="forget_password.jsp">忘记密码？</a></span></td>
					  </tr>
					  <tr id="showverifycode">		  
					  
					   </tr>
					  <tr>
						<td height="54" valign="middle">&nbsp;</td>
						<td height="54" colspan="3" valign="middle">
							<span class="uc_login_cookie_wrap">
							  <input type="checkbox" id="uc_login_cookie" style="margin-left: 0;border: 0;" class="lzmdl" name="autoLogin" tabindex="4" value="true"/>
							  <!--    两周内自动登录  -->
							  <input name="cookieTime" id="js_cookieTime" type="hidden" value="0.5"/>

                              <label for="uc_login_cookie" style="padding-left: 0.1em;">两周内免登录</label>
                            </span> 
						</td>
					  </tr>
					  <tr>
						<td valign="middle">&nbsp;</td>
						<td colspan="3" valign="middle">
							
							<div class="uc_login_submit_wrap"> 
								<a href="###" class="uc_login_submit_btn js_uc_login_submit_my" tabindex="5"><img src="http://www.haier.com/cn/images/user1102_r8_c7.jpg" /></a>
							</div>
						</td>
					  </tr>
					</table>
					<span class="hide_box"><input type="submit" id="my_submit"/></span>
				</form>
				<div class="login_fenxiang" style="width: 420px; position: absolute;bottom:35px;left:20px">
					<a href="#">使用合作网站账户登录海尔：</a>
					<p id="thirdshow" align="center"  >
						<a style="background:0px;padding-left: 0px;" href="http://user.haier.com/ids/admin/loginByThird.jsp?regFrom=QQ&returnUrl=http://user.haier.com/HaierFramework/haier/appuser/queryUpdateAppuserHr.do">
							<img style="border:0px;" src="http://www.haier.com/cn/images/qq_r1_c1.jpg" title="腾讯微博"/>
						</a>
						<a style="background:0px;padding-left: 0px;" href="http://user.haier.com/ids/admin/loginByThird.jsp?regFrom=sinaWeibo&returnUrl=http://user.haier.com/HaierFramework/haier/appuser/queryUpdateAppuserHr.do">
							<img style="border:0px;" src="http://www.haier.com/cn/images/sina_r1_c2.jpg" title="新浪微博"/>
						</a>
						<a style="background:0px;padding-left: 0px;" href="http://user.haier.com/ids/admin/loginByThird.jsp?regFrom=renren&returnUrl=http://user.haier.com/HaierFramework/haier/appuser/queryUpdateAppuserHr.do">
							<img style="border:0px;padding-left: 0px;" src="http://www.haier.com/cn/images/renren_r1_c3.jpg" title="人人网"/>
						</a>
						<a style="background:0px;padding-left: 0px;" href="http://user.haier.com/ids/admin/loginByThird.jsp?regFrom=kaixin&returnUrl=http://user.haier.com/HaierFramework/haier/appuser/queryUpdateAppuserHr.do">
							<img style="border:0px;" src="http://www.haier.com/cn/images/kaixin_r1_c4.jpg" title="开心网"/>
						</a>
						<a style="background:0px;padding-left: 0px;" href="http://user.haier.com/ids/admin/loginByThird.jsp?regFrom=netEasePassport&returnUrl=http://user.haier.com/HaierFramework/haier/appuser/queryUpdateAppuserHr.do">
							<img style="border:0px;" src="http://www.haier.com/cn/images/wangyi_r1_c5.jpg" title="网易通行证"/>
						</a>
						<a style="background:0px;padding-left: 0px;" href="http://user.haier.com/ids/admin/loginByThird.jsp?regFrom=douban&returnUrl=http://user.haier.com/HaierFramework/haier/appuser/queryUpdateAppuserHr.do">
							<img style="border:0px;" src="http://www.haier.com/cn/images/douban_r1_c6.jpg" title="豆瓣网"/>
						</a>
					</p>
				</div>
			</div>
			</div>
		</div>
          <!-- END main content --> 
<form id="newlogin" method="post">
<input type="hidden" id="yuserName" name="yuserName"/>
<input type="hidden" id="yemail" name="yemail"/>
</form>

		
</body>
</html>