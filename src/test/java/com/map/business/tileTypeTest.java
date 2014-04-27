/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map.business;

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
public class tileTypeTest {
    
    public tileTypeTest() {
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
     * Test of values method, of class tileType.
     */
    @Test
    public void testSeaValue() {
        System.out.println("testSea");
        assertNotNull(tileType.SEA);
    }
    /**
     * Test of values method, of class tileType.
     */
    @Test
    public void testGrassValue() {
        System.out.println("testGrass");
        assertNotNull(tileType.GRASS);
    }
    /**
     * Test of values method, of class tileType.
     */
    @Test
    public void testUknownValue() {
        System.out.println("testUnknown");
        assertNotNull(tileType.UNKNOWN);
    }
    /**
     * Test of values method, of class tileType.
     */
    @Test
    public void testTreasureValue() {
        System.out.println("testTreasure");
        assertNotNull(tileType.TREASURE);
    }
}
