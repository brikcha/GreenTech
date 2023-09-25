package com.Greentech.CQRS.query.repo;

import com.Greentech.CQRS.domain.ZonegéographiqueQuery;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

@Repository
public interface ZonegéographiqueQueryRepository extends MongoRepository<ZonegéographiqueQuery, Long>{
    ZonegéographiqueQuery findByGroupe(String s);

}
