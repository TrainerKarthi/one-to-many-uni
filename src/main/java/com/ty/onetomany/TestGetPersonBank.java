package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetPersonBank {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("karthik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Person person = entityManager.find(Person.class, 2);
		if (person != null) {
			
			System.out.println(person.getAge());
			System.out.println(person.getName());
			System.out.println(person.getGender());

			List<Bank> banks = person.getBanks();
			for (Bank bank : banks) {
				System.out.println(bank.getName());
				System.out.println(bank.getBranch());
				System.out.println(bank.getIfsc());
			}

		} else {

			System.out.println("No person found");

		}

	}

}
