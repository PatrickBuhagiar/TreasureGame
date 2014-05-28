/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pest.suite;

import com.map.MapConcreteCreator;
import com.map.TableMapRender;
import com.map.business.MapCreator;
import com.map.business.tileType;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import com.player.alternatePlayer;
import com.player.alternateTeam;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jake
 */
public class alternateGame {
    // Number of Players and Number of Teams
    int players = 0;
    int teams = 0;
    // List of Teams and List of Players
    ArrayList<alternateTeam> teamList = new ArrayList<alternateTeam>();
    ArrayList<alternatePlayer> playerList = new ArrayList<alternatePlayer>();
    // Team Mode
    boolean teamMode = false;
    boolean gameWon = false;
    // The Game Map
    MapConcreteCreator gameMap = new MapConcreteCreator();
    // Scanner Class for Input
    Scanner sc = new Scanner(System.in);
    TableMapRender tmr;
    public alternateGame(){
        
    }
    /* Launches The Game Call this from Constructor */
    public void launchGame() throws FileNotFoundException {
        launchInput();
        if(teamMode){
            doTeamMode();
        } else {
            doPlayerMode();
        }
    }
    
    /* Algorithm for TeamMode, calls printTeams() */
    public void doTeamMode() throws FileNotFoundException{
        printTeams();
        
        // Set Random positions for all players
        
        for(int i = 0; i< teamList.size(); i++){
            for(int j = 0; j< teamList.get(i).getPlayerList().size(); j++){
                do{
                    int some_x = teamList.get(i).getPlayerList().get(j).getRandomPos(gameMap.getMap().getMap().length);
                    int some_y = teamList.get(i).getPlayerList().get(j).getRandomPos(gameMap.getMap().getMap().length);
                    alternatePlayer tempAltPlayer = new alternatePlayer(99,gameMap.getMap().getMap().length);
                    tempAltPlayer.setPos(some_x, some_y);
                    if(checkMove(tempAltPlayer) == 0){
                        teamList.get(i).getPlayerList().get(j).setStartPos(some_x, some_y);
                    }
                }while(checkMove(teamList.get(i).getPlayerList().get(j)) != 0);
                doDisplay(teamList.get(i),j);
            }
        }
        System.out.println("TEST");
        
        // The Team Loop
        do{
            for(int i = 0; i<= teamList.size() - 1; i++){
                for(int j = 0; j<= teamList.get(i).getPlayerList().size() - 1; j++){
                    doDisplay(teamList.get(i),j);
                    System.out.println("> TURN OF : Player " + teamList.get(i).getPlayerList().get(j).getId() +  " Team (" + i + ") ");
                    // Make Move
                    char playerMove;
                    do{
                        System.out.println("> Please Enter a Move (W/S/A/D): ");
                        playerMove = sc.next().charAt(0);
                    }while(!(teamList.get(i).getPlayerList().get(j).move(playerMove, gameMap.getMap().getMap().length)));
                    switch(checkMove(teamList.get(i).getPlayerList().get(i))){
                        case 0:
                            System.out.println(">> You've Found some Grass! You Live!");
                            doDisplay(teamList.get(i),j);
                            break;
                        case 1:
                            System.out.println(">> You've Found Sea! You Die!");
                            System.out.println(">> Spawning at Start Position...");
                            teamList.get(i).getPlayerList().get(j).goToStart();
                            doDisplay(teamList.get(i),j);
                            break;
                        case 2:
                            System.out.println(">> You've Win! Game Over!");
                            doDisplay(teamList.get(i),j);
                            gameWon = true;
                            // Treasure
                            break;
                        default:
                            // Errror
                            System.out.println(">> AN ERROR HAS OCCURED!");
                    }
                }
            }
        }while(gameWon == false);
    }
    
    private void printTeams(){
        System.out.println("Welcome to Team Mode.");
        System.out.println("Map Size: " + gameMap.getMap().getMap().length);
        System.out.println("Teams assigned:");
        for(int i = 0; i<= teamList.size() -1; i++){
            System.out.print("Team " + teamList.get(i).getId() + " : " );
            ArrayList<alternatePlayer> tempList = teamList.get(i).getPlayerList();
            for(int j = 0; j<= tempList.size() - 1; j++){
                System.out.print(" Player " + tempList.get(j).getId() +  " , ");
            }
            System.out.println(".");
        }
        System.out.println("");
    }
    
    /* Algorithm for Player Mode */
    public void doPlayerMode() throws FileNotFoundException {
        printPlayers();
        System.out.println("**************** STARTING GAME *****************");
        
        // Generate Random Start Positions for Players
        for(int i = 0; i<= playerList.size() - 1; i++){
                do{
                    int some_x = playerList.get(i).getRandomPos(gameMap.getMap().getMap().length);
                    int some_y = playerList.get(i).getRandomPos(gameMap.getMap().getMap().length);
                    alternatePlayer tempAltPlayer = new alternatePlayer(99,5);
                    tempAltPlayer.setPos(some_x, some_y);
                    if(checkMove(tempAltPlayer) == 0){
                        playerList.get(i).setStartPos(some_x, some_y);
                    }
                }while(checkMove(playerList.get(i)) != 0);
        }
        
        // The player Loop
        do{
            for(int i = 0; i<= playerList.size() - 1; i++){
                doDisplay(playerList.get(i));
                System.out.println("> TURN OF : Player " + i);            
                // Make Move

                char playerMove;

                do{
                    System.out.println("> Please Enter a Move (w/s/a/d): ");
                    playerMove = sc.next().charAt(0);
                }while(!(playerList.get(i).move(playerMove, gameMap.getMap().getMap().length)));

                switch(checkMove(playerList.get(i))){
                    case 0:
                        System.out.println(">> You've Found some Grass! You Live!");
                        doDisplay(playerList.get(i));
                        break;
                    case 1:
                        System.out.println(">> You've Found Sea! You Die!");
                        System.out.println(">> Spawning at Start Position...");
                        playerList.get(i).goToStart();
                        doDisplay(playerList.get(i));
                        break;
                    case 2:
                        System.out.println(">> You've Win! Game Over!");
                        // Treasure
                        doDisplay(playerList.get(i));
                        gameWon = true;
                        break;
                    default:
                        // Errror
                        System.out.println(">> AN ERROR HAS OCCURED!");
                }
            }
        }while(gameWon == false);
        System.out.println("Exiting Game");
    }
    
    /* Checks if the coordinate is a Win, Grass or Sea */
    private int checkMove(alternatePlayer p){
        int x = p.getX();
        int y = p.getY();
        if(gameMap.getMap().getTileType(x, y) == tileType.GRASS){
            return 0;
        } else if(gameMap.getMap().getTileType(x, y) == tileType.SEA){
            return 1;
        } else if(gameMap.getMap().getTileType(x, y) == tileType.TREASURE){
            return 2;
        } else {
            return -1;
        }
    }
    
    public void doDisplay(alternateTeam team_input, int current_player_id) throws FileNotFoundException {
        ArrayList<alternatePlayer> tempPlayerList = team_input.getPlayerList();
        boolean [][] input = tempPlayerList.get(0).getVisible();
        for(int i = 0; i <= tempPlayerList.size() - 1; i++){
            for(int j = 0; j<= input.length - 1; j++){
                for(int k = 0; k<= input[j].length - 1; k++){
                    input[j][k] = input[j][k] || tempPlayerList.get(i).getVisible()[j][k];
                }
            }
        }
        System.out.println("T");
        MapConcreteCreator temp = new MapConcreteCreator();
        temp.setMap(1, gameMap.getMap().getMap().length);
        temp.getMap().setUnknown();
        for(int i = 0; i<= input.length - 1; i++){
            for(int j = 0; j<= input[i].length - 1; j++){
                if(input[i][j] == true){
                    temp.getMap().setTileType(i, j, gameMap.getMap().getTileType(i, j));
                }
            }
        }
        tmr = new TableMapRender(temp.getMap().getMap(),"","");
        tmr.setPlayerPoint(tempPlayerList.get(current_player_id).getX(),tempPlayerList.get(current_player_id).getX());
        String code = tmr.generateCode();
        System.out.println(code);
        try {
            String file = "Player " + tempPlayerList.get(current_player_id).getId() + ".html";
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.println(code);
            writer.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(alternatePlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void doDisplay(alternatePlayer player_input) throws FileNotFoundException {
        boolean [][] input = player_input.getVisible();
        MapConcreteCreator temp = new MapConcreteCreator();
        temp.setMap(1, gameMap.getMap().getMap().length);
        temp.getMap().setUnknown();
        for(int i = 0; i<= input.length - 1; i++){
            for(int j = 0; j<= input[i].length - 1; j++){
                if(input[i][j] == true){
                    temp.getMap().setTileType(i, j, gameMap.getMap().getTileType(i, j));
                }
            }
        }
        tmr = new TableMapRender(temp.getMap().getMap(),"","");
        tmr.setPlayerPoint(player_input.getX(),player_input.getY());
        String code = tmr.generateCode();
        System.out.println(code);
        try {
            String file = "Player " + player_input.getId() + ".html";
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.println(code);
            writer.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(alternatePlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Prints Players in PlayerMode */
    private void printPlayers(){
        System.out.println("Welcome to Team Mode.");
        System.out.println("Map Size: " + gameMap.getMap().getMap().length);
        System.out.println("Player list:");
        for(int i = 0; i<= playerList.size() -1; i++){
            System.out.print("Player " + playerList.get(i).getId() + ", " );
        }
        System.out.println("");
    }
    
    /* Asks for Player Input, Calls allocatePlayers() and mapSelect() */
    public void launchInput(){
        int choice = 0;
        System.out.println("********** WELCOME TO THE GAME ***********");
        System.out.println("Enter 1 for Team Mode, Enter 2 for Player Mode");
        System.out.println("Please Choose a Game Mode:");
        do{
            choice = sc.nextInt();
        }while(choice!=2 && choice!=1);
        setMode(choice);
        switch(choice){
            case 2:
                System.out.println("Please enter the number of players (Must be Minimum of 2, Maximum 8):");
                do{
                    players = sc.nextInt();
                }while(players < 2 || players > 8);
                break;
            case 1:
                do{
                    System.out.println("Please enter the number of players (Must be Minimum of 2, Maximum 8):");
                    players = sc.nextInt();
                }while(players < 2 || players > 8);
                do{
                    System.out.println("Please enter the number of teams (Must be At least 2):");
                    teams = sc.nextInt();
                }while(!teamConstraint() && teams < 1);
                break;
        }
        mapSelect();
        allocatePlayers();
    }
    
    /* Allocates Players to Team, Calls SmallestSize and TeamConstraint */
    private void allocatePlayers(){
        int r;
        if(teamMode){
            for(int i = 0; i<= teams - 1; i++){
                teamList.add(new alternateTeam(i));
            }
            for(int i = 0; i<= players - 1; i++){
                playerList.add(new alternatePlayer(i,gameMap.getMap().getMap().length));
            }   
            for(int i = 0; i < playerList.size(); i++){
                do{
                    r = (int)(Math.random() * (teams));
                } while (!evenTeams(r));
                teamList.get(r).addPlayer(playerList.get(i));
            }
        } else {
            for(int i = 0; i<= players - 1; i++){
                playerList.add(new alternatePlayer(i,gameMap.getMap().getMap().length));
            }
        }
    }
    
     public boolean evenTeams(int r) {
         float average = players/teams;
            if (teamList.get(r).getSize() > average){
                return false;
            } else
                return true;
    }
    
    /* Method to get the Smallest Sized Team */
    private int getSmallestSize(ArrayList<alternateTeam> n){
        int output = -1;
        int smallestSize = n.get(0).getSize();
        for(int i = 0; i<= n.size() - 1; i++){
            if(n.get(i).getSize() <= smallestSize){
                smallestSize = n.get(i).getSize();
                output = i;
            }
        }
        return output;
    }
    
    /* Method for Deciding Whether There are Enoguh Teams
        @returns boolean yes or no.
    */
    private boolean teamConstraint(){
        if(players == teams){
            System.out.println(">> Good, One Player per Team!");
            return true;
        } else if( teams > players){
            System.out.println(">> Error! There are more teams than players");
            return false;
        } else if( teams < players){
            System.out.println(">> Good, Enough players for the teams!");
            return true;
        }
        return false;
    }
    
    /* Sets TeamMode if Chosen */
    private void setMode(int n){
        if(n == 1){
            teamMode = true;
        } else {
            teamMode = false;
        }
    }
    
    /* Input Methods for setting Map, Calls Map Config */
    private void mapSelect(){
        System.out.println("Please Enter the type of Map: ");
        int mapChoice, mapSize, minMapSize;
        if(players > 1 && players < 5){
            minMapSize = 5;
        } else {
            minMapSize = 8;
        }
        do{
            System.out.println("Select 1 for Random Map, Select 2 for Dangerous Map, Select 3 for Safe Map:");
            mapChoice = sc.nextInt();
        }while(mapChoice != 1 && mapChoice != 2 && mapChoice != 3);
        do{
           System.out.println("Please Select a Map Size ("+ minMapSize + " - 50):");
           mapSize = sc.nextInt();
        }while(mapSize < minMapSize && mapSize > 50);
        configMap(mapChoice,mapSize);
    }
    
    /* Input Methods for setting Map
       @param c Type of Map
       @param s Size of Map
    */
    private void configMap(int c, int s){
        switch(c){
            case 1:
                // Random map
                gameMap.setMap(c, s);
                break;
            case 2:
                // Dangerous Map
                gameMap.setMap(c, s);
                break;
            case 3:
                // Safe Map
                gameMap.setMap(c, s);
                break;
        }
    }
}