
package appsegurajakartaee.service;

import appsegurajakartaee.entidade.Usuario;
import appsegurajakartaee.repository.UsuarioRepository;
import guiacompleto.dto.UsuarioGrupoDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped

public class UsuarioService {

    @Inject
    UsuarioRepository repository;

    public List<UsuarioGrupoDTO> listaUsuariosGrupos() {
        return repository.listaUsuariosGrupos();
    }

    public List<Usuario> listaUsuarios() {
        return repository.listaUsuarios();
    }

    public UsuarioGrupoDTO getGrupo(String usuario) {
        return repository.buscaGrupo(usuario);
    }

    public Usuario criarUsuario(String usario, String password, String nomeUsario, String sobrenomeUsuario) {
        return repository.criarUsuario(usario, password, nomeUsario, sobrenomeUsuario);
    }

    public Usuario update(Usuario usuario) {
        return repository.actualizarUsuario(usuario);
    }

}
