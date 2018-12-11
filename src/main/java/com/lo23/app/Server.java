package com.lo23.app;

import com.lo23.communication.CommunicationManager.Server.CommunicationManagerServer;
import com.lo23.communication.network.ServerClass;
import com.lo23.data.server.DataManagerServer;

import java.util.Scanner;

/**
 * Classe correspondant au lancement de l'application côté serveur.
 */
public class Server {
    public static void main (String[] args)
    {
        System.out.println("*** LO23 SWAG SERVER APPLICATION ***");

        // On instancie les Manager côté serveur
        DataManagerServer dataManagerServer = new DataManagerServer("LO23 Swag");
        CommunicationManagerServer commManager = new CommunicationManagerServer();

        // On partage les APIs entre les Manager
        dataManagerServer.setCommToDataServer(commManager.getCommInterface());
        commManager.setDataInterface(dataManagerServer.getDataServerToCommApi());

        ServerClass s = new ServerClass();

        System.out.println("Serveur lancé");

        Scanner consoleInput = new Scanner(System.in);
        boolean exitApp = false;
        String command;
        while (!exitApp)
        {
            switch (command = consoleInput.nextLine())
            {
                case "quit":
                {
                    System.out.println("*** FIN DE L'APPLICATION ***");
                    exitApp = true;
                    break;
                }
                default:
                {
                    System.out.println("La commande '" + command.trim() + "' est inconnue.");
                }
            }
        }
        System.exit(0);
    }
}
