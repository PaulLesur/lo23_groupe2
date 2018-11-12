package com.lo23.communication.APIs;

import com.lo23.common.filehandler.FileHandler;
import com.lo23.common.interfaces.comm.CommToDataServer;
import com.lo23.common.user.User;
import com.lo23.common.user.UserIdentity;
import com.lo23.communication.CommunicationManager.Server.CommunicationManagerServer;
import com.lo23.communication.Messages.Users_Server.removeDisconnectedUserMsg;

import java.util.List;

public class CommToDataServerAPI implements CommToDataServer {


    protected static CommunicationManagerServer commManagerServer ;

    /* Constructeur */
    private CommToDataServerAPI()
    {
        commManagerServer= CommunicationManagerServer.getInstance();
    }

    /* Initialisation du singleton*/
    private static CommToDataServerAPI Instance=new CommToDataServerAPI();

    /* Accesseurs */
    public static CommToDataServerAPI getInstance()
    {
        return Instance;
    }

    public static CommunicationManagerServer getCommunicationManager()
    {
        return commManagerServer;
    }


    public void setCommunicationManager(CommunicationManagerServer commManager)
    {
        this.commManagerServer=commManager;
    }


    /*========= Implémentation des méthodes ============= */

    @Override
    public void removeDisconnectedUser(User user, List<FileHandler> files){
        //récupérer l'IP (utile ??)
        //créer message de déconnexion (removeDisconnectedMessageUser)
        removeDisconnectedUserMsg message=new removeDisconnectedUserMsg(user);
        //commManagerServer.broadcast(message);

    }

    @Override
    public void sendConnectedUserToAll(UserIdentity user, List<FileHandler> files){
        //InetAddress ip=commManagerClient.getIP(); //TODO : à changer en string
        //connectedUserMsg message=new connectedUserMsg(user, files, ip);
        //commManagerServer.broadcast(message);

    }

    @Override
    public void sendFileLoc(List<UserIdentity> sourceUsers){

    }

    @Override
    public void sendUpdatedAccountToAll(UserIdentity user){

    }

    @Override
    public void sendNewFileSource(FileHandler file, UserIdentity user){

    }

}
