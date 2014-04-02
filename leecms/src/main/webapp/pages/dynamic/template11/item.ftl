<#import "${ftlPath}/common.ftl" as g/>
<#import "${ftlPath}/common_item_detail.ftl" as item_detail/>

<#macro page3 bean pageSize=10 varName="page">
		<ul><li class="p_total">共<span id="${varName}_totalPage">0</span>页</li>
      <li><a href="javascript:" onclick="${varName}.go(1)">«</a></li>
      <li><a href="javascript:" onclick="${varName}.goPre()">‹</a></li>
      <li class="p_current" id="${varName}_pageNo">0</li>
      <li><a href="javascript:" onclick="${varName}.goNext()">›</a></li>
      <li><a href="javascript:" onclick="${varName}.goEnd()">»</a></li>
      </ul>
        <script>var ${varName}=new Page("${varName}",${pageSize},[]);
        ${varName}.go(1);</script>
        
</#macro>

<#macro main item varName="page">
	<@item_detail.item_detail title=item.name >
	
<script type="text/javascript" src="${commBase}/js/business.js"></script>
	<#if item.type = '3CB'>
	
		<table width="100%" border="0" cellspacing="0" cellpadding="20" height="300">
		 <tbody><tr>
                  <td valign="top"><table cellpadding="0" cellspacing="0" border="0" width="100%">
                    <tbody><tr>
                      <td>
                      <div class="imgList">
	                      <table cellpadding="0" cellspacing="0" align="center" border="0" width="100%"><tbody>
		                     <tr>
		                      <#list 1..9 as one>
		                      	 <td align="center" width="33%">
		                      	 <ul id="${varName}${one_index}div">
		                      	 <li>
		                      	 <a id="${varName}${one_index}imga" target="_blank" href="#" >
		                      	 <img id="${varName}${one_index}img" style="margin-bottom:2px;margin-top:8px;" src="#" alt="" border="0" height="150" width="200"></a>
		                      	 <a id="${varName}${one_index}" target="_blank" href="#" ></a></li>
		                      	 </ul></td>
			                      <#if  one_index != 0 && one_index % 3 = 2 >
			                      	</tr>
			                      	<tr>
			                      </#if>
								</#list>
				           </tr>
	                      </tbody></table>
	                   </div>
                      <div class="pager">
                      <@page3 bean=item pageSize=9 varName=varName/>
                      </div></td>
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
                      <#list 1..10 as one>
                      <li id="${varName}${one_index}div"><span class="dateR">[<span id="${varName}${one_index}time"> </span>]&nbsp;&nbsp;&nbsp;</span><a  id="${varName}${one_index}" href="#"></a></li>
						</#list>
                      </ul></div>
                      <div class=pager>
                      <@page3 bean=item pageSize=10 varName=varName/>
                      </div></td>
                    </tr>
                  </table></td>
                </tr>
              </table>
      </#if>
	</@item_detail.item_detail>
</#macro>
<@main item=data/>