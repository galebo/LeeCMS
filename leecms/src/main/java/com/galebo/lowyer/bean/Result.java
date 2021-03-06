package com.galebo.lowyer.bean;

public class Result {
	public Result(int error, String desc,String url) {
		super();
		this.error = error;
		this.desc = desc;
		this.url = url;
	}
	public static Result getSucess(String url){return new Result(0, "",url);}
	public static Result getError(String desc){return new Result(1, desc,"");}
	int error;
	String desc;
	String url;
	public int getError() {
		return error;
	}
	public String getDesc() {
		return desc;
	}
	public String getUrl() {
		return url;
	}
}
