package com.Greentech.CQRS.query.service;

import com.Greentech.CQRS.domain.ZonegéographiqueQuery;


import java.util.Date;
import java.util.List;


public interface IZonegéographiqueQueryService {
    ZonegéographiqueQuery findById(long Id);

    List<ZonegéographiqueQuery> getZonegéographiques();
    ZonegéographiqueQuery findByGroupe(String s);

}
