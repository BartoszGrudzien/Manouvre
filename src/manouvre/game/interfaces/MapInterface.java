/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manouvre.game.interfaces;

/**
 *
 * @author Piotr
 */
public interface MapInterface {
    
    public TerrainInterface[][] getTerrains();
    
    TerrainInterface getTerrainAtXY(int x, int y);
    
    
    
}
