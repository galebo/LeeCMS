var columnDefine={
		name:"column",
	   	colNames:['','栏目ID', '栏目名称','','','','','操作'],
	   	colModel:[
	  		  	{name:'select',index:'select',hidden:true,width:20},
	  	   		{name:'id',index:'id',align:'center',width:60,key:true},
	  	   		{name:'name',index:'name', width:140},
	  	   		{name:'sort',index:'sort', width:140,hidden:true},
	  	   		{name:'time',index:'time', width:140,hidden:true},
	  	   		{name:'parentId',index:'parentId', width:140,hidden:true},
	  	   		{name:'relativeId',index:'relativeId', width:140,hidden:true},
	  	   		{name:'manger',  width: 150, align:'center', formatter:opFormatter}
	  	   	],
	    width:  350,
		treeGrid: true,ExpandColumn:"name",
		caption: '栏目'
	};
var parentDefine={
		name:"parent",
	   	colNames:['','栏目ID', '栏目名称','','','','','操作'],
	   	colModel:[
	  		  	{name:'select',index:'select',hidden:true,width:20},
	  	   		{name:'id',index:'id',align:'center',width:60,key:true},
	  	   		{name:'name',index:'name', width:140},
	  	   		{name:'sort',index:'sort', width:140,hidden:true},
	  	   		{name:'time',index:'time', width:140,hidden:true},
	  	   		{name:'parentId',index:'parentId', width:140,hidden:true},
	  	   		{name:'relativeId',index:'relativeId', width:140,hidden:true},
	  	   		{name:'manger',  width: 150, align:'center', formatter:opFormatter}
	  	   	],
	    width:  350,
		treeGrid: true,ExpandColumn:"name",
		caption: '栏目'
	};
var sonDefine={
		name:"son",
	   	colNames:['栏目ID', '内容ID', '名称',  '排序','',  '操作'],
	   	colModel:[
		  	   	{name:'id',index:'id',hidden:true, width:1},
	  	   		{name:'contentId',index:'contentId',hidden:true, width:1,key:true},
	  	   		{name:'name',index:'name', width:380},
	  	   		{name:'sort',index:'sort', width:90},
	  	   		{name:'columnContentId',index:'columnContentId', width:1,hidden:true,},
	  	   		{name:'manger',  width: 265, align:'left', formatter:opFormatter}
	  	   	],
	    width:  700,
		caption: '内容'
    };
var op={
        name:"business",
        defines:[
			{
				name:"parentTable",
			    ops:[{cnName:"查看内容",enName:'searchContent',op:"resetSonTable"}]
			},
	        {
	        	name:"columnTable",
		        ops:[{cnName:"选择",enName:'select',op:"selectColumn"}]
	        },
	    	{
	        	name:"sonTable",
		        ops:[{cnName:"选择",enName:'select',op:"selectContent"}]
	    	}]
    	};
function ColumnContent()
{
	this.Url_getColColumns='/jqJson/parents/3AC';
	this.Url_getConContent='/jqJson/sons/3AC';
	this.Url_changeSort='/jqJson/changeSort/ColColumnContent';
	this.G_columnId=null;
	this.setDesc();
}
ColumnContent.prototype.showColumn= function ()
{
	$("#select").show();
	$("#parent").hide();
	$("#son").hide();
	$("#column").show();
	G_initOrRefreshJqGrid(columnDefine,this.Url_getColColumns);
};

ColumnContent.prototype.setDesc= function ()
{
	if($("#url").val().indexOf("${content}")>-1)
	{
		$("#url").attr({readonly:true});
		$("#desc").html("<font color='red'>链接URL属性为内容，（内容和栏目不可以编辑，自定义可以编辑）</font>");
	}
	else if($("#url").val().indexOf("${column}")>-1)
	{
		$("#url").attr({readonly:true});
		$("#desc").html("<font color='red'>链接URL属性为栏目，（内容和栏目不可以编辑，自定义可以编辑）</font>");
	}
	else
	{
		$("#url").attr({readonly:false});
		$("#desc").html("<font color='red'>链接URL属性为自定义，（内容和栏目不可以编辑，自定义可以编辑）</font>");
	}
};
ColumnContent.prototype.showContent= function ()
{
	$("#select").show();
	$("#column").hide();
	$("#parent").show();
	$("#son").show();
	G_initOrRefreshJqGrid(parentDefine,this.Url_getColColumns);
};
ColumnContent.prototype.showSelfDefine= function ()
{
	$("#select").hide();
};
ColumnContent.prototype.resetSonTable= function (rowData,rowId,opType,tableId)
{
	var url=this.Url_getConContent+"/"+rowId;
	G_initOrRefreshJqGrid(sonDefine,url);
};
ColumnContent.prototype.selectColumn= function (rowData,rowId,opType,tableId)
{
	$("#select").hide();
	$("#url").val("${column}/"+rowId);
	this.setDesc();
};
ColumnContent.prototype.selectContent= function (rowData,rowId,opType,tableId)
{
	$("#select").hide();
	$("#url").val("${content}/"+rowData.columnContentId);
	this.setDesc();
};
var business=new ColumnContent();