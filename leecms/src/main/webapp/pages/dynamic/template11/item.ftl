<#import "common.ftl" as g/>
<#import "common_item_detail.ftl" as item_detail/>


<#macro detail>
	<@item_detail title='海外资讯'>
		<table width="100%" border="0" cellspacing="0" cellpadding="20" height="300">
                <tr>
                  <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td><div class="box2"><ul>
                      	<#list 1..15 as one>
                      <li><span class="dateR">[2014-02-28]&nbsp;&nbsp;&nbsp;</span><a  href="#" >美国社会的自信</a></li>
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
	</@item_detail>
</#macro>

<@detail/>