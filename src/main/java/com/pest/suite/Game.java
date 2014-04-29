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
import java.io.IOException;
import com.io.PlayerSave;
import java.io.FileNotFoundException;
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
                }while(varSize < 4 || varSize >  50);
            } else if((varPlayers > 4) && (varPlayers <= 8)){
                do{
                    System.out.println("Please enter a map size between 8 and 50:");
                    varSize = sc.nextInt();
                }while(varSize <  8 || varSize >  50);
            } else {
                varSize = 50;
            }
        }while(varPlayers < 2 || varPlayers > 8);
       /* PlayerSave p = new PlayerSave("C://");
        try{
            p.saveFile();
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }*/
        
        setPlayers(varPlayers);
        setSize(varSize);
    }
/**
 * Contains the main working algortihms for class
 * including input verification of number of players
 * and map size.
 */
    
    /**
     * Contains the main working algortihms for class
 including input verification of number of players
 and map size.
     * @throws java.io.FileNotFoundException
     */
    protected void GameMethod() throws FileNotFoundException {
        playerInput();
        this.setMap(new Map()); // create Map Instace
        currentMap.setMapSize(size, size); // Set the Map Size
        currentMap.generate(); // Generates the Map 
        
        ArrayList<Player> playerList = new ArrayList();
        for(int i = 0; i<= players-1; i++){
            playerList.add(new Player(i,this));
        }
        int currentPlayer = 0;
        boolean won = false;
        do{
            System.out.println("Player " + playerList.get(currentPlayer).getID() +"'s turn ");
            System.out.println("Enter the Key to Move");
            char c;
            boolean moveResult = false;
            do{
                c = askforKey();
                moveResult = playerList.get(currentPlayer).movePlayer(c);
                
            } while(moveResult != true);
            
            char s = playerList.get(currentPlayer).checkStatus();
            switch(s){
                case 'W':
                    won = true;
                    break;
                case 'L':
                    System.out.println("You Lose! Start again");
                    playerList.get(currentPlayer).ResetPosition();
                    break;
                case 'C':
                    System.out.println("The grass is green!");
                    break;
            }
            if(won != true){
                if(playerList.get(currentPlayer) == playerList.get(playerList.size() - 1)){
                    currentPlayer = 0;
                } else {
                    currentPlayer++;
                }
            }
        }while(won == false);
        System.out.println(playerList.get(currentPlayer) + " Wins!");
        System.out.println("Number of players: " + getPlayers());
        System.out.println("Mapsize is: " + getSize() +"x"+getSize());
    }
    
    public char askforKey(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your move:");
        char c = sc.next().charAt(0);
        return c;
    }
    
    public Map getMap(){
        return currentMap;
    }
    public void setMap(Map m){
        this.currentMap = m;
    }
}
