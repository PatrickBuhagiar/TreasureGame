/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.player;
import java.util.ArrayList;
/**
 *
 * @author Jake
 */
public class alternateTeam {
    private int id;
    private ArrayList<alternatePlayer> players = new ArrayList<alternatePlayer>();
    public alternateTeam(int i){
        this.id = i;
    }
    public ArrayList<alternatePlayer> getPlayerList(){
        return players;
    }
    public void setPlayerList(ArrayList<alternatePlayer> p){
        this.players = p;
    }
    public int getId(){
        return id;
    }
    public void setId(int x){
        this.id = x;
    }
    public int getSize(){
        return players.size();
    }
    public void addPlayer(alternatePlayer p){
        players.add(p);
    }
}
