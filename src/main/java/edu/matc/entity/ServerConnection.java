package edu.matc.entity;

import com.jcraft.jsch.*;
import com.mysql.fabric.Server;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Created by bvue0 on 10/21/2016.
 */
public class ServerConnection {

    private List<String> result = new ArrayList<String>();
    private final Logger logger = Logger.getLogger(this.getClass());
    private Properties properties;
    //static Logger logger = Logger.getLogger(ServerConnection.class.getName());

    //get properties info
    public void loadProperties(String propertiesFilePath)  {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException ioException) {
            ioException.printStackTrace();
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }

    //public void getRemoteServerConnection() {
    //public static void main(String[] args) {


        public List getTaskList() {

            loadProperties("serverConnection.properties");

            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String host = properties.getProperty("host");
            int port = Integer.parseInt(properties.getProperty("port"));


            /**
             * This method will execute the script file on the server.
             * This takes file name to be executed as an argument
             * The result will be returned in the form of the list
             */

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
                Session session = jsch.getSession(username, host, port);
                session.setConfig("StrictHostKeyChecking", "no");
                session.setPassword(password);
                session.connect();
                logger.info("Connection established.");

                //create the excution channel over the session
                Channel channelExec = session.openChannel("exec");

                ((ChannelExec) channelExec).setCommand(command);
                channelExec.setInputStream(null);
                ((ChannelExec) channelExec).setErrStream(System.err);

                // Gets an InputStream for this channel. All data arriving in as messages from the remote side can be read from this stream.
                InputStream in = channelExec.getInputStream();

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
                    logger.info("Done, but exit status not set!");
                } else if (exitStatus > 0) {
                    logger.info("Done, but with error!");
                } else {
                    logger.info("Done!");
                }
            } catch (Exception e) {
                logger.error("Error: " + e);
            }

            //map this to the controller class and display on JSP page
            for (String runningTasks : result) {
                logger.info(runningTasks);
                //MapController mapResultsToJsp = new MapController();
                //mapResultsToJsp.getRunningTasks(runningTasks);
            }

            return result;

    }






}
