package com.leysoft.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.leysoft.ws.autor.GetAllAutorRequest;
import com.leysoft.ws.autor.GetAllAutorResponse;
import com.leysoft.ws.autor.GetAutorRequest;
import com.leysoft.ws.autor.GetAutorResponse;

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
}