package co.edu.utp.isc.agencia.model.repository;

import co.edu.utp.isc.agencia.model.entities.ServicioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServicioRepository extends CrudRepository<ServicioEntity, Long> {

    List<ServicioEntity> findAll();
    List<ServicioEntity> findByCiudad(String ciudad);
}
