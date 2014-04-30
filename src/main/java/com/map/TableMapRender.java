/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map;
import com.map.business.htmlPage;
import com.map.business.tileType;
import com.map.htmlGenerator.*;
import com.map.htmlGenerator.business.Tag;
import java.util.ArrayList;
import com.position.Position;

/**
 *
 * @author Jake
 */
public class TableMapRender extends htmlPage {
      private int width, height;
    private tileType[][] map;
    private ArrayList<Tag> tags = new ArrayList<Tag>();
    private Position playerPoint = null;
    public TableMapRender(tileType [][] mapArray, String htmlStyle, String bodyStyle){
        this.map = mapArray;
    }
    
    public TableMapRender(String htmlStyle, String bodyStyle){
        super.setHtmlStyle(htmlStyle);
        super.setBodyStyle(bodyStyle);
    }
    public void setPlayerPoint(Position p){
        this.playerPoint = p;
    }
    public Position getPlayerPoint(Position p){
        return p;
    }
      public String generateCode(){
       super.htmlTag.setCSSStyle("display: table; margin: auto;");
       super.bodyTag.setCSSStyle("display: table-cell; vertical-align: middle;");
       String o = "";
       Tag tableTag = new Table();
       o = o + htmlTag.getOpenTag();
       o = o + bodyTag.getOpenTag();
       Tag trTag = new Tr();
       Tag tdTag = new Td();
       o = o + tableTag.getOpenTag();
       for(int i = 0; i<= map.length - 1; i++){
           trTag = new Tr();
           o = o + trTag.getOpenTag();
           for(int j = 0; j<= map[0].length - 1; j++){
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
               o = o + tdTag.getOpenTag();
               if(playerPoint != null){
                   if(i == playerPoint.getX() && j == playerPoint.getY()){
                       o = o + "&#167;"; // Show Player Icon
                   }
               }
               o = o + tdTag.getCloseTag();
           }
           o = o + trTag.getCloseTag();
       }
       o = o + tableTag.getCloseTag();
       o = o + bodyTag.getCloseTag();
       o = o + htmlTag.getCloseTag();
       return o;
   }
}
