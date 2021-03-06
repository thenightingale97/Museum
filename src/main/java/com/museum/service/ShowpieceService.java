package com.museum.service;

import com.museum.entity.*;
import com.museum.model.filter.ShowpieceFilter;
import com.museum.model.request.ShowpieceRequest;

import java.util.List;
import java.util.Map;

public interface ShowpieceService extends Service<Showpiece, Integer> {

    List<Showpiece> findAllByHall(Hall hall);

    List<Showpiece> findAllByAuthor(Author author);

    List<Showpiece> findAllByGuardian(Guardian guardian);

    Map<ShowpieceTechnique, Long> getStatisticByTechnique();

    Map<ShowpieceMaterial, Long> getStatisticByMaterial();

    List<Showpiece> findAllByRandom(int count);

    void update(ShowpieceRequest showpiece);

    List<Showpiece> findAllByFilter(ShowpieceFilter showpieceFilter);
}
