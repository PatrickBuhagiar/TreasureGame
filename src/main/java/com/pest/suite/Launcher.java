package com.pest.suite;
import com.map.Map;
import com.map.TableMapRender;
/**
 * This class constitutes the main entry point for PESTSuite.
 * @author mark
 *
 */

public class Launcher {
	/**
	 * Entry point.  Creates a Launcher instance and activates it.
	 * @param args
	 */
	public static void main(String[] args) {
            Map m = new Map();
            m.setMapSize(5, 5);
            m.generate();
            TableMapRender tmr = new TableMapRender(m.getMap(),"","");
            System.out.println(tmr.generateCode());
	}
	
}
