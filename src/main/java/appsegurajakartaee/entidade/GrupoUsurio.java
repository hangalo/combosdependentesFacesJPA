
package appsegurajakartaee.entidade;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;


@Entity
@Table(name = "usuario_grupo")
public class GrupoUsurio {
    @EmbeddedId
    GrupoUsuarioKey grupoUsuarioKey;
    
    @ManyToOne
    @MapsId("idGrupo")
    @JoinColumn( name = "id_grupo")
    Grupo grupo;
    
    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    Usuario usuario;

    public GrupoUsurio() {
    }

    public GrupoUsuarioKey getGrupoUsuarioKey() {
        return grupoUsuarioKey;
    }

    public void setGrupoUsuarioKey(GrupoUsuarioKey grupoUsuarioKey) {
        this.grupoUsuarioKey = grupoUsuarioKey;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
