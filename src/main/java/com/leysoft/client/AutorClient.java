package com.leysoft.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.leysoft.ws.autor.AddAutorRequest;
import com.leysoft.ws.autor.AddAutorResponse;
import com.leysoft.ws.autor.Autor;
import com.leysoft.ws.autor.DeleteAutorRequest;
import com.leysoft.ws.autor.DeleteAutorResponse;
import com.leysoft.ws.autor.GetAllAutorRequest;
import com.leysoft.ws.autor.GetAllAutorResponse;
import com.leysoft.ws.autor.GetAutorRequest;
import com.leysoft.ws.autor.GetAutorResponse;
import com.leysoft.ws.autor.UpdateAutorRequest;
import com.leysoft.ws.autor.UpdateAutorResponse;

public class AutorClient extends WebServiceGatewaySupport {
	
	public GetAllAutorResponse getAllAutor() {
		GetAllAutorRequest request = new GetAllAutorRequest();
		GetAllAutorResponse response = (GetAllAutorResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);
		return response;
	}
	
	public GetAutorResponse getAutor(int id) {
		GetAutorRequest request = new GetAutorRequest();
		request.setId(id);
		GetAutorResponse response = (GetAutorResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);
		return response;
	}
	
	public AddAutorResponse addAutor(String name) {
		AddAutorRequest request = new AddAutorRequest();
		request.setName(name);
		AddAutorResponse response = (AddAutorResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);
		return response;
	}
	
	public UpdateAutorResponse updateAutor(int id, Autor autor) {
		UpdateAutorRequest request = new UpdateAutorRequest();
		request.setId(id);
		request.setAutor(autor);
		UpdateAutorResponse response = (UpdateAutorResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);
		return response;
	}
	
	public DeleteAutorResponse deleteAutor(int id) {
		DeleteAutorRequest request = new DeleteAutorRequest();
		request.setId(id);
		DeleteAutorResponse response = (DeleteAutorResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);
		return response;
	}
}