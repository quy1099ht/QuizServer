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
public class UpdateData {
    Connection conn;
    public boolean Update(Player s) {

        try {
            Connect a = new Connect();
            conn = a.GetConnection();
            String sql = "Update Players set IP=?,Point=?,Rank=? where Name=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getIP());
            ps.setFloat(2, s.getPoint());
            ps.setFloat(3, s.getRank());
            ps.setString(4, s.Name);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
