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
    
    private void playerInput(){
        Scanner sc = new Scanner(System.in);
        int varSize, varPlayers;
        do{
            System.out.println("Welcome! How many players are you?");
            varPlayers = sc.nextInt();
            if((varPlayers>=2 && varPlayers<=4)){
                do{
                    System.out.println("Please enter a map size between 5 and 50:");
                    varSize = sc.nextInt();
                }while(varSize > 5 && varSize <  50);
            } else if((varPlayers > 5) && (varPlayers < 8)){
                do{
                    System.out.println("Please enter a map size between 8 and 50:");
                    varSize = sc.nextInt();
                }while(varSize >  5 && varSize <  50);
            } else {
                varSize = 50;
            }
        }while(varPlayers < 2 && varPlayers > 8);
        setPlayers(varPlayers);
        setSize(varSize);
    }
/**
 * Contains the main working algortihms for class
 * including input verification of number of players
 * and map size.
 */
    protected void GameMethod() {
        playerInput();
        Map m = new Map(); // Create a Map Instance
        m.setMapSize(size, size); // Set the Map Size
        m.generate(); // Generates the Map 
        for(int i = 0; i<= m.getMap().length - 1; i++){
            for(int j = 0; j<= m.getMap()[0].length - 1; j++){
                System.out.print(m.getMap()[i][j]);
            }
        }
        ArrayList<Player> playerList = new ArrayList();
        for(int i = 0; i<= players; i++){
            playerList.add(new Player(i,this));
        }
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
