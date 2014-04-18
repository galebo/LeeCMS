<%@ include file="/common/taglibs.jsp"%>

<page:applyDecorator name="default">

<head>
    <title><fmt:message key="404.title"/></title>
    <meta name="heading" content="<fmt:message key='404.title'/>"/>
</head>


    <div style="width:600px;margin: 50px auto 70px auto;">
        	<h1  style="text-align: center;margin-top:0px;font-size:40px;color: #5B4F5B;"><fmt:message key="404.message"/></h1>
        	
            <div style="color: #0898DD;
    display: block;
    font-size: 16px;
    height: 25px;
    line-height: 20px;
    padding-left: 324px;
    text-decoration: none;
    width: 134px;position: absolute;"><span class="times"><span id="time"></span></span><a href="#" id="homepage"><fmt:message key="404.message2"/></a></div>
        </div>
        
<script type="text/javascript" src="<c:url value='/p/js/error.js'/>"></script>
<script type="text/javascript">
	
	document.getElementById('homepage').href=getUrl();
</script>

<script type="text/javascript" src="http://www.qq.com/404/search_children.js" charset="utf-8"></script>
</page:applyDecorator>