package br.edu.ifpb.serversocket.abstraction;

import java.io.IOException;
import java.net.InetAddress;

public interface ServerService {

    byte[] getRequest () throws IOException;
    void sendReply (byte[] reply, InetAddress clientHost, int clientPort) throws IOException;

}
