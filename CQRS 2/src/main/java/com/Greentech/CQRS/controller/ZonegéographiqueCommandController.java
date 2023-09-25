package com.Greentech.CQRS.controller;

import com.Greentech.CQRS.command.service.IZonegéographiqueCommandService;
import com.Greentech.CQRS.domain.ZonegéoraphiqueCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/zone-command")
@CrossOrigin(origins = "*")
public class ZonegéographiqueCommandController {

    @Autowired
    IZonegéographiqueCommandService zonegéographiqueCommandServiceImp;

    // api de creation du zone
    @PostMapping("/create")
    public  ResponseEntity<?> createZonegéographique(@RequestBody ZonegéoraphiqueCommand t){
        //modifier la date de dérniere modification
        t.setCreationDate(new Date());
        if(this.zonegéographiqueCommandServiceImp.createZonegéographique(t)==1){
            return new ResponseEntity<>( HttpStatus.CREATED);
        };
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //api de récupération de tous les zones pour des fins de tests
    @GetMapping("all")
    public List<ZonegéoraphiqueCommand> getAll(){
        return this.zonegéographiqueCommandServiceImp.getAll();
    }

    //api de suppression du zone
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteZonegéographique( @PathVariable long id){

        try{
            this.zonegéographiqueCommandServiceImp.deleteZonegéographique(id);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.CONFLICT);

        }


    }

    //api de modification du zone
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ZonegéoraphiqueCommand t){
        //p.setLastModifiedDate(new Date());
        if(this.zonegéographiqueCommandServiceImp.updateZonegéographique(t)==1){
            return new ResponseEntity<>(HttpStatus.CREATED);
        };
        return  new ResponseEntity<>(HttpStatus.CONFLICT);

    }
}
