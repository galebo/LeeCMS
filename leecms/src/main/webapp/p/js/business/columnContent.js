
var parentDefine={
		name:"parent",
	   	colNames:['','ID', parent_name+'名称','','','','','操作'],
	   	colModel:[
	  		  	{name:'select',index:'select',hidden:true,width:1},
	  	   		{name:'id',index:'id',align:'center',width:25,key:true},
	  	   		{name:'name',index:'name', width:80},
	  	   		{name:'sort',index:'sort', width:1,hidden:true},
	  	   		{name:'time',index:'time', width:1,hidden:true},
	  	   		{name:'parentId',index:'parentId', width:140,hidden:true},
	  	   		{name:'relativeId',index:'relativeId', width:140,hidden:true},
	  	   		{name:'manger',  width: 300, align:'center', formatter:opFormatter}
	  	   	],
	    width:  550,
		treeGrid: true,ExpandColumn:"name",
		caption: parent_name
	};
var sonDefine={
		name:"son",
	   	colNames:[parent_name+'ID', son_name+'ID', '名称',  '排序','',  '操作'],
	   	colModel:[
		  	   	{name:'id',index:'id',hidden:true, width:1},
	  	   		{name:'contentId',index:'contentId',hidden:true, width:1,key:true},
	  	   		{name:'name',index:'name', width:380},
	  	   		{name:'sort',index:'sort', width:90},
	  	   		{name:'columnContentId',index:'columnContentId', width:1,hidden:true,},
	  	   		{name:'manger',  width: 265, align:'left', formatter:opFormatter}
	  	   	],
	    width:  700,
		caption: '文章'
    };
var son1Define={
		name:"son1",
	   	colNames:[G_initCheckBox("son1Table"),son_name+'ID', '名称', '提交时间'],
	   	colModel:[
	   		    {name:'childCheckbox', width: 18, align:'center', formatter:checkFomatter},
	  	   		{name:'contentId',index:'contentId',width:30,key:true},
	  	   		{name:'name',index:'name', width:300},
	  	   		{name:'date',index:'date', width:90}
	  	   	],
	    width:  700,
		caption: '可绑定文章'
    };


function ColumnContent()
{
	this.Url_getColColumns='/jqJson/parents/'+type;
	this.Url_getConContent='/jqJson/sons/'+type;
	this.Url_changeSort='/jqJson/changeSort/'+parentSon;
	this.Url_addToParent='/jqJson/addToParent/'+type;
	this.G_columnId=null;
	this.div=new Div(["#div","#div1"]);
	this.div.hideAll();
	this.init();
}
ColumnContent.prototype.init= function ()
{
	G_initOrRefreshJqGrid(parentDefine,this.Url_getColColumns);
};
ColumnContent.prototype.set= function (rowData,rowId,opType,tableId)
{
	this.G_columnId=rowId;
	var parent = rowData.parent;
	var name = rowData.name;
	while(parent>-1&&parent){
		rowData = jQuery("#"+tableId).getRowData(parent);
		parent = rowData.parent;
		name = rowData.name+"--> "+name;
	}
	jQuery("#currentCol").html(name);
};
ColumnContent.prototype.op_viewContent= function(rowData,rowId,opType,tableId)
{
	var url="/"+son_name_big_l+"form?parentId="+rowData.id+"&sonId="+rowData.contentId+"&parentSonId="+rowData.columnContentId;
	G_showCommBox(url,'查看'+son_name,900,750,{'关闭': true});
};
ColumnContent.prototype.op_resetSonTable= function (rowData,rowId,opType,tableId)
{
	var url=this.Url_getConContent+"/"+this.G_columnId;
	G_initOrRefreshJqGrid(sonDefine,url);
	this.div.show("#div");
};
ColumnContent.prototype.op_addContent= function (rowData,rowId,opType,tableId)
{
	var url="/"+son_name_big_l+"form?parentId="+this.G_columnId;
	G_showCommBox(url,'增加'+son_name,900,750,{'关闭': true},callBack_resetSonTable);
};
ColumnContent.prototype.op_releaseContent= function(rowData,rowId,opType,tableId)
{
	var url="/jqJson/releaseContent/"+rowData.columnContentId;
	G_callAjax(url,"",{closed:callBack_resetSonTable});
};
ColumnContent.prototype.op_bang= function (rowData,rowId,opType,tableId)
{
	var url='/jqJson/sonsNoBang/'+type+"/"+this.G_columnId;
	G_initOrRefreshJqGrid(son1Define,url);
	this.div.show("#div1");
};
ColumnContent.prototype.op_changeSort= function (rowData,rowId,opType,tableId)
{
	var url=this.Url_changeSort+"/"+opType+"/"+this.G_columnId+"/"+rowData.columnContentId+"/"+rowData.contentId+"/"+rowData.sort;
	G_callAjax(url,"",{closed:callBack_resetSonTable});
};
ColumnContent.prototype.op_editColumn= function (rowData,rowId,opType,tableId)
{
	var url="/colColumnform?columnId="+rowId;
	G_showCommBox(url,'编辑'+name,600,450,{'关闭': true},callBack_init);
};
ColumnContent.prototype.op_addColumn= function (rowData,rowId,opType,tableId){
	var url="/colColumnform?parentId="+rowId+"&parentColumnName="+rowData.name;
	G_showCommBox(url,'增加'+name,600,450,{'关闭': true},callBack_init);
};
ColumnContent.prototype.op_deleteColumn=function (rowData,rowId,opType,tableId)
{
	var url="/jqJson/deleteColumn/"+rowId;
	G_callAjax(url,"",{closed:callBack_init});
};
ColumnContent.prototype.op_changeSort_column= function (rowData,rowId,opType,tableId)
{
	var url="/jqJson/changeSort/Column/"+opType+"/"+rowData.parentId+"/"+rowData.relativeId+"/"+rowId+"/"+rowData.sort;
	G_callAjax(url,"",{closed:callBack_init});
};

ColumnContent.prototype.addToParent= function()
{
	var sonIds=G_captureCheckValue("son1Table");
	if(sonIds==null||sonIds.length==0)
		confirm("选项数为0");
	else if(confirm("请确认添加这几项信息")){
		var url =this.Url_addToParent+"/"+this.G_columnId;
		var para ="sonIds="+sonIds;
		G_callAjax(url,para,{closed:function(){business.resetSonTable();}});
	}
};

jBox.setDefaults({ defaults: { border: 8,draggable: true,top: '1%' }}); 
var business=new ColumnContent();
function callBack_resetSonTable(){business.op_resetSonTable();}
function callBack_init(){business.init();}