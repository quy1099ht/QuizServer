/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.mycompany.arena100.ChatServerThread;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.net.ServerSocket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;
 

/**
 *
 * @author ACER
 */
 public class ServerThread extends Thread {
    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private PrintWriter output;
    
    public ServerThread(Socket socket,ArrayList<ServerThread> threads){
        this.socket = socket;
        this.threadList = threads;
    }
    @Override
    public void run()
    {
        
        try{
            //Reading input from Clients
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(),true);
            String outString = "";
            outString = input.readLine();
            
            printToAllClients("" + outString);
            while(true)
            {
                outString = input.readLine();
                printToAllClients("" + outString);
            }
            
        }catch(Exception e)
        {
            System.out.println("Error: "+ e.getStackTrace());
        }
    }
    private void printToAllClients(String outString)
    {
        for(ServerThread st : threadList)
        {
            if(st.socket.getInetAddress().equals(socket.getInetAddress()))
            {
                st.output.println(outString);
            }
            
        }
    }
    
}