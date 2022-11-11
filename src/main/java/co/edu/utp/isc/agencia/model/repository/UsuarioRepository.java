package co.edu.utp.isc.agencia.model.repository;

import co.edu.utp.isc.agencia.model.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

    List<UsuarioEntity> findAll();
    List<UsuarioEntity> findByDeuda(Integer deuda);
    UsuarioEntity findByCedulaUsuario(Long cedulaUsuario);
    List<UsuarioEntity> findByViajesConfirmados(Integer viajesCOnfirmados);
}
