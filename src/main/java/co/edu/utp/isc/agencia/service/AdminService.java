package co.edu.utp.isc.agencia.service;

import co.edu.utp.isc.agencia.exceptions.YaExistePaqueteException;
import co.edu.utp.isc.agencia.model.dto.AdminDTO;
import co.edu.utp.isc.agencia.model.dto.PaqueteDTO;
import co.edu.utp.isc.agencia.model.dto.ServicioDTO;

import java.util.List;

public interface AdminService {

    PaqueteDTO crearPaquete(PaqueteDTO paqueteDTO) throws YaExistePaqueteException;
    PaqueteDTO borrarPaquete(PaqueteDTO paqueteDTO);
    List<ServicioDTO> consultarServicios();
    AdminDTO ingresar(AdminDTO adminDTO);
}
