
<#macro item_detail title>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<title>${title} - CRADI INTERNATIONAL (USA) INC</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="http://www.usacradi.com/images/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<@g.top/>

	<table width="920" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td width="190" valign="top">
   				<@item_detail_left/>
			</td>
			<td width="9" valign="top"></td>
			<td valign="top">
			
			<table style="border: 1px solid #dcdcdc;" border="0" cellpadding="0" cellspacing="0" width="100%">
					<tbody>
						<tr>
           					 <td width="320" height="26" colspan="2" align="right" background="http://www.usacradi.com/images/index-02_54.jpg">
           					 <table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="2"></td>
										<td width="90" nowrap="nowrap" background="http://www.usacradi.com/images/index-02_69.jpg"><div class="pianbt2">${title} &gt;&nbsp;&nbsp;</div></td>
                 						 <td width="16"><img src="http://www.usacradi.com/images/index-02_69.gif" width="16" height="26"></td>
										<td></td>

									</tr>
								</table></td>
						</tr>
						<tr>
							<td colspan="2" align="left">
								<#nested>
							</td>
						</tr>
					</tbody>
				</table>
				</td>
		</tr>
	</table>

<@g.bottom/>


</body>
</html>

</#macro>

<#macro item_detail_left>

			<table style="border: 1px solid #dcdcdc;" border="0" cellpadding="0" cellspacing="0" width="100%">
					<tbody>
						<tr>
     			 		<td class="baojie" align="left" background="http://www.usacradi.com/images/index-02_77.jpg" height="24"><div class="pianbt3">信息搜索 &gt;&nbsp;&nbsp;</div></td>
						</tr>
						<tr>
							<td align="left" valign="top"><DIV class=lysearch>
									<FORM action=search.asp method="get">
										<INPUT value=0 type=hidden name=kwtype>
											<P>
												<INPUT name=q class=text type=text id="q" onfocus="if(this.value==this.defaultValue){this.value='';}" onBlur="if(this.value==''){this.value=this.defaultValue;}" value="请输入查找关键字"> <INPUT value=titlekeyword type=hidden name=searchtype>
											</P>
											<P>
												<INPUT class=lysub value=提交 type=submit name=Submit>
											</P>
									</FORM>
								</DIV></td>
						</tr>
					</tbody>
				</table>
				<table width="100%" height="10" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td></td>
					</tr>
				</table>
				<table style="border: 1px solid #dcdcdc;" border="0" cellpadding="0" cellspacing="0" width="100%">
					<tbody>
						<tr>
      						<td class="baojie" align="left" background="http://www.usacradi.com/images/index-02_77.jpg" height="24"><div class="pianbt3">海外资讯 &gt;&nbsp;&nbsp;</div></td>
						</tr>
						<tr>
							<td align="left" valign="top"><table width="100%" height="4" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td></td>
									</tr>
								</table>
								<table width="100%" height="10" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td style="padding-left: 5px;">
						              <#list 1..5 as one>
						              <table width="100%" align="center" cellspacing="0" cellpadding="0">
						              	<tr><td width=12 height=20><img src="http://www.usacradi.com/images/newsdot.gif"></td><td><a  href="#" >美国人闯不闯黄灯!</a></td></tr></table>       
									</#list>
									</td>
									</tr>
								</table>
								<table width="100%" height="4" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td></td>
									</tr>
								</table></td>
						</tr>
					</tbody>
				</table>
</#macro>