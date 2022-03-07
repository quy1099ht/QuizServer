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

import java.util.Random;

/**
 *
 * @author ACER
 */
public class ServerThread extends Thread
{

    Socket socket;
    private ArrayList<ServerThread> threadList;
    private PrintWriter output;
    public ArrayList<QuesKind> qK;
    public int state = 1;
    public int i;
    public int preI;
    public int nextI;
    public String clientName;
    public ArrayList<Question> q;
    public int Point;

    public ServerThread(Socket socket, ArrayList<ServerThread> threads, ArrayList<QuesKind> ques)
    {
        this.socket = socket;
        this.threadList = threads;
        this.qK = ques;
        i = 0;
        preI = 1;
        nextI = 1;
        Point = 0;
    }

    @Override
    public void run()
    {
        Question ques = new Question();
        try
        {
            if (i < q.size())
            {
                ques = this.q.get(i);
            }
            else
            {
                ques = this.q.get(q.size() - 1);
            }
        } catch (Exception e)
        {
            System.out.println("Ok");
        }

        try
        {

            //Reading input from Clients
            System.out.println("IP : " + socket.getInetAddress());
            System.out.println("Index : " + i);
            System.out.println("Index 2 : " + (i - preI));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            while (true)
            {
                String outString = input.readLine();
                String[] info = outString.split("_");
                System.out.println("Recieved : " + outString);
                /* if(info.length > 2)
                {
                    output.println("Got u!");
                    System.out.println("Info");
                }*/
                if (outString.equals("exit"))
                {
                    break;
                }
                if (outString.equals("Question"))
                {
                    output.println("Here is your question!");
                    TimeUnit.SECONDS.sleep(1);
                }
                else if (info[0].equals("Name"))
                {
                    System.out.println("Info recieved!!");
                    clientName = info[1];
                    output.println("Nothing");
                    //AddData a = new AddData();
                    //a.AddPlayer(new Player(clientName,String.valueOf(socket.getInetAddress()),0,0));
                }
                else if (info[0].equals("Type"))
                {
                    for (QuesKind s : qK)
                    {
                        if (s.type.equals(info[1]))
                        {
                            q = s.getQ();
                            System.out.println("Type : " + s.type);
                            i = 0;
                            preI = 1;
                            nextI = 1;
                            break;
                        }
                    }
                    if (i < q.size())
                    {
                        ques = this.q.get(i);
                    }
                    else
                    {
                        ques = this.q.get(q.size() - 1);
                    }
                }
                else if (outString.equals("Update"))
                {
//                    UpdateData a = new UpdateData();
//                    a.Update(new Player(clientName,String.valueOf(socket.getInetAddress()),Point,0));
                }
                else if (outString.equals(ques.getAnwser()))
                {
                    output.println("Right");
                    Point++;
                    state = 1;
                    System.out.println("Message send back:" + ques.getAnwser() + ".");
                    i++;
                }
                else if (outString.equals("Hint"))
                {
                    output.println(Fifty(ques));
                    System.out.println("Hinted");
                }
                else if (outString.equals("Point"))
                {
                    output.println("Point " + Point);
                    System.out.println("He got the point!");
                }
                else if (outString.equals("1"))
                {
                    TimeUnit.SECONDS.sleep(1);
                    output.println("1");
                    System.out.println("Message received : " + 1);
                }
                else if (outString.equals("Info_pre"))
                {
                    Question e = this.q.get(i - preI);
                    String s = e.getQuestion() + "_" + e.getA() + "_" + e.getB() + "_" + e.getC() + "_" + e.getD();
                    output.println(s);
                    System.out.println("Index : " + i);
                    System.out.println("Message received : " + outString);
                    preI++;
                }
                else if (outString.equals("Info_next"))
                {
                    preI -= 1;
                    Question e = this.q.get(i - preI + 1);
                    String s = e.getQuestion() + "_" + e.getA() + "_" + e.getB() + "_" + e.getC() + "_" + e.getD();
                    output.println(s);
                    System.out.println("Index : " + i);
                    System.out.println("Message received : " + outString);
                }
                else if (outString.equals("Info"))
                {

                    String s = ques.getQuestion() + "_" + ques.getA() + "_" + ques.getB() + "_" + ques.getC() + "_" + ques.getD();
                    output.println(s);
                    System.out.println("Index : " + i);
                    System.out.println("Message received : " + outString);

                }
                else if (!outString.equals(ques.getAnwser()))
                {
                    System.out.println("Wrong answer");
                    output.println("Wrong");
                    System.out.println("Message send back:" + ques.getAnwser() + ".");
                    i++;
                }
                else
                {
                    //System.out.println("Server is waiting to accept user...");
                    output.println("Nothing");
                    System.out.println("Message received : " + outString);
                    System.out.println("Message send back: Nothing.");

                }

            }

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getStackTrace());
        }
    }

    private String Fifty(Question q)
    {
        Random ran = new Random();
        ArrayList<String> a = new ArrayList<>();
        a.add("A");
        a.add("B");
        a.add("C");
        a.add("D");
        String tmp = "";
        String tmp2 = "";
        int i = ran.nextInt(4);
        if (!a.get(i).equals(q.getAnwser()))
        {
            tmp += a.get(i);
        }
        else
        {
            try
            {
                tmp += a.get(i + 1);
            } catch (Exception e)
            {
                tmp += a.get(i - 1);
            }

        }
        i = ran.nextInt(4);
        if (!a.get(i).equals(q.getAnwser()))
        {
            tmp2 += a.get(i);
        }
        else
        {
            try
            {
                tmp += a.get(i + 1);
            } catch (Exception e)
            {
                tmp += a.get(i - 1);
            }
        }
        return tmp + "_" + tmp2;

    }

    private void printToAllClients(String outString)
    {
        for (ServerThread st : threadList)
        {
            if (st.socket.getInetAddress().equals(socket.getInetAddress()))
            {
                st.output.println(outString);
            }

        }
    }

    private int getNameIndex(String name)
    {
        for (int j = 0; j < threadList.size(); j++)
        {
            if (threadList.get(j).clientName.equals(name))
            {
                return j;
            }
        }
        return -1;
    }

    private void printToSomeOne(String name, String message)
    {
        for (ServerThread s : threadList)
        {
            if (s.clientName.equals(name))
            {
                s.output.println(message);
            }
        }
    }
}
