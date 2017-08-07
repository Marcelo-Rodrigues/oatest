package oatest.secure;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

public class SecurityContextOauth implements SecurityContext {
	UsuarioAutenticado usuarioAutenticado;
	SecurityContext currentSecurityContext;
	
	public SecurityContextOauth(SecurityContext currentSecurityContext, UsuarioAutenticado usuarioAutenticado) {
		this.usuarioAutenticado = usuarioAutenticado;
		this.currentSecurityContext = currentSecurityContext;
	}

    @Override
    public Principal getUserPrincipal() {

        return usuarioAutenticado;
    }

    @Override
    public boolean isUserInRole(String role) {
        return true;
    }

    @Override
    public boolean isSecure() {
        return currentSecurityContext.isSecure();
    }

    @Override
    public String getAuthenticationScheme() {
        return "Bearer";
    }

}
