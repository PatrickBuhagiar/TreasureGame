/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.player;
import com.position.Position;
import java.util.Random;
import com.pest.suite.Game;
import com.map.business.tileType;
import java.io.IOException;

/**
 *
 * @author Patrick
 */
public class Player {
    private int id;
    private Position currentPosition;
    private Game currentGame;
    
    public Player(int ID, Game game){
        id = ID;
        currentGame = game;
        currentPosition = generateStart();
    }
    
    private Position generateStart(){
        Random randomGenerator = new Random();
        boolean loop = true;
        int X=0,Y=0;
        while (loop){
            X = randomGenerator.nextInt(currentGame.getSize());
            Y = randomGenerator.nextInt(currentGame.getSize());
            //Jake Arrange this
            if (currentGame.getMap().getTileType(X, Y) == tileType.GRASS){
                loop = false;
            }
        }
        Position currentPosition = new Position();
        currentPosition.setPosition(X, Y);
        return currentPosition;
    }
    
    public void Move() throws IOException{
        char step;
        boolean loop=true;
        int x = currentPosition.getX();
        int y = currentPosition.getY();
        
        while (loop){
            step = (char) System.in.read();
            if (step == 'w'){
                if(!currentPosition.OutOfBounds(x,y-1, currentGame)){
                    currentPosition.setPosition(x,y-1);
                    loop = false;
                }
            } else if (step == 'a'){
                if(!currentPosition.OutOfBounds(x-1,y, currentGame)){
                    currentPosition.setPosition(x-1,y);
                    loop = false;
                }
            } else if (step == 's'){
                if(!currentPosition.OutOfBounds(x,y+1, currentGame)){
                    currentPosition.setPosition(x,y+1);
                    loop = false;
                }
            } else if (step == 'd'){
                if(!currentPosition.OutOfBounds(x+1,y, currentGame)){
                    currentPosition.setPosition(x+1,y);
                    loop = false;
                }
            }
        }
    }
}
