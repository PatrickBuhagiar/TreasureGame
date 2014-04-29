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
        String style = "";
        htmlPage instance = new htmlPageImpl();
        instance.setHtmlStyle(style);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBodyStyle method, of class htmlPage.
     */
    @Test
    public void testSetBodyStyle() {
        System.out.println("setBodyStyle");
        String style = "";
        htmlPage instance = new htmlPageImpl();
        instance.setBodyStyle(style);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class htmlPageImpl extends htmlPage {
    }
    
}
