package com.algaworks.ecommerce.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class EntityManagerAbstract {
	
	private static EntityManagerFactory factory;
	
	protected EntityManager manager;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		factory = Persistence.createEntityManagerFactory("ecommerce-pu");
	}
	
	@Before
	public void setUp() {
		manager = factory.createEntityManager();
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		factory.close();
	}
	
}
