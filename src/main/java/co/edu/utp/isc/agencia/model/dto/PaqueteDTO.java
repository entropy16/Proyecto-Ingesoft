package co.edu.utp.isc.agencia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaqueteDTO {

    private Long idPaquete;
    private String ciudadIntermedia;
    private String ciudadFinal;
}
