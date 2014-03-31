package com.galebo.lowyer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.galebo.lowyer.bean.Common;
import com.galebo.lowyer.bean.Detail;
import com.galebo.lowyer.bean.Item;
import com.galebo.lowyer.services.mock.BeanCreator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Ftl2Html {
	public static void main(String[] args) throws IOException, TemplateException {
		
		
		Configuration cfg=new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("E:/workspace/git/LeeCMS/leecms/src/main/webapp/pages/dynamic/template11"));
		

		BeanCreator BeanCreator=new BeanCreator();
		Map<String, Object> map = new HashMap<String, Object>();
		String out="E:/workspace/git/LeeCMS/leecms/target/";

		Common common = BeanCreator.getCommon();
		map.put("common", common);
		map.put("ftlPath", "/");
		map.put("commTBase", "../src/main/webapp/p/common/template11");
		
		Template template = cfg.getTemplate("index.ftl");
		template.process(map, new FileWriter(out+"zindex.html"));

		Item item=BeanCreator.getItem();
		map.put("data", item);
		Template template3 = cfg.getTemplate("item.ftl");
		template3.process(map, new FileWriter(out+"zitem.html"));

		Detail detail=BeanCreator.getDetail();
		Template template2 = cfg.getTemplate("detail.ftl");
		map.put("data", detail);
		template2.process(map, new FileWriter(out+"zdetail.html"));

		System.out.println("over");
	}
}
