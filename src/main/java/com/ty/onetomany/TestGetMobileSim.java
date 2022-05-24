package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetMobileSim {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("karthik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Mobile mobile = entityManager.find(Mobile.class,5);
		if (mobile != null) {
			System.out.println("======================s");
			System.out.println("Mobile name is "+mobile.getName());
			System.out.println("Mobile cost is "+mobile.getCost());
			System.out.println("=====================================");

			List<Sim> sims = mobile.getSims();
			for (Sim sim : sims) 
			{
				System.out.println("Sim id "+sim.getId());
				System.out.println("Sim provider"+sim.getProvider());
				System.out.println("Sim type");
				System.out.println("===================================");
			}
			
		} else {
			System.out.println("There is no mobile with the given id ");

		}
		
		
	}

}
