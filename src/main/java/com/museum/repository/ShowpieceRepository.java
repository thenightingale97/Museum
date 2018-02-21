package com.museum.repository;

import com.museum.entity.Showpiece;

import java.util.List;


public interface ShowpieceRepository extends Repository<Showpiece, Integer> {
    
    List<Showpiece> getByAuthor(int authorId);
}
