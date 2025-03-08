/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guiacompleto.dto;

import appsegurajakartaee.entidade.Grupo;



/**
 *
 * @author informatica
 */
public class UsuarioGrupoDTO {
    private String usuario;
    private String password;
    private String nomeUsuario;
    private String sobrenomeUsuario;
    private String nomeGrupo;
    private String descricaoGrupo;

    public UsuarioGrupoDTO(String usuario, String password, String nomeUsuario, String sobrenomeUsuario, String nomeGrupo, String descricaoGrupo) {
        this.usuario = usuario;
        this.password = password;
        this.nomeUsuario = nomeUsuario;
        this.sobrenomeUsuario = sobrenomeUsuario;
        this.nomeGrupo = nomeGrupo;
        this.descricaoGrupo = descricaoGrupo;
    }
    
  

  

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSobrenomeUsuario() {
        return sobrenomeUsuario;
    }

    public void setSobrenomeUsuario(String sobrenomeUsuario) {
        this.sobrenomeUsuario = sobrenomeUsuario;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getDescricaoGrupo() {
        return descricaoGrupo;
    }

    public void setDescricaoGrupo(String descricaoGrupo) {
        this.descricaoGrupo = descricaoGrupo;
    }

  
  
   

   
    
    
}
