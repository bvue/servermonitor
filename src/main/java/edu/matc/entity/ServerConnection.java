package edu.matc.entity;

import com.jcraft.jsch.*;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by bvue0 on 10/21/2016.
 */
public class ServerConnection {

    private final Logger logger = Logger.getLogger(this.getClass());

    public void getRemoteServerConnection() {


        String USERNAME = "root"; // username for remote host
        String PASSWORD = "Appleton920"; // password of the remote host
        String host = "67.205.162.127"; // remote host address
        int port = 22;

        /**
         * This method will execute the script file on the server.
         * This takes file name to be executed as an argument
         * The result will be returned in the form of the list
         */

        List<String> result = new ArrayList<String>();
        String command = "ps ux";

        try {

            /**
             * Create a new Jsch object
             * This object will execute shell commands or scripts on server
             */
            JSch jsch = new JSch();

         /*
         * Open a new session, with your username, host and port
         * Set the password and call connect.
         * session.connect() opens a new connection to remote SSH server.
         * Once the connection is established, you can initiate a new channel.
         * this channel is needed to connect to remotely execution program
         */
            Session session = jsch.getSession(USERNAME, host, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(PASSWORD);
            session.connect();
            //logger.info("Connection established.");

            //create the excution channel over the session
            Channel channelExec = session.openChannel("exec");

            ((ChannelExec) channelExec).setCommand(command);
            channelExec.setInputStream(null);
            ((ChannelExec) channelExec).setErrStream(System.err);

            // Gets an InputStream for this channel. All data arriving in as messages from the remote side can be read from this stream.
            InputStream in = channelExec.getInputStream();

            // Set the command that you want to execute
            // In our case its the remote shell script
            //channelExec.setCommand("ps ux");

            // Execute the command
            channelExec.connect();

            // Read the output from the input stream we set above
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = "";

            //Read each line from the buffered reader and add it to result list
            // You can also simple print the result here
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }

            //retrieve the exit status of the remote command corresponding to this channel
            int exitStatus = channelExec.getExitStatus();

            //Safely disconnect channel and disconnect session. If not done then it may cause resource leak
            channelExec.disconnect();
            session.disconnect();

            if (exitStatus < 0) {
                System.out.println("Done, but exit status not set!");
            } else if (exitStatus > 0) {
                System.out.println("Done, but with error!");
            } else {
                System.out.println("Done!");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        System.out.println(result);
    }


        /** to read a file

         public void connectToRemoteServer() {
         String user = "root";
         String password = "Appleton920";
         String host = "67.205.162.127";
         int port=22;

         String remoteFile="/test.txt";

         try {
         JSch jsch = new JSch();
         Session session = jsch.getSession(user, host, port);
         session.setPassword(password);
         session.setConfig("StrictHostKeyChecking", "no");
         logger.info("Establishing Connection...");
         session.connect();
         logger.info("Connection established.");
         logger.info("Crating SFTP Channel.");
         ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
         sftpChannel.connect();
         logger.info("SFTP Channel created.");


         InputStream out= null;
         out= sftpChannel.get(remoteFile);
         BufferedReader br = new BufferedReader(new InputStreamReader(out));
         String line;
         while ((line = br.readLine()) != null)
         logger.info(line);
         br.close();
         }
         catch(Exception e){
         System.err.print(e);
         }
         }
         */


}
