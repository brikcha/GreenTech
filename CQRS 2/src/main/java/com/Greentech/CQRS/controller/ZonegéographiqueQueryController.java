package com.Greentech.CQRS.controller;

import com.Greentech.CQRS.domain.ZonegéographiqueQuery;
import com.Greentech.CQRS.query.service.IZonegéographiqueQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Slf4j
@RequestMapping("/zone-query")
@CrossOrigin("*")
public class ZonegéographiqueQueryController {
    @Autowired
    IZonegéographiqueQueryService zonegéographiqueQueryServiceImp;

    //api de récupération du zone par id
    @GetMapping("/zonebyid/{id}")
    public ZonegéographiqueQuery getZonegéographiqueById(@PathVariable  long id){

        return this.zonegéographiqueQueryServiceImp.findById(id);
    }

    //api de récupération de tous les zones
    @GetMapping("/all")
    public List<ZonegéographiqueQuery> getZonegéographiques(){

        return this.zonegéographiqueQueryServiceImp.getZonegéographiques();
    }



    //api de récupération du zone son groupe
    @GetMapping("/zonebyTitle/{title}")
    public ZonegéographiqueQuery getZonegéographiqueGroupe(@PathVariable String groupe){
        return this.zonegéographiqueQueryServiceImp.findByGroupe(groupe);
    }






}
