package oatest.secure;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
	final Authorization auth;
	
	public AuthenticationFilter() {
		auth = new Authorization(new AuthorizationService());
	}
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		// Get the HTTP Authorization header from the request
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		// Check if the HTTP Authorization header is present and formatted
		// correctly
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new NotAuthorizedException("O token de autorização deve ser fornecido");
		}

		// Extract the token from the HTTP Authorization header
		String token = authorizationHeader.substring("Bearer".length()).trim();

		UsuarioAutenticado usuario = validateToken(token);

		if (usuario == null) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}

		if(!auth.authorizeUser(usuario.funcional, requestContext.getUriInfo().getPath())) {
			requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
		}
		
		System.out.println(requestContext.getUriInfo().getPath());
		
		SecurityContext secContext = new SecurityContextOauth(requestContext.getSecurityContext(), usuario);

		requestContext.setSecurityContext(secContext);

	}

	private UsuarioAutenticado validateToken(String token) {
		if (token.equals("abc"))
			return new UsuarioAutenticado("Marcelo", "ABC");
		else if (token.equals("a"))
			return new UsuarioAutenticado("Usuario2", "A");
		else if (token.equals("ab"))
			return new UsuarioAutenticado("Usuario3", "AB");
		else
			return null;
	}
}
