package br.edu.ifpb.clientsocket.core;

import br.edu.ifpb.clientsocket.abstraction.ClientService;
import br.edu.ifpb.clientsocket.service.ClientServiceImpl;
import br.edu.ifpb.clientsocket.util.RemoteRef;

import java.io.IOException;

public class UDPClient {

	final ClientService clientService;
	final String SERVER_ADDRESS = "localhost";
	final int PORT_NUMBER = 9876;
	final int OPERATION_ID = 1;
	final RemoteRef remoteRef;

	public UDPClient(ClientServiceImpl clientService) {
		this.clientService = clientService;
		this.remoteRef = new RemoteRef(SERVER_ADDRESS, PORT_NUMBER);
	}

	public byte[] sendMessage(String message) throws IOException {
		return clientService.doOperation(remoteRef, OPERATION_ID, message.getBytes());
	}

}
