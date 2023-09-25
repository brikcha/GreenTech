package com.Greentech.CQRS.command.service;

import com.Greentech.CQRS.domain.ZonegéoraphiqueCommand;
import java.util.List;

public interface IZonegéographiqueCommandService {
    int createZonegéographique(ZonegéoraphiqueCommand zonegéoraphiqueCommand);
    int updateZonegéographique(ZonegéoraphiqueCommand zonegéoraphiqueCommand);
    void deleteZonegéographique(Long id );
    List<ZonegéoraphiqueCommand> getAll();
}
