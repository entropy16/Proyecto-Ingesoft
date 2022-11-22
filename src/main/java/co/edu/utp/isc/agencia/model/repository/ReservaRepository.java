package co.edu.utp.isc.agencia.model.repository;

import co.edu.utp.isc.agencia.model.entities.ReservaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservaRepository extends CrudRepository<ReservaEntity, Long> {

    List<ReservaEntity> findAll();
    List<ReservaEntity> findByCedulaUsuario(Long cedulaUsuario);
    List<ReservaEntity> findByIdPaquete(Long idPaquete);
    List<ReservaEntity> findByEstado(String estado);
}
