<#import "/web/area.ftl" as area/>
<#import "/dynamic/common.ftl" as g/>

<@index/>

<#macro index>
<@area.frame>
<div class="wrap linebg">
	<@area.nav/>
	<@right/>
</div>
	<div class="clear"></div>
	<@list/>
	<@step/>
</@area.frame>
<script type="text/javascript" src="/p/scripts/prototype.js"></script>
<script type="text/javascript" src="/p/scripts/global.js"></script>
<script type="text/javascript">
    if (getCookie("username") != null) {
        $("j_username").value = getCookie("username");
        $("j_password").focus();
    } else {
        $("j_username").focus();
    }
    
    function saveUsername(theForm) {
        var expires = new Date();
        expires.setTime(expires.getTime() + 24 * 30 * 60 * 60 * 1000); // sets it for approx 30 days.
        setCookie("username",theForm.j_username.value,expires,"/");
    }
    
    function validateForm(form) {                                                               
        return validateRequired(form); 
    } 
    
    function passwordHint() {
        if ($("j_username").value.length == 0) {
            alert("用户名 为必填项。");
            $("j_username").focus();
        } else {
            location.href="/passwordHint?username=" + $("j_username").value;
        }
    }
    
    function required () { 
        this.aa = new Array("j_username", "用户名 为必填项。", new Function ("varName", " return this[varName];"));
        this.ab = new Array("j_password", "密码 为必填项。", new Function ("varName", " return this[varName];"));
    } 
</script>
</#macro>


<#macro list>
<div class="bg-common-2 wrap">
	<div class="list_top">
		<div class="list_title">
		      基&nbsp;&nbsp;本&nbsp;&nbsp;服&nbsp;&nbsp;务
		</div>
	      <ul >
	        <li>网站标志一个[赠送]</li>
	        <li>Banner广告一个[赠送]</li>
	        <li>1个独立域名</li>
	        <li>功能完善的网站管理系统</li>
	        <li>全静态网站程序</li>
	        <li>MYSQL数据库支持</li>
	        <li>会打字就能建网站</li>
	        <li>高性能网站服务器</li>
	        <li>在线技术支持</li>
	        <li>7×24小时网站监控维护</li>
	      </ul>
	</div>
	<div class="clear"></div>
	<div>
		<ul class="compose-1">
			<li>
		          <h5><a target="_blank" href="#">个人普及型</a></h5>
		          <p>100M网站空间<br/>50个并发连接数<br/>普及型模板<br/>支持数据导出(否)<br/>模板可编辑(否)</p>
		          <p class="second">服务费：600元/年</p>
		          <p><a target="_blank" class="btn-2" href="#"><span>立即订购</span></a></p>
		          <div><a target="_blank" href="#" class="newphone"></a><a target="_blank" href=#" class="more-bg"></a></div>
	        </li>
			<li>
		          <h5><a target="_blank" href="#">个人豪华型</a></h5>
		          <p>200M网站空间<br/>100个并发连接数<br/>个人豪华型模板<br/>支持数据导出(否)<br/>模板可编辑(是)</p>
		          <p class="second">服务费：900元/年</p>
		          <p><a target="_blank" class="btn-2" href="#"><span>立即订购</span></a></p>
		          <div><a target="_blank" href="#" class="newphone"></a><a target="_blank" href=#" class="more-bg"></a></div>
	        </li>
			<li>
		          <h5><a target="_blank" href="#">公司普通型</a></h5>
		          <p>300M网站空间<br/>200个并发连接数<br/>公司豪华型模板<br/>支持数据导出(是)<br/>模板可编辑(否)</p>
		          <p class="second">服务费：1000元/年</p>
		          <p><a target="_blank" class="btn-2" href="#"><span>立即订购</span></a></p>
		          <div><a target="_blank" href="#" class="newphone"></a><a target="_blank" href=#" class="more-bg"></a></div>
	        </li>
			<li>
		          <h5><a target="_blank" href="#">公司豪华型</a></h5>
		          <p>400M网站空间<br/>300个并发连接数<br/>公司豪华型模板<br/>支持数据导出(是)<br/>模板可编辑(是)</p>
		          <p class="second">服务费：1500元/年</p>
		          <p><a target="_blank" class="btn-2" href="#"><span>立即订购</span></a></p>
		          <div><a target="_blank" href="#" class="newphone"></a><a target="_blank" href=#" class="more-bg"></a></div>
	        </li>
		</ul>
	</div>
</div>
</#macro>

<#macro right>
	<div class="fmiddle">
		<@g.lunBo pictures=loop1 />
        <div class="clear"></div>
	</div>
	<div class="fright">
	<#if user?has_content>
		<div id="loginsty"><ul><li class="select">用户信息</li><li class=""><a href="/logout">退出</a></li></ul></div>
    	<div id="content">
			<div class="main">
				<div class="l_account">
            		<span class="numtext1">欢迎您 </span>
				</div>
				<div class="l_account clear">
            		<span class="numtext1">用户名:</span>
                    <span class="numinput"> ${user.username}</span>
				</div>
			<div class="goto clear"><div><a href="/pages/view/index/1.html" >访问主站</a></div></div>
			<div class="goto clear"><div><a href="/pp/w/adminIndex" >进入管理平台</a></div></div>
			</div>
		</div>
	<#else>
		<div id="loginsty"><ul><li class="select">用户登录</li><li class=""><a href="/pp/w/signup">用户注册</a></li></ul></div>
		<form method="post" id="loginForm" action="/j_security_check" onsubmit="saveUsername(this);return validateForm(this)">
    	<div id="content">
			<div class="main">
				<div class="l_account clear">
            		<span class="numtext">用户名:</span>
                    <span class="numinput">
                        <input type="text" onfocus="hiddenTipInfo(this);" value="请输入用户名" alt="用户名"
                         style="text-align:left;ime-mode:active; color:#999999; " maxlength="11" tipinfo="请输入用户名"
                          id="j_username" name="j_username" class="telnum"/>
                    </span>
				</div>
				<div class="l_account clear">
            		<span class="numtext">密码:</span>
                    <span class="numinput">
                        <input type="password" onfocus="hiddenTipInfo(this);" value="请输入密码" alt="密码"
                         style="text-align:left;ime-mode:active; color:#999999; " maxlength="11" tipinfo="请输入手机号码"
                          id="j_password" name="j_password" class="telnum"/>
                    </span>
				</div>
			</div>
			<div class="login sub"><input type="submit" id="t_login" value="登录" style="cursor:hand;"></div>
		</div>
		</form>
	</#if>
	</div>
</#macro>

<#macro step>
<div class="rmyw wrap">
	<div class="title"><strong>建站流程</strong></div>
	<div class="yw_box">
		<span class="step"><span class="step_num1"></span><h3>第一步</h3>
			<h4>填写必要信息<br/>注册账号</h4>
		</span>
		<span class="remen_img"><img src="/p/css/web/arrow_big_r.gif"></span>
		<span class="step"><span class="step_num2"></span><h3>第二步</h3>
			<h4>在试用期内您可以熟悉各项操作，<br/>如果遇到问题，我们的技术支持人员会为您提供技术支持</h4>
		</span>
		<span class="remen_img"><img src="/p/css/web/arrow_big_r.gif"></span>
		<span class="step"><span class="step_num3"></span><h3>第三步</h3>
		    <h4>熟悉操作后，如果您觉得合适，可以签订合同并汇款，我们会为您及时开通，给您进行全程服务</h4>
		</span>
		<span class="remen_img"><img src="/p/css/web/arrow_big_r.gif"></span>
		<span class="step"><span class="step_num4"></span><h3>第四步</h3>
			<h4>收取到汇款后，<br/>我们会在一周之内为您建立好域名和Logo，你就可以使用快捷方便的网站了。</h4>
		</span>
	</div>
</div>
</#macro>