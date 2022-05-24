package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobileSim {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("karthik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setName("Sony");
		mobile.setCost(20000);
		
		Sim sim1 = new Sim();
		sim1.setProvider("VI");
		sim1.setType("4G");
		
		Sim sim2 = new Sim();
		sim2.setProvider("Bsnl");
		sim2.setType("5G");
		
		Sim sim3 = new Sim();
		sim3.setProvider("Idea");
		sim3.setType("3G");
		
		List<Sim> sims = new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);
		sims.add(sim3);
		
		mobile.setSims(sims);
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityManager.persist(sim3);
		entityTransaction.commit();
		
	}

}
