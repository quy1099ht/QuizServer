/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arena100;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class TicTacServer extends Thread {
    @Override
    public void run()
    {
        ArrayList<TicTacThread> threadList = new ArrayList<>();
        try(ServerSocket serverSocket = new ServerSocket(666)){
            while(true)
            {
                Socket socket = serverSocket.accept();
                TicTacThread servThread = new TicTacThread(socket,threadList);
                threadList.add(servThread); 
                servThread.start();
            }
        } catch (IOException ex) {
            //Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static int ExistIP(ArrayList<TicTacThread> threadList, TicTacThread servThread)
    {
        for(TicTacThread s : threadList)
        {
            if(s.socket.getInetAddress().equals(servThread.socket.getInetAddress()))
            {
                return 1;
            }
        }
        return -1;
    }
    private static int LocateIPIndex(ArrayList<TicTacThread> threadList, TicTacThread servThread)
    {
        for(int i = 0; i < threadList.size();i++)
        {
            if(threadList.get(i).socket.getInetAddress().equals(servThread.socket.getInetAddress()))
            {
                return i;
            }
        }
        return -1;
    }
    private static void ReplaceServer(ArrayList<TicTacThread> threadList, TicTacThread servThread, int index)
    {
        try{
            for(TicTacThread s : threadList)
            {
                if(s.socket.getInetAddress().equals(servThread.socket.getInetAddress()))
                {
                    servThread.clientName = s.clientName;
                    s.socket.close();
                }
            }
            threadList.set(index, servThread);
        }catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
        
    }    
}
