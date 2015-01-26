package com.academysmart.restsqrt.resource;

import java.util.Map;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.academysmart.restsqrt.factory.ResponseParseFactory;

public abstract class BaseResource extends ServerResource{

	  protected ResponseParseFactory parseFactory = null;
	  String jsonString="";

	 @SuppressWarnings("rawtypes")
	 @Post("json")
	 public Representation doPost(Representation entity){
	  Map json = null;
	  jsonString = "";
	  parseFactory = new ResponseParseFactory();
	  try {
	   JsonRepresentation represent = new JsonRepresentation(entity);
	   JSONObject jsonobject = represent.getJsonObject();
	   JSONParser parser = new JSONParser();
	   String jsonText = jsonobject.toString();
	   json = (Map) parser.parse(jsonText);
	   jsonString = processRequest(json,"post");
	  } catch (Exception e) {
	   e.printStackTrace();
	   jsonString = parseFactory.getFailureJsonString(e.getMessage());
	  }
	  return new StringRepresentation(jsonString, MediaType.APPLICATION_JSON);
	 }

	 public abstract String processRequest(Map json,String method);

}
