<#import "/main/right/common.ftl" as common/>
<#macro main>
<@common.body>
	<div style="margin-top:100px;">
		<table class="tb" align="center" border="0" cellpadding="6" cellspacing="1">
			<tbody>
			<tr>
				<td class="tb_title" style="HEIGHT: 14px" colspan="2" align="center">网站基本信息</td>
			</tr>
			<tr>
				<td style="width: 81px">用户名:</td><td style="width:650px"><span id="lblUserName">${user.username}</span></td>
			</tr>
			<tr>
				<td>用户类型:</td>
				<td><span id="lblUserType">${webInfo.webType}</span></td>
			</tr>
			<tr>
				<td>注册日期:</td>
				<td><span id="lblInDate">${webInfo.createTime?string('yyyy/MM/dd HH:mm:ss')}</span></td>
			</tr>
			<tr>
				<td>最近登录IP:</td>
				<td><span id="lblLoginIP">${webInfo.lastLoginIp}</span></td>
			</tr>
			<tr>
				<td>最近登录时间:</td>
				<td><span id="lblLoginTime">${webInfo.lastLoginTime?string('yyyy/MM/dd HH:mm:ss')}</span></td>
			</tr>
			<tr>
				<td>到期日期:</td>
				<td><span id="lblEndDate">${webInfo.expireTime?string('yyyy/MM/dd HH:mm:ss')}</span></td>
			</tr>
			<tr>
				<td>网站模板:</td>
				<td><span id="templateInstanceId">NO.${webInfo.webCfgTemplateId}</span><input style="margin-left:100px;" type="button" onclick="javasript:business.show();" value="更换模板"></td>
			</tr>
			<tr>
				<td>空间使用情况:</td>
				<td>
					<table id="Table2" style="WIDTH: 197px; HEIGHT: 20px" bgcolor="darkgray" border="0" cellpadding="1" cellspacing="1" width="197">
						<tbody><tr>
							<td bgcolor="#ffffff">
								<table id="Table3" bgcolor="#66ff66" border="0" cellpadding="0" cellspacing="0" height="100%" width="0.35%">
									<tbody><tr><td background="/pages/main/images/100bg.gif"></td></tr>
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
				<td>临时网址:</td>
				<td><a id="hlUrl" href="${webInfo.webTmpUrl}" target="_blank" style="text-decoration:underline;">${webInfo.webTmpUrl}</a></td>
			</tr>
			<tr>
				<td>网站域名:</td>
				<td><span id="lbldomain">${webInfo.webDomain}</span></td>
			</tr>
		</tbody></table>
	</div>
	
<div style="position: absolute;top: 100px;left: 100px;" id="select">
	<table id="selectTable"></table>
	<div id="selectDiv"></div>
</div>
<script type="text/javascript" src="/p/js/business/common.js"></script>
<script type="text/javascript" src="/p/js/business/template.js"></script>
</@common.body>
</#macro>

<@main/>