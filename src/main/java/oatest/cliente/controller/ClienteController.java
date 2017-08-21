package oatest.cliente.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.RequestBuilder;
import com.sun.jersey.api.client.WebResource;

import oatest.cliente.model.Cliente;
import oatest.cliente.model.Consumo;
import oatest.secure.Secured;
import oatest.secure.UsuarioAutenticado;

@Path("/")
public class ClienteController {

	@Path("consumo")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Consumo[] getConsumo(@QueryParam(value="id") int id) {
		final Consumo[] consumo = new Consumo[1];

		for (int i = 0; i < consumo.length; i++) {
			consumo[i] = new Consumo();
			consumo[i].setNome("Cliente " + (i + 1));
			consumo[i].setValor(id + i);
		}

		return consumo;
	}

	@Path("consumidor")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String Consumidor(@QueryParam(value="qt") String qt) {
return null;
	}

	@Path("cliente")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente[] getCliente() {
		final Cliente[] clientes = new Cliente[1];

		for (int i = 0; i < clientes.length; i++) {
			clientes[i] = new Cliente();
			clientes[i].setNome("Cliente " + (i + 1));
			clientes[i].setIdade(20 + i);
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

		UsuarioAutenticado usuario = ((UsuarioAutenticado) securityContext.getUserPrincipal());

		clientes[0] = new Cliente();
		clientes[0].setNome(usuario.getName());
		clientes[0].setFuncional(usuario.getFuncional());

		for (int i = 1; i < clientes.length; i++) {
			clientes[i] = new Cliente();
			clientes[i].setNome("Cliente " + (i + 1));
			clientes[i].setIdade(20 + i);
			clientes[i].setFuncional("1111111" + i);
		}

		return clientes;
	}

	@Path("urlRoleA")
	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Consumo[] urlRoleA(@QueryParam(value="id") int id) {
		final Consumo[] consumo = new Consumo[1];

		for (int i = 0; i < consumo.length; i++) {
			consumo[i] = new Consumo();
			consumo[i].setNome("Cliente " + (i + 1));
			consumo[i].setValor(id + i);
		}

		return consumo;
	}


	@Path("urlRoleA")
	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Consumo[] urlRoleA2(@QueryParam(value="id") int id) {
		final Consumo[] consumo = new Consumo[1];

		for (int i = 0; i < consumo.length; i++) {
			consumo[i] = new Consumo();
			consumo[i].setNome("Cliente " + (i + 1));
			consumo[i].setValor(id + i);
		}

		return consumo;
	}
	
	@Path("urlRoleB")
	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Consumo[] urlRoleB(@QueryParam(value="id") int id) {
		final Consumo[] consumo = new Consumo[1];

		for (int i = 0; i < consumo.length; i++) {
			consumo[i] = new Consumo();
			consumo[i].setNome("Cliente " + (i + 1));
			consumo[i].setValor(id + i);
		}

		return consumo;
	}
	
	@Path("urlRoleC")
	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Consumo[] urlRoleC(@QueryParam(value="id") int id) {
		final Consumo[] consumo = new Consumo[1];

		for (int i = 0; i < consumo.length; i++) {
			consumo[i] = new Consumo();
			consumo[i].setNome("Cliente " + (i + 1));
			consumo[i].setValor(id + i);
		}

		return consumo;
	}
	@Path("urlPublicRole")
	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Consumo[] urlPublicRole(@QueryParam(value="id") int id) {
		final Consumo[] consumo = new Consumo[1];

		for (int i = 0; i < consumo.length; i++) {
			consumo[i] = new Consumo();
			consumo[i].setNome("Cliente " + (i + 1));
			consumo[i].setValor(id + i);
		}

		return consumo;
	}
}
