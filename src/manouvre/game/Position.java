/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manouvre.game;

import java.util.ArrayList;
import manouvre.game.interfaces.PositionInterface;
import manouvre.gui.MapGUI;

/**
 *Map looks like this

| Y/X      | 0        | 1        | 2        | 3        | 4        | 5        | 6        | 7        |
+----------+----------+----------+----------+----------+----------+----------+----------+----------+
| 7        |          |          |          |          |          |          |          |          |
|          |          |          |          |          |          |          |          |          |
| 6        |          |          |          |          |          |          |          |          |
|          |          |          |          |          |          |          |          |          |
| 5        |          |          |          |          |          |          |          |          |
|          |          |          |          |          |          |          |          |          |
| 4        |          |          |          |          |          |          |          |          |
|          |          |          |          |          |          |          |          |          |
| 3        |          |          |          |          |          |          |          |          |
|          |          |          |          |          |          |          |          |          |
| 2        |          |          |          |          |          |          |          |          |
|          |          |          |          |          |          |          |          |          |
| 1        |          |          |          |          |          |          |          |          |
|          |          |          |          |          |          |          |          |          |
| 0        |          |          |          |          |          |          |          |          |
+----------+----------+----------+----------+----------+----------+----------+----------+----------+
 * @author Piotr
 */
public class Position implements PositionInterface{

    
    private int x;
    private int y;
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
        
        /**
	 * calculate upper left corner of terrain
	 * @param 
	 * @return x coordinate for upper right corner  terrain	
	 */
       public  int getMouseX(){
		return MapGUI.PIECES_START_X + MapGUI.SQUARE_WIDTH * x;
	}
	
	/**
	 * calculate upper left corner of terrain
	 * @param 
	 * @return y coordinate for  upper right corner  terrain
	 */
	public  int getMouseY(){
		return MapGUI.PIECES_START_Y + MapGUI.SQUARE_HEIGHT * (PositionInterface.ROW_8 - y);
	}
        /**
         * 
         * @return Positions               
         * @see Positions
               
        */
    
    @Override
    public ArrayList<Position> getAdjencedPositions() {
       
      ArrayList<Position>  adjencedPositions = new ArrayList<Position>();
          if (this.getX()-1  >= 0 ) {
                adjencedPositions.add(new Position(this.getX()-1, this.getY()));
          }
          if (this.getY()-1 >= 0){      
                adjencedPositions.add(new Position(this.getX(), this.getY()-1 ));
          }
          if (this.getY()+1 <= ROW_8){
                adjencedPositions.add(new Position(this.getX(), this.getY()+1));
          }
          if (this.getX()+1 <= COLUMN_H){
                adjencedPositions.add(new Position(this.getX()+1, this.getY()));
          }
     return adjencedPositions;
        
        
        
        
    }
    
    @Override
    public String toString(){
    return "Position X: " + getX() + " Position Y: " + getY() ;
    
    
    }
    
    @Override
    public boolean equals(Object in){
    
        Position p = (Position) in;
        if (getX() == p.getX() && getY()==p.getY()) return true;
        
        else return false;
        
        
    }
    
    public boolean checkIfMouseFitInPositon(int mouseX, int mouseY)
    {
        
        return mouseX > getMouseX() && mouseX < getMouseX() + MapGUI.SQUARE_WIDTH  
                 && mouseY > getMouseY() && mouseY < getMouseY() + MapGUI.SQUARE_HEIGHT;
    }
    
    
             
         
}
