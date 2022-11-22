package co.edu.utp.isc.agencia.service.impl;


import com.plan.turismo.entity.Usuario;
import com.plan.turismo.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepo.findByUsername(username);
        if(usuario == null){
            throw  new UsernameNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }
}
