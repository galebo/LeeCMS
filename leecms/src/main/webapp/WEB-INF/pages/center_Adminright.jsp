<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html><head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>welcome</title>
<link href="/pages/main/css/Style.css" type="text/css" rel="stylesheet">
<script language="javascript">
//parent.topFrame.document.all.nav.innerHTML = "您现在的位置：网站基本信息";
</script>
</head>
	<body >
	<table style="HEIGHT: 414px" align="center" border="0" cellpadding="0" cellspacing="1" height="414" width="100%">
		<tbody>
			<tr align="center" valign="top">
				<td height="178" valign="top"><br>
					<br>
					<table class="Tb" id="Table1" style="WIDTH: 731px; HEIGHT: 391px" align="center" border="0" cellpadding="6" cellspacing="1" width="731">
						<tbody>
						<tr>
							<td class="TbTitle" style="HEIGHT: 14px" colspan="2" align="center">网站基本信息</td>
						</tr>
						<tr>
							<td class="Tb_TD" style="WIDTH: 81px">用户名:</td><td class="Tb_TD"><span id="lblUserName">${pageContext.request.remoteUser}</span></td>
						</tr>
						<tr>
							<td class="Tb_TD" style="WIDTH: 81px">用户类型:</td><td class="Tb_TD"><span id="lblUserType">普及型</span></td>
						</tr>
						<tr>
							<td class="Tb_TD" style="WIDTH: 81px">注册日期:</td><td class="Tb_TD"><span id="lblInDate">2012-8-17 17:54:12</span></td>
						</tr>
						<tr>
							<td class="Tb_TD" style="WIDTH: 81px; HEIGHT: 27px">最近登录IP:</td>
							<td class="Tb_TD" style="HEIGHT: 27px"><span id="lblLoginIP">119.57.33.198</span></td>
						</tr>
						<tr>
							<td class="Tb_TD" style="WIDTH: 81px; HEIGHT: 27px">最近登录时间:</td>
							<td class="Tb_TD" style="HEIGHT: 27px"><span id="lblLoginTime">2012-8-27 9:50:50</span></td>
						</tr>
						<tr>
							<td class="Tb_TD" style="WIDTH: 81px; HEIGHT: 28px">到期日期:</td>
							<td class="Tb_TD" style="HEIGHT: 28px"><span id="lblEndDate">2012-8-25 0:00:00</span>&nbsp;<font color="#ff0000"><strong>您的网站已到期，请及时续费!</strong></font></td>
						</tr>
						<tr>
							<td class="Tb_TD" style="WIDTH: 81px">网站模板:</td><td class="Tb_TD"><span id="lblTemp_ID">NO.34</span></td>
						</tr>
						<tr>
							<td class="Tb_TD" style="WIDTH: 81px">空间使用情况:</td>
							<td class="Tb_TD">
								<table id="Table2" style="WIDTH: 197px; HEIGHT: 20px" bgcolor="darkgray" border="0" cellpadding="1" cellspacing="1" width="197">
									<tbody><tr>
										<td bgcolor="#ffffff">
											<table id="Table3" bgcolor="#66ff66" border="0" cellpadding="0" cellspacing="0" height="100%" width="0.35%">
												<tbody><tr>
													<td background="images/100bg.gif"></td>
												</tr>
											</tbody></table>
										</td>
									</tr>
								</tbody></table>
								总空间:
								<span id="lblFileSize">100.00</span>MB &nbsp;已用空间:
								<span id="lblUseFileSize">0.35</span>MB
							</td>
						</tr>
						<tr>
							<td class="Tb_TD" style="WIDTH: 81px">临时网址:</td>
							<td class="Tb_TD">
								<a id="hlUrl" href="http://s2.86lawyer.net/site/fangtao" target="_blank" style="text-decoration:underline;">${WebTmpUrl}</a></td>
						</tr>
						<tr>
							<td class="Tb_TD" style="WIDTH: 81px">网站域名:</td>
							<td class="Tb_TD">
								<span id="lbldomain">尚未开通独立域名!</span></td>
						</tr>
					</tbody></table>
				</td>
			</tr>
		</tbody>
	</table>
</body></html>