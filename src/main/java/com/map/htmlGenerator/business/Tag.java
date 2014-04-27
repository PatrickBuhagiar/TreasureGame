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
    protected ArrayList<Tag> innerTag = null;
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
    public void placeTag(Tag t){
        innerTag = new ArrayList<Tag>();
        innerTag.add(t);
    }
    public void removeTag(Tag t){
        if(innerTag != null){
            innerTag.remove(t);
        }
        if(innerTag.isEmpty()){
            innerTag = null;
        }
    }
    public String getCode(){
        String output = "";
        String openTag = getOpenTag();
        output += openTag;
        if(innerTag != null){
            for(Tag item : innerTag){
                output += item.getCode();
            }
        }
        String closeTag = getCloseTag();
        output += closeTag;
        return output;
    }
    
    private String getCloseTag(){
        return "</" + tagName + ">";
    }
    
    private String getOpenTag(){
        String output = "";
        output += "<" + tagName;
        if(cssStyle != null){
            output += " style=\"" + cssStyle + "\"";
        }
        output += ">";
        return output;
    }
}
