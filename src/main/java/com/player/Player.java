/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.player;
import com.position.Position;
import java.util.Random;
import com.game.Game;
import com.map.business.tileType;
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
}
