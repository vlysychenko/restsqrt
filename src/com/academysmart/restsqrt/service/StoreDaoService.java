package com.academysmart.restsqrt.service;

import com.academysmart.restsqrt.dao.SqrtDao;

public class StoreDaoService implements StoreService {

	SqrtDao dao = SqrtDao.INSTANCE;
	
	@Override
	public void storeResult(double number, double result) {
		dao.add(number, result);
	}

}
