package appsegurajakartaee.beans;

import appsegurajakartaee.service.UsuarioService;
import guiacompleto.dto.UsuarioGrupoDTO;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.security.enterprise.AuthenticationStatus;
import static jakarta.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import static jakarta.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import static jakarta.security.enterprise.AuthenticationStatus.SUCCESS;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.IOException;

@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    @NotEmpty
    @Size(min = 4, message = " O username deve ter 4 ou mais caracters")
    private String username;
    @NotEmpty
    @Size(min = 4, message = "A senha deve ter 4 ou mais caracters")
    private String password;

    @Inject
    FacesContext facesContext;

    @Inject
    SecurityContext securityContext;
    @Inject
    UsuarioService usuarioService;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void execute() throws IOException {
        switch (processAuthentication()) {
            case SEND_CONTINUE:
                facesContext.responseComplete();
                break;
            case SEND_FAILURE:
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciais inválidas", null));
                break;
            case SUCCESS:

                String usuario = securityContext.getCallerPrincipal().getName();

                UsuarioGrupoDTO usuarioGrupoDTO = usuarioService.getGrupo(usuario);

                String regra = usuarioGrupoDTO.getNomeGrupo();
                if (regra.equalsIgnoreCase("usuario")) {

                    getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/index_usuario.xhtml");
                    
                } else if (regra.equalsIgnoreCase("admin")) {

                    getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/index.xhtml");

                } else {
                    System.out.println("");
                }

                break;

        }
    }

    private AuthenticationStatus processAuthentication() {
        ExternalContext exContext = getExternalContext();

        return securityContext.authenticate((HttpServletRequest) exContext.getRequest(), (HttpServletResponse) exContext.getResponse(),
                AuthenticationParameters.withParams().credential(new UsernamePasswordCredential(username, password)));

    }

    private ExternalContext getExternalContext() {

        return facesContext.getExternalContext();
    }

}
