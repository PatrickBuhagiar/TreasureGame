/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map;
import com.map.business.iMap;
import com.map.business.tileType;
/**
 *
 * @author Jake
 */
public class Map implements iMap {
    private int map [][];
    public Map(){
        map = new int [5][5];
    }
    public boolean setMapSize(int x, int y){
        this.map = new int [x][y];
        return true;
    }
    public void generate(){
        
    }
    public tileType getTileType(int x, int y){
        return tileType.UNKNOWN;
    }
}
