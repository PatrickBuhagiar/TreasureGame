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
    private Random randomGenerator = new Random();
    public Map(){
        map = new tileType [5][5];
    }
    public boolean setMapSize(int x, int y){
        this.map = new tileType [x][y];
        return true;
    }
    public void generate(){
        int randomX = randomGenerator.nextInt(map.length);
        int randomY = randomGenerator.nextInt(map[0].length);
        map[randomX][randomY] = tileType.TREASURE;
        // First create map without water.
        for(int i = 0; i<= map.length - 1; i++){
            for(int j = 0; j<= map[0].length - 1; j++){
                map[i][j] = tileType.GRASS;
            }
        }
        recursiveDivisor(map.length, map[0].length);
    }
    public String outputMap(){
        String output = "";
        output += "<html>";
        return "";
    }
    
    public tileType getTileType(int x, int y){
        return tileType.UNKNOWN;
    }
    
    /* Recursive Divisor Algorithm for Maze Generation */
    public void recursiveDivisor(int width, int height){
        boolean direction = randomGenerator.nextBoolean();
        int randomWater = randomGenerator.nextInt(height);
        int randomGrass = randomGenerator.nextInt(width);
        if(direction == false){
            splitMapVertical(randomWater, randomGrass);
        } else {
            splitMapHorizontal(randomWater,randomGrass);
        }
    }
    public void splitMapVertical(int randomWater, int randomGrass){
        for(int i = 0; i<= map.length -1; i++){
            // Create a random hole in the wall
            if(i == randomGrass){
                map[i][randomWater] = tileType.GRASS;
            } else {
                map[i][randomWater] = tileType.SEA;
            }
        }
        recursiveDivisor(map.length-randomWater,map[0].length);
    }
    public void splitMapHorizontal(int randomWater, int randomGrass){
        for(int i = 0; i<= map.length -1; i++){
            // Create a random hole in the wall
            if(i == randomGrass){
                map[randomWater][i] = tileType.GRASS;
            } else {
                map[randomWater][i] = tileType.SEA;
            }
        }
        recursiveDivisor(map.length, map.length-randomWater);
    }
}
