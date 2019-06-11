package br.edu.ifpb.clientsocket.loader;

import br.edu.ifpb.clientsocket.core.UDPClient;
import br.edu.ifpb.clientsocket.service.ClientServiceImpl;

import java.io.*;
import java.nio.charset.StandardCharsets;

class Loader {

    public static void main(String args[]) throws Exception {

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        UDPClient udpClient = new UDPClient(new ClientServiceImpl());

        System.out.print("Digite o texto a ser enviado ao servidor: ");
        String sentence = inFromUser.readLine();

        byte[] messageReceived = udpClient.sendMessage(sentence);
        String modifiedSentence = new String(messageReceived, StandardCharsets.UTF_8).trim();

        System.out.println("Texto recebido do servidor:" + modifiedSentence);
    }
}
