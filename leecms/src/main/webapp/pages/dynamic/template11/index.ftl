<#import "${ftlPath}/common.ftl" as g/>
<#macro list column>
	<table style="border:1px solid #dcdcdc;" border="0" cellpadding="0" cellspacing="0" width="100%">
      <tbody>
        <tr>
          <td width="320" height="26" colspan="2" align="right" background="${commTBase}/images/index-02_54.jpg"><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="2"></td>
                <td width="90" background="${commTBase}/images/index-02_69.jpg" align=left><div class="pianbt2">${column.name}&gt;&nbsp;&nbsp;</div></td>
                <td width="16"><img src="${commTBase}/images/index-02_69.gif" width="16" height="26" /></td>
                <td></td>
                <td width="1"><a href="#" target="_parent"><img src="${commTBase}/images/index-02_59.jpg" border="0" /></a></td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td colspan="2" align="left"><table width="100%" border="0" cellspacing="0" cellpadding="10">
              <tr>
                <td><table width="100%" height="5" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td>
                      	<#list column.contents as one>
                       <table width="100%" align="center" cellspacing="0" cellpadding="0"><tr> <td width=12 height=20><img src="${commTBase}/images/newsdot.gif"></td><td><a  href="#" >美国社会的自信</a></td></tr></table>
						</#list>
                       </td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </tbody>
  </table>
</#macro>

<#macro index>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<title>移民美国、留学、L-1签证国外美国展会 EB1-C签证,CRADI INTERNATIONAL (USA) INC</title>
<meta name="keywords" content="移民美国、留学、L-1签证国外美国展会 EB1-C签证"/>
<meta name="description" content="专门为中国公司设立美国跨国公司服务， L-1签证，美国展会全程地接服务。带领国人，冲出国门。走向美国，走向世界！"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link href="${commTBase}/css/css.css" rel="stylesheet" type="text/css" />
<link href="${commTBase}/css/li.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="${commTBase}/js/index.js" charset="utf-8"></script>
</head>

<body>
<@g.top/>



<table width="920" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="190" valign="top">
    
  	<@g.left_list column=common.itemIdList[1]/>
    
      <table width="100%" height="10" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td></td>
        </tr>
      </table>
      
      <table style="border:1px solid #dcdcdc;" border="0" cellpadding="0" cellspacing="0" width="100%">
      <tbody>
        <tr>
          <td class="baojie" align="left" background="${commTBase}/images/index-02_77.jpg" height="24"><div class="pianbt3">实用链接 &gt;&nbsp;&nbsp;</div></td>
        </tr>
        <tr>
          <td align="left" valign="top">
            <table border="0" cellpadding="0" cellspacing="1" width="100%">
              <tbody>
              <#list common.groupLinks['link3'].sons as one>
                <tr>
                  <td width="16%"><div align="center"><img src="${commTBase}/images/icon00.jpg" height="10" width="9"/></div></td>
                  <td width="84%"><a target="_blank" href="${one.url}">${one.name}</a></td>
                </tr>
				</#list>
              </tbody>
            </table>
			</td>
        </tr>
      </tbody>
    </table>
    
      <table width="100%" height="10" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td>
          </td>
        </tr>
      </table>
      
  	<@g.left_list column=common.itemIdList[2]/>
  	
	</td>
	
    <td width="9" valign="top"></td>
    
    <td valign="top">
	    <table width="100%" height="10" border="0" cellpadding="0" cellspacing="0">
	      <tr>
	        <td>
	          <SCRIPT language="javascript" type="text/javascript"> 
				 ImageShow();
				</SCRIPT>
			</td>
	      </tr>
	    </table>
	    
	      <table width="100%" height="10" border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td></td>
	        </tr>
	      </table>
	      
	      <table width="100%" height="10" border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td width="49%" valign="top">
	          <@g.bb/>
	          </td>
	          <td width="9"></td>
	          <td valign="top">
	          	<@g.aa/>
	          </td>
	        </tr>
	      </table>
	      <table width="100%" height="10" border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td></td>
	        </tr>
	      </table>
	      
	      <table width="100%" height="10" border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td width="49%" valign="top">
				<@list column=common.itemIdList[3]/>
				</td>
	          
	          <td width="9"></td>
	          
	          <td valign="top">
				<@list column=common.itemIdList[4]/>
	          </td>
	        </tr>
	      </table>
    </td>
  </tr>
</table>



<table width="920" height="10" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td></td>
  </tr>
</table>



<table width="920" border="0" align="center" cellpadding="0" cellspacing="0" style="border:1px solid #dcdcdc;">
  <tbody>
    <tr>
      <td class="baojie" align="left" background="${commTBase}/images/index-02_77.jpg" height="24"><div class="pianbt3">美国旅游 &gt;&nbsp;&nbsp;</div></td>
    </tr>
    <tr>
      <td align="left" valign="top" width="327"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><div class=imgList style="margin-left:10px "> 
          <div id="demo" style="overflow:hidden; width:900px; height:160px;">
				  <table cellspacing="0" cellpadding="0" align="left" border="0" cellspace="0">
				    <tr>
				      <td id="demo1" valign="top"><table border="0" cellpadding="0" cellspacing="0">
				        <tr>
				        	<#list 1..7 as one>
		        	          <td><table width="100%"><tr><td><a  href="#">
		        	          <img class=proimg border="0" height="120" alt="洛杉矶贝佛利山庄" src="${commTBase}/upload/20131224091209.jpg" width="160">
		        	          </a></td></tr></table><table width="100%"><tr><td align="center"><a  href="#">洛杉矶贝佛利山庄</a></td></tr></table></td>
				 			</#list>
				        </tr>
				      </table></td>
				      <td id="demo2" valign="top">&nbsp;</td>
				    </tr>
				  </table>
				</div>
			</div></td>
        </tr>
      </table></td>
    </tr>
  </tbody>
</table>

<@g.bottom/>



</body>
</html>


</#macro>

<@index/>