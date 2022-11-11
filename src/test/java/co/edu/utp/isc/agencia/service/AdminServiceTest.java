package co.edu.utp.isc.agencia.service;

import co.edu.utp.isc.agencia.exceptions.YaExistePaqueteException;
import co.edu.utp.isc.agencia.model.dto.PaqueteDTO;
import co.edu.utp.isc.agencia.model.entities.PaqueteEntity;
import co.edu.utp.isc.agencia.model.repository.AdminRepository;
import co.edu.utp.isc.agencia.model.repository.PaqueteRepository;
import co.edu.utp.isc.agencia.model.repository.ServicioRepository;
import co.edu.utp.isc.agencia.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

public class AdminServiceTest {

    private PaqueteRepository paqueteRepository;
    private ServicioRepository servicioRepository;
    private AdminRepository adminRepository;
    private AdminService instance;
    private ModelMapper modelMapper = new ModelMapper();

    private List<PaqueteDTO> paquetesPrueba = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        paqueteRepository = Mockito.mock(PaqueteRepository.class);
        instance = new AdminServiceImpl(adminRepository,servicioRepository,paqueteRepository,modelMapper);

        PaqueteDTO paquete = new PaqueteDTO(1L,"Medellin","Cartagena");

        paquetesPrueba.add(paquete);
    }

    @Test
    @DisplayName("Crear paquete. ya existe paquete")
    public void crearPaqueteTest1(){

        when(paqueteRepository.findByCiudadIntermediaAndCiudadFinal("Medellin","Cartagena"))
                .thenReturn(Optional.of(new PaqueteEntity(3L, "Medellin", "Cartagena")));

        try {
            instance.crearPaquete(paquetesPrueba.get(0));
            fail("No saltó excepción esperada: YaExtistePaqueteException");
        } catch (YaExistePaqueteException e) {}
    }

    @Test
    @DisplayName("Crear paquete. No existe aún el paquete")
    public void crearPaqueteTest2(){

        when(paqueteRepository.findByCiudadIntermediaAndCiudadFinal("Medellin","Cartagena"))
                .thenReturn(Optional.empty());

        PaqueteEntity paqueteGuardar = modelMapper.map((paquetesPrueba.get(0)),PaqueteEntity.class);
        when(paqueteRepository.save(paqueteGuardar)).thenReturn(paqueteGuardar);

        try {
            PaqueteDTO result = instance.crearPaquete(paquetesPrueba.get(0));

            assertThat(result).usingRecursiveComparison().isEqualTo(paquetesPrueba.get(0));

        } catch (YaExistePaqueteException e) {
            fail("Saltó excepción inesperada: YaExtistePaqueteException");
        }

    }
}
