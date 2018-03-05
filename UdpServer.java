package com.certissecurity.udptest;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by limkh on 3/5/2018.
 */

public class UdpServer {
    private final String TAG = "UdpServer";
    private DatagramSocket serverSocket;
    DatagramPacket rPacket; //packet to receive the payload
    private byte[] buf = new byte[2000];

    private static final int SERVER_PORT_NUM = 1437;

    UdpServer(){

    }

    void init(){
        try {
            Log.i(TAG, "Initialise UDP Server");
            this.serverSocket = new DatagramSocket(SERVER_PORT_NUM);
            this.rPacket = new DatagramPacket(buf, buf.length);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE: Run this method in an infinite loop in a thread
     * @return message received from UDP serverSocket
     */
    String receive(){
        try {
            if(serverSocket != null){
                Log.i(TAG, "Waiting for rPacket");
            this.serverSocket.receive(rPacket); //blocking method i.e waits until rPacket is received before moving next line
                Log.i(TAG, "Received rPacket");
                return new String(rPacket.getData());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
