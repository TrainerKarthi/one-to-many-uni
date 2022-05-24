package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDeletePersonBank {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("karthik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person = entityManager.find(Person.class, 3);

		List<Bank> bank = person.getBanks();

		entityTransaction.begin();
		
		for (Bank bank2 : bank) {
			entityManager.remove(bank2);
		}
		entityManager.remove(person);
		entityTransaction.commit();

	}

}
