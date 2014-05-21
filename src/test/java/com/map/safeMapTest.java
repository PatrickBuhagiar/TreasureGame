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
public class safeMapTest {
    
    public safeMapTest() {
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
        safeMap instance = new safeMap();
        boolean expResult = true;
        boolean result = instance.setMapSize(x, y);
        assertEquals(true, result);
    }

    /**
     * Test of getMap method, of class Map.
     */
    @Test
    public void testGetMap() {
        System.out.println("getMap");
        safeMap instance = new safeMap();
        tileType[][] expResult = new tileType[5][5];
        tileType[][] result = instance.getMap();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of generate method, of class Map.
     */
    @Test
    public void testGenerate() {
        System.out.println("generate");
        safeMap instance = new safeMap();
        int mapSize = (instance.getMap().length - 1)*(instance.getMap()[0].length - 1);
        int maxBlue = ((10*mapSize)/100);
        int blueCount = 0;
        instance.generate();
        tileType [][] a = instance.getMap();
        System.out.println("Max Blue: " + maxBlue);
        for(int i = 0; i<= a.length - 1; i++){
            for(int j = 0; j<= a[0].length - 1; j++){
                if(a[i][j] == tileType.SEA){
                    blueCount++;
                }
            }
        }
        System.out.println("Blue Count: " + blueCount);
        assertTrue(blueCount <= maxBlue);
    }

    /**
     * Test of setUnknown method, of class Map.
     */
    @Test
    public void testsetUnknown() {
        System.out.println("setUnknown");
        safeMap instance = new safeMap();
        instance.setUnknown();
        for(int i = 0; i <= instance.getMap().length - 1; i++){
            for(int j = 0; j<= instance.getMap()[0].length - 1; j++){
                assertEquals(instance.getMap()[i][j],tileType.UNKNOWN);
            }
        }
    }
    
    /**
     * Test of setWinningTile method, of class Map.
     */
    @Test
    public void testsetWinningTile() {
        System.out.println("setWinningTile");
        safeMap instance = new safeMap();
        instance.setWinningTile(1);
        int counter = 0;
        for(int i = 0; i <= instance.getMap().length - 1; i++){
            for(int j = 0; j<= instance.getMap()[0].length - 1; j++){
                if(instance.getMap()[i][j] == tileType.TREASURE){
                    counter++;
                }
            }
        }
        assertEquals(1,counter);
        assertEquals(instance.setWinningTile(1), true);
        assertEquals(instance.setWinningTile(-1), false);
    }

    /**
     * Test of getTileType method, of class Map.
     */
    @Test
    public void testgetTileType() {
        System.out.println("getTileType");
        int x = 0;
        int y = 0;
        safeMap instance = new safeMap();
        instance.setTileType(2, 2, tileType.SEA);
        tileType expResult = tileType.SEA;
        tileType result = instance.getTileType(2, 2);
        assertEquals(expResult, result);
    }

    /**
     * Test of setTileType method, of class Map.
     */
    @Test
    public void testsetTileType() {
        System.out.println("setTileType");
        safeMap instance = new safeMap();
        instance.setTileType(2, 2, tileType.GRASS);
        tileType expResult = tileType.GRASS;
        tileType result = instance.getTileType(2, 2);
        assertEquals(expResult,result);
    }
}
