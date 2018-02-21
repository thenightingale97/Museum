package com.museum.repository;

import java.util.List;

import com.museum.entity.Showpiece;

public interface ShowpieceRepository extends Repository<Showpiece, Integer> {
    
    List<Showpiece> getByHall(int hallId);
    
    List<Showpiece> getByAuthor(int authorId);

    List<Showpiece> getByGuardian(int guardianId);
}
