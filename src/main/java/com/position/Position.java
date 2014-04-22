/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.position;

/**
 *
 * @author Patrick
 */
public class Position {
    private static int x = 0;
    private static int y = 0;
    
    public void setPosition(int X, int Y){
        x=X;
        y=Y;
    }
    
    public static int getX(){
        return x;
    }
    
    public static int getY(){
        return y;
    }
}
