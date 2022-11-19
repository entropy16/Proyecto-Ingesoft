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
    private List<String> excursiones;
    private List<String> hoteles;
    private List<String> vuelos;
    private List<String> buses;
}
