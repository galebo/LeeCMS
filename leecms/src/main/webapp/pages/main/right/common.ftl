<#macro jQuery>
<script type="text/javascript" src="/p/plugin/jquery-ui-1.8.17.custom/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/p/plugin/jquery-ui-1.8.17.custom/js/jquery-ui-1.8.17.custom.min.js"></script>
<link rel="stylesheet" type="text/css"  href="/p/plugin/jquery-ui-1.8.17.custom/css/ui-lightness/jquery-ui-1.8.17.custom.css"/>
<link rel="stylesheet" type="text/css"  href="/p/plugin/jquery-ui-1.8.17.custom/development-bundle/themes/base/jquery.ui.all.css"/>

<!-- jquery jqgrid start -->
<link rel="stylesheet" type="text/css" media="screen" href="/p/plugin/jquery.jqGrid-4.3.1/css/ui.jqgrid.css" />
<script type="text/javascript" src="/p/plugin/jquery.jqGrid-4.3.1/js/i18n/grid.locale-cn.js"></script>
<script type="text/javascript" src="/p/plugin/jquery.jqGrid-4.3.1/js/jquery.jqGrid.src.js"></script>
<!-- jquery jqgrid end -->

<!-- jquery jBox start -->
<link rel="stylesheet" type="text/css" media="screen" href="/p/plugin/jBox/Skins2/Gray/jbox.css" />
<script type="text/javascript" src="/p/plugin/jBox/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="/p/plugin/jBox/i18n/jquery.jBox-zh-CN.js"></script>		
<!-- jquery jBox end -->	

<!--  JSCal2 end -->
</#macro>

<#import "/main/right/common.ftl" as common/>
<#macro body>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="robots" content="index, follow" />
<meta name="generator" content="galebo iCms" />
<title></title>
<@common.jQuery/>
<link rel="stylesheet" type="text/css" href="/p/css/main/css/style2.css"/>
<link rel="stylesheet" type="text/css" href="/p/css/jq.css" />
</head>
<body>
<#nested/>
</body>
</html>
</#macro>