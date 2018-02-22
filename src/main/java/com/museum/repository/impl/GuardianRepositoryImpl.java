package com.museum.repository.impl;

import com.museum.entity.Guardian;
import com.museum.repository.AbstractRepository;
import com.museum.repository.GuardianRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GuardianRepositoryImpl extends AbstractRepository<Guardian, Integer> implements GuardianRepository {

}
