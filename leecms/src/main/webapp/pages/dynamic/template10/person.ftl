<#macro list1 item>
	<div id="lawermore_down">
		<div id="lawermore_down1">
			<a href="${item.url}">${item.name}</a>
		</div>
		<div id="lawermore_down2_1">
			<ul id="lawermore_down2">
			<#list item.contents as one>
				<li><a href='${one.url}' target='_blank'>${one.name}</a></li>
			</#list>
			</ul>
		</div>
	</div>
</#macro>

<#macro person_about>
<div id="lawerxx">
		<div id="lawerxx_box">
			<div id="lawerxx_2">
				<div id="lawerxx_1_1">
					<div id="lawerxx_1">
						<p>
							<a href="Contact.asp"> <img src="${commTBase}/upload/4834b2707050ca8b.jpg"
								border="0" alt="李永建律师" height="145px" width="125px" />
							</a>
						</p>
					</div>
					<div id="lawerxx_3">
						<span class="lawerxx_33"><a href="#">${common.siteDefine['selfName']}</a></span></br>
						<font>${common.siteDefine['keyword']}</font> <br />手机: ${common.siteDefine['mobile']}<br />电话: ${common.siteDefine['telephone']} <br />
						<div style="height: 25px; width: 35px; line-height: 20px; float: left;">QQ:</div><a target="_blank"
							href="http://wpa.qq.com/msgrd?v=3&uin=${common.siteDefine['qq']}&site=qq&menu=yes">${common.siteDefine['qq']}</a>
						<div>
							<a href="#"><img src="${commTBase}/images/anniu.jpg" border="0" /></a>
						</div>
					</div>

					<div id="lawerxx_4">
						<span>专长领域：</span>
						<font id='lawerxx_4_1'>
						刑事辩护、债务追讨、交通事故<BR>
						合同纠纷、人身损害、婚姻家庭<BR>
						遗产继承、房产纠纷、公司犯罪<BR>
						常年顾问</font><span>律师执业证：</span><font>111111</font><br>
							<span>联系地址：</span><font>${common.siteDefine['address']}</font><br />
						<span>邮箱: </span><font><a href="mailto:${common.siteDefine['email']}" target="_blank">${common.siteDefine['email']}</a></font></br>
						<span>所在地区：</span> <font> <b>北京</b>-<b>北京</b>
						</font></br>
					</div>

				</div>
				<div id="lawerxx_2_1">
					<img src="style/images/fenge_1.gif" width="2" height="328" />
				</div>
			</div>
			<div id="lawermore">
				<div id="lawermore_top">
					<div class="lawermoretop">
						&nbsp;&nbsp;&nbsp;&nbsp; 个人简介:
						法学.金融双学历,中国政法大学研究生.央视CCTV-12《法律讲堂》主讲人.北京电视台《非常看法》嘉宾律师，北京市律师协会专业委员会委员，2011年1月被评为“北京市百名优秀刑辩律师”.
						从业近二十年来.代理了大量的各类纠纷案件.为当事人挽回经济损失上亿元.在民商方面尤为擅长合同纠纷.婚姻继承.债权债务.股权纠纷.侵权赔偿.几百起该方面案件的成功代理.积累了丰富的办案经验和技巧.
						在刑事方面.成功办理多起在全国范围内有重大影响的刑事案件.类型包括贪污受贿、渎职、涉......<a href="/BeijingLawyer.asp">[更多介绍]</a>
					</div>
					<div id="lawermore_top2"></div>
					<br />
				</div>
				<@list1 item=common.indexItemList[0]/>
			</div>
		</div>
	</div>
</#macro>

<#macro index_bianli_link groupLinks >
		<div id="neirong_bm2_1">
			<div id="neirong_bm2_2"> <span>${groupLinks.name}</span> <img src="${commTBase}/images/tub_4.gif" /></div>
			<div id="neirong_bm2_3">
			<#list groupLinks.sons as one>
					<span><a href='${one.url}' target='_blank' rel="nofollow">${one.name}</a></span> 
			</#list>
			</div>
		</div>
</#macro>
<#macro index_bianli>
<div id="neirong_bm">
				<div id="neirong_bml">
					<h3 class="neirong_bm1">便民法律网址导航</h3>
					<div id="neirong_bm2">
					<@index_bianli_link groupLinks=common.groupLinks['left1']/>
					<@index_bianli_link groupLinks=common.groupLinks['left2']/>
					</div>
				</div>
			</div>
</#macro>