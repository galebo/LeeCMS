



function G_showCommBox(desUrl,dialogName,width,height,options,close){
	desUrl = "iframe:"+desUrl+"&jbox=true";
	$.jBox(desUrl, {
	    title: dialogName,
	    width: width,
	    height: height,
	    top:'1%',
	    buttons:options,
	    closed:close
	});
}

function G_callAjax(url,para,callBack){
	jQuery.jBox.tip('开始执行', '正在加载');
	jQuery.ajax({
	   type: "get",
	   dataType: "text",
	   url: url,
	   async: false,
	   data: para,
	   success:function(data){
		   jQuery.jBox.closeTip();
		   if(data==null)
	   			jQuery.jBox.success('请联系操作员','返回信息');
		   else if(data.indexOf('login')>-1)
	   			jQuery.jBox.success("请登录再进行操作",'返回信息');
		   else
	   			jQuery.jBox.success(data,'返回信息',callBack);
	   },
	   error:function(XMLHttpRequest, textStatus, errorThrown){
		   jQuery.jBox.closeTip();
	   		alert('系统处理失败，请联系管理员！');
		   }
		});
}
function G_initOrRefreshJqGrid(setBean,url){
	var gridTableId="#"+setBean.name+"Table";
	var gridDivId="#"+setBean.name+"Div";
	if(setBean.bInit==null)
	{
		jQuery(gridTableId).jqGrid({
			url         :url,
			colNames    :setBean.colNames,
			colModel    :setBean.colModel,
			pager       :gridDivId,
			rowList     :setBean.rowList?setBean.rowList:[100,200,500],
			rowNum      :setBean.rowNum ?setBean.rowNum:100,
			treeGrid    :setBean.treeGrid,
			width       :setBean.width,
			caption     :setBean.caption,
			ExpandColumn:setBean.ExpandColumn,
			datatype    : 'json',
			height      :'auto',
			cmTemplate  :{sortable:false},
			treeGridModel: "adjacency",
			loadError:function(xhr,status,error){
				   if(xhr==null)
			   			jQuery.jBox.success('请联系操作员','返回信息');
				   else if(xhr.responseText.indexOf('login')>-1)
			   			jQuery.jBox.success("请登录再进行操作",'返回信息');
				   else
					   alert("加载遇到问题，请联系管理员");
		    }
			});
		setBean.bInit=true;
	}
	else
		jQuery(gridTableId).setGridParam({"url":url,"page":1}).trigger("reloadGrid");
}

function opFormatter(cellvalue, options, rowObject){
	var btn="";
	for ( var i = 0; i < op.defines.length; i++) {
		if(options.gid==op.defines[i].name)
		{
			for ( var i2 = 0; i2 < op.defines[i].ops.length; i2++) {
				if(op.defines[i].ops[i2].check)
				{
					if(op.defines[i].ops[i2].check(rowObject[rowObject.length-5]))
						btn+="<input type='button' value="+op.defines[i].ops[i2].cnName+" onclick=\"_OP('"+options.gid+"','"+op.defines[i].ops[i2].enName+"','"+options.rowId+"');\"' class='btn'>";
				}
				else
					btn+="<input type='button' value="+op.defines[i].ops[i2].cnName+" onclick=\"_OP('"+options.gid+"','"+op.defines[i].ops[i2].enName+"','"+options.rowId+"');\"' class='btn'>";
			}
		}
	}
	return btn;
}
function _OP(tableId,opType,rowId){
	var rowData = jQuery("#"+tableId).getRowData(rowId);
	if(rowData==null){alert(rowId+"所对元素为空 ");return;}
	for ( var i = 0; i < op.defines.length; i++) {
		if(tableId==op.defines[i].name)
		{
			if(op.defines[i].opAll)
				eval(op.name+"."+op.defines[i].opAll+"(rowData,rowId,opType,tableId);");
			for ( var i2 = 0; i2 < op.defines[i].ops.length; i2++) {
				if(opType==op.defines[i].ops[i2].enName&&op.defines[i].ops[i2].op)
					eval(op.name+"."+op.defines[i].ops[i2].op+"(rowData,rowId,opType,tableId);");
			}
		}
	}
}
/**
 * 捕获scope下所有选中的复选框的值 [id:parentId,id:parentId]
 */
function G_captureCheckValue (scope){
	var rtnArray =  new Array(); 
	$.each($('#'+scope+' input:checkbox'),
			function(key,value){
				if(value.checked)
					rtnArray.push(value.value);
			});
	return rtnArray;
};





/**
 *  以下未使用此方法全选
 */
function _checkAll(obj,treeId){
	$('.'+treeId+'lyz').each(function(){
		  this.checked=obj.checked;
		});
};
function G_initCheckBox(treeId){
	return '<input type="checkbox" onclick="_checkAll(this,\''+treeId+'\')"/>';
};
/**
 * treeGrid 选择子节点复选框以及回调函数
 * selectType 分组checkbox，用来区分同一页面不同tree多组checkbox(测试未通过@cre)
 * 2012-03-15 增加参数，判断cellvalue，如果是N，就不显示复选框，由服务端决定哪些可以被选中
 */
function checkFomatter(cellvalue, options, rowObject){
	if(cellvalue=="N"){
		return '';
	}else{
		return "<input type='checkbox' class='"+options.gid+"lyz' selectType='directChild' value='"+options.rowId+"'/>";
	}
};




G_addEvent = function(element, type, event) {
	if (element.attachEvent) {
		element.attachEvent("on" + type, event);
	} else {
		element.addEventListener(type, event, false);
	}
};
function ShowClose(_name,_type,_dir)
{
	this.name=_name;//"tableframe";
	this.type=_type;//["0,6,*","172,6,*"];
	this.dir=_dir;//"leftright";
	 
	G_addEvent(document.getElementById(this.name+"0"),"click",Function("showClose.show()"));
	G_addEvent(document.getElementById(this.name+"1"),"click",Function("showClose.show()"));
};
ShowClose.prototype.change=function(i)
{
	document.getElementById(this.name+(i%2)).style.display="none";
	document.getElementById(this.name+((i+1)%2)).style.display="block";
};
ShowClose.prototype.show=function ()
{
	var element=parent.document.getElementById(this.name);
	if(this.dir=="topbottom")
	{
	    if (element.rows==this.type[0]){
	    	element.rows=this.type[1];
	    	this.change(1);
		}
	    else{
	    	element.rows=this.type[0];
	    	this.change(0);
		}
	}
	else
	{
	    if (element.cols==this.type[0]){
	    	element.cols=this.type[1];
	    	this.change(1);
		}
	    else{
	    	element.cols=this.type[0];
	    	this.change(0);
		}
	}
};

function Div(_div)
{
	this.div=_div;
}
Div.prototype.show= function(name)
{
	for ( var int = 0; int <this.div.length; int++) {
		if(this.div[int]==name)
			$(this.div[int]).show();
		else
			$(this.div[int]).hide();
	}
};
Div.prototype.hideAll= function()
{
	this.show("");
};