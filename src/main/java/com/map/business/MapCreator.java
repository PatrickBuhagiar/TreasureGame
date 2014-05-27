/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map.business;

import java.util.Random;

/**
 *
 * @author Jake
 */
public abstract class MapCreator {
    protected final Random randomGenerator = new Random();
    protected String mapName;
    protected tileType map [][];
    public boolean setMapSize(int x, int y){
        this.map = new tileType [x][y];
        return true;
    }
    public void setUnknown(){
        for(int i = 0; i<= map.length - 1; i++){
            for(int j = 0; j<= map[0].length - 1; j++){
                map[i][j] = tileType.UNKNOWN;
            }
        }
    }
    public tileType[][] getMap(){
        return map;
    }
    public tileType getTileType(int x, int y){
        return map[x][y];
    }
    public void setTileType(int x, int y, tileType t){
        map[x][y] = t;
    }
    public tileType[][] getView(boolean[][] shown){
        tileType[][] view = new tileType[map.length-1][map.length-1];
        for(int i = 0; i<= map.length - 1; i++){
            for(int j = 0; j<= map[0].length - 1; j++){
                if(shown [i][j] == true){
                    view[i][j] = map[i][j];
                } else {
                    view[i][j] = tileType.UNKNOWN;
                }
            }
        }
        return view;
    }
    public void generate(){
        
    }
    public boolean setWinningTile(int n){
        return false;
    }
}
