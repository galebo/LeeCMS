<#import "${ftlPath}/common.ftl" as g/>
<#import "${ftlPath}/common_item_detail.ftl" as item_detail/>


<#macro main item>
	<@item_detail.item_detail title=item.name>
	
	<#if item.type = '3CB'>
	
		<table width="100%" border="0" cellspacing="0" cellpadding="20" height="300">
		 <tbody><tr>
                  <td valign="top"><table cellpadding="0" cellspacing="0" border="0" width="100%">
                    <tbody><tr>
                      <td>
                      <div class="imgList">
	                      <table cellpadding="0" cellspacing="0" align="center" border="0" width="100%"><tbody>
		                     <tr>
		                      <#list item.contents as one>
		                      	 <td align="center" width="33%">
		                      	 <ul><li><a target="_blank" href="${one.url}">
		                      	 <img style="margin-bottom:2px;margin-top:8px;" src="${one.pic}" alt="${one.name}" border="0" height="150" width="200">${one.name}</a></li>
		                      	 </ul></td>
			                      <#if  one_index != 0 && one_index % 3 = 2 >
			                      	</tr>
			                      	<tr>
			                      </#if>
								</#list>
							
	                       <#if item.contents?size % 3 gt 0>
		                       <#list 1..(item.contents?size %3 + 1) as one>
			                     <td align="center" width="33%"><ul><li>&nbsp;</li></ul></td>
								</#list>
		                   </#if>
				           </tr>
	                      </tbody></table>
	                   </div>
                      <div class="pager">
                      <ul><li class="p_total">1/1</li>
                      <li><a href="./list.asp?id=1&amp;PageNo=1">«</a></li>
                      <li><a href="./list.asp?id=1&amp;PageNo=1">‹</a></li>
                      <li class="p_current"> 1</li>
                      <li><a href="./list.asp?id=1&amp;PageNo=1">›</a></li><li><a href="./list.asp?id=1&amp;PageNo=1">»</a></li>
                      </ul></div></td>
                    </tr>
                  </tbody></table></td>
                </tr>
              </tbody>
      </table>
      
      <#else>
      <table width="100%" border="0" cellspacing="0" cellpadding="20" height="300">
                <tr>
                  <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td><div class="box2"><ul>
                      <#list item.contents as one>
                      <li><span class="dateR">[${one.updateTime?string('yyyy-MM-dd')}]&nbsp;&nbsp;&nbsp;</span><a  href="${one.url}" >11${one.name}</a></li>
						</#list>
                      </ul></div>
                      <div class=pager><UL><LI class=p_total>1/3</LI><li><a href="./list.asp?id=3&PageNo=1">&laquo;</a></li>
                      <li><a href="./list.asp?id=3&PageNo=1">&#8249;</a></li><LI class=p_current> 1</LI><li><a href="./list.asp?id=3&PageNo=2">2</a></li>
                      <li><a href="./list.asp?id=3&PageNo=3">3</a></li><li><a href="./list.asp?id=3&PageNo=2">&#8250;</a></li>
                      <li><a href="./list.asp?id=3&PageNo=3">&raquo;</a></li></UL></div></td>
                    </tr>
                  </table></td>
                </tr>
              </table>
      </#if>
	</@item_detail.item_detail>
</#macro>
<@main item=data/>