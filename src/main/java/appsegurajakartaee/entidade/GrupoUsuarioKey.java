/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appsegurajakartaee.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GrupoUsuarioKey implements Serializable{
    @Column(name = "id_grupo")
    Integer idGrupo;
    @Column(name = "id_usuario")
    Integer idUsuario;

    public GrupoUsuarioKey() {
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.idGrupo);
        hash = 29 * hash + Objects.hashCode(this.idUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GrupoUsuarioKey other = (GrupoUsuarioKey) obj;
        if (!Objects.equals(this.idGrupo, other.idGrupo)) {
            return false;
        }
        return Objects.equals(this.idUsuario, other.idUsuario);
    }
    
    
}
