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
public abstract class iMap {
    private tileType map [][];
    private final Random randomGenerator = new Random();
    public boolean setMapSize(int x, int y){
        this.map = new tileType [x][y];
        return true;
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
}
