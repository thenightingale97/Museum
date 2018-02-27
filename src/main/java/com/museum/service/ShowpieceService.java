package com.museum.service;

import com.museum.entity.Showpiece;
import com.museum.entity.ShowpieceMaterial;
import com.museum.entity.ShowpieceTechnique;

import java.util.List;
import java.util.Map;

public interface ShowpieceService extends Service<Showpiece, Integer> {
    
    List<Showpiece> findAllByHall(int hallId);
    
    List<Showpiece> findAllByAuthor(int authorId);
    
    List<Showpiece> findAllByGuardian(int guardianId);
    
    Map<ShowpieceTechnique, Long> getStatisticByTechnique();
    
    Map<ShowpieceMaterial, Long> getStatisticByMaterial();
    
    List<Showpiece> findAllByRandom(int count);
}
