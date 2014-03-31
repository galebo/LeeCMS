var parentDefine={
		name:"parent",
	   	colNames:['选择','ID','名称','类型','','','','操作'],
	   	colModel:[
		  	   	{name:'childCheckbox',index:'select',hidden:true,width:1},
	  	   		{name:'elmentId',index:'elmentId', width:70},
	  	   		{name:'name',index:'name', width:140},
	  	   		{name:'type',index:'type', width:80},
	  	   		{name:'sort',index:'sort', width:140,hidden:true},
	  	   		{name:'parentElmentId',index:'parentElmentId', width:140,hidden:true},
	  	   		{name:'relativeId',index:'relativeId', width:140,hidden:true,key:true},
	  	   		{name:'manger',  width: 350, align:'center', formatter:opFormatter}
	  	   	],
	    width:  400,
		caption: '栏目'
	};

var selectColumnDefine={
		name:"son1",
	   	colNames:[G_initCheckBox("son1Table"),'栏目ID', '栏目名称','','','',''],
	   	colModel:[
			    {name:'childCheckbox', width:38, align:'center', formatter:checkFomatter},
		  	   	{name:'id',index:'id',key:true, width:60},
	  	   		{name:'name',index:'name', width:180},
	  	   		{name:'sort',index:'sort', width:140,hidden:true},
	  	   		{name:'time',index:'time', width:140,hidden:true},
	  	   		{name:'parentId',index:'parentId', width:140,hidden:true},
	  	   		{name:'relativeId',index:'relativeId', width:140,hidden:true}
	  	   	],
	    width:  350,
		caption: '内容'
    };

var op={
        name:"business",
        defines:[
	        {
	        	name:"parentTable",
		        ops:[{cnName:"向上移动",enName:'Up',op:"changeSort"},
			         {cnName:"向下移动",enName:'Down',op:"changeSort"},
			         {cnName:"解除绑定",enName:'Delete',op:"releaseMenuElement"}]
	        }]
    	};


function IndexItem()
{
	this.Url_getColColumns='/jqJson/indexItems';
	this.Url_changeSort='/jqJson/changeSort/IndexItem';
	this.div=new Div(["#son1"]);
	this.G_columnId=null;

	G_initOrRefreshJqGrid(parentDefine,this.Url_getColColumns);
	this.div.show('none');
}

IndexItem.prototype.showSon1= function()
{
	this.div.show('#son1');
	G_initOrRefreshJqGrid(selectColumnDefine,'/jqJson/itemsNoInIndex');
};

IndexItem.prototype.resetSonTable= function (rowData,rowId,opType,tableId)
{
	//var url=this.Url_getConContent+"/"+this.G_columnId;
	G_initOrRefreshJqGrid(parentDefine,this.Url_getColColumns);
	this.div.show('none');
};
IndexItem.prototype.releaseMenuElement= function (rowData,rowId,opType,tableId)
{
	var url="/jqJson/releaseMenuElement/"+rowData.relativeId;
	G_callAjax(url,"",{closed:callBack_resetSonTable});
};
IndexItem.prototype.addItems=function (){
	var sonIds=G_captureCheckValue("son1Table");
	if(sonIds==null||sonIds.length==0)
		confirm("选项数为0");
	else if(confirm("请确认添加这几项信息")){
		var url ="/jqJson/addIndexItem/"+sonIds;
		G_callAjax(url,"",{closed:callBack_resetSonTable});
	}
};

IndexItem.prototype.changeSort= function (rowData,rowId,opType,tableId)
{
	var url=this.Url_changeSort+"/"+opType+"/"+rowData.parentElmentId+"/"+rowData.relativeId+"/"+rowData.elmentId+"/"+rowData.sort;
	G_callAjax(url,"",{closed:callBack_resetSonTable});
};
var business=new IndexItem();
function callBack_resetSonTable(){business.resetSonTable();}