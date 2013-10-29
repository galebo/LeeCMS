<%@ taglib uri="http://struts-menu.sf.net/tag-el" prefix="menu" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>menu</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" media="screen" href="xtree/css/xtree.css" />
<script type="text/javascript" src="xtree/xtree.js"></script>
</head>
<body style="background-color:#b0c3e2">

<div class="container">
<script type="text/javascript">
<menu:useMenuDisplayer name="Velocity" config="xtree.vm" bundle="org.apache.struts.action.MESSAGE" permissions="rolesAdapter">
	<menu:displayMenu name="templateMenu"/>
	<menu:displayMenu name="AdminMenu"/>
    <menu:displayMenu name="contentMenu"/>
    <menu:displayMenu name="MainMenu"/>
</menu:useMenuDisplayer>

function father_location(subframe,locate)
{
	parent.frames[subframe].location=locate;
} 
</script>
</div>



</body>
</html>
