/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.player;

import com.pest.suite.Game;
import java.util.ArrayList;

/**
 *
 * @author Patrick
 */
public class team {
    ArrayList<Player> players;
    int id;
    private Game game;
    
    public team(int ID, Game g){
        id = ID;
        players = new ArrayList<Player>();
        game = g;
    }
    
    public void addPlayer(Player i){
        players.add(i);
    }
    
    public void printPlayers(){
        System.out.println("Team " + id + " consists of: \n");
        for (Player i: players){
            System.out.println("player " + i.getID());
        }
    }
    
    public int teamSize(){
        return players.size();
    }
}
