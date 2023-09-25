package com.Greentech.CQRS.command.service;

import com.Greentech.CQRS.domain.ZonegéoraphiqueCommand;
import com.Greentech.CQRS.command.repo.ZonegéographiqueCommandRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ZonegéographiqueCommandServiceImp implements IZonegéographiqueCommandService{
    //injection des methode de ZonegéographiqueCommandRepository
    @Autowired
    ZonegéographiqueCommandRepository zonegéographiqueCommandRepository;


    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    private void raiseEventToQueryProject(ZonegéoraphiqueCommand t, String topic){
        try{
            String value = OBJECT_MAPPER.writeValueAsString(t);
            this.kafkaTemplate.send(topic,value);
            System.out.println("sended");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //service de creation du zone
    public int createZonegéographique(ZonegéoraphiqueCommand zonegéoraphiqueCommand) {
        log.info("ZonegéographiqueCommand"+zonegéoraphiqueCommand);
        //récupération du zone crée
        ZonegéoraphiqueCommand t= zonegéographiqueCommandRepository.save(zonegéoraphiqueCommand);
        //appel de la méthode qui va lever un evenment pour envoiyer un topic à kafka pour la creation du meme projet dans la base mongo
        this.raiseEventToQueryProject(t,"zone-event-create");
        return 1;
    }

    //service de modification du zone
    public int updateZonegéographique( ZonegéoraphiqueCommand zonegéoraphiqueCommand) {
        //verrification de la présence du zone à modifier, si il est présent on le modifie
        this.zonegéographiqueCommandRepository.findById(zonegéoraphiqueCommand.getId()).ifPresent(zonegéographiqueCommand1 -> {
            zonegéographiqueCommand1.setId(zonegéoraphiqueCommand.getId());
            zonegéographiqueCommand1.setGroupe(zonegéoraphiqueCommand.getGroupe());
            zonegéographiqueCommand1.setDetails(zonegéoraphiqueCommand.getDetails());
            zonegéographiqueCommand1.setSymbole(zonegéoraphiqueCommand.getSymbole());
            zonegéographiqueCommand1 .setCreationDate(zonegéoraphiqueCommand.getCreationDate());
            zonegéographiqueCommand1.setVisibilite(zonegéoraphiqueCommand.getVisibilite());
            zonegéographiqueCommandRepository.save( zonegéographiqueCommand1);
            //appel de la méthode qui va lever un evenment pour envoiyer un topic à kafka pour la modification du meme tache dans la base mongo
            this.raiseEventToQueryProject( zonegéographiqueCommand1,"zone-event-update");
        });
        return 1;
    }

    //service de suppression du zone
    public void deleteZonegéographique(Long id) {
        ZonegéoraphiqueCommand zonegéoraphiqueCommand= new ZonegéoraphiqueCommand();
        zonegéoraphiqueCommand.setId(id);
       zonegéographiqueCommandRepository.deleteById(id);
        //appel de la méthode qui va lever un evenment pour envoiyer un topic à kafka pour la suppression du meme zone dans la base mongo
        this.raiseEventToQueryProject(zonegéoraphiqueCommand,"zone-event-delete");
    }


    //service de récupération des tache juste pour des raisons de test
    public List<ZonegéoraphiqueCommand> getAll() {
        return this.zonegéographiqueCommandRepository.findAll();
    }
}
