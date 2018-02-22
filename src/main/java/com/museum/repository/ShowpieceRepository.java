package com.museum.repository;

import com.museum.entity.Showpiece;
import com.museum.entity.ShowpieceMaterial;
import com.museum.entity.ShowpieceTechnique;

import java.util.List;
import java.util.Map;

public interface ShowpieceRepository extends Repository<Showpiece, Integer> {
    
    List<Showpiece> getByHall(int hallId);
    
    List<Showpiece> getByAuthor(int authorId);

    List<Showpiece> getByGuardian(int guardianId);
    
    Map<ShowpieceTechnique, Long> getStatisticByTechnique();
    
    Map<ShowpieceMaterial, Long> getStatisticByMaterial();
}
