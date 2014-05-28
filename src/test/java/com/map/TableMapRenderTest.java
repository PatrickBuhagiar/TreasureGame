/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map;

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
public class TableMapRenderTest {
    
    public TableMapRenderTest() {
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
     * Test of generateCode method, of class TableMapRender.
     */
    @Test
    public void testSetPlayerPoints() {
        System.out.println("setPlayerPoints");
        Map p = new Map();
        p.setUnknown();
        TableMapRender instance = new TableMapRender(p.getMap(),"","");
        instance.setPlayerPoint(2, 2);
        int [] playerPoints = instance.getPlayerPoints();
        assertEquals(playerPoints[0],2);
        assertEquals(playerPoints[1],2);
    }
    
    /**
     * Test of generateCode method, of class TableMapRender.
     */
    @Test
    public void testGetPlayerPoints() {
        System.out.println("getPlayerPoints");
        Map p = new Map();
        p.setUnknown();
        TableMapRender instance = new TableMapRender(p.getMap(),"","");
        instance.setPlayerPoint(2, 2);
        int [] playerPoints = instance.getPlayerPoints();
        assertEquals(playerPoints[0],2);
        assertEquals(playerPoints[1],2);
    }
    
    /**
     * Test of generateCode method, of class TableMapRender.
     */
    @Test
    public void testGenerateCode() {
        System.out.println("generateCode");
        Map p = new Map();
        p.setUnknown();
        TableMapRender instance = new TableMapRender(p.getMap(),"","");
        System.out.println(instance.generateCode());
        String expResult = "<html style=\"display: table; margin: auto;\"><head><script type=\"text/JavaScript\"><!--function timedRefresh(timeoutPeriod) {        setTimeout(\"location.reload(true);\",timeoutPeriod);}//   --></script></head><bodyonload=\"JavaScript:timedRefresh(5000);\" style=\"display: table-cell; vertical-align: middle;\"><table><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td></tr><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td></tr><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td></tr><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td></tr><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td></tr></table></body></html>";
        String result = instance.generateCode();
        assertEquals(expResult, result);
    }
    /**
     * Test of getPlayerPoint method, of class TableMapRender.
     */
    @Test
    public void testgetPlayerPoint() {
        System.out.println("getPlayerPoint");
        Map p = new Map();
        p.setUnknown();
        TableMapRender instance = new TableMapRender(p.getMap(),"","");
        int x = 3;
        int y = 3;
        //Position pos = new Position();
        //pos.setPosition(x, y);
        //instance.setPlayerPoint(pos);
        //assertEquals(pos,instance.getPlayerPoint());
    }
    
}
