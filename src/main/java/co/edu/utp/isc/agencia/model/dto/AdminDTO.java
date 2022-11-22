package co.edu.utp.isc.agencia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {

    private Long idAdmin;
    private String usuario;
    private String contraseña;
}
