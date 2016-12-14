package edu.matc.entity;

import com.jcraft.jsch.*;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import edu.matc.util.*;



/**
 * This class executes the shell script on a remote server
*
* @author Bao Vue
*
*/

public class ServerConnection {

    private String username;
    private String password;
    private int port;
    private int exitStatus;
    JSch jsch;
    Session session;
    private Channel channelExec;
    private InputStream in;
    private BufferedReader reader;
    List<String> result = new ArrayList<String>();
    private final Logger logger = Logger.getLogger(this.getClass());



    public List run(String command, String ipAddress) {

        loadProperties();

        try {
            createJschObjectAndLogIn(ipAddress);
            createExecutionChannelandGetTaskList(command);
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
            logger.error("Error while getting specific service: " + e);
        }
        logger.info(result);
        return result;
    }



    public void loadProperties() {

        Properties properties = Utilities.loadProperties("serverConnection.properties");

        username = properties.getProperty("username");
        password = properties.getProperty("password");
        port = Integer.parseInt(properties.getProperty("port"));

    }



    /**
     * Create a new Jsch object
     * Open a new session, with your username, host and port
     * Set the password and call connect.
     * session.connect() opens a new connection to remote SSH server.
     * Once the connection is established, you can initiate a new channel.
     * this channel is needed to connect to remotely execution program
     */
    public void createJschObjectAndLogIn(String ip) throws JSchException {

        logger.info("Username: " + username);
        logger.info("Password: " + password);
        logger.info("Host (aka IP): " + ip);
        logger.info("Port Number: " + port);

        jsch = new JSch();

        session = jsch.getSession(username, ip, port);
        session.setConfig("StrictHostKeyChecking", "no");
        session.setPassword(password);
        //this is where the connection to the remote server happens
        session.connect();
        logger.info("Connection established.");

    }


    /**
     * Create the execution channel over the session
     *
     * @param newCommand
     * @throws JSchException
     */
    public void createExecutionChannelandGetTaskList(String newCommand) throws JSchException {

        //create the excution channel over the session
        channelExec = session.openChannel("exec");

        ((ChannelExec) channelExec).setCommand(newCommand);
        channelExec.setInputStream(null);
        ((ChannelExec) channelExec).setErrStream(System.err);
    }



    /**
     * Gets an InputStream for this channel.
     * All data arriving in as messages from the remote side can be read from this stream.
     * Execute the command
     *
     * @throws IOException
     * @throws JSchException
     */
    public void getInputStreamAndExecuteCommand() throws IOException, JSchException {
        //this is the stream with data from remote server
        in = channelExec.getInputStream();

        //Execute the command
        channelExec.connect();
    }


    /**
     * Read the output from the input stream we set above
     * Read each line from the buffered reader and add it to result list
     *
     * @throws IOException
     */
    public void getReaderAndReadCommandValue() throws IOException {
        // Read the output from the input stream we set above
        reader = new BufferedReader(new InputStreamReader(in));
        String line = "";

        //Read each line from the buffered reader and add it to result list
        while ((line = reader.readLine()) != null) {
            result.add(line);
        }
    }


    /**
     * Retrieve the exit status of the remote command corresponding to this channel
     * Safely disconnect channel and disconnect session. If not done then it may cause resource leak
     */
    public void getExitStatusAndDisconnectSession() {
        //retrieve the exit status of the remote command corresponding to this channel
        exitStatus = channelExec.getExitStatus();

        //Safely disconnect channel and disconnect session. If not done then it may cause resource leak
        channelExec.disconnect();
        session.disconnect();
    }

}
