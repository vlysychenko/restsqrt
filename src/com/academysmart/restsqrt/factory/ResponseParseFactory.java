package com.academysmart.restsqrt.factory;

import java.util.LinkedHashMap;

import org.json.simple.JSONValue;

public class ResponseParseFactory {

  @SuppressWarnings({ "rawtypes", "unchecked" })
 public String getFailureJsonString(String msg){
  String jsonString = "";
  LinkedHashMap list = new LinkedHashMap();
  list.put("response_status", "error");

  list.put("result", msg+"");
  jsonString = JSONValue.toJSONString(list);
  return jsonString;
 }

 @SuppressWarnings({ "rawtypes", "unchecked" })
 public String getSuccessJsonString(Double msg){
  String jsonString = "";
  LinkedHashMap list = new LinkedHashMap();
  list.put("response_status","ok");

  list.put("result", msg);
  jsonString = JSONValue.toJSONString(list);
  return jsonString;
 }
}
