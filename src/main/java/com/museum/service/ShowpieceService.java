package com.museum.service;

import com.museum.entity.Showpiece;
import com.museum.entity.ShowpieceMaterial;
import com.museum.entity.ShowpieceTechnique;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ShowpieceService extends Service<Showpiece, Integer> {
    
    List<Showpiece> findByHall(int hallId);
    
    List<Showpiece> findByAuthor(int authorId);
    
    List<Showpiece> findByGuardian(int guardianId);
    
    Map<ShowpieceTechnique, Long> getStatisticByTechnique();
    
    Map<ShowpieceMaterial, Long> getStatisticByMaterial();

    Showpiece getRandomShowpiece();
}
