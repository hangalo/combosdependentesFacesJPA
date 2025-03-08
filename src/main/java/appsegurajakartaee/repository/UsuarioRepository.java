package appsegurajakartaee.repository;

import appsegurajakartaee.entidade.Grupo;
import appsegurajakartaee.entidade.Usuario;
import guiacompleto.dto.UsuarioGrupoDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsuarioRepository {

    @PersistenceContext(unitName = "appseguraPU")
    private EntityManager em;

    @Inject
    Pbkdf2PasswordHash passwordHansher;

    public List<UsuarioGrupoDTO> listaUsuariosGrupos() {
        return em.createQuery("SELECT NEW guiacompleto.dto.UsuarioGrupoDTO(u.usario, u.password, u.nomeUsuario, u.sobrenomeUsuario, g.nomeGrupo, g.descricaoGrupo) FROM Usuario u JOIN FETCH u.grupos g ", UsuarioGrupoDTO.class).getResultList();
    }

    public List<Usuario> listaUsuarios() {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    public Optional<UsuarioGrupoDTO> getUsuario(String usuario) {
        return em.createQuery("SELECT NEW guiacompleto.dto.UsuarioGrupoDTO(u.usario, u.password, u.nomeUsuario, u.sobrenomeUsuario, g.nomeGrupo, g.descricaoGrupo) FROM Usuario u JOIN FETCH u.grupos g WHERE u.usuario = :usuario", UsuarioGrupoDTO.class)
                .setParameter("usuario", usuario)
                .getResultList()
                .stream()
                .findFirst();
    }

    /*  public UsuarioGrupoDTO buscaGrupo(String usuario){
    return em.createQuery("SELECT NEW guiacompleto.dto.UsuarioGrupoDTO(u.usario, u.password, u.nomeUsario, u.sobrenomeUsuario, g.nomeGrupo, g.descricaoGrupo) FROM Usuario u JOIN FETCH u.grupos g WHERE u.usario = :usuario", UsuarioGrupoDTO.class)
            .setParameter("usuario", usuario)
            .getSingleResult();
           
    }*/
    public UsuarioGrupoDTO buscaGrupo(String usuario) {
        return em.createQuery("SELECT NEW guiacompleto.dto.UsuarioGrupoDTO(u.usario, u.password, u.nomeUsuario, u.sobrenomeUsuario, g.nomeGrupo, g.descricaoGrupo)FROM Grupo g JOIN g.grupoUsurios gu JOIN gu.usuario u WHERE u.usario = :usuario", UsuarioGrupoDTO.class)
                .setParameter("usuario", usuario)
                .getSingleResult();

    }

    public List<UsuarioGrupoDTO> getGrupo(Usuario usuario) {
        return em.createQuery("SELECT NEW guiacompleto.dto.UsuarioGrupoDTO(u.usario, u.password, u.nomeUsuario, u.sobrenomeUsuario, g.nomeGrupo, g.descricaoGrupo  FROM Usuario u JOIN FETCH u.grupos g   JOIN FETCH g.grupoUsurios gus  WHERE gus.usuario.idUsuario  = :idUsuario", UsuarioGrupoDTO.class)
                .setParameter("idUsuario", usuario.getIdUsuario())
                .getResultList();
    }

    @Transactional
    public Usuario criarUsuario(String usario, String password, String nomeUsario, String sobrenomeUsuario) {
        Usuario novoUsuario = new Usuario(usario, passwordHansher.generate(password.toCharArray()), nomeUsario, sobrenomeUsuario);
        em.persist(novoUsuario);
        em.flush();
        return novoUsuario;

    }

    @Transactional
    public Usuario actualizarUsuario(Usuario usuario) {
        //  Usuario usuarioExistente = new Usuario(passwordHansher.generate(password.toCharArray()), nomeUsario, sobrenomeUsuario);
        String password = usuario.getPassword();
        System.out.println("Password Inserida >>>>>>>>>>>>>>>>>>>>>>"+password);
        usuario.setPassword(passwordHansher.generate(password.toCharArray()));

        em.merge(usuario);
        //em.flush();
        //    em.refresh(usuarioExistente);
        System.out.println(">>>>>>>>>>>>>>>>>Actualizar >>>>>>>>>>>>>>>>>>>>><Actualizar");
        return usuario;

    }

    /*
    String usuario, String password, String nomeUsuario, String sobrenomeUsuario, String nomeGrupo, String descricaoGrupo
    
    SELECT g FROM Grupo g WHERE g.usuario.idUsuario = :idUsuario"
    
     */
 /*
    SELECT usuario, senha,  nome_usuario, sobrenome_usuario, nome_grupo, descricao_grupo
FROM usuario u INNER JOIN usuario_grupo ug ON u.id_usuario =ug.id_usuario
INNER JOIN grupo g ON ug.id_grupo = g.id_grupo
    
     */
}
