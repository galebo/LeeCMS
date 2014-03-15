var op={
        name:"business",
        defines:[
	        {
	        	name:"parentTable",
		        ops:[
		    	     {cnName:"编辑",enName:'editColumn',op:"op_editColumn",check:function(level){if(level==0){return false;}return true;}  },
		    	     {cnName:"删除",enName:'deleteColumn',op:"op_deleteColumn",check:function(level){if(level==0){return false;}return true;}  },
			         {cnName:"向上移动",enName:'Up',op:"op_changeSort_column",check:function(level){if(level<=1){return false;}return true;}  },
			         {cnName:"向下移动",enName:'Down',op:"op_changeSort_column",check:function(level){if(level<=1){return false;}return true;}  },
			    	 {cnName:"添加子"+parent_name,enName:'addColumn',op:"op_addColumn",check:function(level){if(level>=2){return false;}return true;}}],
		     	opAll:"set"
	        }]
    	};
