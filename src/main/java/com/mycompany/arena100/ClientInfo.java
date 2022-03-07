/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arena100;

import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class ClientInfo extends javax.swing.JFrame {

    /**
     * Creates new form ClientInfo
     */
    public ClientInfo() {
        initComponents();
    }
    public ClientInfo(String cliInfo,int point,int state, Socket Socket) {
        ClientInfo = cliInfo;
        State = state;
        socket = Socket;
        Point = point;
        initComponents();
        this.clientInfo.append(cliInfo + "\n"); 
        this.clientInfo.append("Grades : "+ Point + "\n");        
        this.clientInfo.append("State : " + State + "\n");
        this.clientInfo.append(String.valueOf(socket.getInetAddress()));
        clientInfo.setLineWrap(true);
        this.setLocation(10, 10);
        this.setTitle("Client's Infook");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        bannedBt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.black);

        jLabel1.setText("Client");

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        bannedBt.setText("Banned");
        bannedBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bannedBtActionPerformed(evt);
            }
        });

        clientInfo.setEditable(false);
        clientInfo.setColumns(20);
        clientInfo.setRows(5);
        clientInfo.setEnabled(false);
        jScrollPane1.setViewportView(clientInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bannedBt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bannedBt)
                    .addComponent(exitBtn))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bannedBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bannedBtActionPerformed
        // TODO add your handling code here:
        State = 0;
        for(ServerThread s : MainServer.threadList)
        {
            if(s.socket.getInetAddress().equals(socket.getInetAddress()))
            {
                s.state = State;
            }
        }
        JOptionPane.showMessageDialog(null, "He's banned!!");
    }//GEN-LAST:event_bannedBtActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false); //you can't see me!
        dispose(); //Destroy the JFrame object
    }//GEN-LAST:event_exitBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public String ClientInfo;
    public int State;
    public Socket socket;
    public int Point;

    public String getClientInfo() {
        return ClientInfo;
    }

    public int getState()
    {
        return State;
    }

    public Socket getSocket() {
        return socket;
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bannedBt;
    private javax.swing.JTextArea clientInfo;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
