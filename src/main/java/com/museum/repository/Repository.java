package com.museum.repository;

public interface Repository {
	void begin();
	void commit();
	void close();
}
