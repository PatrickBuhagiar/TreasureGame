/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.io;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;

/**
 *
 * @author Jake
 */
public class PlayerSave {
    private String dir = "";
    public PlayerSave(String d){
        this.dir = d;
    }
    public void saveFile() throws FileNotFoundException{
        try{
            File file = new File("C:\\file.txt");
            file.getParentFile().mkdirs();
            PrintWriter writer = new PrintWriter(file);
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
