package com.museum.repository;

import com.museum.entity.Showpiece;
import com.museum.entity.ShowpieceMaterial;
import com.museum.entity.ShowpieceTechnique;

import java.util.List;
import java.util.Map;

public interface ShowpieceRepository extends Repository<Showpiece, Integer> {
    
    List<Showpiece> findAllByHall(int hallId);
    
    List<Showpiece> findAllByAuthor(int authorId);
    
    List<Showpiece> findAllByGuardian(int guardianId);
    
    List<Showpiece> findAllByIds(List<Integer> showpieceIds);
    
    Map<ShowpieceTechnique, Long> getStatisticByTechnique();
    
    Map<ShowpieceMaterial, Long> getStatisticByMaterial();
}
