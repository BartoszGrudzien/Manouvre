/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manouvre.game;

import manouvre.game.interfaces.PositionInterface;
import manouvre.gui.MapGUI;

/**
 *
 * @author Piotr
 */
public class Position implements PositionInterface{

    
    private int column;
    private int row;
    
    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
    
    
    
    public Position(int column, int row) {
        this.column = column;
        this.row = row;
    }
    
    
     public  int convertColumnToMouseX(int column){
		return MapGUI.PIECES_START_X + MapGUI.SQUARE_WIDTH * column;
	}
	
	/**
	 * convert logical row into y coordinate
	 * @param row
	 * @return y coordinate for row
	 */
	public  int convertRowToMouseY(int row){
		return MapGUI.PIECES_START_Y + MapGUI.SQUARE_HEIGHT * (PositionInterface.ROW_8 - row);
	}
        
        /**
	 * calculate upper right corner of terrain
	 * @param 
	 * @return x coordinate for upper right corner  terrain	
	 */
       public  int getMouseX(){
		return MapGUI.PIECES_START_X + MapGUI.SQUARE_WIDTH * column;
	}
	
	/**
	 * calculate upper right corner of terrain
	 * @param 
	 * @return y coordinate for  upper right corner  terrain
	 */
	public  int getMouseY(){
		return MapGUI.PIECES_START_Y + MapGUI.SQUARE_HEIGHT * (PositionInterface.ROW_8 - row);
	}
         
}