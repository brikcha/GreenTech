package com.Greentech.CQRS.query.service;

import com.Greentech.CQRS.domain.ZonegéographiqueQuery;
import com.Greentech.CQRS.query.repo.ZonegéographiqueQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ZonegéographiqueQueryServiceImp implements IZonegéographiqueQueryService {

    //injection des methode de ZonegéographiqueQueryRepository
    @Autowired
    private ZonegéographiqueQueryRepository zonegéographiqueQueryRepository;

    //service de récupération d'une zone  by id

    public ZonegéographiqueQuery findById(long id) {
        return zonegéographiqueQueryRepository.findById(id).orElse(null);
    }

    //service de récupération des zones

    public List<ZonegéographiqueQuery> getZonegéographiques() {
        return zonegéographiqueQueryRepository.findAll();
    }

    //service de récupération d'une zone  par groupe
    @Override
    public ZonegéographiqueQuery findByGroupe(String s) {
        return null;
    }


}


