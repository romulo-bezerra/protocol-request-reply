package br.edu.ifpb.clientsocket.service;

import br.edu.ifpb.clientsocket.abstraction.ClientService;
import br.edu.ifpb.clientsocket.util.RemoteRef;

import java.io.IOException;
import java.net.*;

public class ClientServiceImpl implements ClientService {

    public DatagramSocket clientSocket;
    public DatagramPacket sendPacket;
    public DatagramPacket receivePacket;

    public ClientServiceImpl() throws SocketException {
        this.clientSocket = new DatagramSocket();
    }

    /**
     *
     * @param remoteRef objeto de referência remota contendo o endereço IP e porta da máquina de destino
     * @param operationId identificação da operação
     * @param arguments mensagem 'bytificada'
     * @return resposta do servidor
     * @throws IOException causada na falha do envio/recebimento de mensagem, ou na obtenção do endereço IP remoto da máquina de destino
     */
    @Override
    public byte[] doOperation(RemoteRef remoteRef, int operationId, byte[] arguments) throws IOException {

        InetAddress IPAddress = InetAddress.getByName(remoteRef.getRemoteIP());
        byte[] receiveData = new byte[1024];
        sendPacket = new DatagramPacket(arguments, arguments.length, IPAddress, remoteRef.port);

        System.out.println("Enviando pacote UDP para -> " + remoteRef.remoteIP + ":" + remoteRef.port);
        clientSocket.send(sendPacket);
        System.out.println("Pacote enviado.");
        receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        System.out.println("Pacote UDP recebido.");
        clientSocket.close();
        System.out.println("Socket cliente fechado!");

        return receivePacket.getData();
    }

}
