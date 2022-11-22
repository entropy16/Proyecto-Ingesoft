package co.edu.utp.isc.agencia.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIOS")
public class UsuarioEntity {

    @Id
    private Long cedulaUsuario;
    private String nombre;
    private String telefono;
    private Integer deuda = 0;
    private String correo;
    private Integer viajesConfirmados;
}
