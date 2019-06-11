package br.edu.ifpb.clientsocket.abstraction;

import br.edu.ifpb.clientsocket.util.RemoteRef;

import java.io.IOException;
import java.net.UnknownHostException;

public interface ClientService {

    byte[] doOperation (RemoteRef remoteRef, int operationId, byte[] arguments) throws IOException;

}
