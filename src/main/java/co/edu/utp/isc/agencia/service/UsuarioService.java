package co.edu.utp.isc.agencia.service;

import co.edu.utp.isc.agencia.model.dto.UsuarioDTO;
import co.edu.utp.isc.agencia.model.entities.UsuarioEntity;
import com.plan.turismo.entity.Usuario;
import com.plan.turismo.entity.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public UsuarioEntity guardarUsuario(UsuarioDTO usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
}
