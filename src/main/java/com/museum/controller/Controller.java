package com.museum.controller;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.museum.entity.Author;
import com.museum.entity.Event;
import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;
import com.museum.entity.Showpiece;
import com.museum.repository.EventRepository;
import com.museum.repository.GuideRepository;
import com.museum.repository.ShowpieceRepository;
import com.museum.repository.impl.EventRepositoryImpl;
import com.museum.repository.impl.GuideRepositoryImpl;
import com.museum.repository.impl.ShowpieceRepositoryImpl;
import com.museum.service.AuthorService;
import com.museum.service.GuideService;
import com.museum.service.ShowpieceService;
import com.museum.service.impl.AuthorServiceImpl;
import com.museum.service.impl.GuideServiceImpl;
import com.museum.service.impl.ShowpieceServiceImpl;



public class Controller {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
	
	public static void main(String[] args) {
	    GuideService eventRepository = new GuideServiceImpl();
	    System.out.println(eventRepository.getWorkTime(4));
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
}
