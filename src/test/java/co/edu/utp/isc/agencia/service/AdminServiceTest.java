package co.edu.utp.isc.agencia.service;

import co.edu.utp.isc.agencia.exceptions.YaExistePaqueteException;
import co.edu.utp.isc.agencia.model.dto.AdminDTO;
import co.edu.utp.isc.agencia.model.dto.PaqueteDTO;
import co.edu.utp.isc.agencia.model.dto.ServicioDTO;
import co.edu.utp.isc.agencia.model.entities.AdminEntity;
import co.edu.utp.isc.agencia.model.entities.PaqueteEntity;
import co.edu.utp.isc.agencia.model.entities.ServicioEntity;
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
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

class AdminServiceTest {

    private PaqueteRepository paqueteRepository;
    private ServicioRepository servicioRepository;
    private AdminRepository adminRepository;
    private AdminService instance;
    private ModelMapper modelMapper = new ModelMapper();

    private List<PaqueteDTO> paquetesPrueba = new ArrayList<>();
    private List<ServicioEntity> serviciosPrueba = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        paqueteRepository = Mockito.mock(PaqueteRepository.class);
        servicioRepository = Mockito.mock(ServicioRepository.class);
        adminRepository = Mockito.mock(AdminRepository.class);
        instance = new AdminServiceImpl(adminRepository,servicioRepository,paqueteRepository,modelMapper);

        PaqueteDTO paquete = new PaqueteDTO(1L,"Medellin","Cartagena");
        PaqueteDTO paquete2 = new PaqueteDTO(2L,"Medellin","Buenaventura");

        paquetesPrueba.add(paquete);
        paquetesPrueba.add(paquete2);

        ServicioEntity servicio = new ServicioEntity(1L,"Medellin",List.of("Metro","Comuna13"),
                List.of("Micasa"), List.of("Avianca"),List.of("FlotaOccidental"));

        serviciosPrueba.add(servicio);
    }

    @Test
    @DisplayName("Crear paquete. ya existe paquete")
    void crearPaqueteTestExist(){

        when(paqueteRepository.findByCiudadIntermediaAndCiudadFinal("Medellin","Cartagena"))
                .thenReturn(Optional.of(new PaqueteEntity(3L, "Medellin", "Cartagena")));

        try {
            instance.crearPaquete(paquetesPrueba.get(0));
            fail("No saltó excepción esperada: YaExtistePaqueteException");
        } catch (YaExistePaqueteException e) {}
    }

    @Test
    @DisplayName("Crear paquete. No existe aún el paquete")
    void crearPaqueteTestNoExist(){

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

    @Test
    @DisplayName("Borrar Paquete. Existe el paquete")
    void borrarPaqueteTestExist() {

        when(paqueteRepository.findById(1L))
                .thenReturn(Optional.of(new PaqueteEntity(1L,"Medellin","Cartagena")));

        boolean result = instance.borrarPaquete(paquetesPrueba.get(0));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Borrar Paquete. No existe el paquete")
    void borrarPaqueteNoExist() {

        when(paqueteRepository.findById(1L))
                .thenReturn(Optional.empty());

        boolean result = instance.borrarPaquete(paquetesPrueba.get(0));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Consultar Servicios")
    void consultarServiciosTest() {

        when(servicioRepository.findAll())
                .thenReturn(serviciosPrueba);

        List<ServicioDTO> result = instance.consultarServicios();

        assertThat(result).hasSize(1)
                .usingRecursiveFieldByFieldElementComparator().isEqualTo(serviciosPrueba);
    }

    @Test
    @DisplayName("Ingresar. Admin no existe")
    void ingresarTestNoExist() {

        when(adminRepository.findByUsuarioAndContraseña("admin","contraseña"))
                .thenReturn(null);

        boolean result = instance.ingresar(new AdminDTO(1L,"admin","contraseña"));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Ingresar. Admin existe")
    void ingresarTestExist() {

        when(adminRepository.findByUsuarioAndContraseña("admin","contraseña"))
                .thenReturn(new AdminEntity(1L,"admin","contraseña"));

        boolean result = instance.ingresar(new AdminDTO(1L,"admin","contraseña"));

        assertThat(result).isTrue();
    }
}
