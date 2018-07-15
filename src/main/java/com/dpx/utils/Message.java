package com.dpx.utils;

import java.util.HashMap;
import java.util.Map;

//返回结果
public class Message {
	//成功失败状码 100成功 200失败
	private int code;
	//消息
	private String msg;
	//用户给浏览器的数据
	private Map<String, Object> map = new HashMap<String, Object>();
	
	//成功方法
	public static Message success(){
		Message mes = new Message();
		mes.setCode(100);
		mes.setMsg("处理成功");
		return mes;
		
	}
	//失败方法
	public static Message fali(){
		Message mes = new Message();
		mes.setCode(200);
		mes.setMsg("处理失败");
		return mes;
		
	}
	//用户请求信息	
	public  Message add(String key,Object value){
		this.getMap().put(key, value);
		return this;
		
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
