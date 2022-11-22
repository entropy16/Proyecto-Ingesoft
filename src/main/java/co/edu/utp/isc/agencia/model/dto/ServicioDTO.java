package co.edu.utp.isc.agencia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDTO {

    private Long idServicio;
    private String ciudad;
    private List excursiones;
    private List hoteles;
    private List vuelos;
    private List buses;
}
