<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#macro detail>
<div class="guest_main">

	<div><input type="button" onclick="javascript:location.href='#write';" value="我要留言" name="Submit"></div>
	
	<#list 1..4 as one>
	<div class="tableDiv">
		<table width="96%" cellspacing="1" cellpadding="1" border="0" align="center" class="guest_border">
		  <tbody>
		  <tr> <td height="24" class="guest_title" colspan="2">&nbsp;被辞退</td></tr>
		  <tr> 
		    <td width="124" valign="top" align="center" rowspan="2">留言内容<br><img src="${commTBase}/images/face/1.gif"> <br>留言者：匿名</td>
		    <td width="588" valign="top" style="word-break:break-all;word-wrap:break-word;">
		    	我在乡卫生院工作18年当初去工作医院没有与我签订任何合同现在要辞退我我该怎么办请回复一下拜托
		    </td>
		  </tr>
		  <tr> <td height="18" align="right"> 来自:       121.27.217.121      留言时间:       2012-5-31 22:48:45    </td>
		  </tr>
		  
		  <tr> 
		    <td valign="top" align="center" rowspan="2">回复内容</td>
		    <td width="588" valign="top" style="word-break:break-all;word-wrap:break-word;">
		       <font color="#FF0000">你好，建议找当地劳动保障局投诉。<br></font>
		    </td>
		  </tr>
		  <tr> <td height="18" align="right">回复：王律师    回复时间：2012-7-18 21:46:16</td></tr>
		</tbody></table>
	</div>
	</#list>

<div>
<span>共有<font color="#ff0000">780</font>条留言 当前页<font color="#ff0000">1</font>/78</span>
<span> 首页  上页 <a href="Guest.shtml?page=2">下页</a> <a href="Guest.shtml?page=78">尾页 </a>  转到第 
      <select onchange="javascript:location=this.options[this.selectedIndex].value;" name="sel_page">
        
        <option selected value="Guest.shtml?id=&amp;page=1">1</option>
        <#list 1..80 as one>
        <option value="Guest.shtml?id=&amp;page=${one_index}">${one_index}</option>
		</#list>
        
      </select></span>页
</div>

<div class="tableDiv"><strong><a name="write"></a>发 表 留 言</strong>
  <form onsubmit="return Check(this)" action="" method="post" name="form1">
<table width="723" height="398" cellspacing="1" cellpadding="1" align="center">
    <tbody><tr > 
      <td height="23" width="104">&nbsp;是否公开:</td>
      <td width="619"> <input type="radio" checked value="1" name="IsPub">公开 <input type="radio" value="0" name="IsPub">不公开</td>
    </tr>
    <tr > 
      <td height="23">&nbsp;留言主题:</td><td > <input type="text" value="" maxlength="50" size="50" id="Title" name="Title"></td>
    </tr>
    <tr > 
      <td valign="top">&nbsp;留言内容:<br>(不超过800字)</td>
      <td><textarea id="Content" rows="10" cols="62" name="Content"></textarea></td>
    </tr>
    <tr > 
      <td height="23">&nbsp;当前表情:</td>
      <td> 
      <#list 1..17 as one>
        <input type="radio" value="face/${one_index}.gif" name="face"> <img width="20" height="20" src="${commTBase}/images/face/${one_index}.gif"> 
		</#list></td>
    </tr>
    <tr > 
      <td height="23">&nbsp;用户名:</td><td> 
        <input type="hidden" value="0" id="UserID" name="UserID"> 您目前是匿名发表 <a href="./">登录</a> | <a href="Reg_Read.shtml">注册</a> 
        <input type="hidden" value="add" id="action" name="action"> </td>
    </tr>
    <tr >
      <td height="23">&nbsp;姓 名:</td>
      <td><input type="text" maxlength="12" size="12" id="Uname" name="Uname"><font color="#ff0000">*</font>必填,此信息不公开</td>
    </tr>
    <tr >
      <td height="23">&nbsp;联系电话:</td>
      <td><input type="text" maxlength="20" size="20" id="Tel" name="Tel"><font color="#ff0000">*</font>必填,此信息不公开</td>
    </tr>
    <tr >
      <td height="23">&nbsp;电子邮箱:</td>
      <td><input type="text" maxlength="50" size="30" id="Email" name="Email">选填,此信息不公开</td>
    </tr>
    <tr > 
      <td height="23">&nbsp;验证码: </td>
      <td> <input type="text" maxlength="4" size="6" id="Rand" name="Rand"> <img src="inc/code.asp">(请输入四位验证码)</td></tr>
    <tr > 
      <td colspan="2"><input type="submit" value="保存留言" name="Submit"></td>
    </tr>
</tbody></table>
</form>

</div>
</#macro>

<@frame.exe jsName="index">
		<@detail/>
</@frame.exe>