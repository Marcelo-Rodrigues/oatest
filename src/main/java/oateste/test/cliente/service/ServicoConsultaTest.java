package oateste.test.cliente.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import oateste.cliente.service.ServicoConsulta;

@RunWith(MockitoJUnitRunner.class)
public class ServicoConsultaTest {

	@Test
	public void deveExecutar() {
		Client client = mock(Client.class);
		WebResource webResource = mock(WebResource.class);
	    //WebResource.Builder builder = mock( WebResource.Builder.class );		

	    ClientResponse clientResponse = mock( ClientResponse.class );
	    //when( builder.get( ClientResponse.class ) ).thenReturn( clientResponse );
	    when( clientResponse.getEntity( String.class ) ).thenReturn( "true" );
	    //when( webResource.accept( anyString() ) ).thenReturn( builder );
	    when( client.resource( anyString() ) ).thenReturn( webResource );
	    when( webResource.path(anyString())).thenReturn(webResource);
	    when( webResource.queryParam(anyString(),anyString())).thenReturn(webResource);
	 
		ServicoConsulta servico = new ServicoConsulta(client);
		
		servico.Consultar("s");
		//verify(clientResponse).(anyString())).thenCallRealMethod();
	}
}
