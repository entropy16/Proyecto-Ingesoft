package co.edu.utp.isc.agencia.model.repository;

import co.edu.utp.isc.agencia.model.entities.AdminEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<AdminEntity, Long> {

    AdminEntity findByUsuario(String usuario);

}
