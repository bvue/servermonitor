package edu.matc.entity;

import org.apache.log4j.Logger;
import org.hibernate.annotations.common.util.impl.Log;

import java.io.*;
import java.net.*;

/**
 * Created by bvue0 on 10/21/2016.
 */
public class ClientRequest {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void runClient() {

        try {
            //Socket socket = new Socket("67.205.162.127", 444);
            Socket socket = new Socket("localhost", 444);
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println("test message from the client");

            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String message = bufferedReader.readLine();
            logger.info(message);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }



    public static void main(String[] args) throws Exception{
        ClientRequest cr = new ClientRequest();
        cr.runClient();
    }

}
