package com.academysmart.restsqrt.resource;

import java.util.Map;

import com.academysmart.restsqrt.factory.ResponseParseFactory;
import com.academysmart.restsqrt.service.SqrtService;
import com.academysmart.restsqrt.service.StoreDaoService;
import com.academysmart.restsqrt.service.StoreService;

public class SqrtResource extends BaseResource {

	protected SqrtService sqrtService = new SqrtService();
	protected StoreService storeResultService = new StoreDaoService();

	@Override
	public String processRequest(Map json, String method) {
		String response = "";
		double number =  Double.valueOf(json.get("number").toString());
		double result = sqrtService.getSqrt(number);
		response = new ResponseParseFactory().getSuccessJsonString(result);
		storeResultService.storeResult(number, result);
		return response;
	}
}
