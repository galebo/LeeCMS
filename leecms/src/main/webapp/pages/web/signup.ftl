<#import "/web/area.ftl" as area/>
<@exe/>

<#macro exe>
<@area.frame>
<div class="wrap linebg">
	<@area.nav/>
	<@table/>
	<div class="clear"></div>
</div>
</@area.frame>
</#macro>


<#macro table>
<div class="signup">
<table width="639" cellspacing="1" cellpadding="4" border="1" align="center" style="WIDTH: 639px; HEIGHT: 578px" id="Table1">
	<tbody><tr>
		<td bgcolor="#f4f4f4" style="WIDTH: 92px; HEIGHT: 21px"><span>用户名</span></td>
		<td bgcolor="#ffffff" style="WIDTH: 491px;"><input type="text" style="width:145px;" id="txtUser_Name" maxlength="20" name="txtUser_Name"><input type="button" value="检查用户名" onclick="checkreg()" id="btnCheckReg">
			<font color="#ff0000">*</font>用户名:4-16字节，字母数字下划线</td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>密&nbsp; 码</span></td>
		<td bgcolor="#ffffff" style="WIDTH: 491px; HEIGHT: 24px"><input type="password" style="width:148px;" id="txtUser_Pwd" maxlength="30" name="txtUser_Pwd"><font color="#ff0000">*</font></td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>确认密码</span></td>
		<td bgcolor="#ffffff"><input type="password" style="width:147px;" id="txtUser_Pwd1" maxlength="30" name="txtUser_Pwd1"><font color="#ff0000">*</font></td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>联系人姓名</span></td>
		<td bgcolor="#ffffff"><input type="text" id="txtFull_Name" maxlength="10" name="txtFull_Name"><font color="#ff0000">*</font></td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>联系人性别</span></td>
		<td bgcolor="#ffffff"><table border="0" style="width:95px;" id="rbl_Sex">
	<tbody><tr>
		<td><input type="radio" checked="checked" value="男" name="rbl_Sex" id="rbl_Sex_0"><label for="rbl_Sex_0">男</label></td><td><input type="radio" value="女" name="rbl_Sex" id="rbl_Sex_1"><label for="rbl_Sex_1">女</label></td>
	</tr>
</tbody></table></td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>有效证件号码</span></td>
		<td bgcolor="#ffffff"><select id="drpC_Type" name="drpC_Type">
<option value="1">律师执业证号</option>
<option value="2">事务所执业证号</option>
<option value="3">居民身份证</option>

</select>
			<input type="text" style="width:202px;" id="txtCertificate" maxlength="30" name="txtCertificate"><font color="#ff0033">*</font></td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>所在地区</span></td>
		<td bgcolor="#ffffff"><select name="Pro_ID" onchange="javascript:unio_area(document.register.City_ID,this.value)" id="Pro_ID">
				<option selected value="0">选择所在省(市)</option>
				<option value="100009">北京市</option>
				<option value="100010">上海市</option>
				<option value="100011">天津市</option>
				<option value="100012">重庆市</option>
			</select>
			<select name="City_ID" id="City_ID">
				<option selected value="0">选择所在市(区)</option>
			</select>
			<font color="#ff0000">*</font>
		</td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>电话</span></td>
		<td bgcolor="#ffffff"><input type="text" id="txtTel" maxlength="20" name="txtTel"><font color="#ff0000">*</font></td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>手机</span></td>
		<td bgcolor="#ffffff"><input type="text" id="txtMphone" maxlength="20" name="txtMphone"></td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>QQ</span></td>
		<td bgcolor="#ffffff"><input type="text" style="width:105px;" id="txtQQ" maxlength="20" name="txtQQ"></td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>通信地址</span></td>
		<td bgcolor="#ffffff"><input type="text" style="width:326px;" id="txtAddress" maxlength="100" name="txtAddress"><font color="#ff0000">*</font></td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>邮编</span></td>
		<td bgcolor="#ffffff"><input type="text" style="width:71px;" id="txtPostID" maxlength="6" name="txtPostID"><font color="#ff0000">*</font></td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>电子邮箱</span></td>
		<td bgcolor="#ffffff"><input type="text" style="width:184px;" id="txtEmail" maxlength="30" name="txtEmail"><font color="#ff0000">*</font></td>
	</tr>
	<tr>
		<td bgcolor="#f4f4f4"><span>用户类型</span></td>
		<td bgcolor="#ffffff"><select id="drpUser_Type" name="drpUser_Type">
	<option value="1">律师</option>
	<option value="2">律师事务所</option>
	<option value="3">律师协会</option>
	<option value="5">法律学术团体</option>

</select><font color="#ff0000">*</font></td>
		</tr>
		<tr>
			<td bgcolor="#f4f4f4"><span>网站名称</span></td>
			<td bgcolor="#ffffff"><input type="text" style="width:307px;" id="txtSite_Name" maxlength="50" name="txtSite_Name">
<input type="hidden" name="action" value="ok" id="action"><font color="#ff0000">*</font></td>
		</tr>
		<tr>
			<td bgcolor="#ffffff" align="center" colspan="2">&nbsp;
				<input type="button" name="btnSave" value="提交并生成网站" onclick="CheckForm()" id="btnSave"></td>
		</tr>
	</tbody></table>
</div>
</#macro>