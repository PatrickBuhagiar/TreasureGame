/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map;

import com.map.business.MapCreator;
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
public class MapConcreteCreatorTest {
    
    public MapConcreteCreatorTest() {
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
     * Test of setMap method, of class MapConcreteCreator.
     */
    @Test
    public void testSetMap() {
        System.out.println("setMap");
        MapConcreteCreator instance = new MapConcreteCreator();
        instance.setMap(1, 5);
        assertEquals(5,instance.getMap().getMap().length);
        assertNotNull(instance.getMap());
        assertNotNull(instance.setMap(1, 5));
        assertNotNull(instance.setMap(2, 5));
        assertNotNull(instance.setMap(3, 5));
        assertNull(instance.setMap(4, 5));
        
        //assertNull(instance.setMap(1, 2));
    }

    /**
     * Test of getMap method, of class MapConcreteCreator.
     */
    @Test
    public void testGetMap() {
        System.out.println("getMap");
        MapConcreteCreator instance = new MapConcreteCreator();
        instance.setMap(1, 5);
        assertEquals(5,instance.getMap().getMap().length);
        assertNotNull(instance.getMap());
        assertNotNull(instance.setMap(1, 5));
        assertNotNull(instance.setMap(2, 5));
        assertNotNull(instance.setMap(3, 5));
        assertNull(instance.setMap(4, 5));
    }
    
}
