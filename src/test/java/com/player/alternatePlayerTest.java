/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.player;

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
public class alternatePlayerTest {
    
    public alternatePlayerTest() {
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
     * Test of getVisible method, of class alternatePlayer.
     */
    @Test
    public void testGetVisible() {
        System.out.println("getVisible");
        alternatePlayer instance = new alternatePlayer(2,0);
        boolean[][] expResult = null;
        boolean[][] result = instance.getVisible();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class alternatePlayer.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        alternatePlayer instance = new alternatePlayer(2,0);
        assertEquals(2, instance.getId());
    }

    /**
     * Test of setId method, of class alternatePlayer.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int n = 5;
        alternatePlayer instance = new alternatePlayer(2,0);
        instance.setId(n);
        assertEquals(instance.getId(),5);
    }

    /**
     * Test of goToStart method, of class alternatePlayer.
     */
    @Test
    public void testGoToStart() {
        System.out.println("goToStart");
        alternatePlayer instance = new alternatePlayer(5,5);
        instance.setStartPos(2, 2);
        instance.setPos(4, 4);
        instance.goToStart();
        assertEquals(instance.getX(),2);
        assertEquals(instance.getY(),2);
    }

    /**
     * Test of move method, of class alternatePlayer.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        char c = ' ';
        int s = 0;
        alternatePlayer instance = new alternatePlayer(2,5);
        instance.setPos(3, 3);
        instance.move('w', s);
        assertEquals(2, instance.getX());
        assertEquals(3, instance.getY());
        instance.move('s', s);
        assertEquals(3, instance.getX());
        assertEquals(3, instance.getY());
         instance.move('a', s);
        assertEquals(3, instance.getX());
        assertEquals(2, instance.getY());
         instance.move('d', s);
        assertEquals(3, instance.getX());
        assertEquals(3, instance.getY());
    }

    /**
     * Test of OutOfBounds method, of class alternatePlayer.
     */
    @Test
    public void testOutOfBounds() {
        System.out.println("OutOfBounds");
        int i = 0;
        int j = 0;
        int s = 0;
        alternatePlayer instance = new alternatePlayer(2,5);
        boolean expResult = false;
        boolean result = instance.OutOfBounds(4, 5, 5);
        assertEquals(expResult, result);
        expResult = false;
        result = instance.OutOfBounds(5, 4, 5);
        assertEquals(expResult, result);
        expResult = false;
        result = instance.OutOfBounds(-1, -1, 5);
        assertEquals(expResult, result);
        expResult = true;
        result = instance.OutOfBounds(3, 3, 5);
        assertEquals(expResult, result);
    }

    /**
     * Test of setPos method, of class alternatePlayer.
     */
    @Test
    public void testSetPos() {
        System.out.println("setPos");
        int i = 0;
        int j = 0;
        alternatePlayer instance = new alternatePlayer(2,5);
        instance.setPos(i, j);
        assertEquals(i, instance.getX());
        assertEquals(j, instance.getY());
    }

    /**
     * Test of randomPos method, of class alternatePlayer.
     */
    @Test
    public void testRandomPos() {
        System.out.println("randomPos");
        int size = 5;
        alternatePlayer instance = new alternatePlayer(2,size);
        int x = 4;
        int y = 4;
        instance.setPos(x, y);
        instance.randomPos(size);
        boolean expResult = (x == instance.getRandomPos(size));
        boolean expResult2 = (y == instance.getRandomPos(size));
        assertEquals(false,expResult);
        assertEquals(false,expResult2);
    }

    /**
     * Test of getRandomPos method, of class alternatePlayer.
     */
    @Test
    public void testGetRandomPos() {
        System.out.println("getRandomPos");
        alternatePlayer instance = new alternatePlayer(5,5);
        int x = instance.getRandomPos(5);
        boolean expResult = x < 5;
        assertEquals(true, expResult);
    }

    /**
     * Test of setStartPos method, of class alternatePlayer.
     */
    @Test
    public void testSetStartPos() {
        System.out.println("setStartPos");
        int i = 4;
        int j = 4;
        alternatePlayer instance = new alternatePlayer(2,5);
        instance.setStartPos(i, j);
        assertEquals(i,instance.getX());
        assertEquals(j,instance.getY());
        boolean [] [] v = instance.getVisible();
        assertEquals(v[i][j],true);
    }

    /**
     * Test of setY method, of class alternatePlayer.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        alternatePlayer instance = new alternatePlayer(2,0);
        instance.setY(5);
        assertEquals(5, instance.getY());
    }

    /**
     * Test of getY method, of class alternatePlayer.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        alternatePlayer instance = new alternatePlayer(2,0);
        instance.setY(5);
        assertEquals(5, instance.getY());
    }

    /**
     * Test of setX method, of class alternatePlayer.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        alternatePlayer instance = new alternatePlayer(2,0);
        instance.setX(5);
        assertEquals(5, instance.getX());
    }

    /**
     * Test of getX method, of class alternatePlayer.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        alternatePlayer instance = new alternatePlayer(2,0);
        instance.setX(5);
        assertEquals(5, instance.getX());
    }
    
}
