<%@ include file="/common/taglibs.jsp"%>

<script type="text/javascript" src="/p/plugin/jquery-ui-1.8.17.custom/js/jquery-1.7.1.min.js"></script>

<script type="text/javascript">
	jQuery(function(){
	var url=jQuery("#fileUrl").val();
	jQuery("#imgUrl",window.parent.document).val(url);
	window.parent.jQuery.jBox.close(true);
	});
</script>
<input type="hidden" id="fileUrl" value="${location}" name="injectFileUrl"/>
<input type="hidden" id="msg" value="${msg}" name="msg"/>
