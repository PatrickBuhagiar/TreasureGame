/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game;
import com.map.Map;
import com.map.TableMapRender;
/**
 *
 * @author Jake
 */
public class GameLauncher {
      public static void main(String[]args){
          Game g = Game.getInstance();
          Map m = new Map();
          m.setMapSize(5, 5);
          m.generate();
          TableMapRender tmr = new TableMapRender(m.getMap(),"","");
          System.out.println(tmr.generateCode());
      }
}
