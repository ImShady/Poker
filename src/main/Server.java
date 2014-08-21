/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Shady, Sam
 **/
public class Server 
{
    ObjectOutputStream output;
    ObjectInputStream input;
    ServerSocket server;
    Socket connection;

    //set up and run server
    public void startRunning()
    {
        try 
        {
            server = new ServerSocket(4444, 6);

            while (true)
            {
                try 
                {
                    waitForConnection();
                    setupStreams();
                    /* Note to Sam: You may want to not setup the streams until you've verified that there's an open spot on the table.
                    Not sure yet, we'll figure it out soon*/
                    
                    //Sam's awesome algorithim to deal with client interactions is here.
                } 
                catch (EOFException e) 
                {
                    System.out.println("\n Server ended connection.");                    
                } 
                finally
                {
                    closeStreams();
                }
            }
        }
        catch (IOException e) 
        {
            System.out.println(e.getMessage());
        }
    }

    private void waitForConnection() throws IOException
    {
        System.out.println("Waiting for someone to connect...\n");
        connection = server.accept();
        System.out.println("Now connected to " + connection.getInetAddress().getHostAddress());
    }
    
    private void setupStreams() throws IOException
    {
        output = new ObjectOutputStream(connection.getOutputStream());
        input = new ObjectInputStream(connection.getInputStream());
        output.flush();
        System.out.println("Streams setup.");
    }
    
    private void closeStreams()
    {
        System.out.println("Closing streams...");
        try
        {
            output.close();
            input.close();
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println("Closing Streams failed: " + e.getMessage());
        }
    }
}
