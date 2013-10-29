var parentDefine={
	name:"parent",
   	colNames:['序号', '组名称','关键字','类型','操作'],
   	colModel:[
  	   		{name:'id',index:'id', width:30,key:true},
  	   		{name:'name',index:'name', width:80},
  	   		{name:'key',index:'key', width:40},
  	   		{name:'type',index:'type', width:30},
  	   		{name:'manger',width: 200, align:'center', formatter:opFormatter}
  	   	],
    width:  450,
	caption: '组'
};

var sonDefine={
	name:"son",
   	colNames:['ID','','名称', '图片地址', '链接', '排序', '', '操作'],
   	colModel:[
  	   		{name:'id',index:'id', width:60,hidden:true,key:true},
  	   		{name:'childCheckbox',index:'childCheckbox', width:1,hidden:true},
  	   		{name:'name',index:'name', width:80},
  	   		{name:'link',index:'link', width:190},
  	   		{name:'img',index:'img', width:190},
  	   		{name:'sort',index:'sort', width:90},
  	   		{name:'relativeId',index:'relativeId',hidden:true, width:1},
  	   		{name:'manger',  width: 265, align:'left', formatter:opFormatter}
  	   	],
    width:  600,
	caption: '子元素'
};
var selectDefine={
	name:"select",
	colNames:[G_initCheckBox("selectTable"),'ID','名称','图片地址','链接'],
	colModel:[
	    {name:'childCheckbox', width: 18, align:'center', formatter:checkFomatter},
	    {name:'id',index:'id', width:1,hidden:true,key:true},
 		{name:'name',index:'name', width:80},
   		{name:'link',index:'link', width:190},
   		{name:'img',index:'img', width:190}
	],
	width: 600,
	caption: '未绑定元素列表'
};

function addGroup(type){
	var url="/cfgGroupform?type="+type;
	G_showCommBox(url,'增加组',900,450,{'关闭': true});
}


function CfgRelative()
{
	this.Url_getCfgGroups='/jqJson/CfgGroups';
	this.Url_getGroupSon='/jqJson/GroupSon';
	this.Url_getGroupSonNoSelect='/jqJson/GroupSonNoSelect';
	this.Url_getGroupSonAdd='/jqJson/GroupSonAdd';
	this.Url_changeSort='/jqJson/changeSort/Relative';
	this.groupId;
	this.groupType;

	this.resetParentTable();
}
CfgRelative.prototype.set= function (rowData,rowId,opType,tableId)
{
	this.groupId=rowId;
	this.groupType=rowData.type;
	jQuery("#currentCol").html(rowData.name);
}
CfgRelative.prototype.resetParentTable= function (rowData,rowId,opType,tableId)
{
	jQuery("#son").hide();
	jQuery("#select").hide();
	initOrRefreshJqGrid(parentDefine,this.Url_getCfgGroups);
}
CfgRelative.prototype.resetSonTable= function (rowData,rowId,opType,tableId)
{
	jQuery("#select").hide();
	jQuery("#son").show();
	var url=this.Url_getGroupSon+"/"+this.groupId+"/"+this.groupType;
	initOrRefreshJqGrid(sonDefine,url);
}
CfgRelative.prototype.resetSelectTable= function (rowData,rowId,opType,tableId)
{
	jQuery("#son").hide();
	jQuery("#select").show();
	var url=this.Url_getGroupSonNoSelect+"/"+this.groupId+"/"+this.groupType;
	initOrRefreshJqGrid(selectDefine,url);
}
CfgRelative.prototype.changeSort= function (rowData,rowId,opType,tableId)
{
	var url=this.Url_changeSort+"/"+opType+"/"+this.groupId+"/"+rowData.relativeId+"/"+rowId+"/"+rowData.sort;
	_callAjax(url,"",{closed:function(){business.resetSonTable();}});
}
CfgRelative.prototype.release= function (rowData,rowId,opType,tableId)
{
	var url="/jqJson/releaseLinkLoop/"+rowData.relativeId;
	_callAjax(url,"",{closed:function(){business.resetSonTable();}});
}
CfgRelative.prototype.op_edit= function (rowData,rowId,opType,tableId)
{
	var url="/cfgGroupform?groupId="+this.groupId;
	G_showCommBox(url,'编辑',900,450,{'关闭': true});
}
CfgRelative.prototype.op_addBang= function (rowData,rowId,opType,tableId)
{
	var url="/conLinkform?type="+rowData.type+"&groupId="+this.groupId;
	G_showCommBox(url,'编辑',900,450,{'关闭': true});
}

CfgRelative.prototype.addToGroup=function (type){
	var sonIds=G_captureCheckValue("selectTable");
	if(sonIds==null||sonIds.length==0)
		confirm("选项数为0");
	else if(confirm("请确认添加这几项信息")){
		var url =this.Url_getGroupSonAdd+"/"+this.groupId+"/"+this.groupType;
		var para ="sonIds="+sonIds;
		_callAjax(url,para,{closed:function(){business.resetParentTable();}});
	}
}
var business=new CfgRelative();



var op={
        name:"business",
        defines:[
	        {
	        	name:"parentTable",
	        	ops:[{cnName:'查看',enName:'SearchSon',op:"resetSonTable"},
		    	        {cnName:"添加",enName:'AddSon',op:"op_addBang"},
		    	        {cnName:"编辑",enName:'Edit',op:"op_edit"},
		    	        {cnName:"绑定",enName:'BangSon',op:"resetSelectTable"}],
	    		opAll:"set"
	        },
	       {
	        	name:"sonTable",
			    ops:[{cnName:"向上移动",enName:'Up',op:"changeSort"},
			         {cnName:"向下移动",enName:'Down',op:"changeSort"},
			         {cnName:"解绑",enName:'Release',op:"release"}]
	    	}
        ]};
