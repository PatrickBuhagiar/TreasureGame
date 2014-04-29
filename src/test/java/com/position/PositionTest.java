/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.position;

import com.pest.suite.Game;
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
public class PositionTest {
    
    public PositionTest() {
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
     * Test of setPosition method, of class Position.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int X = 4;
        int Y = 3;
        Position instance = new Position();
        instance.setPosition(X, Y);
        // Test X
        assertEquals(X,instance.getX());
        // Test Y
        assertEquals(Y,instance.getY());
    }

    /**
     * Test of getX method, of class Position.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        int X = 4;
        int Y = 3;
        Position instance = new Position();
        instance.setPosition(X, Y);
        // Test X
        assertEquals(X,instance.getX());
    }

    /**
     * Test of getY method, of class Position.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        int X = 4;
        int Y = 3;
        Position instance = new Position();
        instance.setPosition(X, Y);
        // Test Y
        assertEquals(Y,instance.getY());
    }

    /**
     * Test of OutOfBounds method, of class Position.
     */
    @Test
    public void testOutOfBounds() {
        System.out.println("OutOfBounds");
        int x = 0;
        int y = 0;
        //Game 
        //Position instance = new Position();
        boolean expResult = false;
        //boolean result = instance.OutOfBounds(x, y, currentGame);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
