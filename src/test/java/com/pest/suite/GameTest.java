/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pest.suite;

import com.map.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Patrick
 */
public class GameTest {
    
    public GameTest() {
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
     * Test of setPlayers method, of class Game.
     */
    @Test
    public void testSetPlayers() {
        System.out.println("setPlayers");
        int x = 5;
        Game instance = Game.getInstance();
        instance.setPlayers(x);
        assertEquals(instance.getPlayers(), x);
    }

    /**
     * Test of setSize method, of class Game.
     */
    @Test
    public void testSetSize() {
        System.out.println("setSize");
        int x = 4;
        Game instance = Game.getInstance();
        instance.setSize(x);
        assertEquals(instance.getSize(), x);
    }

    /**
     * Test of getPlayers method, of class Game.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        Game instance = Game.getInstance();
        instance.setPlayers(4);
        int expResult = 4;
        int result = instance.getPlayers();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class Game.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Game instance = Game.getInstance();
        instance.setSize(6);
        int expResult = 6;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }


    
    /**
     * Test of getMap method, of class Game.
     */
    @Test
    public void testGetMap() {
        System.out.println("getMap");
        Game instance = Game.getInstance();
        Map expResult = new Map();
        instance.setMap(expResult);
        Map result = instance.getMap();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMap method, of class Game.
     */
    @Test
    public void testSetMap() {
        System.out.println("setMap");
        Map m = new Map();
        Game instance = Game.getInstance();;
        instance.setMap(m);
        assertEquals(instance.getMap(), m);
    }
    
}
