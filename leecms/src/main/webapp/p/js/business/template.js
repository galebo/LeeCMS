var parentDefine={
	name:"select",
   	colNames:['模板实例ID','模板ID','cssID','更新时间', '操作'],
   	colModel:[
  	   		{name:'instanceId',index:'instanceId', width:30,key:true},
  	   		{name:'templateId',index:'templateId', width:40},
  	   		{name:'cssId',index:'cssId', width:30},
  	   		{name:'time',index:'time', width:120},
  	   		{name:'manger',width: 150, align:'center', formatter:opFormatter}
  	   	],
    width:  400,
	caption: '模板组<input style="margin-left:280px;" type="button" onclick="business.close();" value="放弃"/></input>'
};


function CfgRelative()
{
	this.Url_getTemplate='/jqJson/getTemplates';
	this.selectId=1;
}
CfgRelative.prototype.select= function (rowData,rowId,opType,tableId)
{
	var url="/jqJson/updateUserTemplate/"+rowId;
	this.selectId=rowId;
	G_callAjax(url,"",{closed:function(){business.resetSonTable();}});
};
CfgRelative.prototype.resetSonTable= function ()
{
	jQuery("#templateInstanceId").html("NO."+this.selectId);
	jQuery("#select").hide();
};
CfgRelative.prototype.close= function ()
{
	jQuery("#select").hide();
};

CfgRelative.prototype.show= function ()
{
	jQuery("#select").show();
	G_initOrRefreshJqGrid(parentDefine,this.Url_getTemplate);
};
var business=new CfgRelative();

var op={
        name:"business",
        defines:[
	        {
	        	name:"selectTable",
	        	ops:[{cnName:'选择',enName:'select',op:"select"}]
	        }
        ]};
