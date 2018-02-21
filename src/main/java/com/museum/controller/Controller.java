package com.museum.controller;


import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.museum.entity.Author;
import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;
import com.museum.service.AuthorService;
import com.museum.service.GuideService;
import com.museum.service.impl.AuthorServiceImpl;
import com.museum.service.impl.GuideServiceImpl;



public class Controller {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
	
	public static void main(String[] args) {
	    AuthorService authorService = new AuthorServiceImpl();
	    Author author = authorService.find(5);
                System.out.println(author.getFirstName() + " " + author.getLastName() + " " + author.getId());
            }
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
}
