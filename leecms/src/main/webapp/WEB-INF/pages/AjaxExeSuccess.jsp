<%@ include file="/common/taglibs.jsp"%>

<script type="text/javascript">
	if(isInJBox()){
		jQuery(function(){
			var url=jQuery("#fileUrl").val();
			jQuery("#imgUrl",window.parent.document).val(url);
			window.parent.jQuery.jBox.close(true);
		});
	}else{
		jQuery("#result").html("执行成功");
	}
</script>
<input type="hidden" id="fileUrl" value="${location}" name="injectFileUrl"/>
<input type="hidden" id="msg" value="${msg}" name="msg"/>
<div id='result'></div>
