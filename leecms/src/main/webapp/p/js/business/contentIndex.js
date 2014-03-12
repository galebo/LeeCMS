

var sonDefine={
		name:"son",
	   	colNames:['','ID','名称',  '职位','首字母','','',  '操作'],
	   	colModel:[
		  	   	{name:'id',index:'id',hidden:true, width:1},
	  	   		{name:'contentId',index:'contentId',hidden:true, width:1,key:true},
	  	   		{name:'name',index:'name', width:380},
	  	   		{name:'key1',width: 265, align:'center', formatter:selectFormatterKey1},
	  	   		{name:'key2',width: 165, align:'center', formatter:selectFormatterKey2},
	  	   		{name:'key3',index:'key3',hidden:true},
	  	   		{name:'key4',index:'key3',hidden:true},
	  	   		{name:'manger',  width: 200, align:'center', formatter:opFormatter}
	  	   	],
	    width:  700,
		caption: '内容'
    };
var op={
        name:"business",
        defines:[
	    	{
	        	name:"sonTable",
			    ops:[{cnName:"设置",enName:'set',op:"set"}]
	    	}]
    	};
var key1=[{label:'ALL',value:'所有'},{label:'4AA',value:'管理合伙人'},{label:'4AB',value:'合伙人'},{label:'4AC',value:'律师'},{label:'4AD',value:'律师助理'},{label:'4AE',value:'专业顾问'},{label:'4AF',value:'人力资源'},{label:'4AG',value:'市场部'}];
var key2=[{label:'ALL',value:'未配置'},{label:'A',value:'A'},{label:'B',value:'B'},{label:'C',value:'C'},{label:'D',value:'D'},{label:'E',value:'E'},{label:'F',value:'F'},{label:'G',value:'G'},{label:'H',value:'H'},{label:'I',value:'I'},{label:'J',value:'J'},{label:'K',value:'K'},{label:'L',value:'L'},{label:'M',value:'M'},{label:'N',value:'N'},{label:'O',value:'O'},{label:'P',value:'P'},{label:'Q',value:'Q'},{label:'R',value:'R'},{label:'S',value:'S'},{label:'T',value:'T'},{label:'U',value:'U'},{label:'V',value:'V'},{label:'W',value:'W'},{label:'X',value:'X'},{label:'Y',value:'Y'},{label:'Z',value:'Z'}];

function createSelect(name,keys,cellvalue, options, rowObject){
	var btn=""+
	'<select id="'+name+options.rowId+'">                  ';
	for ( var i = 0; i< keys.length; i++) {
		btn=btn+'<option value="'+keys[i].label+'"  ';
		if(cellvalue==keys[i].label)
			btn=btn+' selected="selected" ';
		btn=btn+'    >'+keys[i].value+'</option>  ';
	}
	btn=btn+'</select>';
	return btn;
}
function selectFormatterKey2(cellvalue, options, rowObject){
	return createSelect('key2',key2,cellvalue, options, rowObject);
}
function selectFormatterKey1(cellvalue, options, rowObject){
	return createSelect('key1',key1,cellvalue, options, rowObject);
}

function ContentIndex()
{
	this.resetSonTable();
}
ContentIndex.prototype.set= function (rowData,rowId,opType,tableId)
{
	var key1=document.getElementById("key1"+rowId).value;
	var key2=document.getElementById("key2"+rowId).value;
	var url;
	if(document.getElementById('Sex').value=='1')
		url="/jqJson/setContentIndex/"+rowData.contentId+"/"+key1+"/"+key2;
	else
		url="/jqJson/insertContentIndex/"+rowData.contentId+"/"+key1+"/"+key2;
	G_callAjax(url,"",{closed:callBack_resetSonTable});
};
ContentIndex.prototype.resetSonTable= function (rowData,rowId,opType,tableId)
{
	if(document.getElementById('Sex').value=='1')
		this.Url_getConContent='/jqJson/getIndexSearchData';
	else
		this.Url_getConContent='/jqJson/getIndexSearchDataNotIn';
	G_initOrRefreshJqGrid(sonDefine,this.Url_getConContent);
};
jBox.setDefaults({ defaults: { border: 8,draggable: true,top: '1%' }}); 
var business=new ContentIndex();
function callBack_resetSonTable(){business.resetSonTable();}