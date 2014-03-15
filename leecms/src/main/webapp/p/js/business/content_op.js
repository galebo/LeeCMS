
var op={
        name:"business",
        defines:[
	        {
	        	name:"parentTable",
		        ops:[{cnName:"查看文章",enName:'searchContent',op:"op_resetSonTable"},
		    	     {cnName:"添加文章",enName:'addContent',op:"op_addContent"},
		    	     {cnName:"绑定文章",enName:'op_bang',op:"op_bang"}
		    	     ],
		     	opAll:"set"
	        },
	    	{
	        	name:"sonTable",
			    ops:[{cnName:"查看",enName:'viewContent',op:"op_viewContent"},
			         {cnName:"向上移动",enName:'Up',op:"op_changeSort"},
			         {cnName:"向下移动",enName:'Down',op:"op_changeSort"},
			         {cnName:"解绑",enName:'releaseContent',op:"op_releaseContent"}
			         ]
	    	}]
    	};