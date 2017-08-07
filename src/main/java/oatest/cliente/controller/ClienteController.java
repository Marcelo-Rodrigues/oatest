package oatest.cliente.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import oatest.cliente.model.*;
import oatest.secure.Secured;
import oatest.secure.SecurityContextOauth;
import oatest.secure.UsuarioAutenticado;

@Path("/")
public class ClienteController {

	@Path("cliente")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente[] getCliente() {
		final Cliente[] clientes = new Cliente[1];
		
		for(int i=0; i<clientes.length; i++) {
			clientes[i] = new Cliente();
			clientes[i].setNome("Cliente "+(i+1));
			clientes[i].setIdade(20+i);
			clientes[i].setFuncional("1111111" + i);
		}

		return clientes;
	}

	@Path("clientes")
    @Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente[] getClientes(@Context SecurityContext securityContext) {
		final Cliente[] clientes = new Cliente[10];
		
		UsuarioAutenticado usuario = ((UsuarioAutenticado)securityContext.getUserPrincipal());

		clientes[0] = new Cliente();
		clientes[0].setNome(usuario.getName());
		clientes[0].setFuncional(usuario.getFuncional());
		
		for(int i=1; i<clientes.length; i++) {
			clientes[i] = new Cliente();
			clientes[i].setNome("Cliente "+(i+1));
			clientes[i].setIdade(20+i);
			clientes[i].setFuncional("1111111" + i);
		}

		return clientes;
	}
}
