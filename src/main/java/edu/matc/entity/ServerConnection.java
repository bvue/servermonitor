package edu.matc.entity;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.*;

/**
 * Created by bvue0 on 10/21/2016.
 */
public class ServerConnection {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void runServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(444);
            Socket socket = serverSocket.accept();
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String message = bufferedReader.readLine();
            logger.info(message);

            if (message != null) {
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                printStream.println("Message received on server!");
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception{
        ServerConnection sc = new ServerConnection();
        sc.runServer();
    }

}
