/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.map.business;

/**
 *
 * @author Jake
 */
public interface iMap {
    public boolean setMapSize(int x, int y);
    public void generate();
    public tileType getTileType(int x, int y);
    public void setTileType(int x, int y, tileType t);
    public tileType[][] getMap();
}
