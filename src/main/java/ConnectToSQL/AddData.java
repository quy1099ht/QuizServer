/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectToSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ACER
 */
public class AddData {
Connection conn ;
    public void AddPlayer(Player s) {
        try {
            Connect a = new Connect();
            conn = a.GetConnection();
            String sql = "INSERT INTO Players(Name, IP, Point, Rank)" + "VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getIP());
            ps.setFloat(3, s.getPoint());
            ps.setFloat(4, s.getRank());

            //return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        //return false;
    }
}
