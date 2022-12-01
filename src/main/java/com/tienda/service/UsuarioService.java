package com.tienda.service;

import com.tienda.dao.UsuarioDao;
import com.tienda.domain.Rol;
import com.tienda.domain.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Se busca el usuario en la t abla de usuario
        Usuario usuario = usuarioDao.findByUsername(username);
        if (usuario == null) {//usuarion no existe en BD
            throw new UsernameNotFoundException(username);
        }
        // Se cargan los roles del usuario en un arreglo especial de tipo GrantedAuthority
        var roles = new ArrayList<GrantedAuthority>();
        
        for (Rol rol:usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
            
        }
       return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
