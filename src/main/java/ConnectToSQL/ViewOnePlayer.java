/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectToSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class ViewOnePlayer {
    Connection conn;
    public boolean GetPlayer(Player b) {

        try {
            Connect a = new Connect();
            conn = a.GetConnection();
            String sql = "SELECT * FROM Players where Name= '" + b.Name + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Player s = new Player();
                s.setName(rs.getString("Name"));
                s.setIP(rs.getString("IP"));
                s.setPoint(rs.getFloat("Point"));
                s.setRank(rs.getFloat("Rank"));

                showTable(s);
            }
        } catch (Exception e) {
            System.out.println("There is no player with that name. ");
            e.printStackTrace();
            //System.out.println("There is no player with that name. ");
        }
        try{
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public void showTable(Player s) {
        System.out.println("Name: " + s.getName() + " IP: " + s.getIP() + " Point: " + s.getPoint() + " Rank: " + s.getRank());
    }
}
