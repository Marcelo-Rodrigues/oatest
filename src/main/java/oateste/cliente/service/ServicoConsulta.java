package oateste.cliente.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.RequestBuilder;
import com.sun.jersey.api.client.WebResource;

public class ServicoConsulta implements IServicoConsulta {
	Client client;
	
	public ServicoConsulta(Client client) {
		this.client = client;
	}
	
	public String Consultar(String id) {

		RequestBuilder<WebResource.Builder> webResource = montarUrl(id);

		ClientResponse response = executarServico(webResource);

		return response.getEntity(String.class);
	}

	private ClientResponse executarServico(RequestBuilder<WebResource.Builder> webResource) {
		ClientResponse response = webResource
				.accept("application/json")				
				.get(ClientResponse.class);
		return response;
	}

	private RequestBuilder<WebResource.Builder> montarUrl(String id) {
		RequestBuilder<WebResource.Builder> webResource = client
				.resource("http://localhost:8080/")
				.path("oatest")
				.path("consumo")
				.queryParam("id", id);
		return webResource;
	}
}
