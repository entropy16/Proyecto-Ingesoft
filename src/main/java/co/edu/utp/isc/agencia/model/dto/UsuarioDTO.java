package co.edu.utp.isc.agencia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long cedulaUsuario;
    private String nombre;
    private String telefono;
    private Integer deuda = 0;
    private String correo;
    private Integer viajesConfirmados;
}
