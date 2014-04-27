/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map;
import com.map.business.htmlPage;
import com.map.business.tileType;
import com.map.htmlGenerator.*;


/**
 *
 * @author Jake
 */
public class TableMapRender extends htmlPage {
    private int width, height;
    private tileType[][] map;
    public TableMapRender(tileType [][] mapArray, String htmlStyle, String bodyStyle){
        this.map = mapArray;
        this.height = mapArray.length;
        this.width = mapArray[0].length;
        super.setHtmlStyle(htmlStyle);
        super.setBodyStyle(bodyStyle);
    }
    public String generateCode(){
        super.htmlTag.setCSSStyle("display: table; margin: auto;");
        super.bodyTag.setCSSStyle("display: table-cell; vertical-align: middle;");
        Table tableTag = new Table();
        Tr trTag;
        Td tdTag;
        for(int i = 0; i<= height; i++){
            trTag = new Tr();
            for(int j = 0; j<= width; j++){
                tdTag = new Td();
                switch(map[i][j]){
                    case GRASS:
                         tdTag.setCSSStyle("width:50px;height:50px;background-color:#0C0;padding:10px;margin:10px;");
                        break;
                    case UNKNOWN:
                         tdTag.setCSSStyle("width:50px;height:50px;background-color:#999;padding:10px;margin:10px;");
                        break;
                    case SEA:
                         tdTag.setCSSStyle("width:50px;height:50px;background-color:#03F;padding:10px;margin:10px;");
                        break;
                    case TREASURE:
                         tdTag.setCSSStyle("width:50px;height:50px;background-color:#FF0;padding:10px;margin:10px;");
                        break;
                }
                trTag.placeTag(tdTag);
            }
            tableTag.placeTag(trTag);
        }
        bodyTag.placeTag(tableTag);
        htmlTag.placeTag(bodyTag);
        return htmlTag.getCode();
    }
}
