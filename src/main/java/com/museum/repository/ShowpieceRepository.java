package com.museum.repository;

import com.museum.entity.Showpiece;
import com.museum.entity.ShowpieceMaterial;
import com.museum.entity.ShowpieceTechnique;

import java.util.List;
import java.util.Map;

public interface ShowpieceRepository extends Repository<Showpiece, Integer> {
    
    List<Showpiece> findByHall(int hallId);
    
    List<Showpiece> findByAuthor(int authorId);
    
    List<Showpiece> findByGuardian(int guardianId);
    
    Map<ShowpieceTechnique, Long> getStatisticByTechnique();
    
    Map<ShowpieceMaterial, Long> getStatisticByMaterial();
}
