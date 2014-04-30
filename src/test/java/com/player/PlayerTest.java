/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.player;
import com.pest.suite.Game;
import com.map.Map;
import java.io.FileNotFoundException;
import com.map.business.tileType;
import com.position.Position;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jake
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ResetPosition method, of class Player.
     */
    @Test
    public void testResetPosition() {
        System.out.println("ResetPosition");
        try{
            Game g = Game.getInstance();
            Map m = new Map();
            m.setMapSize(5, 5);
            m.generate();
            g.setMap(m);
            g.setSize(5);
            Player instance = new Player(2,g);
            Position ExpResult = instance.getStartPosition();
            instance.movePlayer('w');
            Position result = instance.getPos();
            instance.ResetPosition();
            assertEquals(ExpResult, instance.getPos());
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test of getPos method, of class Player.
     */
    @Test
    public void testGetPos() {
        System.out.println("getPos");
        try{
            Game g = Game.getInstance();
            Map m = new Map();
            m.setMapSize(5, 5);
            m.generate();
            g.setMap(m);
            g.setSize(5);
            Player instance = new Player(2,g);
            Position ExpResult = new Position();
            ExpResult.setPosition(3, 3);
            instance.getPos().setPosition(3, 3);
            Position result = instance.getPos();
            assertEquals(ExpResult.getX(), result.getX());
            assertEquals(ExpResult.getY(), result.getY());
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test of movePlayer method, of class Player.
     */
    @Test
    public void testMovePlayer() throws Exception {
        System.out.println("movePlayer");
        try{
            Game g = Game.getInstance();
            Map m = new Map();
            m.setMapSize(5, 5);
            m.generate();
            g.setMap(m);
            g.setSize(5);
            Player instance = new Player(2,g);
            Position ExpResult = instance.getStartPosition();
            
            instance.movePlayer('w');
            ExpResult.setPosition(ExpResult.getX() - 1, ExpResult.getY());
            Position result = instance.getPos();
            assertEquals(ExpResult, result);
            
            ExpResult = instance.getPos();
            instance.movePlayer('s');
            ExpResult.setPosition(ExpResult.getX() + 1, ExpResult.getY());
            result = instance.getPos();
            assertEquals(ExpResult, result);
            
            ExpResult = instance.getPos();
            instance.movePlayer('d');
            ExpResult.setPosition(ExpResult.getX(), ExpResult.getY() + 1);
            result = instance.getPos();
            assertEquals(ExpResult, result);
            
            ExpResult = instance.getPos();
            instance.movePlayer('a');
            ExpResult.setPosition(ExpResult.getX(), ExpResult.getY() - 1);
            result = instance.getPos();
            assertEquals(ExpResult, result);
            
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * Test of setID method, of class Player.
     */
    @Test
    public void testsetID() {
        System.out.println("setID");
        try{
            int expResult = 3;
            Game g = Game.getInstance();
            Map m = new Map();
            m.setMapSize(5, 5);
            m.generate();
            g.setMap(m);
            g.setSize(5);
            Player instance = new Player(2,g);
            instance.setID(expResult);
            int result = instance.getID();
            assertEquals(expResult, result);
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Test of getID method, of class Player.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        try{
        int expResult = 3;
        Game g = Game.getInstance();
        Map m = new Map();
        m.setMapSize(5, 5);
        m.generate();
        g.setMap(m);
        g.setSize(5);
        Player instance = new Player(2,g);
        instance.setID(expResult);
        int result = instance.getID();
        assertEquals(expResult, result);
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test of checkStatus method, of class Player.
     */
    @Test
    public void testCheckStatus() {
        System.out.println("checkStatus");
        try{
            Game g = Game.getInstance();
            g.setSize(5);
            Player instance = new Player(2,g);
            Map m = new Map();
            m.setMapSize(5, 5);
            m.generate();
            g.setMap(m);
            m.getMap()[1][3] = tileType.GRASS;
            instance.getPos().setPosition(1, 3);
            assertEquals('C',instance.checkStatus());
            m.getMap()[2][3] = tileType.SEA;
            instance.getPos().setPosition(2, 3);
            assertEquals('L',instance.checkStatus());
            m.getMap()[3][3] = tileType.TREASURE;
            instance.getPos().setPosition(3, 3);
            assertEquals('W',instance.checkStatus());
            m.getMap()[4][3] = tileType.UNKNOWN;
            instance.getPos().setPosition(4, 3);
            assertEquals('C',instance.checkStatus());
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
}
