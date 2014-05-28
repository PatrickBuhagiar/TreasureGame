/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.player;
import java.util.Random;
/**
 *
 * @author Jake
 */
public class alternatePlayer {
    private int Id;
    private int start_x = -1;
    private int start_y = -1;
    private int x,y;
    boolean [][] visible;
    public alternatePlayer(int n, int s){
        this.Id = n;
        visible = new boolean[s][s];
        for(int i = 0; i<= visible.length - 1; i++){
            for(int j = 0; j<= visible[i].length - 1; j++){
                visible[i][j] = false;
            }
        }
    }
    public boolean[][] getVisible(){
        return visible;
    }
    public int getId(){
        return Id;
    }
    public void goToStart(){
        x = start_x;
        y = start_y;
        makeVisible();
    }
    /* Make a Tile Visible */
    private void makeVisible(){
        visible[x][y] = true;
    }
    /* Moves the Player and checks if he is out of bounds.
        @param c Character input
        @param s Size
    */
    public boolean move(char c, int s){
        switch (c){
            case 'w':
                if(OutOfBounds(x-1,y,s)){
                    System.out.println(">> Move out of Bounds! Please Try again!");
                    return false;
                }
                x = x - 1;
                makeVisible();
                return true;
            case 'a':
                if(OutOfBounds(x,y-1,s)){
                    System.out.println(">> Move out of Bounds! Please Try again!");
                    return false;
                }
                y = y - 1;
                makeVisible();
                return true;
            case 's':
                if(OutOfBounds(x+1,y,s)){
                    System.out.println(">> Move out of Bounds! Please Try again!");
                    return false;
                }
                x = x + 1;
                makeVisible();
                return true;
            case 'd':
                if(OutOfBounds(x,y+1,s)){
                    System.out.println(">> Move out of Bounds! Please Try again!");
                    return false;
                }
                y = y + 1;
                makeVisible();
                return true;
            default:
                System.out.println(">> Invalid Key, Please try again");
                return false;
        }
    }
    
    /* Checks if two coordinates are out of bounds */
    public boolean OutOfBounds(int i, int j, int s){
        return ((j<0) || (j > s-1 ) || ( i<0 ) || (i > s - 1));
    }
    
    /* Sets the Position for the Player 
        @param i X-Coordinate
        @param j Y-Coordinate
    */
    
    public void setPos(int i, int j){
        x = i;
        y = j;
        makeVisible();
    }
    
    /* Generates Random Position and if there exists no start, position - sets the Start Position */
    public void randomPos(int size){
        Random r = new Random();
        x = r.nextInt(size - 1);
        y = r.nextInt(size - 1);
        if(start_x == -1 && start_y == -1){
            start_x = x;
            start_y = y;
            makeVisible();
        }
        makeVisible();
    }
    public int getRandomPos(int size){
        Random r = new Random();
        return r.nextInt(size - 1);
    }
    public void setStartPos(int i, int j){
        x = i;
        y = j;
        start_x = x;
        start_y = y;
        makeVisible();
    }
    public void setY(int n){
        this.y = n;
    }
    public int getY(){
        return y;
    }
    public void setX(int n){
        this.x = n;
    }
    public int getX(){
        return x;
    }
}
