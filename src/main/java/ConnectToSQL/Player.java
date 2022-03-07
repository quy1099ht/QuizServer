/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectToSQL;

/**
 *
 * @author ACER
 */
public class Player {

    
    public String Name, IP;
    public float Point, Rank;

    public Player() {
    
    }

    public Player(String Name, String IP, float Point, float Rank) {
        this.Name = Name;
        this.IP = IP;
        this.Point = Point;
        this.Rank = Rank;
    }
    
    public String getName() {
        return Name;
    }
    
    public String getIP() {
        return IP;
    }

    public float getPoint() {
        return Point;
    }

    public float getRank() {
        return Rank;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public void setPoint(float Point) {
        this.Point = Point;
    }

    public void setRank(float Rank) {
        this.Rank = Rank;
    }
    
    
}
