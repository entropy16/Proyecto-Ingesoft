package co.edu.utp.isc.agencia.service;

import co.edu.utp.isc.agencia.model.dto.PaqueteDTO;
import co.edu.utp.isc.agencia.model.dto.ReservaDTO;
import co.edu.utp.isc.agencia.model.dto.ServicioDTO;
import co.edu.utp.isc.agencia.model.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    ReservaDTO crearReserva(ReservaDTO reservaDTO);
    boolean borrarReserva(ReservaDTO reservaDTO);
    List<PaqueteDTO> consultarPaquetes();
    List<ServicioDTO> consultarServicios();
    boolean ingresarUsuario(UsuarioDTO usuarioDTO);
    boolean pagarCuota(UsuarioDTO usuarioDTO);
}
