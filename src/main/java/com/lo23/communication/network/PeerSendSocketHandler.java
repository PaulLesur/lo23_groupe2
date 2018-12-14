package com.lo23.communication.network;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.Serializable;

import com.lo23.communication.Messages.Message;
// Peer To Send Handler Socket

public class PeerSendSocketHandler extends Thread implements Serializable {
    Socket sendThreadSocket;

    public PeerSendSocketHandler(Socket sendThreadSocket) {

        this.sendThreadSocket = sendThreadSocket;
    }

    @SuppressWarnings("unused")
    public void run() {
        try {

            ObjectInputStream objIS = new ObjectInputStream(sendThreadSocket.getInputStream());

            Object msg = objIS.readObject();

            Message msgCast = (Message) msg;

            System.out.println("treatment of the message : " + msgCast.toString());

            this.sendThreadSocket.close();

            msgCast.treatment(); // treatment of the data sent

            System.out.println("end of the treatment");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
