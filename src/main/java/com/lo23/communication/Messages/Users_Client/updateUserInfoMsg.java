package com.lo23.communication.Messages.Users_Client;

import com.lo23.common.interfaces.data.DataServerToComm;
import com.lo23.common.user.UserIdentity;
import com.lo23.communication.CommunicationManager.Server.CommunicationManagerServer;
import com.lo23.communication.Messages.UserMessage;

public class updateUserInfoMsg extends UserMessage{
	
	public updateUserInfoMsg(UserIdentity ui)
    {
		this.user = ui;
	}
	public void treatment()
    {
        /**
         * Recupere le communication manager cote serveur
         * Recupere son interface de dataServer
         * Appel la methode updateUserChanges
         */
        CommunicationManagerServer cms = CommunicationManagerServer.getInstance();
        DataServerToComm dataInterface = cms.getDataInterface();
        dataInterface.updateUserChanges(user);
	}
}
