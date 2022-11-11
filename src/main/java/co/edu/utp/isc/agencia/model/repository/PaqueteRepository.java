package co.edu.utp.isc.agencia.model.repository;

import co.edu.utp.isc.agencia.model.entities.PaqueteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PaqueteRepository extends CrudRepository<PaqueteEntity, Long> {

    List<PaqueteEntity> findAll();
    Optional<PaqueteEntity> findByCiudadIntermediaAndCiudadFinal(String ciudadIntermedia, String ciudadFinal);
}
