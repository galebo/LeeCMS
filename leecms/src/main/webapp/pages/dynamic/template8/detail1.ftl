<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#macro main>
	<@frame.exe1 bean=data>
		<@div2/>
	</@frame.exe1>
</#macro>
<#macro div2>
	<div class="div1">
		<@left2/><@right2/>
	<div class="clear"></div>
	</div>
</#macro>
<#macro left2>
	<div class="left left650 div1_ div1_detail list_image2">
		<div class="title">每日聚焦每日聚焦每日聚焦每日聚焦每日聚焦</div>
		<div class="info">2012-11-11 来源 信息中心  责任编辑 你好</div>
		<div class="text"><p>为了迅速兴起学习贯彻党的十八大精神的热潮，全面准确、深入系统地做好十八大精神宣传解读工作，为在新的起点上奋力开创江苏“两个率先”新局面营造良好的舆论氛围，11月22日，江苏广电总台启动学习宣传贯彻党的十八大精神全媒体大型新闻行动《开启新征程&nbsp;谱写新篇章——学习十八大精神环省行》。省委宣传部、省广电局和各市宣传部、广播电视台领导出席。　</p>
<p>党的十八大是在我国进入全面建成小康社会决定性阶段召开的一次十分重要的会议。认真学习宣传贯彻党的十八大精神，关系党和国家工作全局，关系中国特色社会主义事业长远发展，是当前和今后一个时期首要的政治任务。江苏广电总台严格按照省委统一部署，发挥主流媒体优势，在迎接十八大宣传和会中报道取得良好社会反响的基础上，继续加大宣传力度，迅速掀起学习贯彻十八大精神的热潮，大力营造学习贯彻的浓厚氛围。　</p>
<p>作为江苏广电总台下一阶段工作的重点之一，学习宣传贯彻党的十八大精神全媒体大型新闻行动《开启新征程&nbsp;谱写新篇章——学习十八大精神环省行》将整合广播、电视、新媒体资源，集中展示全省各地学习宣传贯彻十八大精神的新思路、新举措、新期待、新成效和新进展。在此次新闻行动中，江苏广电总台将与各地市台深度合作，采用13+1的呈现方式，在各市台设置分演播室，邀请各市市委书记、专家学者、群众代表等走进演播室，利用场内场外结合、大屏与网络电视台、微博全媒体互动等创新手段，展示各地学习贯彻十八大的思路和举措，解读十八大报告的热词新词，畅聊大家对全面建成小康社会的愿景期待。据悉，节目的主持人设置将采取与各地市主持人1+1现场互动的直播模式，一位现场主持人负责总体把控调度、另一位主持人或首席记者负责互动环节，使节目形式更加鲜活。　</p>
<p>在仪式上，各市报道团队悉数到场，整装待发，省委宣传部梁勇副部长将大型新闻行动的旗帜授给报道团队的代表，并与省广电局、江苏广电总台和协作地市宣传部领导触摸水晶球，共同启动大型新闻行动。仪式结束后，各报道组将深入全省各地，通过电视、广播、网络等多个平台全面准确、深入系统地解读十八大精神，展现我省把科学发展观贯彻到小康和现代化建设的思路举措，展现我省在新的起点上开创“两个率先”新局面的成效进展。</p></div>
	</div>
</#macro>


<#macro right2>
	<div class="right right300 div1_ div1_2 list_num2">
		<div class="div_title right_title"><div class="title">每日聚焦</div><div class="day"><span class="day1">每日</span><span class="day2">每周</span></div></div>
		<div class="content">
			<ul class="content_ul">
				<#list 1..10 as one>
				<li><div class="url"><a href="#">十八大解读，全面建设小康社会</a></div></li>
				</#list>
			</ul>
		</div>
	</div>
	<div class="right300 div1_ div1_2 list_image5">
		<div class="div_title right_title"><div class="title">每日聚焦</div></div>
		<div class="content">
			<ul>
			<#list 1..4 as one>
			<li <#if one_index=1 || one_index=3>class="noright"</#if> ><div><img src="/p/image.jpg"/></div>
			<div class="name"><a href="#">《网的盛宴》</a></div></li>
			</#list>
			</ul>
		</div>
	</div>
</#macro>