/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manouvre.gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import static java.lang.Math.round;
import java.util.ArrayList;
import manouvre.game.Game;
import manouvre.game.Position;
import manouvre.game.Unit;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;


/**
 *
 * @author Bartosz
 */
public class GameGUI {
    
    Game game;
    ArrayList<UnitGUI> unitsGui = new ArrayList<UnitGUI>(); 
    MapGUI mapGui;
    CardSetGUI cardSetGui;
    CardSetGUI discardSetGui;
    /*
    Wielkosc ramki stolu w kwadracie w pikselach
    */
    final int BACKGRNDTABLE = 678;
    
    ArrayList<Integer> selectionSeq = new ArrayList<Integer>();
  
    
    
    public GameGUI (Game newGame) throws IOException{
        this.game=newGame;
        this.mapGui = new MapGUI(game.getMap());
        this.generateUnitsUI();
        this.cardSetGui = new CardSetGUI(game.getCurrentPlayer().getHand());
        this.discardSetGui = new CardSetGUI(game.getCurrentPlayer().getDiscardPile());
       
    }
//------------- MAP - RIGHT UPPER CORNER OF THE SCREEN -----------------------------------
    void drawMap(Graphics g) {
        int gap = 5;
        // draw background
        
        g.drawImage(mapGui.background, 0, 0,BACKGRNDTABLE,BACKGRNDTABLE, null);
        // draw terrain
        for (TerrainGUI terrainGUI : mapGui.getTerrainsGUI()) {
                        
            
            g.drawImage(
                    terrainGUI.getImg(), 
                    terrainGUI.getPos().getMouseX(), 
                    terrainGUI.getPos().getMouseY(), 
                    MapGUI.SQUARE_WIDTH,
                    MapGUI.SQUARE_HEIGHT,
                    
                    null);
        }
        /*
        Draws selection
         */
        if (mapGui.isUnitSelected()) {
            for (TerrainGUI terrain : mapGui.getTerrainsGUI()) {
                if (terrain.isSelected()) {
                    g.drawRoundRect(
                            terrain.getPos().getMouseX() + gap, 
                            terrain.getPos().getMouseY() + gap, 
                            MapGUI.SQUARE_WIDTH - 2 * gap, 
                            MapGUI.SQUARE_HEIGHT - 2 * gap, 
                            10, 10
                    );
                    System.out.println("Position " + terrain.getPos());
                    /*
                    Draw AdjencedSpace /Move
                     */
                    if (!terrain.getTerrain().getIsOccupiedByUnit()) {
                        ArrayList<Position> adjencedPositions = terrain.getPos().getAdjencedPositions();
                        System.out.println(terrain.getPos().toString());
                        g.setColor(Color.red);
                        for (int k = 0; k < adjencedPositions.size(); k++) {
                            g.drawRoundRect(
                                    adjencedPositions.get(k).getMouseX() + gap, 
                                    adjencedPositions.get(k).getMouseY() + gap, 
                                    MapGUI.SQUARE_WIDTH - 2 * gap, 
                                    MapGUI.SQUARE_HEIGHT - 2 * gap, 
                                    10, 10);
                        }
                    } else {
                        System.out.println("manouvre.gui.ClientUI.drawMap() : " + game.getUnitAtPosition(terrain.getPos()).toString());
                        ArrayList<Position> movePositions = game.getPossibleMovement(game.getUnitAtPosition(terrain.getPos()));
                        for (Position drawMovePosion : movePositions) {
                            g.setColor(Color.blue);
                            g.drawRoundRect(
                                    drawMovePosion.getMouseX() + gap, 
                                    drawMovePosion.getMouseY() + gap, 
                                    MapGUI.SQUARE_WIDTH - 2 * gap, 
                                    MapGUI.SQUARE_HEIGHT - 2 * gap, 
                                    10, 10);
                        }
                    }
                }
            }
        }
        /*
        Draw units
         */
        int gapUnit = 7;
        for (UnitGUI drawUnit : unitsGui) {
            g.drawImage(
                    drawUnit.getImg(), 
                    drawUnit.getUnit().getPos().getMouseX() + MapGUI.PIECES_START_X,
                    drawUnit.getUnit().getPos().getMouseY() + MapGUI.PIECES_START_Y,
                    MapGUI.PIECE_WIDTH, 
                    MapGUI.PIECE_HEIGHT
                    , null);
        }
    }

    void generateUnitsUI() {
        for (Unit unit : game.getCurrentPlayer().getArmy()) {
            unitsGui.add(new UnitGUI(unit));
        }
    }

    UnitGUI getSelectedUnit() {
        for (UnitGUI unitSearch : this.unitsGui) {
            if (unitSearch.isSelected()) {
                return unitSearch;
            }
        }
        return null;
    }

    void unselectAllUnits() {
        unitsGui.stream().forEach((UnitGUI unit) -> {
            unit.setSelected(false);
        });
        mapGui.setUnitSelected(false);
    }
    
    public Game getGame() {
        return game;
    }

    public MapGUI getMapGui() {
        return mapGui;
    }
    
    
    
 //-------- CARDS - BOTTOM OF THE SCREEN -----------------------------------

    public void drawCard(Graphics g, int mouseCoorX, int mouseCoorY, int mouseClick)                 
    {   
        float f=0.5f; //scale factor //Normally cards has 260x375 pixels
        int width=round(260*f), height=round(375*f);
        int cardPaddingTop=70;
        int cardPaddingLeft=20;
        int cardPaddingTopTemp=cardPaddingTop;
        int gap = 5;    
        for (int i=0; i<cardSetGui.cardsLeftInSet(); i++){  
            
           if(mouseCoorY>(cardPaddingTop-20*cardSetGui.getCardByPosInSet(i).isOverCard()-20*cardSetGui.getCardByPosInSet(i).isSelected()) && mouseCoorY<(cardPaddingTop+height)){ // if mouse is in row with cards
                if ((mouseCoorX>cardPaddingLeft+(gap*i)+width*(i)) && mouseCoorX<(cardPaddingLeft+(gap*i)+width*(i+1))){ //if mouse is in th collon with card
                    cardSetGui.getCardByPosInSet(i).setOverCard(1);
                } 
                else{
                    cardSetGui.getCardByPosInSet(i).setOverCard(0);
                }
            }  
            else  cardSetGui.getCardByPosInSet(i).setOverCard(0);
            if(mouseClick==1&&cardSetGui.getCardByPosInSet(i).isOverCard()==1){
                if(cardSetGui.getCardByPosInSet(i).isSelected()==0) {
                    cardSetGui.getCardByPosInSet(i).setSelected(1);
                    selectionSeq.add(cardSetGui.getCardIDBySetID(i)); 
                }   
                else {
                    cardSetGui.getCardByPosInSet(i).setSelected(0);
                    Integer j=cardSetGui.getCardIDBySetID(i);
                    selectionSeq.remove(j); //remove number Integer j, not position int i
                }           
            }
            if(cardSetGui.getCardByPosInSet(i).isOverCard()==1 || cardSetGui.getCardByPosInSet(i).isSelected()==1) cardPaddingTopTemp=cardPaddingTop-20;
            else cardPaddingTopTemp=cardPaddingTop;
            g.drawImage(cardSetGui.getCardByPosInSet(i).getImgFull(), cardPaddingLeft+(width+gap)*i, cardPaddingTopTemp, width, height, null);       
        }
                Integer j=0;
                if(!selectionSeq.isEmpty()){        
                    j=selectionSeq.get(selectionSeq.size()-1);              

                    System.out.println("selectionSeq Last:" + j); 
                    System.out.println("selectionSeq Last Position in hand:" + game.getCurrentPlayer().getHand().getPositionInSetByCardID(j)); 
                    j=game.getCurrentPlayer().getHand().getPositionInSetByCardID(j); 
                    int[] xPoints={cardPaddingLeft+35+width*j+(gap*j),cardPaddingLeft+95+width*j+(gap*j),cardPaddingLeft+35+(95-35)/2+width*j+(gap*j)};
                    int[] yPoints={cardPaddingTop-18,cardPaddingTop-18,cardPaddingTop-8};
                    g.setColor(Color.LIGHT_GRAY);
                    g.setFont(new Font("Bookman Old Style", 1, 11));
                    g.drawString("This card will be visible",cardPaddingLeft+width*j+(gap*j)+0,31);
                    g.drawString("on the Discard Pile",cardPaddingLeft+width*j+(gap*j)+10,44);  
                    g.fillPolygon(xPoints, yPoints, 3);
                }                         
        }

    public void discardSelCards(){
        //get all selected cards
        int numberOfDiscardedCards=0;
          for (int i=0; i<selectionSeq.size(); i++){   
                game.getCurrentPlayer().getHand().dealCardToOtherSetByCardID(selectionSeq.get(i),  game.getCurrentPlayer().getDiscardPile());
                numberOfDiscardedCards++;  
          }
          if(numberOfDiscardedCards!=0){
            game.getCurrentPlayer().getHand().addRandomCardsFromOtherSet(numberOfDiscardedCards, game.getCurrentPlayer().getDrawPile());
            game.getCurrentPlayer().getHand().sortCard();
            cardSetGui.reSet();
            discardSetGui.reSet();
            numberOfDiscardedCards=0; 
          }
          selectionSeq.clear();
    }
    
    public void drawDiscard(Graphics g){
        float f=0.41f; //scale factor //Normally cards has 260x375 pixels
        int width=round(260*f), height=round(375*f);
        int cardPaddingTop=16;
        int cardPaddingLeft=5;
        if(discardSetGui.cardsLeftInSet()>0){
         g.drawImage(discardSetGui.getCardByPosInSet(discardSetGui.cardsLeftInSet()-1).getImgFull(), cardPaddingLeft, cardPaddingTop, width, height, null);           
        }
        else{
            g.setColor(Color.LIGHT_GRAY);
            g.setFont(new Font("Bookman Old Style", 1, 11));
            g.drawString("No Card",20,60);  
        }
    }
    
    public void drawDrawLeft(Graphics g){
        Integer drawLeft=game.getCurrentPlayer().getDrawPile().cardsLeftInSet();
            g.setColor(Color.LIGHT_GRAY);
            g.setFont(new Font("Bookman Old Style", 1, 11));        
            g.drawString(drawLeft.toString(),20,60); 
    }
    
    
}