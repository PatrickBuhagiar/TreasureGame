/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map;
import com.map.business.iMap;
import com.map.business.tileType;
import java.util.Random;

/**
 *
 * @author Jake
 */
public class Map implements iMap {
    private tileType map [][];
    private final Random randomGenerator = new Random();
    public Map(){
        map = new tileType [5][5];
    }
    @Override
    public boolean setMapSize(int x, int y){
        this.map = new tileType [x][y];
        return true;
    }
    
    public tileType[][] getMap(){
        return map;
    }
    
    @Override
    public void generate(){
        for(int i = 0; i<= map.length - 1; i++){
            for (int j = 0; j<= map[0].length - 1; j++){
                int b = randomGenerator.nextInt(100);
                if(b%2 == 0){  map[i][j] = tileType.GRASS; } else{   map[i][j] = tileType.SEA; }
            }
        }
        setWinningTile(1);
    }
    public void setUnknown(){
        for(int i = 0; i<= map.length - 1; i++){
            for(int j = 0; j<= map[0].length - 1; j++){
                map[i][j] = tileType.UNKNOWN;
            }
        }
    }
    
    private boolean setWinningTile(int n){
        int x,y;
        if(n > 0){
            x = randomGenerator.nextInt(map.length);
            y = randomGenerator.nextInt(map[0].length);
            do{
               for(int i = 0; i<= map.length - 1; i++){
                   for(int j = 0; j<= map[0].length - 1; j++){
                       map[x][y] = tileType.TREASURE;
                   }
               }
               n--;
            }while(n > 0);
            return true;
        }
        return false;
    }
    
    @Override
    public tileType getTileType(int x, int y){
        return map[x][y];
    }
    
    @Override
    public void setTileType(int x, int y, tileType t){
        map[x][y] = t;
    }
}
