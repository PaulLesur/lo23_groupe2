package com.lo23.communication.Messages.Authentication_Client;

import com.lo23.common.exceptions.CommException;
import com.lo23.common.user.UserStats;
import com.lo23.communication.CommunicationManager.Server.ClientInfo;
import com.lo23.communication.Messages.Authentication;
import com.lo23.communication.CommunicationManager.Server.CommunicationManagerServer;
import com.lo23.common.interfaces.data.DataServerToComm;
import com.lo23.communication.Messages.Users_Server.removeDisconnectedUserMsg;

public class logoutMsg extends Authentication {
	private static final long serialVersionUID = 10002L;
	protected String UserIPAdress;
	private int UserPort;
	private CommunicationManagerServer commManager;

	public logoutMsg(UserStats us, String ipAdress, CommunicationManagerServer cms){
		this.userStats= us;
		this.UserIPAdress =ipAdress;
		this.commManager=cms;
	}
	/**
	 * Recupere le cms
	 * Recupere son objet dataServeur
	 * Utilise la methode removeDisconnectedUser pour transmettre la demande de deconnexion
	 * Supprime la paire IPUser - IPServer dans la table
	 * @param UserStats utilisateur statistiques
	 */
	public void treatment(){
		DataServerToComm dataInterface = this.commManager.getDataInterface();
		/** On récupère et stocke l'adresse IP du serveur
		 */
		String ServerIpAdress = cms.getIP();

		try {
			this.commManager.removeUserFromMap(this.UserIPAdress);
		}catch(CommException e){
			System.out.println("Message: \t");
			System.out.println(e.getMessage());
			System.out.println("\t printStackTrace: \t");
			e.printStackTrace();
		}

		dataInterface.removeDisconnectedUser(this.userStats);

		/**Faire le broadcast du message de connection vers tout les utilisateurs connectés**/
		removeDisconnectedUserMsg message = new removeDisconnectedUserMsg(this.userStats);
		message.setPort(this.getPort());
		this.commManager.broadcast(message);
	}

	public boolean isToServ(){return true;}
}
