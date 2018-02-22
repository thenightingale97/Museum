package com.museum.controller;



import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Controller {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
	
	public static void main(String[] args) {
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
}
