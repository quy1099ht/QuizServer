/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arena100;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author ACER
 */
public class Sender {
    public static void main(String argv[]) throws Exception
    {
        String sentence_to_server;
        String sentence_from_server;

        //Tạo Inputstream(từ bàn phím)
        System.out.print("Input from client: ");
        BufferedReader inFromUser =  new BufferedReader(new InputStreamReader(System.in));
        //Lấy chuỗi ký tự nhập từ bàn phím
        sentence_to_server = inFromUser.readLine();    
        //Tạo socket cho client kết nối đến server qua ID address và port number
        Socket clientSocket = new Socket("192.168.1.9", 443);
        //Tạo OutputStream nối với Socket
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        //Tạo inputStream nối với Socket
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    //     
        //Gửi chuỗi ký tự tới Server thông qua outputStream đã nối với Socket (ở trên)
        System.out.println();

        ;int c= 0;
        while(c < 1){
            clientSocket = new Socket("192.168.1.9", 443);
        //Tạo OutputStream nối với Socket
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
        //Tạo inputStream nối với Socket
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    //   

            outToServer.writeBytes("Name_Quy" + "\n");
            System.out.println("Sent");
            sentence_from_server = inFromServer.readLine();
            System.out.println("Sent");
            //Đọc tin từ Server thông qua InputSteam đã nối với socket
            outToServer.writeBytes("Type_Animal" + '\n');

            //sentence_from_server = inFromServer.readLine();
            //print kết qua ra màn hình
            //System.out.println("Server is waiting to accept user...");
            //System.out.println("FROM SERVER: " + sentence_from_server);
            //Send Info

            c++;
        }
        c= 0;
        while(c < 10){
            clientSocket = new Socket("192.168.1.9", 443);
        //Tạo OutputStream nối với Socket
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
        //Tạo inputStream nối với Socket
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    //   


            //sentence_from_server = inFromServer.readLine();
            //print kết qua ra màn hình
            //System.out.println("Server is waiting to accept user...");
            //System.out.println("FROM SERVER: " + sentence_from_server);
            //Send Info
            

            

            outToServer.writeBytes("Info" + "\n");
            sentence_from_server = inFromServer.readLine();
            System.out.println("FROM SERVER: " + sentence_from_server + "\n");
            String[] question = sentence_from_server.split("_");
            for(String q : question){
                System.out.println(" "+ q +" ");
            }
            
            
            outToServer.writeBytes("A" + "\n");
            
            sentence_from_server = inFromServer.readLine();
            System.out.println("Got : " + sentence_from_server);
            c++;
        }
    }
}
