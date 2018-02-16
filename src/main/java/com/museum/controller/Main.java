package com.museum.controller;


import com.museum.dao.GuideDao;
import com.museum.dao.impl.GuideDaoImpl;
import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;

public class Main {
	public static void main(String[] args) {
		GuideDao guideDao = new GuideDaoImpl();
		Guide guide = new Guide();
		
		guide.setFirstName("Yaroslav");
		guide.setPhoneNumber("3213123");
		guide.setPosition(GuidePosition.MIDDLE);
		
		guideDao.addGuide(guide);
	}
}
