/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map;
import com.map.business.MapCreator;
import com.map.business.iMap;
import com.map.business.tileType;
/**
 *
 * @author Jake
 */
public class safeMap extends MapCreator implements iMap {
    public safeMap(){
        super.mapName = "Safe Map";
        super.map = new tileType [5][5];
    }
    @Override
    public void generate(){
        int mapSize = (map.length - 1)*(map[0].length - 1);
        int maxBlue = ((10*mapSize)/100);
        int blueCount = 0;
        for(int i = 0; i<= map.length - 1; i++){
            for (int j = 0; j<= map[0].length - 1; j++){
                int b = randomGenerator.nextInt(100);
                if(b%2 == 1 && blueCount < maxBlue){  
                    map[i][j] = tileType.SEA; blueCount++; 
                } 
                else{
                    map[i][j] = tileType.GRASS; 
                }
            }
        }
        setWinningTile(1);
    }
    @Override
    public boolean setWinningTile(int n){
        int x,y;
        if(n > 0){
            do{
                x = randomGenerator.nextInt(map.length);
                y = randomGenerator.nextInt(map[0].length);
                if(map[x][y] != tileType.SEA){
                    for(int i = 0; i<= map.length - 1; i++){
                        for(int j = 0; j<= map[0].length - 1; j++){
                            map[x][y] = tileType.TREASURE;
                            n--;
                        }
                    }
                }
            }while(n > 0);
            return true;
        }
        return false;
    }
}
