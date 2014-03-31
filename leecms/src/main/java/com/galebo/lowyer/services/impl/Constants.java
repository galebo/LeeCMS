package com.galebo.lowyer.services.impl;

import com.galebo.common.UtilsOS;

public class Constants {
	static public final String uploadDir="/p/upload";
	static public final String uploadDirKey="${uploadDir}";
	static public final String commBase="/common";
	static public final String exportStaticPre = "../";
	static public String uploadDirNew = "/p/upload";
	static public final String url="#";
	static public final String img=uploadDir+"/default.jpg";
	static public final String indexPath = "/p/upload/index";
	static public final String loopType="3AB";
	static public final String linkType="3AA";
	static public final String columnType="3AC";
	static public final String indexMenuType="3AD";
	static public final String indexItemType="3AF";
	static public final String categoryType="3AE";
	
	static public final String menuColumn="3BA";
	static public final String menuContent="3BB";
	static public final String selfType="3BC";

	public static final String DivDefineType = "2AA";
	public static final String SiteDefineType = "2AB";
	public static final String GlobalDefineType = "2AC";
	public static final String STATUS_IN_USE = "1AA";
	public static final String STATUS_NOT_IN_USE = "1AB";
	

	static public String realPath = "/e/static/tmp/";
	static public String destPath = "/e/static/html/";
	static public String exportUploadDir = "http://42.96.146.224:8982/p/upload";
	static
	{
		if(UtilsOS.isWindowsOS())
		{
			destPath="E:/workspace/java/lowyer/static";
			realPath="E:/pages/";
			exportUploadDir = "http://localhost:8080/p/upload";
		}
	}
}
