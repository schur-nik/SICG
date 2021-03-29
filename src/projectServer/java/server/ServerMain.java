package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args)  {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1006);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.println("server started....");

            Socket clientAccepted = null;
            ObjectInputStream isos = null;
            ObjectOutputStream osos = null;
            try {
                clientAccepted = serverSocket.accept();
                isos = new ObjectInputStream(clientAccepted.getInputStream());
                osos = new ObjectOutputStream(clientAccepted.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            WorkWithClient myWorkWithClient = new WorkWithClient(clientAccepted, isos, osos);
            Thread threadForWorkWithClient = new Thread(myWorkWithClient);
            threadForWorkWithClient.start();
        }
    }
}
