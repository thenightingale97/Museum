package com.museum.repository.impl;


import java.util.List;

import javax.persistence.TypedQuery;

import com.museum.entity.Showpiece;
import com.museum.repository.AbstractRepository;
import com.museum.repository.ShowpieceRepository;

public class ShowpieceRepositoryImpl extends AbstractRepository<Showpiece, Integer> implements ShowpieceRepository {

    
    /**
     * Task 4.
     * SELECT showpiece.name, hall.name FROM showpiece JOIN hall ON 
     * showpiece.hall_id = hall.id WHERE hall.name = "hall1 .. ";
     */
    @Override
    public List<Showpiece> getByHall(int id) {
        String sql = "SELECT showpiece FROM Showpiece showpiece JOIN showpiece.hall WHERE hall = ?1";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        return query.getResultList();
    }

}
