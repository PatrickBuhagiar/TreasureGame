/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pest.suite;
import java.util.Scanner;
import java.util.ArrayList;
import com.map.Map;
import com.player.Player;
/**
 *
 * @author Patrick
 */
public class Game {
    private static int turns;
    private static int players;
    private int size;
    private Map currentMap;
    
    private static Game singleton = new Game();
    
     //Private constructor so as to prevent any other class from instantiating
    private Game(){
        turns = 0;
        players = 0;
        size = 0;
    }
    
    //get singleton instance
    protected static Game getInstance() {
        return singleton;
    }
    
    //getter for turns
    private static int getTurns(){
        return turns;
    }
    
    //increment turns
    private static void incrementTurn(){
        turns++;
    }
    
    //setter for players
    private static void setPlayers(int x){
        players = x;
    }
    
    //setter for Map size
    private void setSize(int x){
        size = x;
    }
    
    //getter for players
    private  int getPlayers(){
        return players;
    }
    
    //getter for Map size
    public  int getSize(){
        return size;
    }
    
/**
 * Contains the main working algortihms for class
 * including input verification of number of players
 * and map size.
 */
    protected void GameMethod() {
        System.out.println("Welcome! How many players are you?\n");
        
        //For Looping purposes 
        boolean loop = true;
        boolean loop2 = true;
        
        /**
         * x:# of players
         * y:Map size
         */
        int x=0;
        int y=0;
        
        while (loop){
            //open input stream
            Scanner input = new Scanner(System.in);
            //enter # of players
            x = input.nextInt();
            
            //condition for 2-4 players
            if ((x>=2)&&(x<=4)){
                System.out.println("what map size would you like? [5-50]\n");
                while(loop2){
                    //input Map size  
                    y = input.nextInt();
                    //accepting only numbers between 5-50 to break loop 
                    if ((y>=5) && (y<=50)){
                        loop2=false;
                    }
                }
                loop=false;
            }
            //condition for 5-8 players
            else if ((x>=5)&&(x<=8)){
                System.out.println("what map size would you like? [8-50]\n");
                while(loop2){
                    //input Map size  
                    y = input.nextInt();
                    //accepting only numbers between 5-50 to break loop 
                    if ((y>=8) && (y<=50)){
                        loop2=false;
                    }
                }
                loop=false;
            }
            Map m = new Map(); // Create a Map Instance
            m.setMapSize(y, y); // Set the Map Size
            m.generate(); // Generates the Map 
            ArrayList<Player> playerList = new ArrayList();
            for(int i = 0; i<= x; i++){
                playerList.add(new Player(i,this));
            }
        }
        //set class variables
        setPlayers(x);
        setSize(y);
        
        //checking if correct inputs
        System.out.println("Number of players: " + getPlayers());
        System.out.println("Mapsize is: " + getSize() +"x"+getSize());
    }
    
    public Map getMap(){
        return currentMap;
    }
    public void setMap(Map m){
        this.currentMap = m;
    }
}