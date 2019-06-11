package br.edu.ifpb.clientsocket.util;

public class RemoteRef {

    final public String remoteIP;
    final public int port;

    public RemoteRef(String remoteIP, int port) {
        this.remoteIP = remoteIP;
        this.port = port;
    }

    public String getRemoteIP() {
        return remoteIP;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "RemoteRef{" +
                "remoteIP='" + remoteIP + '\'' +
                ", port=" + port +
                '}';
    }
}
