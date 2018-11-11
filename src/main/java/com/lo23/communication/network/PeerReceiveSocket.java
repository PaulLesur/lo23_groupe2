package com.lo23.comm.communication.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



// Peer to Receive 


public class PeerReceiveSocket {
	
	@SuppressWarnings({"unused"})
	public PeerReceiveSocket()
	{  
		Socket socket;
		String addrPeer = null;
		int peerServerPort = 0;
   
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // just for test Input for the client
  			
			System.out.println("Client parameters");
			
			System.out.println("addr of the peer as a server :");
			addrPeer = br.readLine(); // Sera r�cup�r� par des m�thodes. 
			
			System.out.println("port of the peer as a server :");
			peerServerPort = Integer.parseInt(br.readLine()); // Idem
  
			PeerSendSocket objSendSocket = new PeerSendSocket(peerServerPort, addrPeer);
			objSendSocket.start();
				
			// Connexion avec le client qui nous envoie les donn�es
			
			InfoPeer infoPeer = new InfoPeer();
			String addrReceive = infoPeer.addrPeer;
			int portPeer = infoPeer.portPeer;
			
			socket = new Socket(addrReceive, portPeer);
			
			System.out.println("Connection with the client succesful");
			
			ObjectInputStream objIS = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream objOS = new ObjectOutputStream(socket.getOutputStream()); 
  
			// Inclure m�thode pour r�cup�rer le/les fichiers sur le client qui doit envoyer les fichiers; 
					
			System.out.println("Waiting for Server");
			
			String clientAsServerAddr = "localhost";
			int clientAsServerPort = 100;
				
			// M�thodes pour r�cup�rer les fichiers sur le client o� on download le fichier
			clientAsServer(clientAsServerAddr, clientAsServerPort);  
		}
		catch(Exception e)
		{
			System.out.println("Error to connect peers");
		}
	}
	
	@SuppressWarnings({ "unused", "resource" })
	public static void clientAsServer(String clientAsServerAddr, int clientAsServerPort) throws ClassNotFoundException
	{   
		try {
				
				Socket clientAsServersocket = new Socket(clientAsServerAddr, clientAsServerPort);
				
				ObjectOutputStream clientObjectOS = new ObjectOutputStream(clientAsServersocket.getOutputStream());
				ObjectInputStream clientObjectIS = new ObjectInputStream(clientAsServersocket.getInputStream());
				
				// Methode pour confirmer la r�cup�ration du fichier sur le client
				
		} 
		catch (Exception e) {
		}
	}
}
