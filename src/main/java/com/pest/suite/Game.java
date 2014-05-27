/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pest.suite;
import com.map.MapConcreteCreator;
import com.map.business.MapCreator;
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
    private MapConcreteCreator currentMap;
    private static  ArrayList<Player> playerList = new ArrayList<Player>();
    private static ArrayList<team> teamList = new ArrayList<team>();
    private int currentPlayer;
    
    private static final Game singleton = new Game();
    
     //Private constructor so as to prevent any other class from instantiating
    private Game(){
        currentMap = new MapConcreteCreator();
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
    
    private void playerInput() throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        int varSize, varPlayers, varTeams=-1;
        do{
            /*
                ENTER NUMBER OF PLAYERS AND MAP SIZE
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
        
        /*
                ENTER MAP TYPE HERE
            */
            int mapChoice = 0;
            System.out.println("Please Select a map Type: ");
            System.out.println("Enter 1 for a Regular Map");
            System.out.println("Enter 2 for a Dangerous Map");
            System.out.println("Enter 3 for a Safe Map");
         do{
                mapChoice = sc.nextInt();
         }while(mapChoice != 1 && mapChoice != 2 && mapChoice != 3);
         currentMap.setMap(mapChoice, varSize);
        
            setTeamNo(varTeams);
            setPlayers(varPlayers);
            setSize(varSize);
            setTeams();
    }
    
    /**
     * Contains the main working algortihms for class
 including input verification of number of players
 and map size.
     * @throws java.io.FileNotFoundException
     */
    public void GameMethod() throws FileNotFoundException {
        playerInput();
        
         // create Map Instace
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
    
    public MapCreator getMap(){
        return currentMap.getMap();
    }
    public void setTeams() throws FileNotFoundException{
        if (players<=teams){
            teams=players;
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
            System.out.println("entered condition 2");
            for (int i = 0; i< teams; i++){
                team newTeam = new team(i,this);  
                teamList.add(newTeam);
                //System.out.println("Team " + i + "Created");
            }
            System.out.println("Number of teams created: " + teamList.size());
            for (int i = 0; i< players; i++){
                System.out.println("player");
                Player newPlayer;
                newPlayer = new Player(i,this);
                playerList.add(newPlayer);
                findteam(newPlayer);
                System.out.println("added player " + i);
            }
        }
        
    }

    public void findteam(Player newPlayer) {
        Random randomGenerator = new Random();
        int r;
        int i = 0; // testing
        do{
            r =  (int)(Math.random() * ((teams)));
            System.out.println("Random team try" +i + ": " + r);
            i++;
        } while (!evenTeams(r));
        teamList.get(r).addPlayer(newPlayer);
        
    }

    public boolean evenTeams(int r) {
        for (int i = 0; i< teams; i++){
            if ((teamList.get(i).teamSize() - teamList.get(r).teamSize()) > -1 
                    || (teamList.get(i).teamSize() - teamList.get(r).teamSize()) < 1){
                        return true;
            }
        System.out.println("loop " + i);
        }
        return false;
    }
}
