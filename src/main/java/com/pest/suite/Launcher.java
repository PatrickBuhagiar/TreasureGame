/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pest.suite;
import java.io.IOException;
/**
 *
 * @author Jake
 */
public class Launcher {
    public static void main(String[]args){
        Game g = Game.getInstance();
        try{
            g.GameMethod();
        } catch(IOException e){
            
        }
    }
}
