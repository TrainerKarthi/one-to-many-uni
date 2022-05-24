package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonBank {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("karthik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person = new Person();
		person.setName("raja");
		person.setAge(25);
		person.setGender("male");

		List<Bank> banks = new ArrayList<Bank>();
		Bank bank1 = new Bank();
		bank1.setName("SBI");
		bank1.setBranch("Greamspet");
		bank1.setIfsc("SBI9007289");

		Bank bank2 = new Bank();
		bank2.setBranch("karnataka");
		bank2.setName("ICICI");
		bank2.setIfsc("ICICI287368");

		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(bank1);
		entityManager.persist(bank2);
		entityTransaction.commit();
		
	}

}
