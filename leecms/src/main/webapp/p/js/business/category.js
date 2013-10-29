
var parentDefine={
	name:"parent",
   	colNames:['',name+'ID', 
   	          name+'名称',
   	          '排序',
   	          '更改时间',
   	          '父id',
   	          '关系id',
   	          '操作'],
   	colModel:[
		  	{name:'select',index:'select',align:'center',width:20,hidden:true},
  	   		{name:'id',index:'id', width:50,key:true},
  	   		{name:'name',index:'name', width:150},
  	   		{name:'sort',index:'sort',align:'center', width:50},
  	   		{name:'time',index:'time',align:'center', width:150},
  	   		{name:'parentId',index:'parentId',align:'center', width:150,hidden:true},
  	   		{name:'relativeId',index:'relativeId',align:'center', width:150,hidden:true},
  	   		{name:'manger',  width: 450, align:'center', formatter:opFormatter}
  	   	],
		treeGrid: true,ExpandColumn:"name",
  	    width:  1000,
	caption: name
}
var op={
        name:"business",
        defines:[
	        {
	        	name:"parentTable",
		        ops:[{cnName:"编辑",enName:'editColumn',op:"editColumn",check:function(level){if(level==0){return false;}return true;}  },
		    	     {cnName:"删除",enName:'deleteColumn',op:"deleteColumn",check:function(level){if(level==0){return false;}return true;}  },
			         {cnName:"向上移动",enName:'Up',op:"changeSort",check:function(level){if(level<=1){return false;}return true;}  },
			         {cnName:"向下移动",enName:'Down',op:"changeSort",check:function(level){if(level<=1){return false;}return true;}  },
			    	 {cnName:"添加子"+name,enName:'addColumn',op:"addColumn",check:function(level){if(level>=2){return false;}return true;}}]
	        }]
    	};
function Column()
{
	this.Url_getColColumns='/jqJson/parents/'+name_code;
	this.initColumn();
}

Column.prototype.initColumn=function ()
{
	initOrRefreshJqGrid(parentDefine,this.Url_getColColumns);
}
Column.prototype.editColumn= function (rowData,rowId,opType,tableId)
{
	var url="/"+name_big+"form?"+name_en_l+"Id="+rowId;
	G_showCommBox(url,'编辑'+name,600,450,{'关闭': true},callBack_resetSonTable);
}	
Column.prototype.addColumn= function (rowData,rowId,opType,tableId){
	var url="/"+name_big+"form?parentId="+rowId+"&parent"+name_en+"Name="+rowData.name;
	G_showCommBox(url,'增加'+name,600,450,{'关闭': true},callBack_resetSonTable);
}
Column.prototype.deleteColumn=function (rowData,rowId,opType,tableId)
{
	var url="/jqJson/delete"+name_en+"/"+rowId;
	_callAjax(url,"",{closed:callBack_resetSonTable});
}
Column.prototype.changeSort= function (rowData,rowId,opType,tableId)
{
	var url="/jqJson/changeSort/"+name_en+"/"+opType+"/"+rowData.parentId+"/"+rowData.relativeId+"/"+rowId+"/"+rowData.sort;
	_callAjax(url,"",{closed:callBack_resetSonTable});
}
function callBack_resetSonTable(){business.initColumn();}
var business=new Column();