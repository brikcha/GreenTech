package com.Greentech.CQRS.hundler;

import com.Greentech.CQRS.domain.ZonegéographiqueQuery;


public interface IZonegéographiqueQueryHandler {
    public  void createZonegéographique(ZonegéographiqueQuery zonegéographiqueQuery);
    public void updateZonegéographique(ZonegéographiqueQuery zonegéographiqueQuery);
    public  void deleteZonegéographique(ZonegéographiqueQuery tacheQueryDto);
}
