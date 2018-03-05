package com.segway.loomo.vlssample;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by limkh on 3/5/2018.
 */

public class UdpClient {
    private DatagramSocket clientSocket;
    private InetAddress serverAddress;
    private DatagramPacket sPacket; //packet to contain the payload
    private byte[] buf;


    private static final int SERVER_PORT_NUM = 1437;
    private static final int CLIENT_PORT_NUM = 1437;
    private static final String SERVER_HOST_NAME = "192.168.220.71";

    UdpClient(){

    }

    void init(){
        try {
            this.clientSocket = new DatagramSocket(CLIENT_PORT_NUM);
            this.serverAddress = InetAddress.getByName(SERVER_HOST_NAME);
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a string over the UDP clientSocket
     * @param payload
     */
    void send(String payload){
        this.buf = payload.getBytes();
        this.sPacket = new DatagramPacket(this.buf, this.buf.length, this.serverAddress, SERVER_PORT_NUM);
        try {
            clientSocket.send(sPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
