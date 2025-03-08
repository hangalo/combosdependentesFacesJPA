

package appsegurajakartaee.beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;



@Named(value = "logoutBean")
@RequestScoped
public class LogoutBean {

    @Inject
    FacesContext facesContext;
    @Inject
    private HttpServletRequest request;

    public String logout() throws ServletException {

        ExternalContext ec = facesContext.getExternalContext();
        ((HttpServletRequest) ec.getRequest()).logout();
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
       return "/login.xhtml?faces-redirect=true";
    }
    
    
    public void submit() throws ServletException {
        request.logout();
        request.getSession().invalidate();
    }

}
