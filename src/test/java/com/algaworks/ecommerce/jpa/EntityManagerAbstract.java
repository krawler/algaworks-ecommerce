package com.algaworks.ecommerce.jpa;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerAbstract {
	
	private static EntityManagerFactory factory;
	
	protected EntityManager manager;
	
	@BeforeAll
	public static void setUpBeforeClass() {
		factory = Persistence.createEntityManagerFactory("ecommerce-pu");
	}
	
	@BeforeEach
	public void setUp() {
		manager = factory.createEntityManager();
	}
	
	@AfterAll
	public static void tearDownAfterClass() {
		factory.close();
	}
	
}
