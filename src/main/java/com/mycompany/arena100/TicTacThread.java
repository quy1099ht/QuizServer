/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arena100;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class TicTacThread extends Thread {
    Socket socket;
    private ArrayList<TicTacThread> threadList;
    private PrintWriter output;
    public String clientName ;
    private ArrayList<Location> moveList = new ArrayList<>();
    public TicTacThread(Socket socket, ArrayList<TicTacThread> threadList)
    {
        this.socket = socket;
        this.threadList = threadList;
        this.clientName = "";
        CreateTable();
    }
    @Override
    public void run()
    {
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
                if(info[0].equals("Bot"))
                {
                    output.println("");
                }
                else{
                    //System.out.println("Server is waiting to accept user...");
                    printToAllClients(outString);
                    
                }
                
            }
            
        }catch(Exception e)
        {
            System.out.println("Error: "+ e.getStackTrace());
        }
    }
    private void printToAllClients(String outString)
    {
        for(TicTacThread st : threadList)
        {
            st.output.println(outString);
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
        for(TicTacThread s : threadList)
        {
            if(s.clientName.equals(name))
            {
                s.output.println(message);
            }
        }
    }
    private String Bot(Point p)
    {
        int min = 0;
        int max = 0;
        
        
        return "";
    }
    private boolean isMarked(Location l)
    {
        for(Location lc : moveList)
        {
            if(l.i == lc.i && l.j == lc.j)
            {
                if(lc.tictac.equals(""))
                {
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        return true;
    }
    boolean win = false;
    boolean checkH = false;
    boolean checkV = false;
    boolean checkD = false;
    private void CreateTable()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                moveList.add(new Location(i,j,""));
            }
        }
    }
    private void CheckHori()
    {
        if(win == false && checkH)
        {
            int j =0;
            while(j < 3)
            {
                ArrayList<Location> li = new ArrayList<>();
                for (int i = 0; i < 3; i++) 
                {
                    for (Location l : moveList) 
                    {
                        if (l.i == i && l.j == j) {
                            
                            break;
                        }
                    }
                }

                try{
                    WillWin(li);
                }catch(Exception e)
                {

                }
                j++;
            }
        }
    }
    private void WillWin(ArrayList<Location> li)
    {
        if(li.get(0).equals("X") || li.get(0).equals("O"))
        {
            if(li.get(0).equals(li.get(1)))
            {
                
                win = true;
            }
        }
        
    }
}
