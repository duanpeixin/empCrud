package com.dpx.utils;

import java.util.HashMap;
import java.util.Map;

//���ؽ��
public class Message {
	//�ɹ�ʧ��״�� 100�ɹ� 200ʧ��
	private int code;
	//��Ϣ
	private String msg;
	//�û��������������
	private Map<String, Object> map = new HashMap<String, Object>();
	
	//�ɹ�����
	public static Message success(){
		Message mes = new Message();
		mes.setCode(100);
		mes.setMsg("����ɹ�");
		return mes;
		
	}
	//ʧ�ܷ���
	public static Message fali(){
		Message mes = new Message();
		mes.setCode(200);
		mes.setMsg("����ʧ��");
		return mes;
		
	}
	//�û�������Ϣ	
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
