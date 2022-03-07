/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectToSQL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class ConnectSQL {
    /*
    public static void main(String[] args) {
        //Demo Add Player/////////////////////////////
        Player s = new Player();

        System.out.println("Name : ");
        Scanner x = new Scanner(System.in);
        s.Name = x.nextLine();

        System.out.println("IP : ");
        Scanner y = new Scanner(System.in);
        s.IP = y.nextLine();

        System.out.println("Point: ");
        Scanner z = new Scanner(System.in);
        s.Point = z.nextFloat();

        System.out.println("Rank: ");
        Scanner m = new Scanner(System.in);
        s.Rank = m.nextFloat();

        AddData a = new AddData();
        a.AddPlayer(s);
        
        //Demo Update Player //////////////////////////
        Player r = new Player();

        System.out.println("Name : ");
        Scanner i = new Scanner(System.in);
        r.Name = i.nextLine();

        System.out.println("IP : ");
        Scanner o = new Scanner(System.in);
        r.IP = o.nextLine();

        System.out.println("Point: ");
        Scanner p = new Scanner(System.in);
        r.Point = p.nextFloat();

        System.out.println("Rank: ");
        Scanner u = new Scanner(System.in);
        r.Rank = u.nextFloat();

        UpdateData b = new UpdateData();
        b.Update(r);
        
        //Demo View All Player////////////////////////
        ViewALLPlayer c = new ViewALLPlayer();
        c.getListPlayer();
        
        //Demo View choosen Player///////////////////////
        Player t = new Player();
        System.out.println("Enter the name of the player you want to search : ");
        Scanner q = new Scanner(System.in);
        t.Name = q.nextLine();

        System.out.print("Here ");
        ViewOnePlayer d = new ViewOnePlayer();
        d.GetPlayer(t);

    }
*/
}
