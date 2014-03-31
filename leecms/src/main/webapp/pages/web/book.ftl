<html>
<head>
<title>留言板-美国凯帝国际有限公司</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="留言板">
<meta name="description" content="雨点免费留言板,单用户免费留言本">
<link href="/p/css/book.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function Mpic(f) {
		if (pass.style.display == "none") {
			pass.style.display = '';
			f.checked = true;
		} else {
			pass.style.display = 'none';
			f.checked = false;
		}
	}
	
	function Juge(theForm)
	{
		if (theForm.user_name.value == "")
		{
			alert("用户名为空");
			theForm.u_name.focus();
			return (false);
		}
		if (theForm.message.value == "")
		{
			alert("内容为空");
			theForm.T_Content.focus();
			return (false);
		}
	}
	function goPage(theForm)
	{
		if (theForm.page.value == "")
		{
			alert("页码为空");
			theForm.page.focus();
			return (false);
		}else{
			var url='/pp/listMessage?page='+theForm.page.value;
			theForm.action=url;
			return true;
		}
	} 
</script>
</head>

<body background="http://www.usacradi.com/gbook/image/bg1.gif" topmargin="0">
	<script type="text/javascript">
		function ShowSearch() {
			mysearch.style.display = '';
		}
		function HideSearch() {
			mysearch.style.display = 'none';
		}
	</script>
	<table width="740" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="FF6500" class="table1">
		<tr bgcolor="FED5BA">
			<td width="600" height="26"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="f12">
					<tr>
						<td width="17%"><div align="center">
								| <a href="http://www.usacradi.com/" target="_blank">版主主页</a> |
							</div></td>
						<td width="17%"><div align="center">
								| <a href="userlogin.asp">留言管理</a> |
							</div></td>
						<td width="17%"><div align="center">
								| <a href="modify.asp">资料修改</a> |
							</div></td>
						<td width="17%"><div align="center">
								<div id="mysearch" style="position: absolute; display: none; left: 457px; top: 32px; width: 200px; height: 31px; z-index: 1" onMouseOut="HideSearch()" onMouseOver="ShowSearch()">
									<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="FF6500">
										<form name="form2" method="post" action="index.asp">
											<tr bgcolor="FFFBF7">
												<td height="30"><input name="keyword" type="text" id="keyword" size="18" class="input"> <input type="submit" name="Submit" value="搜索" class="button"></td>
											</tr>
										</form>
									</table>
								</div>
								| <a href="#" onMouseOver="ShowSearch()"><strong>搜索留言</strong></a> |
							</div></td>
						<td width="17%"><div align="center"></div></td>
						<td width="17%"><div align="center"></div></td>
					</tr>
				</table></td>
			<td width="140">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<div align="right" class="f12">
								<a href="user_logout.asp"> </a>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>



	<table width="90%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="12"></td>
		</tr>
	</table>

	<table width="740" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="FF6500" class="f12">
		<form name="form1" method="post" action="/pp/saveMessage" onSubmit="return Juge(this)">
			<tr bgcolor="FED5BA">
				<td height="30" colspan="4"><div align="center">访 客 留 言 (加*号为必填项)</div></td>
			</tr>
			<tr>
				<td width="100" height="30" bgcolor="FFFBF7"><div align="center">用户网名：</div></td>
				<td width="192" bgcolor="FFFBF7">&nbsp; <input name="userName" type="text" class="input" id="userName" size="25" maxlength="40" value=> *
				</td>
				<td width="90" bgcolor="FFFBF7"><div align="center" style="display: none">用户信箱：</div></td>
				<td width="353" bgcolor="FFFBF7">&nbsp; <!--<input name="email" type="text" class="input" id="email" value="" size="30" maxlength="40"> -->
				</td>
			</tr>
			<tr>
				<td height="30" bgcolor="FFFBF7"><div align="center">联系电话：</div></td>
				<td bgcolor="FFFBF7">&nbsp; <input name="u_tel" type="text" class="input" id="u_tel" value="" size="25" maxlength="40">
				</td>
				<td bgcolor="FFFBF7"><div align="center">您的地址：</div></td>
				<td bgcolor="FFFBF7">&nbsp; <input name="u_add" type="text" class="input" id="u_add" value="" size="30" maxlength="40">
				</td>
			</tr>
			<tr>
				<td height="26" bgcolor="FFFBF7"><div align="center">您的留言：</div></td>
				<td height="100" colspan="3" bgcolor="FFFBF7">&nbsp; <textarea name="message" cols="80" rows="6" class="input" id="message"></textarea> *
					<div align="center"></div>
					<div align="center"></div></td>
			</tr>
			<!--tr bgcolor="efeff7">
				<td height="30" bgcolor="FFFBF7"><div align="center">附加码：</div></td>
				<td height="30" colspan="3" bgcolor="FFFBF7">&nbsp; <input name=verifycode type=text class="input" value="" size="25" maxlength="50"> &nbsp;请在附加码框输入 <img src="getcode.asp"></td>
			</tr-->
			<tr bgcolor="efeff7">
				<td height="30" bgcolor="FFFBF7"><div align="center">加密留言：</div></td>
				<td height="30" colspan="3" bgcolor="FFFBF7">&nbsp; <input name="isPublic" type="checkbox" id="isPublic" onClick="Mpic(this)" value="1"> 是否为加密留言
				</td>
			</tr>
			<tr bgcolor="efeff7" id="pass" style="display: none">
				<td height="30" bgcolor="FFFBF7"><div align="center">预留密码：</div></td>
				<td height="30" colspan="3" bgcolor="FFFBF7">&nbsp; <input name="pass" type="password" id="pass"> (查看自己的加密留言回复时需要使用到的密码)
				</td>
			</tr>
			<tr bgcolor="efeff7">
				<td height="30" bgcolor="FFFBF7">&nbsp;</td>
				<td height="30" colspan="3" bgcolor="FFFBF7"><font color="#FF3300">(您要为您所发的言论的后果负责，故请各位遵纪守法并注意语言文明)</font></td>
			</tr>
			<tr bgcolor="FFFBF7">
				<td height="30" colspan="4"><div align="center">
						<input name="Submit" type="submit" class="button" value="提交留言"> <input name="Submit2" type="reset" class="button" value="重新填写">
					</div></td>
			</tr>
		</form>
	</table>

	<table width="90%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>



<#list messages as one>
	<table width="740" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="FF6500">
		<tr bgcolor="FFFBF7">
			<td width="140" rowspan="3" valign="top"><div align="center">
					<table width="96%" border="0" cellpadding="0" cellspacing="0" style="margin-top: 30px;">
						<tr>
							<td height="24" valign="bottom" style="filter: glow(color =   #ff0000, direction =   10)"><div align="center" class="text">
									<p class="f12">
										<font color="#000000">${one.userName}</font>
									</p>
								</div></td>
						</tr>

						<tr>
							<td height="24"></td>
						</tr>
					</table>
				</div></td>
			<td width="600" height="26" class="f12">
			</td>
		</tr>
		<tr>
			<td width="600" height="70" valign="top" bgcolor="FFFBF7"><table width="96%" border="0" align="center" cellpadding="0" cellspacing="0" class="message">
					<tr>
						<td height="10"></td>
					</tr>
					<tr>
						<td style="WORD-BREAK: break-all">${one.message}</td>
					</tr>
					<tr>
						<td height="10"></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td width="600" height="24" bgcolor="FED5BA"><div align="right">
					<p class="f12">发表于:${one.createTime?string('yyyy-MM-dd HH:mm:ss')}&nbsp;</p>
				</div></td>
		</tr>

	</table>


	<table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>

</#list>



	<table width='740' border='0' align='center' cellPadding='0' cellSpacing='1' bgcolor='FF6500' class='f12'>
		<form method=Post action='' onSubmit="return goPage(this)">
			<tr bgcolor='FED5BA'>
				<td height='24'>
				<div align='center'>
						<#if page.currentPage == 1>
						<font color='#333333'>首页</font> -
						<font color='#333333'>前页</font> -
						<#else>
						<a href="/pp/listMessage?page=1"><font color="#ff0000">首页</font></a> -
						<a href="/pp/listMessage?page=${page.currentPage-1}"><font color="#ff0000">前页</font></a> -
						</#if>
						<#if page.currentPage < page.totalPage>
						<a href="/pp/listMessage?page=${page.currentPage+1}"><font color="#ff0000">后页</font></a> -
						<a href="/pp/listMessage?page=${page.totalPage}"><font color="#ff0000">尾页</font></a>
						<#else>
						<font color='#333333'>后页</font> -
						<font color='#333333'>尾页</font>
						</#if>
						
						<#if page.currentPage lt page.totolPage>
						<#else><font color='#333333'>尾页</font>
						</#if>
						
						
						&nbsp;&nbsp;<font color='#333333'>页次:</font>
						<font color=#ff0000 face='Geneva, Arial, Helvetica, sans-serif'>${page.currentPage}</font><font
							color='#333333' face='Geneva, Arial, Helvetica, sans-serif'>/${page.totalPage}</font>&nbsp;
							<font color=#ff0000 face='Geneva, Arial, Helvetica, sans-serif'>5</font>
							<font color='#333333' face='Geneva, Arial, Helvetica, sans-serif'>条/页&nbsp共</font><font color=#ff0000
							face='Geneva, Arial, Helvetica, sans-serif'>${page.count}</font>
							<font color='#333333'>条信息</font>&nbsp;&nbsp;<font color='#333333'>转到：</font>
							<input type='text' name='page' size=4 maxlength=4 class='Input' value=1>&nbsp;
							<input type='submit' value='转到' name='cndok' class='button'></span>
					</div>
				</td>
			</tr>
		</form>
	</table>
	<table width="90%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table width="90%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>

</body>
</html>