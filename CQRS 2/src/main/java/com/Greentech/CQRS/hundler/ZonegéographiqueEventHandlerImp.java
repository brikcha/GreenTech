package com.Greentech.CQRS.hundler;

import com.Greentech.CQRS.domain.ZonegéographiqueQuery;
import com.Greentech.CQRS.query.repo.ZonegéographiqueQueryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ZonegéographiqueEventHandlerImp implements IZonegéographiqueQueryHandler{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Autowired
    private ZonegéographiqueQueryRepository zonegéographiqueQueryRepository;


    public void createZonegéographique(ZonegéographiqueQuery zonegéographiqueQuery) {
        zonegéographiqueQueryRepository.save(zonegéographiqueQuery);
    }


    public void updateZonegéographique(ZonegéographiqueQuery zonegéographiqueQuery) {
        zonegéographiqueQueryRepository.save(zonegéographiqueQuery);
    }


    public void deleteZonegéographique(ZonegéographiqueQuery zonegéographiqueQuery) {
        zonegéographiqueQueryRepository.deleteById(zonegéographiqueQuery.getId());
    }

    //lister on the topic sended when creating one zone in mysql database to create in mongo database
    @KafkaListener(topics = "zone-event-create")
    public void consumeCreate(String userStr) {
        System.out.println("in");
        try {
            ZonegéographiqueQuery zonegéographiqueQuery = OBJECT_MAPPER.readValue(userStr,ZonegéographiqueQuery.class);
            log.info(userStr);
            this.createZonegéographique(zonegéographiqueQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //lister on the topic sended when updating one zone in mysql database to update in mongo database
    @KafkaListener(topics = "zone-event-update")
    public void consumeUpdate(String userStr) {
        try {
            ZonegéographiqueQuery zonegéographiqueQuery = OBJECT_MAPPER.readValue(userStr, ZonegéographiqueQuery.class);
            this.updateZonegéographique(zonegéographiqueQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //lister on the topic sended when deleting one zone in mysql database to delete in mongo database
    @KafkaListener(topics = "zone-event-delete")
    public void consumeDelete(String userStr) {
        try {
            //System.out.println(purchaseOrderStr);
                ZonegéographiqueQuery zonegéographiqueQuery = OBJECT_MAPPER.readValue(userStr, ZonegéographiqueQuery.class);
            this.deleteZonegéographique(zonegéographiqueQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
