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
    private List excursiones;
    private List hoteles;
    private List vuelos;
    private List buses;
}
