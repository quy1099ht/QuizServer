/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.arena100;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import ConnectToSQL.AddData;
import ConnectToSQL.Player;
import ConnectToSQL.Connect;
import ConnectToSQL.UpdateData;
import ConnectToSQL.ViewALLPlayer;
import ConnectToSQL.ViewOnePlayer;
/**
 *
 * @author ACER
 */
public class MainServer extends javax.swing.JFrame {

    /** Creates new form MainServer */
    public MainServer() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        showScores = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Show Client");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 824, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );

        jMenu2.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tools");

        jMenuItem2.setText("Get File");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        showScores.setText("Show Scores");
        showScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showScoresActionPerformed(evt);
            }
        });
        jMenu3.add(showScores);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 722, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jPanel1.removeAll();
        Point p = new Point();
        //x=789,y=6 Max vertical
        //x=0,y=207 Max horizontal       '
        int maxX = 789;
        int maxY = 207;
        p.x = 0;
        p.y = 0;
        int i = 0;
        for(ServerThread s : threadList)
        {
            if(Math.abs( p.x - maxX) <= 20 )
            {
                p.x = 0;
                p.y += 30;
            }
            else if(Math.abs( p.x - maxY) <= 20 )
            {
                JOptionPane.showMessageDialog(null,"No more space!!");
                return;
            }
            NewBt(jPanel1,p, s, i);
            p.x += 160;
            p.y += 0;
            i++;
        }
        Component[] comp = jPanel1.getComponents();
        for(int j = 0; j < comp.length; j++)
        {
            if(threadList.get(j).state == 0)
            {
                ((JButton)comp[j]).setEnabled(true);
                System.out.println(((JButton)comp[j]).getText());
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,    "You can choose 3 type of questions!");
        for (int i = 0; i < 3; i++) {
            JOptionPane.showMessageDialog(null,    "The " + i+1 + "'th Type of Questions.");
            final JFileChooser fileDialog = new JFileChooser();
            int returnVal = fileDialog.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                java.io.File file = fileDialog.getSelectedFile();
                QuesKind a = new QuesKind();
                a.setQ(AddQuestion(file.getPath()));
                String b = file.getName();
                b = b.replace(".txt", "");
                System.out.println(b);
                a.setType(b);
                ListQues.add(a);
            } else {

            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void showScoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showScoresActionPerformed
        // TODO add your handling code here:
        ListofScore = new ArrayList<>();
        for(ServerThread s : threadList)
        {
            Score e = new Score(s.clientName,s.Point);
            ListofScore.add(e);
        }
        Chart chart = new Chart(ListofScore);
        chart.setVisible(true);
    }//GEN-LAST:event_showScoresActionPerformed
    private static void MultipleClient()
    {
       
        for(Question q : ListQuestion)
        {
            System.out.println(q.getQuestion());
        }
        threadList = new ArrayList<>();
        JOptionPane.showMessageDialog(null,    "Server started!.");
        try(ServerSocket serverSocket = new ServerSocket(443)){
            while(true)
            {
                Socket socket = serverSocket.accept();
                ServerThread servThread = new ServerThread(socket,threadList, ListQues);
                System.out.println("\n 1 or -1 : " + ExistIP(threadList,servThread));
                System.out.println("Location : " + LocateIPIndex(threadList,servThread));
                System.out.println("IP : " + socket.getInetAddress());
                //Replace Server with same IP
                if(ExistIP(threadList,servThread) == 1)
                {
                    if(isBanned(servThread))
                    {
                        servThread.socket.close();
                    }else{
                        ReplaceServer(threadList,servThread,LocateIPIndex(threadList,servThread));
                        servThread.start();    
                    }
                    
                }
                else{
                   threadList.add(servThread); 
                   servThread.start();
                }
            }
        }catch(Exception e){
            System.out.println("Error!");
        }
    }
    private static void NewBt(JPanel jPanel, Point p, ServerThread socket, int i)
    {
        ServerThread a = socket;
        String f ="Client = "+ i +" "+ a.clientName;
        JButton b=new JButton(f);
        
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ClientInfo cliInfo = new ClientInfo(a.clientName,a.Point,a.state,a.socket);
                
                cliInfo.setVisible(true);
                cliInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JOptionPane.showMessageDialog(null,    "Client's Name = " + a.clientName + "\n"+"State = "+ a.state +"\nIP = "+ a.socket.getInetAddress());
            }   
        };
        b.addActionListener(actionListener);
        b.setBounds(p.x,p.y,150,30); 
        b.setVisible(true);
        jPanel.add(b);
        jPanel.setVisible(true);
        System.out.println("Yes");
    }
    private static int ExistIP(ArrayList<ServerThread> threadList, ServerThread servThread)
    {
        for(ServerThread s : threadList)
        {
            if(s.socket.getInetAddress().equals(servThread.socket.getInetAddress()))
            {
                return 1;
            }
        }
        return -1;
    }
    private static int LocateIPIndex(ArrayList<ServerThread> threadList, ServerThread servThread)
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
    private static void ReplaceServer(ArrayList<ServerThread> threadList, ServerThread servThread, int index)
    {
        try{
            for(ServerThread s : threadList)
            {
                if(s.socket.getInetAddress().equals(servThread.socket.getInetAddress()))
                {
                    servThread.i = s.i;
                    servThread.clientName = s.clientName;
                    servThread.preI = s.preI;
                    servThread.Point = s.Point;
                    servThread.nextI = s.nextI;
                    servThread.q = s.q;
                    
                    s.socket.close();
                }
            }
            threadList.set(index, servThread);
        }catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
        
    }
    private static boolean isBanned(ServerThread s)
    {
        for(ServerThread ss : threadList)
        {
            if(ss.socket.getInetAddress().equals(s.socket.getInetAddress()))
            {
                if(ss.state == 0)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static ArrayList<Question> AddQuestion(String url)
    {
        ArrayList<Question> arr = new ArrayList();       
        try {           
            BufferedReader reader = new BufferedReader(new FileReader(url));

            int j = 0;
            for (int i = 0; i < 10; i++) {
                Question a = new Question();
                String line = reader.readLine();
                a.setQuestion(line);
                line = reader.readLine();

                a.setA(line);
                line = reader.readLine();   

                a.setB(line);
                line = reader.readLine();

                a.setC(line);
                line = reader.readLine();

                a.setD(line);j++;
                line = reader.readLine();

                a.setAnwser(line);
                line = reader.readLine();


                arr.add(a);
            }
            System.out.print(j+"\n");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
    public static void ChatServer()
    {
        
    }
    public static void TicTacToe()
    {
        TicTacServer tic = new TicTacServer();
        tic.start();
    }
    /**
     * @param args the command line arguments
     */
    static ArrayList<ServerThread> threadList;
    static ArrayList<Question> ListQuestion;
    static ArrayList<Score> ListofScore = null;
    static ArrayList<QuesKind> ListQues = new ArrayList<>();
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainServer().setVisible(true);
            }
        });
        ChatServer();
        TicTacToe();
        ListQuestion = new ArrayList<>();
        MultipleClient();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem showScores;
    // End of variables declaration//GEN-END:variables

}