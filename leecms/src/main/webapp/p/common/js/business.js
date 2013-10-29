
function exeAjax(url,data,callBack)
{
	jQuery.ajax({
	    type : "get",
	    async:true,
	    url : url,
	    data:data,
	    dataType : "jsonp",
	    jsonp: "call",
	    jsonpCallback:callBack,
	    success : function(json){
	        alert(json);
	    },
	    error:function(){
	    }
	});
}
function getCounts(url,_name,_ids)
{
	exeAjax(url,{ids:_ids,name:_name},"upCountCallBack");
}
function upCount(url,_id)
{
	exeAjax(url,{id:_id,name:""},"upCountCallBack");
}
function upCountCallBack(name,data, textStatus){
	if(data)
	{
		for(i=0;i<data.length;i++)
		{
			if(document.getElementById(name+data[i].id))
				document.getElementById(name+data[i].id).innerHTML=""+data[i].count;
		}
	}
}
var commCssBase="";
function getWebCount(url,_name,_id)
{
	exeAjax(url,{id:_id,name:_name,commCssBase:commCssBase},"getWebCountCallBack");
}
function getWebCountCallBack(name,data, textStatus){
	if(data)
	{
		for(i=0;i<data.length;i++)
		{
			if(document.getElementById(name+data[i].id))
			{
				var numPic=""+data[i].count;
				for ( var int = 0; int < numPic.length; int++) {
					$("#"+name+data[i].id).append("<img src='"+commCssBase+"/images/num/"+numPic[int]+".gif'/>");
				}
			}
		}
	}
}

function getItemTop(url,_id)
{
	exeAjax(url,{id:_id},"getItemTopCallBack");
}
function getItemTopCallBack(data, textStatus){
	if(data)
	{
		if(data[0])
		{
			_set("top",data[0],'点击排行');
		}
		if(data[1])
		{
			_set("recommend",data[1],'热门推荐');
		}
	}
}
function _set(name,data,txt){
	if(document.getElementById("item"+name))
		document.getElementById("item"+name).innerHTML=txt;
	for(i=0;i<data.length;i++)
	{
		if(document.getElementById(name+i))
		{
			document.getElementById(name+i).href=data[i].url;
			document.getElementById(name+i).title=data[i].name;
			document.getElementById(name+i).innerHTML=data[i].name;
		}
	}
}
function setHTML(name,html)
{
	if(document.getElementById(name))
		document.getElementById(name).innerHTML=html;
}
function setUrl(name,url)
{
	if(document.getElementById(name))
		document.getElementById(name).url=url;
}
function show(name)
{
	if(document.getElementById(name))
		document.getElementById(name).style.display="block";
}
function hide(name)
{
	if(document.getElementById(name))
		document.getElementById(name).style.display="none";
}
var key1="ALL";
var key2="ALL";
function showKey1(key)
{
	$("#key1"+key1).css("font-weight","normal");
	$("#"+key1+"_"+key2).hide();
	key1=key;
	$("#"+key1+"_"+key2).show();
	$("#key1"+key1).css("font-weight","bold");
}
function showKey2(key)
{
	$("#key2"+key2).css("color","#ffffff");
	$("#"+key1+"_"+key2).hide();
	key2=key;
	$("#"+key1+"_"+key2).show();
	$("#key2"+key2).css("color","#ff0000");
}
/*
 * lyz page类 2012-11-17
 */
function Page(_varName,_pageSize,_contents)
{
	this.pageSize=_pageSize;
	this.contents=_contents;
	this.varName=_varName;
	this.now=1;
	this.prePageNo=1;
	this.nextPageNo=1;
	this.total=this.contents.length;
	this.pageNo=1;

	//设置总记录数、总页数、当前页号
	this.totalPage = Math.ceil(this.total / this.pageSize);
	
	//计算上一页和下一页的页码及按钮的状态
	this.prePageNo = this.pageNo;
	this.nextPageNo = this.pageNo;
	if (this.pageNo > 1) this.prePageNo--;
		else this.prePageNo = 1;
	if (this.pageNo < this.totalPage) this.nextPageNo++;
		else this.nextPageNo = this.totalPage;
	if (this.pageNo == 1) this.preOk=false;
	if (this.pageNo == this.totalPage) this.nextOk=false;
	setHTML("page_total",this.total);
	setHTML("page_pageSize",this.pageSize);
	setHTML("page_pageNo",this.pageNo);
	setHTML("page_totalPage",this.totalPage);
}
Page.prototype._go=function()
{
	var max=(this.now)*this.pageSize;
	if(max>this.contents.length)
		max=this.contents.length;
	var i=0;
	var index=0;
	for(i=(this.now-1)*this.pageSize,index=0;i<max;i++,index++)
	{
		setUrl(this.varName+index,this.contents[i].url);
		setHTML(this.varName+index,this.contents[i].name);
		show(this.varName+index+"div");
	}
	if(this.now==this.totalPage)
	{
		for(;index<this.pageSize;index++)
		{
			hide(this.varName+index+"div");
		}
	}
	setHTML("page_pageNo",this.now);
};
Page.prototype.go=function(index)
{
	if(index<1||index>this.totalPage)
		return;
	this.now=index;
	this._go();
};
Page.prototype.goPre=function()
{
	if(this.now==1)
		return;
	this.now=this.now-1;
	this._go();
};
Page.prototype.goNext=function()
{
	if(this.now==this.totalPage)
		return;
	this.now=this.now+1;
	this._go();
};
Page.prototype.goEnd=function()
{
	this.now=this.totalPage;
	this._go();
};