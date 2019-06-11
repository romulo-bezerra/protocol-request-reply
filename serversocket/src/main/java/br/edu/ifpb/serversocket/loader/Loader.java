package br.edu.ifpb.serversocket.loader;

import br.edu.ifpb.serversocket.core.UDPServer;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Loader {

    public static void main(String[] args) throws IOException {

        UDPServer udpServer = new UDPServer();

        while (true) {
            byte[] request = udpServer.getRequest();
            udpServer.sendReply(formmaterMessage(request).getBytes(), InetAddress.getLocalHost(), 9876);
        }
    }

    public static String formmaterMessage(byte[] reply) {
        return new String(reply, StandardCharsets.UTF_8).trim().toUpperCase();
    }

}
