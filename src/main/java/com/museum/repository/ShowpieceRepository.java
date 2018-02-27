package com.museum.repository;

import com.museum.entity.*;

import java.util.List;
import java.util.Map;

public interface ShowpieceRepository extends Repository<Showpiece, Integer> {
    
    List<Showpiece> findAllByHall(Hall hall);
    
    List<Showpiece> findAllByAuthor(Author author);
    
    List<Showpiece> findAllByGuardian(Guardian guardian);
    
    List<Showpiece> findAllByIds(List<Integer> showpieceIds);
    
    Map<ShowpieceTechnique, Long> getStatisticByTechnique();
    
    Map<ShowpieceMaterial, Long> getStatisticByMaterial();
}
