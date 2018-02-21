package com.museum.service;

import java.util.List;

import com.museum.entity.Showpiece;

public interface ShowpieceService extends Service<Showpiece, Integer> {
    
    List<Showpiece> getByHall(int hallId);
    
    List<Showpiece> getByAuthor(int authorId);

    List<Showpiece> getByGuardian(int guardianId);
    
}
