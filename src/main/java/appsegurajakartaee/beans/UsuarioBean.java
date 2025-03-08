/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package appsegurajakartaee.beans;

import appsegurajakartaee.entidade.Usuario;
import appsegurajakartaee.service.UsuarioService;
import guiacompleto.dto.UsuarioGrupoDTO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informatica
 */
@Named(value = "usuarioBean")
//@RequestScoped
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(UsuarioBean.class.getName());
    @Inject
    UsuarioService usuarioService;
    @Inject
    Usuario usuario;
    
    @Inject
    FacesContext facesContext;

    private List<UsuarioGrupoDTO> usuariosGrupos;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
  

    

    @PostConstruct
    public void inicializa() {
        usuariosGrupos = usuarioService.listaUsuariosGrupos();
           
    }

    
    
    
    public List<UsuarioGrupoDTO> getUsuariosGrupos() {
        return usuariosGrupos;
    }

    public String save() {
        LOGGER.log(Level.INFO, "guardar dados do usario @{0}", usuario);
        if (this.usuario.getIdUsuario() == null) {
            this.usuario = usuarioService.criarUsuario(usuario.getUsario(), usuario.getPassword(), usuario.getNomeUsuario(), usuario.getSobrenomeUsuario());
            usuario = new Usuario();
            FacesMessage info = new FacesMessage("Dados do usuario guardados com sucesso!");
            facesContext.addMessage("msg", info);
            facesContext.getExternalContext().getFlash().setKeepMessages(true);
            return "/app/usuario_novo.xhtml?faces-redirect=true";
        } else {
            this.usuario = usuarioService.update(usuario);
            usuario = new Usuario();
            FacesMessage info = new FacesMessage("Dados do usuario actualizados com sucesso!");
            facesContext.addMessage("msg", info);
            facesContext.getExternalContext().getFlash().setKeepMessages(true);
            return "/app/usuario_novo.xhtml?faces-redirect=true";

        }

    }

}
