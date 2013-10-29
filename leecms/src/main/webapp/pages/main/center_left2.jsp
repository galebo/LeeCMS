<%@ taglib uri="http://struts-menu.sf.net/tag-el" prefix="menu" %>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>menu</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="/p/css/main/css/style2.css"/>
<link rel="stylesheet" type="text/css" media="screen" href="/p/plugin/xtree/css/xtree.css" />
<script type="text/javascript" src="/p/plugin/xtree/xtree.js"></script>
</head>
<body>
<div class="left">
<div class="leftBody">
	<div class="mailInto">
	    <span title="" onclick="" class="mailTo ico"></span>
	</div>
	<div class="nav_topbg"></div>
	<div class="nav_main" id="navScrool">
	    <div class="nav_tree">
			<script type="text/javascript">
			<menu:useMenuDisplayer name="Velocity" config="xtree.vm" bundle="org.apache.struts.action.MESSAGE" permissions="rolesAdapter">
				<menu:displayMenu name="templateMenu"/>
				<menu:displayMenu name="AdminMenu"/>
			    <menu:displayMenu name="MenuCommon"/>
			    <menu:displayMenu name="MenuMore"/>
			    <menu:displayMenu name="MainMenu"/>
			</menu:useMenuDisplayer>
			
			function father_location(frameName,url,name)
			{
				parent.frames[frameName].location=url;
				parent.parent.frames['topFrame'].document.getElementById("menuOn").innerHTML=name;
			} 
			</script>
	    </div>
	</div>

</div>

</div>


</body>
</html>
