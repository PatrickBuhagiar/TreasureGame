/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map;

import com.map.business.tileType;
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
public class MapTest {
    
    public MapTest() {
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
     * Test of setMapSize method, of class Map.
     */
    @Test
    public void testSetMapSize() {
        System.out.println("setMapSize");
        int x = 0;
        int y = 0;
        Map instance = new Map();
        boolean expResult = false;
        boolean result = instance.setMapSize(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMap method, of class Map.
     */
    @Test
    public void testGetMap() {
        System.out.println("getMap");
        Map instance = new Map();
        tileType[][] expResult = null;
        tileType[][] result = instance.getMap();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generate method, of class Map.
     */
    @Test
    public void testGenerate() {
        System.out.println("generate");
        Map instance = new Map();
        instance.generate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnknown method, of class Map.
     */
    @Test
    public void testSetUnknown() {
        System.out.println("setUnknown");
        Map instance = new Map();
        instance.setUnknown();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTileType method, of class Map.
     */
    @Test
    public void testGetTileType() {
        System.out.println("getTileType");
        int x = 0;
        int y = 0;
        Map instance = new Map();
        tileType expResult = null;
        tileType result = instance.getTileType(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTileType method, of class Map.
     */
    @Test
    public void testSetTileType() {
        System.out.println("setTileType");
        int x = 0;
        int y = 0;
        tileType t = null;
        Map instance = new Map();
        instance.setTileType(x, y, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
