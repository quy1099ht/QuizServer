/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arena100;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class ChatBot {
    public String Bot(String a)
    {
        ArrayList<String> whatanswer = new ArrayList<>();
        whatanswer.add("It's a cat");
        whatanswer.add("It's a dog");
        whatanswer.add("It's a car");
        whatanswer.add("It's a human");
        whatanswer.add("It's a school");
        whatanswer.add("It's a bike");
        whatanswer.add("It's a body");
        whatanswer.add("It's a f");
        whatanswer.add("It's a chicket");
        whatanswer.add("It's a church");
        whatanswer.add("It's a catdog");
        whatanswer.add("It's a Something");
        
        ArrayList<String> randomanswer = new ArrayList<>(); 
        randomanswer.add("Yeah!");
        randomanswer.add("Whatever!");
        randomanswer.add("Really?");
        randomanswer.add("Wow!!");
        randomanswer.add("Nice desu!");
        randomanswer.add("I dunno man.");
        randomanswer.add("Beat me!");
        randomanswer.add("I don't give a damn");
        randomanswer.add("Yeah yeah!");
        randomanswer.add("Yeah right.");
        randomanswer.add("Yeah?");
        
        ArrayList<String> greeting = new ArrayList<String>();
        greeting.add("Hello!");
        greeting.add("Hi!");
        greeting.add("It’s nice to meet you!");
        greeting.add("What’s up!");
        greeting.add("Hey!");
        greeting.add("What's your name?");
        greeting.add("Pleased to meet you!");
        greeting.add("Nice to meet ya!");
        
        ArrayList<String> vehicles = new ArrayList<>();
        vehicles.add("bike");
        vehicles.add("car");
        vehicles.add("boat");
        vehicles.add("plane");
        
        ArrayList<String> meAnswer = new ArrayList<>();
        meAnswer.add("Me! I'm Anton. The dumbest bot ever!");
        meAnswer.add("I'm Skynet.");
        meAnswer.add("Peko desu!");
        meAnswer.add("I'm Calli dadbeat.");
        meAnswer.add("I'm just me");
        
        ArrayList<String> randomName = new ArrayList<>();
        randomName.add("Arn Benjamín");
        randomName.add("Sherisse Kiran");
        randomName.add("Ketzi'ah Armel");
        randomName.add("Bróðir Delyth");
        randomName.add("Áki Tewodros");
        randomName.add("Birgit Glukel");
        randomName.add("Gilfoyle Bertram");
        randomName.add("Dinesh Chugtai");
        randomName.add("Richard Hendricks");
        randomName.add("Arabella Lecia");
        randomName.add("Quintella Teagan");
        randomName.add("Nikole Ethelred");
        randomName.add("Khloe Ember");
        randomName.add("Emmaline Gaynor");
        randomName.add("Tristan Sarina");
        randomName.add("Royal Braden");
        randomName.add("Harriette Hyakinthos");
        randomName.add("Hatty Edwin");
        randomName.add("Emmitt Kristel");
        randomName.add("Alyse Garrett");
        randomName.add("Ina Griselda");
        randomName.add("Morton Bryn");
        randomName.add("Wilt Kasey");
        randomName.add("Karrie Joni");
        randomName.add("Kennedy Sherill");
        randomName.add("Christiana Catharine");
        randomName.add("Camron Kenneth");
        randomName.add("Rick Sanchez");
        randomName.add("Rozanne Helen");
        randomName.add("Acacia Bert");
        randomName.add("Vince Indie");
        randomName.add("Mary Jo Rayner");
        randomName.add("Nelson Bighetti");
        randomName.add("Willard Kelcey");
        randomName.add("Willy Wonka");
        randomName.add("Barry Allen");
        randomName.add("Oliver Queen");
        randomName.add("Bruce Wayne");
        randomName.add("Clack Kent");
        randomName.add("Anton");
        
        ArrayList<String> dir = new ArrayList<>();
        dir.add("go straight");
        dir.add("go behind");
        dir.add("turn left");
        dir.add("turn right");
        dir.add("turn around");
        int range = getRandomInt(1,100);
        ArrayList<String>  measurement = new ArrayList<>();
        measurement.add("cm");
        measurement.add("m");
        measurement.add("km");
        measurement.add("miles");
        measurement.add("feet");
        
        ArrayList<String> ranLocation = new ArrayList<>();
        ranLocation.add("factory");
        ranLocation.add("Art Gallery");
        ranLocation.add("Bank");
        ranLocation.add("Bus Station");
        ranLocation.add("Church");
        ranLocation.add("Cinema");
        ranLocation.add("Fire Station");
        ranLocation.add("Garage");
        ranLocation.add("Hotel");
        ranLocation.add("Hospital");
        ranLocation.add("Museum");
        ranLocation.add("Theatre");
        ranLocation.add("Restaurant");
        ranLocation.add("School");
        ranLocation.add("Airport");
        ranLocation.add("Mc'Donnal");
        ranLocation.add("Aquarium");
        ranLocation.add("Supermarket");
        ranLocation.add("Pet Clinic");

        
        
        
        
        
        

        String result = null;
        String a2 = a; 
        a = a.toLowerCase();
        String[] chars = a.split(" ");
        
        if(chars[0].contains("hi")|| chars[0].contains("hello") || chars[0].contains("Hey"))
        {
            return greeting.get(getRandomInt(0,greeting.size()));
        }
        else if(chars[0].contains("my"))
        {
            for(String s : chars)
            {
                if(s.contains("name"))
                {
                    return "Nice to meet you," + chars[chars.length-1] ;
                }
            }
        }
        else if(chars[0].contains("fuck"))
        {
            if(chars.length == 1)
            {
                return "Fuck?";
            }
            else if(chars[chars.length-1].contains("you") || chars[chars.length-1].contains("u"))
            {
                return "Fuck you!";
            }
        }
        else if(chars[0].contains("what"))
        {
            int co = 0;
            if(chars[chars.length - 1].contains("up"))
            {
                return "Hey!";
            }else{
                for (String s : chars) 
                {
                    if(s.contains("name"))
                    {
                        return "My name is " + "Anton. And What's your name?";
                    }
                    else if(s.contains("that") || s.contains("this"))
                        {
                        return whatanswer.get(getRandomInt(0,whatanswer.size()));
                    }
                }
            }
            
        }else if(chars[0].contains("how"))
        {
            if(chars[1].contains("many"))
            {
                return "There are " + getRandomInt(5,30) + " " + chars[2] + ", " + randomName.get(getRandomInt(0,randomName.size()));
            }
            else if(chars[1].contains("did") || chars[1].contains("do") || chars[1].contains("does"))
            {
                if(a.contains("get"))
                {
                    return "I get there by " + vehicles.get(getRandomInt(0,vehicles.size()-1)) + " " + randomName.get(getRandomInt(0,randomName.size()));
                }
            }
            else if(chars[chars.length - 1].contains("you") || chars[chars.length - 1].contains("u"))
            {
                return "I'm fine, thanks. And you?";
            }
            else if(chars[chars.length - 1].contains("she") || chars[chars.length - 1].contains("crush"))
            {
                return "She is.... great! I guess";
            }
            else if(chars[chars.length - 1].contains("he"))
            {
                return "He's nice.";
            }
            else if(hasTo(chars))
            {
                
                String g = "";
                for (int i = getIndexTo(chars) + 1; i < chars.length; i++) {
                    g += chars[i] + " ";
                }
                String re = "";
                for (int i = 0; i < 5; i++) {
                    re += Direction(g,dir,measurement,ranLocation) + " ";
                }
                char[] r = g.toCharArray();
                g = "";
                for (int i = 0; i < r.length-2; i++) {
                    g += r[i];
                }

                re += "The " + g + " is near that place!";
                return re;
            }
        }else if(chars[0].contains("who"))
        {
             
            if(chars[chars.length - 1].contains("you") || chars[chars.length - 1].contains("u") || chars[chars.length - 1].contains("yu"))
            {
                return "My name is Anton";
            }
            else{
                int ran = getRandomInt(0,2);
                     switch(ran){
                         case 0:
                             return "He's " + randomName.get(getRandomInt(0,randomName.size()));
                         case 1:
                             return "She's " + randomName.get(getRandomInt(0,randomName.size()));
                         default:
                             return "They're " + randomName.get(getRandomInt(0,randomName.size()));
                    }
            }
             
        }else if(chars[0].contains("where"))
        {
            String g = "";
            if(chars[1].contains("is"))
            {
                for (int i = 2; i < chars.length; i++) {
                    g += chars[i] + " ";
                }
            }
            
            String re = "";
            for (int i = 0; i < 5; i++) {
                re += Direction(g,dir,measurement,ranLocation) + " ";
            }
            
            if(hasQuestionMark(g))
            {
                char[] r = g.toCharArray();
                g = "";
                for (int i = 0; i < r.length-2; i++) {
                    g += r[i];
                }
            }
            
            re += "The " + g + " is near that place!";
            return re;
            
        }
        else 
        {
            int i = getRandomInt(0,3);
            switch(i){
                case 0:
                    return randomanswer.get(getRandomInt(0,randomanswer.size()));
                case 1:
                    return a2 + " ?";
                case 2:
                    return "Pardun?";
            }
            
        }
        return "Pardun?";
        
    }
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public static String Direction(String endpoint, ArrayList<String> dir, ArrayList<String> measument, ArrayList<String> ranLoc)
    {
        ArrayList<String> f = new ArrayList<>();
        f.add("next to");
        f.add("behind");
        f.add("in front of");
        String result = "From your place, ";
        result += dir.get(getRandomInt(0,dir.size() - 1))+ " " +getRandomInt(1,100) + " " + measument.get(getRandomInt(0,measument.size()-1)) + " .Then you will see a " + ranLoc.get(getRandomInt(0,ranLoc.size()))+ " " + f.get(getRandomInt(0,2)) + " you.";
        return result;
    }
    public static boolean hasTo(String[] chars)
    {   
        for(String s : chars)
        {
            if(s.contains("to"))
            {
                return true;
            }
        }
        return false;
    }
    public static int getIndexTo(String[] chars)
    {
        int index = -1;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i].contains("to"))
            {
                index = i;
            }
        }
        return index;
    }
    public static boolean hasQuestionMark(String chars)
    {
        if(chars.contains("?"))
        {
            return true;
        }
        return false;
    }
}
