package edu.matc.entity;

import com.jcraft.jsch.*;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.matc.util.*;

import static edu.matc.util.Utilities.*;


/**
 * Created by bvue0 on 10/21/2016.
 */
public class ServerConnection {

    private String username;
    private String password;
    private String host;
    private int port;
    private int exitStatus;
    JSch jsch;
    Session session;
    private Channel channelExec;
    private InputStream in;
    private BufferedReader reader;
    List<String> result = new ArrayList<String>();
    private final Logger logger = Logger.getLogger(this.getClass());
    private Utilities utils = new Utilities();


    /**
     * This method will execute the command on the server.
     * The result will be returned in the form of the list
     */
    public List getTaskList() {

        /**
        username = "root";
        password = "java2016";
        host = "67.205.162.127";
        port = 22;
         */


        try {

            createJschObjectAndLogIn();
            createExecutionChannelandGetTaskList();
            getInputStreamAndExecuteCommand();
            getReaderAndReadCommandValue();
            getExitStatusAndDisconnectSession();

            if (exitStatus < 0) {
                logger.info("Done, but exit status not set!");
            } else if (exitStatus > 0) {
                logger.info("Done, but with error!");
            } else {
                logger.info("Done!");
            }

        } catch (Exception e) {
            logger.error("Error: " + e);
        }

        //mapResponseToControllerClass();

        return result;
    }


    public void loadProperties() {

        Properties properties = Utilities.loadProperties("serverConnection.properties");

        username = properties.getProperty("username");
        password = properties.getProperty("password");
        host = properties.getProperty("host");
        port = Integer.parseInt(properties.getProperty("port"));

        //logger.info("Username: " + username);
        //logger.info("Password: " + password);
        //logger.info("Host (aka IP): " + host);
        //logger.info("Port Number: " + port);

    }



    /**
     * Create a new Jsch object
     * This object will execute shell commands or scripts on server
     * Open a new session, with your username, host and port
     * Set the password and call connect.
     * session.connect() opens a new connection to remote SSH server.
     * Once the connection is established, you can initiate a new channel.
     * this channel is needed to connect to remotely execution program
     */
    public void createJschObjectAndLogIn() throws JSchException {

        logger.info("Username: " + username);
        logger.info("Host (aka IP): " + host);
        logger.info("Port Number: " + port);

        jsch = new JSch();

        session = jsch.getSession(username, host, port);
        session.setConfig("StrictHostKeyChecking", "no");
        session.setPassword(password);
        session.connect();
        logger.info("Connection established.");

    }


    public void createExecutionChannelandGetTaskList() throws JSchException {
        String command = "ps ux";

        //create the excution channel over the session
        channelExec = session.openChannel("exec");

        ((ChannelExec) channelExec).setCommand(command);
        channelExec.setInputStream(null);
        ((ChannelExec) channelExec).setErrStream(System.err);
    }

    // Gets an InputStream for this channel.
    // All data arriving in as messages from the remote side can be read from this stream.
    // Execute the command
    public void getInputStreamAndExecuteCommand() throws IOException, JSchException {
        in = channelExec.getInputStream();

        channelExec.connect();
    }


    public void getReaderAndReadCommandValue() throws IOException {
        // Read the output from the input stream we set above
        reader = new BufferedReader(new InputStreamReader(in));
        String line = "";

        //Read each line from the buffered reader and add it to result list
        while ((line = reader.readLine()) != null) {
            result.add(line);
        }
    }

    public void getExitStatusAndDisconnectSession() {
        //retrieve the exit status of the remote command corresponding to this channel
        exitStatus = channelExec.getExitStatus();

        //Safely disconnect channel and disconnect session. If not done then it may cause resource leak
        channelExec.disconnect();
        session.disconnect();
    }

    /**
    public void mapResponseToControllerClass() {
        //map this to the controller class and display on JSP page
        for (String runningTasks : result) {
            MapController mapResultsToJsp = new MapController();
            mapResultsToJsp.getRunningTasks(runningTasks);
        }
    }
     */
}
