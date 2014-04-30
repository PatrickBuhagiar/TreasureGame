/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map;

import org.junit.After;
import com.position.Position;
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
    public void testGenerateCode() {
        System.out.println("generateCode");
        Map p = new Map();
        p.setUnknown();
        TableMapRender instance = new TableMapRender(p.getMap(),"","");
        String expResult = "<html style=\"display: table; margin: auto;\"><body style=\"display: table-cell; vertical-align: middle;\"><table><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td></tr><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td></tr><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td></tr><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td></tr><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\"></td></tr></table></body></html>";
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
        Position pos = new Position();
        pos.setPosition(x, y);
        instance.setPlayerPoint(pos);
        assertEquals(pos,instance.getPlayerPoint());
    }
    
}
