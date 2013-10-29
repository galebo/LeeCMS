var jqTreeGridUtil = {};


/**
 * leaf 节点不显示checkbox,其他属性同jqTreeGridUtil.directChildCheckFomatter -Not Leaf
 */
jqTreeGridUtil.directChildCheckFomatterNL = function($){ return function(cellvalue, options, rowObject){
    var checkValue=options.rowId+":"+rowObject[rowObject.length-1-2];//取得parentid信息
    var isLeaf = rowObject[rowObject.length-1-1];//判断isLeaf
    if(isLeaf){
    	return '';
    }else{
    	return '<input type="checkbox" selectType="directChild" value="'+checkValue+'"onclick="jqTreeGridUtil.directChildCheckCB(this)"/>';
    }
};
}(jQuery);
jqTreeGridUtil.directChildCheckCB =  function($){return function(obj){
	var v = obj.value.split(":")[0];
	var checked = false;
	if(obj.checked==true){
		checked = true;
	}
	//parent属性  _parent由Treeid决定，所以要修改为后缀为_parent的2012-03-15
	$.each($('td[aria-describedby$="_parent"]'),function(key,value){
		if($(value).text()==v){
			$(value).parent().find(':checkbox[selectType="directChild"]').attr('checked',checked);
		}
	});
};
}(jQuery);


/**
 * 全选操作
 */
/**
 * 此方法仅选中第一级的树节点,level=0
 * @Cre 2012-04-01 16:17
 */
jqTreeGridUtil.checkLevl0All =function($){
	return function(obj,treeId){
		$.each($('#'+treeId+' tr td[aria-describedby="'+treeId+'_level"]'),function(key,value){
			if($(value).text()==0){
				$(value).parent().find(':checkbox').attr('checked',obj.checked);
			}
		});	
	};
}(jQuery);
function level0AllCheckBox(treeId){
	return '<input type="checkbox" onclick="jqTreeGridUtil.checkLevl0All(this,\''+treeId+'\')"/>';
};





/**
 * formater生成方法
 * 生成打开新窗口的button-formater
 * openType 1 button 2 超链接
 * openType=1 openName为button的名字，openType=2时 openName 为超链接的显示文本
 * 未解决样式下划线的问题 2012-03-06 @cre
 */
jqTreeGridUtil.jBoxOpenDialog = function($){return function(openType,openName,desUrl,dialogName,width,height,options){
	if(options == null){
		options = '{buttons: { \'关闭\': true} }';
	}
	desUrl="iframe:"+desUrl;
	var onclickMethod = 'onclick="$.jBox.open(\''+desUrl+'\',\''+dialogName+'\','+width+','+height+','+options+')"';
	if(openType==1){
		return '<a '+onclickMethod+' style=":link:{text-decoration:blank;color:blue}">'+openName+'</a>';
	}else if(openType==2){
		return '<input type="button" value="'+openName+'" '+onclickMethod+' />';
	}
};
}(jQuery);
