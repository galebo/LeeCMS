<#import "${ftlPath}/common.ftl" as g/>




<#macro main detail>
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
		<@g.list_left items=detail.item.brotherItems  currentItem=detail.item/>
		<div id="list_right">
			<div id="list_right_nr">
				<div id="list_right_nr_1">
					<div id="list_right_nr_2">
						<div id="list_right_nr_3">
							<strong>当前位置：</strong>
							 <span><a href="${common.homePage.url}">首页</a></span> <font>&gt;</font>
							 <span><a href="${detail.item.url}">${detail.item.name}</a></span>
						</div>
						<div id="list_right_xq">
							<div id="list_right_xq1">
								<h1>${detail.content.name}</h1>
								<span>发布时间：</span><font>${detail.content.updateTime?string('yyyy年MM月dd日')}</font> <span>&nbsp;</span>
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

<@main detail=data/>