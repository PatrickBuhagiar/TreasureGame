/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pest.suite;
import com.map.Map;
import com.player.Player;
import com.player.team;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Patrick
 */
public class Game {
    private static int players;
    private int teams;
    private int size;
    private Map currentMap;
    private static  ArrayList<Player> playerList = new ArrayList<Player>();
    private static ArrayList<team> teamList = new ArrayList<team>();
    private int currentPlayer;
    
    private static final Game singleton = new Game();
    
     //Private constructor so as to prevent any other class from instantiating
    private Game(){
        
        size = 0;
    }
    
    //get singleton instance
    public static Game getInstance() {
        return singleton;
    }
       
    //setter for players
    public void setPlayers(int x){
        players = x;
    }
    
    public void setTeamNo(int x){
        teams = x;
    }
    
    public int getTeamNo(){
        return teams;
    }
    
    //setter for Map size
    public void setSize(int x){
        size = x;
    }
    
    //getter for players
    public  int getPlayers(){
        return players;
    }
    
    //getter for Map size
    public  int getSize(){
        return size;
    }
    
    private void playerInput(){
        Scanner sc = new Scanner(System.in);
        int varSize, varPlayers, varTeams;
        do{
            /*
                ENTER MAP TYPE HERE
            */
                
            /*
                ENTER NUMBER OF PLAYERS
            */
            System.out.println("How many players are you?");
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
        
        /*
            ENTER NUMBER OF TEAMS
        */
        do {
         System.out.println("Please enter number of teams: ");
         varTeams = sc.nextInt();
        } while (varTeams<0);
        /*
            SET CONDITIONS FOR TEAMS
        */
        
        setTeamNo(varTeams);
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
    public void GameMethod() throws FileNotFoundException {
        playerInput();
        this.setMap(new Map()); // create Map Instace
        currentMap.setMapSize(size, size); // Set the Map Size
        currentMap.generate(); // Generates the Map 
        System.out.println("Number of players: " + getPlayers());
        System.out.println("Number of teams: " +  getTeamNo());
        System.out.println("Mapsize is: " + getSize() +"x"+getSize());
       
        /*
            CREATE TEAMS
        */
        
        /*
            SETS RANDOM POSITION
        */
        
        for(int i = 0; i< playerList.size()-1; i++){
            System.out.println("test");
            System.out.println("Player "+playerList.get(i).getID()+" pos:" + playerList.get(i).getPos().getX() + ","+playerList.get(i).getPos().getY());
        }
        //Determine who's next to play
        currentPlayer =0;
        boolean won = false;
        char c;
        //System.out.println("current player is " + currentPlayer + " " + playerList.get(currentPlayer).getID());
        do{
            
            System.out.println("Player " + playerList.get(currentPlayer).getID() +"'s turn ");
            System.out.println("Enter the Key to Move");
            
            boolean moveResult;
            do{
                System.out.println("pos: cha" + playerList.get(currentPlayer).getPos().getX() + ","+playerList.get(currentPlayer).getPos().getY());
                
                c = askforKey();
                System.out.println("read key. current Player = " + currentPlayer);
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
            if(!won){
                if(currentPlayer == (players-1)){
                    currentPlayer = 0;
                } else {
                    currentPlayer++;
                }
            }
            Scanner key = new Scanner(System.in);
            System.out.println("press enter for next player");
            key.nextLine();
        }while(won == false);
        
        System.out.println("Player "+playerList.get(currentPlayer).getID() + " Wins!");
        
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
    
    public void setTeams(int p, int t) throws FileNotFoundException{
        if (p<=t){
            t=p;
            /*
            set one player per team
            */
            for(int i = 0; i< teams; i++){
                team newTeam = new team(i, this);
                Player newPlayer = new Player(i,this);
                newTeam.addPlayer(newPlayer);
                playerList.add(newPlayer);
                teamList.add(newTeam);
            }
        }
        else {
            for (int i = 0; i< teams; i++){
                team newTeam = new team(i,this);
                teamList.add(newTeam);
            }
            
            for (int i = 0; i< players; i++){
                Player newPlayer = new Player(i,this);
                findteam(newPlayer);
            }
        }
        
    }

    public void findteam(Player newPlayer) {
        Random randomGenerator = new Random();
        int r;
        do{
            r =  randomGenerator.nextInt(teams-1);
        } while (!evenTeams(r));
        teamList.get(r).addPlayer(newPlayer);
    }

    public boolean evenTeams(int r) {
        for (int i = 0; i< teams; i++){
            if ((teamList.get(i).teamSize() - teamList.get(r).teamSize()) > 1 
                    || (teamList.get(i).teamSize() - teamList.get(r).teamSize()) < -1){
                        return false;
            }
        }
        return true;
    }
}
