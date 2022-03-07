/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arena100;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class QuesKind {
    public ArrayList<Question> q;

    public QuesKind() {
    }

    public QuesKind(ArrayList<Question> q, String type) {
        this.q = q;
        this.type = type;
    }

    public ArrayList<Question> getQ() {
        return q;
    }

    public void setQ(ArrayList<Question> q) {
        this.q = q;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String type;
}
