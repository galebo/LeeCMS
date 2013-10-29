<#macro top>
<div class="xin_head">
	<div class="xin_head1"><img  src="${uploadDir}/logo.png"> </div>
	<div class="xin_head2"><img  src="${uploadDir}/kouhao.png"> </div>
	<div class="xin_head3">
		<div class="xin_topy1">
		<a href="#">本站使用指南</a>
		<a target=blank href=>qq在线咨询</a>
		<a href="#" target="_blank">收藏本站</a>
		</div>
		<div class="xin_topy2">
		<p>${common.siteDefine['selfName']}  资深房产纠纷专业律师</p>
		<p> 咨询电话：${common.siteDefine['mobile']}</p>
		</div>
	</div>
</div>
</#macro>

<#macro copyright>
<div class="copyright">
	<a href="#">关于我们</a>|<a href="#">权责声明 </a>| <a href="#">联系我们</a>| <a href="#">网站地图</a><br>
	版权所有 未经允许 禁止抄袭。<br>
	地址：${common.siteDefine['address']} 邮编：${common.siteDefine['mail-num']}<br>电话：${common.siteDefine['workSite']} （工作时间）
	  传真：${common.siteDefine['fax']}  手机：${common.siteDefine['mobile']}<br>
	email：${common.siteDefine['email']}  qq：${common.siteDefine['qq']}  msn：${common.siteDefine['msn']}<br>
</div>
</#macro>

<#macro self divCss="l1 b_div_top" h2DivClass="" >
	<div class="${divCss}">
		<div class="${h2DivClass}"><h2><a href="">律师介绍</a></h2></div>
		<p>
			<img src="${common.siteDefine['selfPicture']}">
			<span>${common.siteDefine['selfAbout']}</span>
		</p>
	</div>
</#macro>
<#macro ziXun>
	<div class="r_1">
		<div class="line1"><p><a href="#" target="_blank"><img border="0" alt="咨询" src="${uploadDir}/gbzx.jpg"></a></p></div>
		<div class="line2">
		<p>
		<a href="#" target="_blank"><img border="0" src="#" alt="点击这里给我发消息" title="点击这里给我发消息"></a>
		<a href="#" target="_blank"><img border="0" src="#" alt="点击这里给我发消息" title="点击这里给我发消息"></a>
		</p>
		</div>
	</div>
</#macro>
<#macro guangGao>
	<div class="banner"><a href="#" target="_blank"><img src="${uploadDir}/banner1.jpg"></a></div>
</#macro>
