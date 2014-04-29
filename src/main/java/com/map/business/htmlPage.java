/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map.business;
import com.map.htmlGenerator.Html;
import com.map.htmlGenerator.Body;
import com.map.htmlGenerator.business.Tag;

/**
 * Abstract Class for an htmlPage; uses tags from HTMLGenerator
 * <html> and <body> tags are default implementation for any HTML page.
 * @author Jake
 */
public abstract class htmlPage {
    protected Tag htmlTag = new Html();
    protected Tag bodyTag = new Body();
    public htmlPage(){
        
    }
    public void setHtmlStyle(String style){
        this.htmlTag.setCSSStyle(style);
    }
    public void setBodyStyle(String style){
        this.bodyTag.setCSSStyle(style);
    }
    public String getHtmlStyle(){
        return htmlTag.getCSSStyle();
    }
    public String getBodyStyle(){
        return bodyTag.getCSSStyle();
    }
}
