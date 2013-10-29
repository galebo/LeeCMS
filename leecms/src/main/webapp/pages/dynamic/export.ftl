<#macro exe>
<html>
<head></head>
<body>
<#list beans as one>
<div style="background: #0edf1;margin:10px 30px;border: 1px solid #c4d3df;">
<span id="nameCn">${one.nameCn}</span><span id="contentId">${one.contentId}</span>
</div>
<div style="background: #e8edf1;margin:30px;border: 1px solid #c4d3df;">
${one.html}
</div>
</#list>
</body>
</html>
</#macro>
<@exe/>