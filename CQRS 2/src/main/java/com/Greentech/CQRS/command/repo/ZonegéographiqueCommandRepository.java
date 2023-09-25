
package com.Greentech.CQRS.command.repo;

import com.Greentech.CQRS.domain.ZonegéoraphiqueCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;


@Repository
public interface ZonegéographiqueCommandRepository extends JpaRepository<ZonegéoraphiqueCommand, Long>{
    ZonegéoraphiqueCommand findByGroupe(String s);

}
