/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arena100;

import javax.swing.JButton;

/**
 *
 * @author ACER
 */
public class Location {

    public int i;
    public int j;
    public String tictac;

    public Location() {
    }

    public Location(int i, int j, String tictac) {
        this.i = i;
        this.j = j;
        this.tictac = tictac;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public String getTictac() {
        return tictac;
    }

    public void setTictac(String tictac) {
        this.tictac = tictac;
    }



}
