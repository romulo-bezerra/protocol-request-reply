package br.edu.ifpb.serversocket.core;

import br.edu.ifpb.serversocket.abstraction.ServerService;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPServer implements ServerService {

    byte[] receiveData = new byte[1024];
    byte[] sendData = new byte[1024];
    int porta = 9876;
    int numConn = 1;

    public DatagramSocket serverSocket;
    DatagramPacket receivePacket;

    public UDPServer() throws SocketException, IOException {
        serverSocket = new DatagramSocket(porta);
        receivePacket = new DatagramPacket(receiveData, receiveData.length);
    }

    @Override
    public byte[] getRequest() throws IOException {
        System.out.println("Esperando por datagrama UDP na porta " + porta);
        serverSocket.receive(receivePacket);
        System.out.print("Datagrama UDP [" + numConn + "] recebido...");

        return receivePacket.getData();
    }

    @Override
    public void sendReply(byte[] reply, InetAddress clientHost, int clientPort) throws IOException {
        InetAddress IPAddress = receivePacket.getAddress();

        int port = receivePacket.getPort();

        sendData = reply;

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

        System.out.print("Enviando " + new String(reply, StandardCharsets.UTF_8) + "...");

        serverSocket.send(sendPacket);
        System.out.println("OK\n");

    }

}
