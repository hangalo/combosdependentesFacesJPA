

package appsegurajakartaee.configuracao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@DatabaseIdentityStoreDefinition(

dataSourceLookup = "jdbc/appsegura", 
        callerQuery = "SELECT senha FROM usuario u  WHERE u.usuario = ?",
        groupsQuery = "SELECT nome_grupo FROM usuario_grupo ug INNER JOIN grupo g ON ug.id_grupo = g.id_grupo INNER JOIN usuario u ON ug.id_usuario=u.id_usuario WHERE u.usuario = ?", 
        hashAlgorithmParameters = {
        "Pbkdf2PasswordHash.Iterations=3072",
        "Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA512",
        "Pbkdf2PasswordHash.SaltSizeBytes=64"
    }
)


@CustomFormAuthenticationMechanismDefinition(
loginToContinue = @LoginToContinue(
loginPage = "/login.xhtml",
        errorPage = "",
        useForwardToLogin = false
)

)
@FacesConfig
@ApplicationScoped
public class ConfiguraAplicacao {
    
}
