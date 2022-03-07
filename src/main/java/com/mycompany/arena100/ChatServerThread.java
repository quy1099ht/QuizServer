/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arena100;

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
public class ChatServerThread extends Thread {
    Socket socket;
    ArrayList<ChatServerThread> threadList;
    private PrintWriter output;
    public String clientName ;
    public ChatServerThread(Socket socket, ArrayList<ChatServerThread> threadList)
    {
        this.socket = socket;
        this.threadList = threadList;
        this.clientName = "";
    }
    @Override
    public void run()
    {
        ChatBot chat = new ChatBot();
        try{
            //Reading input from Clients
            System.out.println("IP : " + socket.getInetAddress());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(),true);         
            while(true){
                String outString = input.readLine();
                String[] info = outString.split("_");
                System.out.println("Client's Name : " + clientName);
                System.out.println("Recieved : " + outString);
               /* if(info.length > 2)
                {
                    output.println("Got u!");
                    System.out.println("Info");
                }*/
                if(outString.equals("exit"))
                {
                    break;
                }
                else if(info[0].equals("Chat"))
                {
                    //Do something
                    if(info[1].equals("Bot"))
                    {
                       output.println("Anton >> "+chat.Bot(info[2]));
                       System.out.println("Anton >> Responsed");   
                    }
                    else if(info[1].equals("all"))
                    {
                        printToAllClients("From : " + clientName + " >> "+ info[2]);
                        System.out.println("Message sent");
                    }
                    else if(getNameIndex(info[1]) > -1)
                    {
                        printToSomeOne(info[1],"From : " + clientName + " >> " +info[2]);
                        System.out.println("Sent to " + info[1]);
                    }
                    
                }
                else if(info[0].equals("Name"))
                {
                    clientName = info[1];
                }
                else{
                    //System.out.println("Server is waiting to accept user...");
                    output.println("");
                    System.out.println("Message received : " + outString);
                    System.out.println("Message send back: Nothing.");
                    
                }
                
            }
            
        }catch(Exception e)
        {
            System.out.println("Error: "+ e.getStackTrace());
        }
    }
    private void printToAllClients(String outString)
    {
        for(ChatServerThread st : threadList)
        {
            if(!st.socket.getInetAddress().equals(socket.getInetAddress()))
            {
                st.output.println(outString);
            }
            
        }
    }   
    private int getNameIndex(String name)
    {
        for (int j = 0; j < threadList.size(); j++) {
            if(threadList.get(j).clientName.equals(name))
            {
                return j;
            }
        }
        return -1;
    }
    private void printToSomeOne(String name, String message)
    {
        for(ChatServerThread s : threadList)
        {
            if(s.clientName.equals(name))
            {
                s.output.println(message);
            }
        }
    }
}
