package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

class WorkWithClient implements Runnable
{
    private final Socket clientAccepted;
    private final ObjectInputStream sois;
    private final ObjectOutputStream soos;

    public WorkWithClient(Socket clientAccepted, ObjectInputStream sois, ObjectOutputStream soos) {
        this.clientAccepted = clientAccepted;
        this.sois = sois;
        this.soos = soos;
    }

    public void run()
    {
/*        try {
            Conn.Conn();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        try {
            String clientMessageRecieved = (String) sois.readObject();
            while (!clientMessageRecieved.equals("0")){
                System.out.println("clients message: " + clientMessageRecieved);
                switch (clientMessageRecieved){
                    case "test1": {
                        System.out.println("NEW SERVER READY");
                    }
                }
                clientMessageRecieved = (String) sois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
