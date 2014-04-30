/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.position;

import com.pest.suite.Game;
/**
 *
 * @author Patrick
 */
public class Position {
    private int x;
    private int y;

    
    public void setPosition(int X, int Y){
        x=X;
        y=Y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean OutOfBounds(int x, int y, Game currentGame){
        if (y<0||y>currentGame.getSize()||x<0||x>currentGame.getSize()){
            return true;
        } else return false;
    }
}


