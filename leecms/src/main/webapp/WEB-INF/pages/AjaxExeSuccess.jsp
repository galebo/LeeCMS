<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<style type="text/css">
.msg{margin-left:auto;margin-right:auto;width:70%;margin-top:40px;font-weight: bold;color: #0066CC;font-size: 13px;text-align: center;}
</style>
<input type="hidden" id="fileUrl" value="${location}" name="fileUrl"/>
<input type="hidden" id="msg" value="${msg}" name="msg"/>
<div id='result111' class="msg"></div>
<script type="text/javascript">
	if(isInJBox()){
		jQuery(function(){
			var url=jQuery("#fileUrl").val();
			jQuery("#imgUrl",window.parent.document).val(url);
			window.parent.jQuery.jBox.close(true);
		});
	}else{
		jQuery("#result111").html("执行成功");
	}
</script>