

// 滚动图片构造函数
// liyanzhao QQ:9747375
//
function ScrollPic(scrollContId, arrLeftId, arrRightId, dotListId) {
	this.scrollContId = scrollContId;
	this.arrLeftId = arrLeftId;
	this.arrRightId = arrRightId;
	this.dotListId = dotListId;
	this.dotClassName = "dotItem";
	this.dotOnClassName = "dotItemOn";
	this.dotObjArr = [];
	this.pageWidth = 0;
	this.frameWidth = 0;
	this.speed = 10;
	this.space = 10;
	this.pageIndex = 0;
	this.autoPlay = true;
	this.autoPlayTime = 5;
	var _autoTimeObj="";
	var _scrollTimeObj="";
	var _state = "ready";
	this.stripDiv = document.createElement("DIV");
	this.listDiv01 = document.createElement("DIV");
	this.listDiv02 = document.createElement("DIV");
	if (!ScrollPic.childs) {
		ScrollPic.childs = [];
	}
	this.ID = ScrollPic.childs.length;
	ScrollPic.childs.push(this);
	this.initialize = function() {
		if (!this.scrollContId) {
			throw new Error("必须指定scrollContId.");
			return
		}
		this.scrollContDiv = this.get(this.scrollContId);
		if (!this.scrollContDiv) {
			throw new Error("scrollContId不是正确的对象.(scrollContId = \"" + this.scrollContId + "\")");
			return
		}
		this.scrollContDiv.style.width = this.frameWidth + "px";
		this.scrollContDiv.style.overflow = "hidden";
		this.listDiv01.innerHTML = this.listDiv02.innerHTML = this.scrollContDiv.innerHTML;
		this.scrollContDiv.innerHTML = "";
		this.scrollContDiv.appendChild(this.stripDiv);
		this.stripDiv.appendChild(this.listDiv01);
		this.stripDiv.appendChild(this.listDiv02);
		this.stripDiv.style.overflow = "hidden";
		this.stripDiv.style.zoom = "1";
		this.stripDiv.style.width = "32766px";
		this.listDiv01.style.cssFloat = "left";
		this.listDiv01.style.styleFloat = "left";
		this.listDiv02.style.cssFloat = "left";
		this.listDiv02.style.styleFloat = "left";
		this.addEvent(this.scrollContDiv, "mouseover",Function("ScrollPic.childs[" + this.ID + "].stop()"));
		this.addEvent(this.scrollContDiv, "mouseout",Function("ScrollPic.childs[" + this.ID + "].play()"));
		if (this.arrLeftId) {
			this.arrLeftObj = this.get(this.arrLeftId);
			if (this.arrLeftObj) {
				this.addEvent(this.arrLeftObj, "mousedown",Function("ScrollPic.childs[" + this.ID+ "].rightMouseDown()"));
				this.addEvent(this.arrLeftObj, "mouseup",Function("ScrollPic.childs[" + this.ID	+ "].rightEnd()"));
				this.addEvent(this.arrLeftObj, "mouseout",Function("ScrollPic.childs[" + this.ID+ "].rightEnd()"));
			}
		}
		if (this.arrRightId) {
			this.arrRightObj = this.get(this.arrRightId);
			if (this.arrRightObj) {
				this.addEvent(this.arrRightObj, "mousedown",Function("ScrollPic.childs[" + this.ID+ "].leftMouseDown()"));
				this.addEvent(this.arrRightObj, "mouseup",Function("ScrollPic.childs[" + this.ID+ "].leftEnd()"));
				this.addEvent(this.arrRightObj, "mouseout",Function("ScrollPic.childs[" + this.ID+ "].leftEnd()"));
			}
		}
		if (this.dotListId) {
			this.dotListObj = this.get(this.dotListId);
			if (this.dotListObj) {
				var pages = Math.round(this.listDiv01.offsetWidth / this.frameWidth + 0.4), i, tempObj;
				for (i = 0; i < pages; i++) {
					tempObj = document.createElement("span");
					this.dotListObj.appendChild(tempObj);
					this.dotObjArr.push(tempObj);
					if (i == this.pageIndex) {
						tempObj.className = this.dotClassName;
					} else {
						tempObj.className = this.dotOnClassName;
					}
					tempObj.title = "第" + (i + 1) + "页";
					this.addEvent(tempObj, "click",Function("ScrollPic.childs[" + this.ID+ "].pageTo(" + i + ")"));
				}
			}
		}
		if (this.autoPlay) {
			this.play();
		}
	};
	this.leftMouseDown = function() {
		if (_state != "ready") {
			return
		}
		_state = "floating";
		_scrollTimeObj = setInterval("ScrollPic.childs[" + this.ID+ "].moveLeft()", this.speed);
	};
	this.rightMouseDown = function() {
		if (_state != "ready") {
			return
		}
		;
		_state = "floating";
		_scrollTimeObj = setInterval("ScrollPic.childs[" + this.ID+ "].moveRight()", this.speed);
	};
	this.moveLeft = function() {
		if (this.scrollContDiv.scrollLeft + this.space >= this.listDiv01.scrollWidth) {
			this.scrollContDiv.scrollLeft = this.scrollContDiv.scrollLeft + this.space - this.listDiv01.scrollWidth;
		} else {
			this.scrollContDiv.scrollLeft += this.space;
		}
		this.accountPageIndex();
	};
	this.moveRight = function() {
		if (this.scrollContDiv.scrollLeft - this.space <= 0) {
			this.scrollContDiv.scrollLeft = this.listDiv01.scrollWidth + this.scrollContDiv.scrollLeft - this.space;
		} else {
			this.scrollContDiv.scrollLeft -= this.space;
		}
		this.accountPageIndex();
	};
	this.leftEnd = function() {
		if (_state != "floating") {
			return
		}
		_state = "stoping";
		clearInterval(_scrollTimeObj);
		var fill = this.pageWidth - this.scrollContDiv.scrollLeft % this.pageWidth;
		this.move(fill);
	};
	this.rightEnd = function() {
		if (_state != "floating") {
			return
		}
		_state = "stoping";
		clearInterval(_scrollTimeObj);
		var fill = -this.scrollContDiv.scrollLeft % this.pageWidth;
		this.move(fill);
	};
	this.move = function(num, quick) {
		var thisMove = num / 5;
		if (!quick) {
			if (thisMove > this.space) {
				thisMove = this.space;
			}
			if (thisMove < -this.space) {
				thisMove = -this.space;
			}
		}
		if (Math.abs(thisMove) < 1 && thisMove != 0) {
			thisMove = thisMove >= 0 ? 1 : -1;
		} else {
			thisMove = Math.round(thisMove);
		}
		//var temp = this.scrollContDiv.scrollLeft + thisMove;
		if (thisMove > 0) {
			if (this.scrollContDiv.scrollLeft + thisMove >= this.listDiv01.scrollWidth) {
				this.scrollContDiv.scrollLeft = this.scrollContDiv.scrollLeft + thisMove - this.listDiv01.scrollWidth;
			} else {
				this.scrollContDiv.scrollLeft += thisMove;
			}
		} else {
			if (this.scrollContDiv.scrollLeft - thisMove <= 0) {
				this.scrollContDiv.scrollLeft = this.listDiv01.scrollWidth + this.scrollContDiv.scrollLeft - thisMove;
			} else {
				this.scrollContDiv.scrollLeft += thisMove;
			}
		}
		num -= thisMove;
		if (Math.abs(num) == 0) {
			_state = "ready";
			if (this.autoPlay) {
				this.play();
			}
			this.accountPageIndex();
			return
		} else {
			this.accountPageIndex();
			setTimeout("ScrollPic.childs[" + this.ID + "].move(" + num + ","+ quick + ")", this.speed);
		}
	};
	this.next = function() {
		if (_state != "ready") {
			return
		}
		_state = "stoping";
		this.move(this.pageWidth, true);
	};
	this.play = function() {
		if (!this.autoPlay) {
			return
		}
		clearInterval(_autoTimeObj);
		_autoTimeObj = setInterval("ScrollPic.childs[" + this.ID + "].next()",this.autoPlayTime * 1000);
	};
	this.stop = function() {
		clearInterval(_autoTimeObj);
	};
	this.pageTo = function(num) {
		if (_state != "ready") {
			return
		}
		_state = "stoping";
		var fill = num * this.frameWidth - this.scrollContDiv.scrollLeft;
		this.move(fill, true);
	};
	this.accountPageIndex = function() {
		this.pageIndex = Math.round(this.scrollContDiv.scrollLeft/ this.frameWidth);
		if (this.pageIndex > Math.round(this.listDiv01.offsetWidth/ this.frameWidth + 0.4) - 1) {
			this.pageIndex = 0;
		}
		var i;
		for (i = 0; i < this.dotObjArr.length; i++) {
			if (i == this.pageIndex) {
				this.dotObjArr[i].className = this.dotClassName;
			} else {
				this.dotObjArr[i].className = this.dotOnClassName;
			}
		}
	};
	this.get = function(objName) {
		if (document.getElementById) {
			return eval('document.getElementById("' + objName + '")');
		} else {
			return eval('document.all.' + objName);
		}
	},
	this.addEvent = function(element, i, event) {
		if (element.attachEvent) {
			element.attachEvent("on" + i, event);
		} else {
			element.addEventListener(i, event, false);
		}
	};
};

function moveDiv(id,divUrl,divImg)
{
	this.name="moveDiv"+id;
	this.divUrl=divUrl;
	//设置广告块 
	this.divLeft=0;//设置广告块初始左边位置 
	this.divTop=0;//设置广告块初始顶部位置 
	this.divWidth=90;//设置广告块宽度 
	this.divHeight=120;//设置广告块高度 
	this.divImg=divImg;//设置广告图片的URL地址 
	var txt="<div id='moveDiv' style='position:absolute;left:"+this.divLeft+"px;top:"+this.divTop+"px;width:"+this.divWidth+"px;height:"+this.divHeight+
	"px; z-index:1;' onMouseOver='javascript:window.clearInterval("+this.name+".varId)' onMouseOut='javascript:beginMoveAd();'>"+
	" <a href='"+this.divUrl+"' target=_blank><img src='"+this.divImg+"' width=100 height=100 border=0></a> </div>";
	document.write(txt);
	
	this.moveDiv=document.getElementById("moveDiv");
	//初始化每次偏离的象素 
	this._stepx=2;
	this._stepy=2;
	this.moveSpeed=40;//速度 
	this.varId;//获取setInterval的ID 
};
moveDiv.prototype.moveAd=function (){//飘浮广告主函数 
	var _adLeft=parseInt(this.moveDiv.style.left); 
	var _adTop=parseInt(this.moveDiv.style.top); 
	var _adWidth=parseInt(this.moveDiv.style.width); 
	var _adHeight=parseInt(this.moveDiv.style.height);
	var _bodyLeft=document.body.scrollLeft; 
	var _bodyTop=document.body.scrollTop; 
	var _bodyHeight=document.body.clientHeight+_bodyTop; 
	var _bodyWidth=document.body.clientWidth+_bodyLeft; 
	if(_adLeft<=_bodyLeft){ 
		this._stepx=2; 
	} 
	if(_adTop<=_bodyTop){ 
		this._stepy=2; 
	} 
	if((_adLeft+_adWidth)>=_bodyWidth){ 
		this._stepx=-2; 
	} 
	if((_adTop+_adHeight)>=_bodyHeight){ 
		this._stepy=-2;
	} 
	this.moveDiv.style.left=_adLeft+this._stepx; 
	this.moveDiv.style.top=_adTop+this._stepy; 
};
moveDiv.prototype.beginMoveAd=function (){
	this.varId=window.setInterval(this.name+".moveAd()",this.moveSpeed);
};




function PicTimeChange(_pics,_name)
{
	this.pics = _pics;
	this.nextPic = 0;
	this.timer = null;
	this.name=_name;

	this.changePic();
	this.picOn();
}


PicTimeChange.prototype.changePic=function () {
	document.getElementById(this.name+'_title').href = this.pics[this.nextPic].url;
    document.getElementById(this.name+'_title').innerHTML = this.pics[this.nextPic].name;
	for(var i=0;i<this.pics.length;i++) {
		document.getElementById(this.name+'_'+i).className = '';
	    document.getElementById(this.name+'_div'+i).style.display='none';
	}
	document.getElementById(this.name+'_'+this.nextPic).className = 'on';
    document.getElementById(this.name+'_div'+this.nextPic).style.display='block';
	this.nextPic = this.nextPic+1;
};

PicTimeChange.prototype.picOn=function () {
	var obj=this;
	this.timer = setInterval(function(){
		if(obj.nextPic >= obj.pics.length) {
			obj.nextPic = 0;
		}
		obj.changePic();
	}, 4000);
};

PicTimeChange.prototype.picOff=function (index) {
	this.nextPic=index;
	if(this.timer !== null) clearTimeout(this.timer);
	this.changePic();
};




function menuFix(menuId,offCss) {
	var navMenuLis = document.getElementById(menuId).getElementsByTagName("li");
	for ( var i = 0; i < navMenuLis.length; i++) {
		navMenuLis[i].onmouseover = function() {
			this.className += (this.className.length > 0 ? " " : "") + offCss;
		};
		navMenuLis[i].onMouseDown = function() {
			this.className += (this.className.length > 0 ? " " : "") + offCss;
		};
		navMenuLis[i].onMouseUp = function() {
			this.className += (this.className.length > 0 ? " " : "") + offCss;
		};
		navMenuLis[i].onmouseout = function() {
			this.className = this.className.replace(new RegExp("( ?|^)"+offCss+"\\b"), "");
		};
	}
}

function hiddenTipInfo(input)
{
	input.value="";
}