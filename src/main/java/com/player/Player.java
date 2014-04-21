/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.player;
import com.position.Position;
import com.map.Map;
import java.util.Random;
import com.game.Game;

/**
 *
 * @author Patrick
 */
public class Player {
   private Position xy;
   private int id;
   private Map currentMap;
   private Game currentGame;

    public Player() {
    }
   
   public Player(int ID, Map map, Game game){
       id = ID;
       currentGame=game;
   }
   
   private void GenerateStart(){
       Random randomGenerator = new Random();
       int X = randomGenerator.nextInt(currentGame.getSize());
       int Y = randomGenerator.nextInt(currentGame.getSize());
       
   }
}
