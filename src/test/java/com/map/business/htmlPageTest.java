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
public class htmlPageTest {
    
    public htmlPageTest() {
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
     * Test of setHtmlStyle method, of class htmlPage.
     */
    @Test
    public void testSetHtmlStyle() {
        System.out.println("setHtmlStyle");
        String style = "style=500px;";
        htmlPage instance = new htmlPageImpl();
        instance.setHtmlStyle(style);
        assertEquals(style,instance.getHtmlStyle());
    }

    /**
     * Test of setBodyStyle method, of class htmlPage.
     */
    @Test
    public void testSetBodyStyle() {
        System.out.println("setBodyStyle");
        String style = "style=500px;";
        htmlPage instance = new htmlPageImpl();
        instance.setBodyStyle(style);
        assertEquals(style,instance.getBodyStyle());
    }
    
    /**
     * Test of getHtmlStyle method, of class htmlPage.
     */
    @Test
    public void testGetHtmlStyle() {
        System.out.println("setHtmlStyle");
        String style = "style=500px;";
        htmlPage instance = new htmlPageImpl();
        instance.setHtmlStyle(style);
        assertEquals(style,instance.getHtmlStyle());
    }

    /**
     * Test of getBodyStyle method, of class htmlPage.
     */
    @Test
    public void testGetBodyStyle() {
        System.out.println("setBodyStyle");
        String style = "style=500px;";
        htmlPage instance = new htmlPageImpl();
        instance.setBodyStyle(style);
        assertEquals(style,instance.getBodyStyle());
    }

    public class htmlPageImpl extends htmlPage {
    }
}
