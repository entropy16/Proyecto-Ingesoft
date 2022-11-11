package co.edu.utp.isc.agencia.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PAQUETES")
public class PaqueteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPaquete;
    private String ciudadIntermedia;
    private String ciudadFinal;
}
