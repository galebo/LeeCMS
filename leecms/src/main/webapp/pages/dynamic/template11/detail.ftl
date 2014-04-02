<#import "${ftlPath}/common.ftl" as g/>
<#import "${ftlPath}/common_item_detail.ftl" as item_detail/>

<#macro preNext content preText><#if content.name !='' ><a href="${content.url}">${preText}${content.name}</a><#else>${preText}没有了</#if></#macro>

<#macro main detail>
	<@item_detail.item_detail title=detail.item.name>
		<table width="100%" border="0" cellspacing="0" cellpadding="20" height="300">
			<tr>
				<td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td align="center" valign="top"><font style="font-size: 16px">${detail.content.name}</font></td>
						</tr>
						<tr>
							<td height="10">${detail.content.html}</td>
						</tr>
						<tr>
							<td>
								<p>&nbsp;</p> <br />
								<DIV class=prevNews><@preNext content=detail.content.pre preText="上一篇："/></DIV>
								<DIV class=nextNews><@preNext content=detail.content.next preText="下一篇："/></DIV>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</@item_detail.item_detail>
</#macro>

<@main detail=data/>