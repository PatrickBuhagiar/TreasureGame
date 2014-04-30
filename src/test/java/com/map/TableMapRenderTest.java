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
    public void testGenerateCode() {
        System.out.println("generateCode");
        Map p = new Map();
        p.setUnknown();
        TableMapRender instance = new TableMapRender(p.getMap(),"","");
        System.out.println(instance.generateCode());
        String expResult = "<html style=\"display: table; margin: auto;\"><body style=\"display: table-cell; vertical-align: middle;\"><table><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">0,0</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">0,1</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">0,2</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">0,3</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">0,4</td></tr><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">1,0</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">1,1</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">1,2</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">1,3</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">1,4</td></tr><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">2,0</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">2,1</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">2,2</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">2,3</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">2,4</td></tr><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">3,0</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">3,1</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">3,2</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">3,3</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">3,4</td></tr><tr><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">4,0</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">4,1</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">4,2</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">4,3</td><td style=\"width:50px;height:50px;background-color:#999;padding:10px;margin:10px;\">4,4</td></tr></table></body></html>";
        String result = instance.generateCode();
        assertEquals(expResult, result);
    }
    
}
