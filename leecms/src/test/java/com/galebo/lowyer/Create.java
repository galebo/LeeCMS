package com.galebo.lowyer;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Create
{
	private Configuration cfg;

	public Configuration getCfg()
	{
		return cfg;
	}

	public void init() throws Exception
	{
		cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("E:/workspace/java/workspace/letvCms1.0/src/test/java"));
	}

	public static void main(String[] args) throws Exception
	{
		Create test = new Create();
		test.init();
		Map map = test.getMap();
		
		Template template = test.getCfg().getTemplate("CommonDao.ftl");
		Writer writer = new OutputStreamWriter(new FileOutputStream("E:/workspace/java/workspace/letvCms1.0/src/main/java/com/galebo/lowyer/dao/CommonDao.java"), "GBK");
		template.process(map, writer);
		System.out.println("Successfull................");
	}

	private  List<String> getList(List<String> _beans) {
		List<String> beans=new ArrayList<String>();
		for (Iterator iterator = _beans.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			beans.add(string.replace("user.", ""));
		}
		return beans;
	}
	private  Map getMap() {
		Map map = new HashMap();
		List<String> beans=new ArrayList<String>();

		beans.add("ConContent");
		beans.add("Define");
		beans.add("DefineInstance");
		beans.add("ColColumn");
		beans.add("Role");
		beans.add("User");
		map.put("importBeans", beans);
		map.put("beans", getList(beans));
		return map;
	}
}