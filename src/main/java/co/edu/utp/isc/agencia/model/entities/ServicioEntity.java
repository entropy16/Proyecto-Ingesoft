package co.edu.utp.isc.agencia.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SERVICIOS")
public class ServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idServicio;
    private String ciudad;
    private List<String> excursiones;
    private List<String> hoteles;
    private List<String> vuelos;
    private List<String> buses;
}
