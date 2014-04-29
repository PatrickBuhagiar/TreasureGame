/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map.htmlGenerator;

import com.map.htmlGenerator.business.Tag;
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
public class BodyTest {
    
    public BodyTest() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTagName method, of class Tag.
     */
    @Test
    public void testSetTagName() {
        System.out.println("setTagName");
        String name = "html";
        Tag instance = new Body();
        instance.setTagName(name);
        String expResult = name;
        String result = instance.getTagName();
        assertEquals(expResult,result);
    }

    /**
     * Test of getTagName method, of class Tag.
     */
    @Test
    public void testGetTagName() {
        System.out.println("getTagName");
        String name = "html";
        Tag instance = new Body();
        instance.setTagName(name);
        String expResult = name;
        String result = instance.getTagName();
        assertEquals(expResult,result);
    }

    /**
     * Test of setCSSStyle method, of class Tag.
     */
    @Test
    public void testSetCSSStyle() {
        System.out.println("setCSSStyle");
        String css = "style=\"width=200px;\"";
        Tag instance = new Body();
        instance.setCSSStyle(css);
        String expResult = css;
        String result = instance.getCSSStyle();
        assertEquals(expResult,result);
    }
    
}
