package com.academysmart.restsqrt.service;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class StoreResultService implements StoreService{

	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public void storeResult(double number, double result){
		Entity resultEntity = new Entity("Sqrt");
		resultEntity.setProperty("number", number);
		resultEntity.setProperty("result", result);
		
		datastore.put(resultEntity);
	}
}
