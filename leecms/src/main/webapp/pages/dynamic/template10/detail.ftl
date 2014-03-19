<#import "/common.ftl" as g/>

<#macro GuestBook>
		<div id="list_right_xq2">
			<div id="list_right_xq2_1">
				<a href='/GuestBook/PingLun.asp?cpid=780459908495&classid=22' target="_blank"> 【已有<span>3</span>位网友浏览过此网页】
				</a>
			</div>
			<div id="list_right_xq2_2">
				<iframe id="iframe_gbook" src="http://xslsbj.maxlaw.cn/GuestBook/iframeGbook.asp?classid=22&countPingLun=0&products_id=780459908495&referUrl=http://xslsbj.maxlaw.cn/GuestBook/iframeGbook.asp" height="270px" width="706px" border="no" frameborder="no"
					scrolling="no"></iframe>
			</div>
		</div>


		<script language="javascript" src="/js/ReGuestBook.js"></script>
		<BR>
			<div id="list_right_xq3">
				<div id="list_right_xq3_1">
					<div id="list_right_xq3_2">您可能也对以下文章感兴趣</div>
					<ul>
					<#list 1..5 as one>
						<li><a href='#' target='_blank'>1.执行预案威力大 快速执结效果好</a></li>
					</#list>
					</ul>
				</div>
			</div>
</#macro>


<#macro main>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${detail.content.name}</title>
<meta name="description" content="${detail.content.name}">
<meta name="keywords" content="${detail.content.name}">
<link href="http://www.xslsbj.com/style/list_xq.css" rel="stylesheet" type="text/css" />
</head>


	<@g.top/>
	<@g.menu/>
	<@g.logo1/>
	
	<div id="list_nr">
		<@g.list_left/>
		<div id="list_right">
			<div id="list_right_nr">
				<div id="list_right_nr_1">
					<div id="list_right_nr_2">
						<div id="list_right_nr_3">
							<strong>当前位置：</strong>
							 <span><a href="/">首页</a></span> <font>&gt;</font>
							 <span><a href="${detail.item.url}">${detail.item.name}</a></span>
						</div>
						<div id="list_right_xq">
							<div id="list_right_xq1">
								<h1>${detail.content.name}</h1>
								<span>发布时间：</span><font>2014年3月18日</font> <span>&nbsp;</span>
								<font>来源: <a href='#' class='linkBottomBlue'>${detail.content.author}</a>&nbsp;&nbsp;</font>
							</div>
							<br />
							<div id="artpage">
								${detail.content.html}
							</div>
							<br />
							<div align="center">
								上一篇:<a href="${detail.content.pre.url}" title="上一篇">${detail.content.pre.name}</a>
								 下一篇:<a href="${detail.content.next.url}" title="下一篇">${detail.content.next.name}</a>
							</div>
							<br />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<@g.foot/>


</body>
</html>
</#macro>

<@main/>