package appsegurajakartaee.beans;

import appsegurajakartaee.entidade.Usuario;
import appsegurajakartaee.service.UsuarioService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "usuarioGestaoBean")
@SessionScoped
public class UsuarioGestaoBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(UsuarioGestaoBean.class.getName());
    @Inject
    UsuarioService usuarioService;
    @Inject
    Usuario usuario;
    @Inject
    FacesContext facesContext;
    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {
        usuarios = usuarioService.listaUsuarios();

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String save() {
        LOGGER.log(Level.INFO, "Actualizar dados do usario @{0}", usuario);
     
        if (this.usuario.getIdUsuario() != null) {
            this.usuario = usuarioService.update(usuario);
            usuario = new Usuario();
            FacesMessage info = new FacesMessage("Dados do usuario actualizados  com sucesso!");
            facesContext.addMessage("msg", info);
            facesContext.getExternalContext().getFlash().setKeepMessages(true);
            return "/app/usuario_editar.xhtml?faces-redirect=true";
        } else {

            FacesMessage info = new FacesMessage("Erro ao actualizar!");
            facesContext.addMessage("msg", info);
            facesContext.getExternalContext().getFlash().setKeepMessages(true);
            return "/app/usuario_editar.xhtml?faces-redirect=true";

        }
        
      

    }

}
