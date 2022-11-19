package co.edu.utp.isc.agencia.service.impl;

import co.edu.utp.isc.agencia.exceptions.YaExistePaqueteException;
import co.edu.utp.isc.agencia.model.dto.AdminDTO;
import co.edu.utp.isc.agencia.model.dto.PaqueteDTO;
import co.edu.utp.isc.agencia.model.dto.ServicioDTO;
import co.edu.utp.isc.agencia.model.entities.AdminEntity;
import co.edu.utp.isc.agencia.model.entities.PaqueteEntity;
import co.edu.utp.isc.agencia.model.repository.AdminRepository;
import co.edu.utp.isc.agencia.model.repository.PaqueteRepository;
import co.edu.utp.isc.agencia.model.repository.ServicioRepository;
import co.edu.utp.isc.agencia.service.AdminService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    @Autowired
    public AdminRepository adminRepository;

    @Autowired
    public ServicioRepository servicioRepository;

    @Autowired
    public PaqueteRepository paqueteRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public PaqueteDTO crearPaquete(PaqueteDTO paqueteDTO) throws YaExistePaqueteException{

        Optional<PaqueteEntity> paqueteRecuperado = paqueteRepository.findByCiudadIntermediaAndCiudadFinal(paqueteDTO.getCiudadIntermedia(),
                paqueteDTO.getCiudadFinal());

        if(!paqueteRecuperado.isEmpty()){
            throw new YaExistePaqueteException("Ya existe un paquete registrado con esas ciudades");
        } else {
            PaqueteEntity paqueteEntity = modelMapper.map(paqueteDTO, PaqueteEntity.class);

            return modelMapper.map(this.paqueteRepository.save(paqueteEntity), PaqueteDTO.class);
        }
    }

    @Override
    public boolean borrarPaquete(PaqueteDTO paqueteDTO){

        Optional<PaqueteEntity> recuperado = paqueteRepository.findById(paqueteDTO.getIdPaquete());

        if(recuperado.isPresent()){
            paqueteRepository.delete(recuperado.get());
            return true;
        }
        return false;
    }

    @Override
    public List<ServicioDTO> consultarServicios() {

        return servicioRepository.findAll().stream()
                .map(servicioEntity -> modelMapper.map(servicioEntity,ServicioDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public boolean ingresar(AdminDTO adminDTO){

        AdminEntity recuperado = adminRepository
                .findByUsuarioAndContraseña(adminDTO.getUsuario(),adminDTO.getContraseña());
        return recuperado != null;
    }
}
