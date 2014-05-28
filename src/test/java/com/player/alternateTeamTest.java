/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.player;

import java.util.ArrayList;
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
public class alternateTeamTest {
    
    public alternateTeamTest() {
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
     * Test of getPlayerList method, of class alternateTeam.
     */
    @Test
    public void testGetPlayerList() {
        System.out.println("getPlayerList");
        ArrayList<alternatePlayer> p = new ArrayList<alternatePlayer>();
        p.add(new alternatePlayer(1,2));
        p.add(new alternatePlayer(1,2));
        alternateTeam instance = new alternateTeam(0);
        instance.setPlayerList(p);
        assertEquals(p, instance.getPlayerList());
    }
    
    /**
     * Test of setPlayerList method, of class alternateTeam.
     */
    @Test
    public void testSetPlayerList() {
        System.out.println("setPlayerList");
        ArrayList<alternatePlayer> p = new ArrayList<alternatePlayer>();
        p.add(new alternatePlayer(1,2));
        p.add(new alternatePlayer(1,2));
        alternateTeam instance = new alternateTeam(0);
        instance.setPlayerList(p);
        assertEquals(p, instance.getPlayerList());
    }
    

    /**
     * Test of getId method, of class alternateTeam.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        alternateTeam instance = null;
        int expResult = 2;
        instance = new alternateTeam(expResult);
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of setId method, of class alternateTeam.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        alternateTeam instance = new alternateTeam(0);
        instance.setId(5);
        int result = instance.getId();
        assertEquals(5, result);
    }

    /**
     * Test of getSize method, of class alternateTeam.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        alternateTeam instance = new alternateTeam(2);
        instance.addPlayer(new alternatePlayer(1,5));
        instance.addPlayer(new alternatePlayer(1,5));
        assertEquals(2, instance.getSize());
    }
    
    /**
     * Test of addPlayer method, of class alternateTeam.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        alternateTeam instance = new alternateTeam(2);
        instance.addPlayer(new alternatePlayer(1,5));
        instance.addPlayer(new alternatePlayer(1,5));
        assertEquals(2, instance.getSize());
    }
}
