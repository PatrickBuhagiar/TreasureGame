/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map;
import com.map.business.MapCreator;
/**
 *
 * @author Jake
 */
public class MapConcreteCreator {
    private boolean teamMode = false; // TRUE FOR TEAM MODE, FALSE FOR PLAYER MODE
    private int n_Teams = 0; // TO BE USED IN TEAM MODE
    private int n_Players = 0; // TO BE USED IN PLAYER MODE
    public int n_currentTeam = 0; // TO BE USED IN TEAM MODE
    public int n_currentPlayer = 0; // TO BE USED IN PLAYER MODE
    MapCreator mainMap;
    public MapConcreteCreator(){
        
    }
    /*
        Method to Create a Map.
        @param n type of map
        @parma s size of map
    */
    public MapCreator setMap(int n, int s){
        switch (n){
            case 1:
                mainMap = new Map();
                mainMap.setMapSize(s, s);
                mainMap.generate();
                return mainMap;
            case 2:
                mainMap = new dangerousMap();
                mainMap.setMapSize(s, s);
                mainMap.generate();
                return mainMap;
            case 3:
                mainMap = new safeMap();
                mainMap.setMapSize(s, s);
                mainMap.generate();
                return mainMap;
        }
        return null;
    }    
    
    public MapCreator getMap(){
        return mainMap;
    }
}
