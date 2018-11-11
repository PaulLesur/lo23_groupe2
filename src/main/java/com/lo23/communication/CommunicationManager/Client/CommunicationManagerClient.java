package com.lo23.communication.CommunicationManager.Client;


import com.lo23.common.interfaces.comm.CommToDataClient;
import com.lo23.common.interfaces.data.DataClientToComm;
import com.lo23.common.interfaces.data.DataServerToComm;
import com.lo23.communication.Messages.Message;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.lo23.communication.CommunicationManager.CommunicationManager;

public class CommunicationManagerClient extends CommunicationManager{

	protected DataClientToComm dataInterface;
	protected CommToDataClient commInterface;
	protected ArrayList<String> addressIpServer;
	
	/* Constructeur privé pour implémentation du singleton */
	private CommunicationManagerClient()
	{
		/** Initialisation des variables privees du CMC **/
		this.dataInterface = null;
		this.commInterface = null;
		/** Initialisation de la List
		 *
		 */
		this.addressIpServer = new ArrayList<String>();
		/** Bloc try pour recuperer l'adresse IP de la machine sur le reseau (fonction a tester) **/
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException ex)
		{
			System.out.print("Error in getting IP Adress");
		}
	}
	/** Implementation du singleton **/
	private static CommunicationManagerClient Instance = new CommunicationManagerClient();
	
	/** Point d'accès à l'instance unique **/
	public static CommunicationManagerClient getInstance()
	{
		return Instance;
	}
	/** Getteur et setteur d'interfaces **/
	public ArrayList<String> getAddressIpServer()
	{
		return addressIpServer;
	}
	public DataClientToComm getDataInterface()
	{
		return dataInterface;
	}
	public CommToDataClient getCommInterface()
	{
		return commInterface;
	}
	public void delAddressIpServer(String ipaddress)
	{
		if(this.addressIpServer.contains(ipaddress))
			this.addressIpServer.remove(ipaddress);
		else
			System.out.print("Suppression de l'adresse serveur impossible, elle n'est pas dans la table");
	}

	public void addAddressIpServer(String ipaddress)
	{
		if(!this.addressIpServer.contains(ipaddress))
			this.addressIpServer.add(ipaddress);
		else
			System.out.print("L'adresse du serveur existe deja");
	}
	public void setDataInterface(DataClientToComm di)
	{
		this.dataInterface = di;
	}
	public void setCommInterface (CommToDataClient ci)
	{
		this.commInterface = ci;
	}
}
