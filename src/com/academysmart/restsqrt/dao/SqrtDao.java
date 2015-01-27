package com.academysmart.restsqrt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.academysmart.restsqrt.model.Sqrt;
import com.academysmart.restsqrt.service.EMFService;

public enum SqrtDao {
	INSTANCE;

	@SuppressWarnings("unchecked")
	public List<Sqrt> listResults() {
		EntityManager em = EMFService.get().createEntityManager();
		// read the existing entries
		Query q = em.createQuery("select m from Sqrt m");
		List<Sqrt> results = q.getResultList();
		return results;
	}

	public void add(double number, double result) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Sqrt sqrt = new Sqrt();
			sqrt.setNumber(number);
			sqrt.setResult(result);
			em.persist(sqrt);
			em.close();
		}
	}

	public void remove(long id) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Sqrt sqrt = em.find(Sqrt.class, id);
			em.remove(sqrt);
		} finally {
			em.close();
		}
	}
}