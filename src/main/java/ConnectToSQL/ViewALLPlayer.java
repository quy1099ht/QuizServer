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
public class ViewALLPlayer {
    Connection conn;
    public ArrayList<Player> getListPlayer() {
        ArrayList<Player> list = new ArrayList<>();
        
        try {
            Connect a = new Connect();
            conn = a.GetConnection();
            String sql = "SELECT * FROM Players";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Player s = new Player();
                s.setName(rs.getString("Name"));
                s.setIP(rs.getString("IP"));
                s.setPoint(rs.getFloat("Point"));
                s.setRank(rs.getFloat("Rank"));

                list.add(s);
            }
            showTable(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public void showTable(ArrayList<Player> list) {
        for (Player s : list) {
            System.out.println("Name: " + s.getName() + " IP: " + s.getIP() + " Point: " + s.getPoint() + " Rank: " + s.getRank());
        }
    }
}
