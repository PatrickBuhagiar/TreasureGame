/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map.htmlGenerator.business;

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
public class TagTest {
    
    public TagTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("@BeforeClass - Testing Tag Class");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("@AfterClass - Testing Tag Class");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setTagName method, of class Tag.
     */
    @Test
    public void testSetTagName() {
        System.out.println("setTagName");
        String name = "html";
        String expResult = "html";
        Tag instance = new TagImpl();
        instance.setTagName(name);
        String result = instance.getTagName();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of getTagName method, of class Tag.
     */
    @Test
    public void testGetTagName() {
        System.out.println("getTagName");
        String name = "div";
        String expResult = "div";
        Tag instance = new TagImpl();
        instance.setTagName(name);
        String result = instance.getTagName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCSSStyle method, of class Tag.
     */
    @Test
    public void testSetCSSStyle() {
        System.out.println("setCSSStyle");
        String css = "style=\"width:500px\"";
        Tag instance = new TagImpl();
        instance.setCSSStyle(css);
        String result = instance.getCSSStyle();
        String expResult = "style=\"width:500px\"";
        assertEquals(result,expResult);
    }

    /**
     * Test of getCode method, of class Tag.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        Tag instance = new TagImpl();
        String expResult = "<html></html>";
        instance.setTagName("html");
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    public class TagImpl extends Tag {
    }
    
}
