package com.museum.dao;

public interface Dao {
	void begin();
	void commit();
	void close();
}
