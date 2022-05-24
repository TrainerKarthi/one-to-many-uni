package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveUserAccountPage {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("karthik");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		UserAccount account = new UserAccount();
		account.setName("karthikkathi341");
		account.setEmail("karthikkathi341@gmail.com");
		account.setPassword("86869187");
		
		Page page1 = new Page();
		page1.setName("karthik");
		page1.setDescription("karthik is a good boy");
		page1.setTitle("Enjoyy");
		
		Page page2 = new Page();
		page2.setName("prasad");
		page2.setDescription("prasad is a worst fellow");
		page2.setTitle("RGV ramuism");
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page1);
		pages.add(page2);
		
		account.setPage(pages);
		entityTransaction.begin();
		entityManager.persist(account);
		entityManager.persist(page1);
		entityManager.persist(page2);
		entityTransaction.commit();
		
	}
	
}
