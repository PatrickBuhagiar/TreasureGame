/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map.htmlGenerator.business;

import java.util.ArrayList;
/**
 *
 * @author Jake
 */
public abstract class  Tag {
    protected String tagName;
    protected String cssStyle = null;
    public ArrayList<Tag> innerTag = null;
    public Tag(){
    }
    public Tag(String n){
        this.tagName = n;
    }
    
    public void setTagName(String name){
        this.tagName = name;
    }
    
    public String getTagName(){
        return tagName;
    }
    
    public void setCSSStyle(String css){
        this.cssStyle = css;
    }
    public String getCSSStyle(){
        return cssStyle;
    }
    
    public String getCloseTag(){
        return "</" + tagName + ">";
    }
    
    public String getOpenTag(){
        String output = "";
        output += "<" + tagName;
        if(cssStyle != null){
            output += " style=\"" + cssStyle + "\"";
        }
        output += ">";
        return output;
    }
}
