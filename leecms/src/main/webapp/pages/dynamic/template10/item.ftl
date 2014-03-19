<#import "/common.ftl" as g/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>律师文集-刑事动态</title>
<meta name="description" content="刑事动态">
<meta name="keywords" content="刑事动态">
<link href="http://www.xslsbj.com/style/list.css" rel="stylesheet" type="text/css" />
</head>


	<@g.top/>

	<@g.menu/>

	<@g.logo1/>

	<div id="list_nr">
		<div id="list_left">
			<div id="list_left_top">
				<div id="list_left_top_1">
					<h3>法律文集</h3>
				</div>
				<div id="list_left_nr">
					<div id="list_left_nrbg">
						<div id="list_left_nr1">
							<div id="list_left_nr2">
								<ul class="list_left_nrul">
								<#list 1..14 as one>
									<li><a <#if one_index=0>class='on'</#if> href='#'>刑事动态</a></li>
								</#list>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div id="list_left_nr3">
				<div id="list_left_nr3_1">
					<div id="list_left_nr3_2">
						<div id="list_lfet_input">
							<form name="formsearch" method="post" action="/art/Tags.asp" onsubmit="return zCheckSearch(this);">
								<input class="list_left_input" type="text" name="key" size="18" />
								 <input type="submit" class="list_left_input_bt" value="文档搜索" />
							</form>
						</div>
					</div>
				</div>
			</div>


		</div>


		<div id="list_right">

			<div id="list_right_nr">
				<div id="list_right_nr_1">
					<div id="list_right_nr_2">
						<div id="list_right_nr_3">
							<strong>当前位置：</strong> <span><a href="/">首页</a></span> <font>&gt;</font> <span><a href="/art/">律师文集</a></span> <font>&gt;</font> <span><a href="/art/List.asp?classid=736527670376">刑事动态</a></span>
						</div>
						<!--新闻版块Begin-->
							<#list 1..14 as one>
								<div id='list_right_nr_4'>
									<div id='list_right_nr_4_1'>
										<span> <a href='#' target='_blank'>最高检:提高七种岗位技能 加强侦查监督能力建设</a>
										</span> <font>2014-3-18 12:13:22</font>
									</div>
									<div id='list_right_nr_4_2'>
										分类: <strong><a href='#'>刑事动态</a></strong>&nbsp;| 浏览: <font>2 </font>
									</div>
								</div>
							</#list>
						

						<div id="list_right_nr_fy">
							<span> <a href="#" title="首页">&lt;&lt;</a> 
									<#list 1..6 as one>
											<a <#if one_index=0>  class='now'</#if>  href='/'>${one}</a> 
									</#list>
								 <a href="#" title='尾页'>&gt;&gt;</a>
							</span>

						</div>

					</div>
				</div>
			</div>

		</div>
	</div>


	<@g.foot/>


</body>
</html>