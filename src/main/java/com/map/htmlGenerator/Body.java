/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map.htmlGenerator;
import com.map.htmlGenerator.business.Tag;
/**
 *
 * @author Jake
 */
public class Body extends Tag  {
    public Body(){
        super.tagName = "body";
    }
    @Override
    public String getOpenTag(){
        String output = "";
        output += "<" + tagName;
        if(cssStyle != null){
            output += "onload=\"JavaScript:timedRefresh(5000);\" style=\"" + cssStyle + "\"";
        }
        output += ">";
        return output;
    }
}
